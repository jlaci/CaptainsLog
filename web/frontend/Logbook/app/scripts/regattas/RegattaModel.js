'use strict';

var Regatta = function() {
  this.id = "";
  this.name = "";
  this.type = "TOURING";
  this.organizer = {
    id: "",
    name: ""
  };
  this.location = "";
  this.startDate = new Date();
  this.endDate = new Date();
  this.races = [];
};

var Race = function() {
  this.id = "";
  this.order = 0;
  this.type = "TOURING";
  this.startDate = new Date();
  this.endDate = new Date();
};
