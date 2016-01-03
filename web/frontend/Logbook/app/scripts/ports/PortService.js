"use strict";

serviceModule.factory('PortService', ['$resource', 'restServiceUrl', function PortService($resource, restServiceUrl) {
  var Ports = $resource(restServiceUrl + "/port/");

  return {
    getAll : function(callback) {
      Ports.query(callback);
    }
  };
}]);
