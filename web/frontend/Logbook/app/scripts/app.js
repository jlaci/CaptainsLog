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
    'logbookApp.services',
    'ui.bootstrap',
    'growlNotifications'
  ]
);

var serviceModule = angular
  .module('logbookApp.services', []
);

serviceModule.value('restServiceUrl', '/api');

logbookApp.config(function ($routeProvider, $httpProvider) {

    $httpProvider.defaults.useXDomain = true;
    $httpProvider.defaults.withCredentials = true;


    $routeProvider
      .when('/', {
        templateUrl: 'views/main.html',
        controller: 'MainCtrl',
        controllerAs: 'main'
      })
      .when('/boats', {
        templateUrl: 'views/boats/overview.html',
        controller: 'BoatsController',
        controllerAs: 'boats'
      })
      .when('/boats/new', {
        templateUrl: 'views/boats/editor.html',
        controller: 'BoatEditorController',
        controllerAs: 'boatsEdit'
      })
      .when('/boats/:boatId/edit', {
        templateUrl: 'views/boats/editor.html',
        controller: 'BoatEditorController',
        controllerAs: 'boatsEdit'
      })
      .when('/regattas', {
        templateUrl: 'views/regattas/overview.html',
        controller: 'RegattasController',
        controllerAs: 'regattas'
      })
      .when('/regattas/new', {
        templateUrl: 'views/regattas/editor.html',
        controller: 'RegattaEditorController',
        controllerAs: 'regattasEdit'
      })
      .when('/regattas/:regattaId/edit', {
        templateUrl: 'views/regattas/editor.html',
        controller: 'RegattaEditorController',
        controllerAs: 'regattasEdit'
      })
      .when('/results', {
        templateUrl: 'views/results.html',
        controller: 'ResultsController',
        controllerAs: 'results'
      })
      .when('/clubs', {
        templateUrl: 'views/clubs/overview.html',
        controller: 'ClubsController',
        controllerAs: 'clubs'
      })
      .when('/ports', {
        templateUrl: 'views/ports/overview.html',
        controller: 'PortsController',
        controllerAs: 'ports'
      })
      .when('/user/profile', {
        templateUrl: 'views/users/profile.html',
        controller: 'UserController',
        controllerAs: 'users'
      })
      .otherwise({
        redirectTo: '/'
      });


    var interceptor = ['$q', '$location', '$injector', '$rootScope',
      function ($q, $location, $injector, $rootScope) {
        return {
          response: function (response) {
            return response;
          },
          responseError: function (response) {
            if (response.status == 401) {
              $rootScope.authenticated = false;
              $location.path("/");
              return $q.reject(response);
            }
            return $q.reject(response);
          }
        }
      }];

    $httpProvider.interceptors.push(interceptor);
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
      BoatService.getOwn(function(result) {
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

