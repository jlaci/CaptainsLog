"use strict";

serviceModule.factory('RegattaService', ['$resource', 'restServiceUrl', function RegattaService($resource, restServiceUrl) {
  var Regattas = $resource(restServiceUrl + "/regatta/:id", {id:'@id'}, { withCredentials : true, 'update': {method : 'PUT'}});

  return {
    getAll : function(callback) {
      Regattas.query(callback);
    },
    getOne : function(id, callback) {
      Regattas.get({id: id}).$promise.then(callback);
    },
    update : function (id, data, callback) {
      Regattas.update({id: id}, data).$promise.then(callback);
    },
    save : function(data, callback) {
      var newRegatta = new Regattas(data);
      newRegatta.$save(callback);
    },
    delete : function(id, callback) {
      var regatta = new Regattas({id:id});
      regatta.$delete(callback);
    }
  };

}]);
