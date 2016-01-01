"use strict";

serviceModule.factory('RegattaService', ['$resource', 'restServiceUrl', function RegattaService($resource, restServiceUrl) {
  var Regatta = $resource(restServiceUrl + "/regatta/", [], { withCredentials : true});

  return {
    getAll : function(callback) {
      Regatta.query(callback);
    },
    save : function(data) {
      var newRegatta = new Regatta(data);
      newRegatta.$save();
    }
  };
}]);
