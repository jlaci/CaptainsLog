"use strict";

serviceModule.factory('RegattaService', ['$resource', 'restServiceUrl', function RegattaService($resource, restServiceUrl) {
  var Regatta = $resource(restServiceUrl + "/regatta/");

  return {
    getAll : function(callback) {
      Regatta.query(callback);
    }
  };
}]);
