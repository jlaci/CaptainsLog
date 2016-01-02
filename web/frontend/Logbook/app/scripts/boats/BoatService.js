"use strict";

serviceModule.factory('BoatService', ['$resource', 'restServiceUrl', function BoatService($resource, restServiceUrl) {
  var Boats = $resource(
    restServiceUrl + "/boat/:id",
    {
      id:'@id'
    },
    {
      withCredentials : true,
      'update':
      {
        method : 'PUT'
      },
      'getOwn':
      {
        method : 'GET',
        url : restServiceUrl + "/boat/own",
        isArray : true
      }
    }
  );

  return {
    getAll : function(callback) {
      Boats.query(callback);
    },
    getOwn : function (callback) {
      Boats.getOwn().$promise.then(callback);
    }
  };
}]);
