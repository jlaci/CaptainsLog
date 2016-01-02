angular.module('logbookApp')
  .controller('BoatsController', function ($scope, BoatService) {

    BoatService.getAll(function(boats) {
      $scope.boats = boats;
    });

  });

angular.module('logbookApp')
  .controller('BoatEditorController', function ($scope, BoatService) {

  });
