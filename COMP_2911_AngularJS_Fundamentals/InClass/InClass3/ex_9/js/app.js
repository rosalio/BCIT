// Module.
var myApp = angular.module('myApp', ['myControllers']);

// Controllers.
var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    // Inject scope and service reference.
    myControllers.controller('AppCtrl', ['$scope', 'nameService',
                                         function ($scope, nameService) {
                                             $scope.personName = nameService.getName();
                                         }]);
    return myControllers;
}());

// Service
myApp.factory("nameService", function () {
    return {
        getName: function () {
            return { "First": "Mary", "Last": "Jane" };
        }
    }
});
