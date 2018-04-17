// Application module that injects routing, controller, and directive dependencies.
var myApp = angular.module('myApp', ['ngRoute', 'myControllers', 'myDirectives'])
                     .config(function ($routeProvider) {
                         $routeProvider.when("/home", {
                             // templateUrl: 'views/list.html',
                             // controller: 'ListCtrl'
                         }
                    )
             // If no route is selected then use the 'home' route.
             .otherwise({ redirectTo: '/home' });
                     });

// Controller - dispatches inputs and outputs.
var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    // Controllers are defined by the controller function.
    myControllers.controller('AppCtrl', ['$scope', function ($scope) {
        $scope.title = "AngularJS Directive Tutorial";
    }]);
    return myControllers;
}());

// Directive - Modifies HTML behaviour.
var myDirectives = (function () {
    var myDirectives = angular.module('myDirectives', []);

    // directive() is a factory method to create directives.
    myDirectives.directive('welcomeMessage', function () {
        return {
            restrict: 'A', // restrict to attributes.
            template: '<b>Hello from {{title}}</b>'
        }
    });
    return myDirectives;
}());
