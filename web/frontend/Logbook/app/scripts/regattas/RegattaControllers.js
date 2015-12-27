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


    //Fill the page with data, by seasons
    RegattaService.getAll(function(regattas) {
      $scope.regattas = regattas;

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
    });

  });
