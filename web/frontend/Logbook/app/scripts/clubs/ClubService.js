"use strict";

serviceModule.factory('ClubService', ['$resource', 'restServiceUrl', function ClubService($resource, restServiceUrl) {
  var Clubs = $resource(restServiceUrl + "/club/");

  return {
    getAll : function(callback) {
      Clubs.query(callback);
    }
  };
}]);
