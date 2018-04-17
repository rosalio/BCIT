// Application module that injects routing, controller, and directive dependencies.
var myApp = angular.module('myApp', ['myControllers', 'myDirectives']);

// Controller - dispatches inputs and outputs.
var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    // Controllers are defined by the controller function.
    myControllers.controller('AppCtrl', ['$scope', function ($scope) {
        $scope.title = "AngularJS Tutorial";
    }]);
    return myControllers;
}());

// Directives
var myDirectives = (function () {
    var myDirectives = angular.module('myDirectives', []);
    myDirectives.directive('myHeader', function () {
        return {
            restrict: 'E',
            replace: true,
            // Template allows inline tag declarations.
            template: '<h1>Google - California!</h1>'
        }
    });
    return myDirectives;
}());
