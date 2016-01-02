'use strict';

/**
 * @ngdoc function
 * @name logbookApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the logbookApp
 */
angular.module('logbookApp')
  .controller('MainCtrl', function ($scope) {
    $scope.notifications = {};
    $scope.notificationIndex = 0;

    $scope.addNotification = function(notification){
      $scope.notifications[$scope.notificationIndex++] = notification;
    };
  });

/**
 * @ngdoc function
 * @name logbookApp.controller:HeaderController
 * @description
 * # MainCtrl
 * Controller for the header.
 */
angular.module('logbookApp')
  .controller('HeaderController', function ($scope, $location) {
    $scope.isActive = function (viewLocation) {
      return viewLocation === $location.path();
    };
  });
