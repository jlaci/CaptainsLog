'use strict';

/**
 * @ngdoc function
 * @name logbookApp.controller:RegattasController
 * @description
 * # RegattasController
 * Controller of the logbookApp
 */
angular.module('logbookApp')
  .controller('RegattasController', function ($scope, RegattaService) {

    //Utility functions
    $scope.parseDate = function(date) {
      return new Date(date);
    };

    $scope.parseType = function(type) {
      if(type === 'TOURING') {
        return "Túra";
      } else if(type === 'MIXED') {
        return "Vegyes";
      } else if (type === 'COURSE') {
        return "Pálya";
      } else {
        return "Ismeretlen";
      }
    };

    $scope.delete = function(regatta) {
      RegattaService.delete(regatta.id, function() {
        $scope.addNotification("Sikeres törlés!");
        $scope.regattas.splice($scope.regattas.indexOf(regatta), 1);
        sortToSeasons($scope.regattas);
      });
    };


    function sortToSeasons(regattas) {
      var seasons = [];
      var seasonsByYear = {};

      for (var i = 0; i < regattas.length; i++) {
        var year = new Date(regattas[i].startDate).getFullYear();
        if(seasonsByYear[year] == null) {
          seasonsByYear[year] = {
            date : year,
            regattas : []
          };
          seasons.push(seasonsByYear[year]);
        }
        seasonsByYear[year].regattas.push(regattas[i]);
      }

      //Sort the seasons
      seasons.sort(function(s1, s2) {
        return s2.date - s1.date;
      });

      //Sort the races in seasons
      for(var i = 0; i < seasons.length; i++) {
        seasons[i].regattas.sort(function(r1, r2) {
          return r1.startDate - r2.startDate;
        });
      }

      $scope.seasons = seasons;
    }


    //Fill the page with data, by seasons
    RegattaService.getAll(function(regattas) {
      $scope.regattas = regattas;
      sortToSeasons(regattas);
    });

  }
);

angular.module('logbookApp')
  .controller('RegattaEditorController', function ($scope, $routeParams, $location, RegattaService, ClubService) {

    function createNew() {
      $scope.regatta = new Regatta();
      $scope.editMode = false;

      var d = new Date();
      d.setHours(9);
      d.setMinutes(0);
      $scope.regatta.startDate = d;
      $scope.regatta.endDate = d;

      $scope.lastRaceNumber = 0;

      if($scope.clubs != null && $scope.clubs.length > 0) {
        $scope.regatta.organizer.id = $scope.clubs[0].id;
      }
    }

    function loadExisting(regatta) {
      $scope.regatta = regatta;
      $scope.editMode = true;
      $scope.regatta = regatta;

      $scope.lastRaceNumber = regatta.races.length;
    }

    function initialize() {
      //Get the available organizing clubs
      ClubService.getAll(function(result) {
        $scope.clubs = result;

        if($scope.clubs != null && $scope.clubs.length > 0 && $scope.editMode === false) {
          $scope.regatta.organizer.id = $scope.clubs[0].id;
        }
      });

      //Set up the datepickers
      $scope.dateOptions = {
        formatYear: 'yy',
        startingDay: 1
      };
      $scope.datePickerStates = {};

      //Check if we are editing or creating a new
      if ($routeParams.regattaId !== undefined) {
        RegattaService.getOne($routeParams.regattaId, function (regatta) {
          loadExisting(regatta);
        });
      } else {
        createNew();
      }
    }

    initialize();

    $scope.addRace = function () {
      var race = new Race();
      race.order = ++$scope.lastRaceNumber;
      race.startDate = $scope.regatta.startDate;
      race.endDate = $scope.regatta.endDate;

      $scope.regatta.races.push(race);
    };

    $scope.removeRace = function(raceNumber) {
      $scope.regatta.races.splice(raceNumber - 1, 1);

      for(var i = 0; i < $scope.regatta.races.length; i++) {
       $scope.regatta.races[i].order = i + 1;
      }

      $scope.lastRaceNumber = $scope.regatta.races.length;
    };

    $scope.moveRaceUp = function(raceNumber) {
      var index = raceNumber - 1;

      if(index >= 1 && index < $scope.regatta.races.length) {
        var aboveIndex = index - 1;
        var above = $scope.regatta.races[aboveIndex];
        var current = $scope.regatta.races[index];

        current.order = above.order;
        $scope.regatta.races[aboveIndex] = current;

        above.order = current.order + 1;
        $scope.regatta.races[index] = above;
      }
    };

    $scope.moveRaceDown = function(raceNumber) {
      $scope.moveRaceUp(raceNumber + 1);
    };

    $scope.save = function() {
      if($scope.editMode === true) {
        RegattaService.update($scope.regatta.id, $scope.regatta, function() {
          $scope.addNotification("Sikeres frissítés!");
          $location.path("/regattas")
        });
      } else {
        RegattaService.save($scope.regatta, function() {
          $scope.addNotification("Sikeres mentés!");
          $location.path("/regattas");
        });
      }
    };
  }
);
