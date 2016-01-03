'use strict';

angular.module('logbookApp')
  .controller('PortsController', function ($scope, PortService) {

    PortService.getAll(function(ports) {
      $scope.ports = ports;
    });
  }
);
