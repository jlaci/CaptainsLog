'use strict';

angular.module('logbookApp').controller('UserController', function UserController($scope, $http, $rootScope, $cookies, UserService, BoatService) {

  $scope.authenticate = function () {

    //Construct the credentials object
    var credentials = new Credentials();
    credentials.principal = $scope.principal;
    credentials.secret = $scope.secret;

    //Authenticate with the server
    UserService.authenticate(credentials).success(function (data, status, headers) {
      if (status == 200) {
        UserService.getDetails().success(function (data) {
          $rootScope.authenticated = true;
          $rootScope.user = data;
          $cookies.put("authenticated", "true");

          //List the boats for the user
          BoatService.getAll(function(result) {
            $rootScope.user.availableBoats = result;

            if(result != null && result.length > 0) {
              $rootScope.user.selectedBoat = result[0].id;
            }
          });
        });
      }
    }).error(function (data, status){
      $rootScope.authenticated = false;
      if(status == 400 || status == 403){
        alert("Wrong username or password! (" + status + ")");
      } else {
        alert("Error while connecting to server! " + status);
      }
    });
  };

  $scope.logout = function() {
    $rootScope.authenticated = false;
    $rootScope.user = {};
    $cookies.remove('authenticated');
  }
});
