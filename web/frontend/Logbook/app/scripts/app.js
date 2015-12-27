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

logbookApp.config(function ($routeProvider) {
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
    .otherwise({
      redirectTo: '/'
    });
  }
);
