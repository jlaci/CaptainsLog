'use strict';

serviceModule.factory('UserService', ['$http', 'restServiceUrl', '$rootScope', function UserService($http, restServiceUrl, $rootScope) {
  return {
    authenticate: function (credentials) {
      var authString = credentials.principal + ":" + credentials.secret;

      var req = {
        method: 'GET',
        url: restServiceUrl + '/user',
        headers: {
          'Authorization': 'Basic ' + btoa(authString)
        }
      };
      return $http(req);
    },
    getDetails : function() {
      var req = {
        method: 'GET',
        url: restServiceUrl + '/user/current'
      };
      return $http(req);
    }
  };
}]);
