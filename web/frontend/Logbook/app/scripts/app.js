'use strict';



/**
 * @ngdoc overview
 * @name logbookApp
 * @description
 * # logbookApp
 *
 * Main module of the application.
 */
var logbookApp = angular
  .module('logbookApp', [
    'ngAnimate',
    'ngCookies',
    'ngResource',
    'ngRoute',
    'ngSanitize',
    'ngTouch',
    'logbookApp.services'
  ]
);

var serviceModule = angular
  .module('logbookApp.services', []
);

serviceModule.value('restServiceUrl', 'http://localhost:8080');

logbookApp.config(function ($routeProvider, $httpProvider) {

    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.withCredentials = true;


    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/regattas', {
        templateUrl: 'views/regattas.html',
        controller: 'RegattasController',
        controllerAs: 'regattas'
      })
      .when('/results', {
        templateUrl: 'views/results.html',
        controller: 'ResultsController',
        controllerAs: 'results'
      })
      .when('/user/profile', {
        templateUrl: 'views/users/profile.html',
        controller: 'UserController',
        controllerAs: 'users'
      })
      .otherwise({
        redirectTo: '/'
      });
    }
);


logbookApp.run(function($rootScope, $cookies, UserService, BoatService) {

  $rootScope.authenticated = false;
  $rootScope.user = {};

  //If we have a previous session try to re use it
  if ($cookies.get('authenticated') != undefined) {
    UserService.getDetails().success(function (data) {
      $rootScope.authenticated = true;
      $rootScope.user = data;

      //List the boats for the user
      BoatService.getAll(function(result) {
        $rootScope.user.availableBoats = result;

        if(result != null && result.length > 0) {
          $rootScope.user.selectedBoat = result[0].id;
        }
      });
    }).error(function() {
      $cookies.remove('authenticated');
    });
  }
});

