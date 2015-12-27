'use strict';

/**
 * @ngdoc function
 * @name logbookApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the logbookApp
 */
angular.module('logbookApp')
  .controller('MainCtrl', function () {

  });

/**
 * @ngdoc function
 * @name logbookApp.controller:HeaderController
 * @description
 * # MainCtrl
 * Controller for the header.
 */
angular.module('logbookApp')
  .controller('HeaderController', function ($scope, $location, BoatService) {
    $scope.isActive = function (viewLocation) {
      return viewLocation === $location.path();
    };

    BoatService.getAll(function(result) {
      $scope.availableBoats = result;

      if(result != null && result.length > 0) {
        $scope.selectedBoat = result[0].id;
      }
    });

  });
