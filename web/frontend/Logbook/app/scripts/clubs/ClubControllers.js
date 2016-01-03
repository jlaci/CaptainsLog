'use strict';

angular.module('logbookApp')
  .controller('ClubsController', function ($scope, ClubService) {

    ClubService.getAll(function(clubs) {
      $scope.clubs = clubs;
    });
  }
);
