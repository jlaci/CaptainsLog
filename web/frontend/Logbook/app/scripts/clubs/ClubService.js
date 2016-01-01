"use strict";

serviceModule.factory('ClubService', ['$resource', 'restServiceUrl', function ClubService($resource, restServiceUrl) {
  var Club = $resource(restServiceUrl + "/club/");

  return {
    getAll : function(callback) {
      Club.query(callback);
    }
  };
}]);
