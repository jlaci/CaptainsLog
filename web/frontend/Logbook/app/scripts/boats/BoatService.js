"use strict";

serviceModule.factory('BoatService', ['$resource', 'restServiceUrl', function BoatService($resource, restServiceUrl) {
  var Boat = $resource(restServiceUrl + "/boat/");

  return {
    getAll : function(callback) {
      Boat.query(callback);
    }
  };
}]);
