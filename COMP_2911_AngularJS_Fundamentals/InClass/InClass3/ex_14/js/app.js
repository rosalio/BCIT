// Application module that injects routing, controller, and directive dependencies.
var myApp = angular.module('myApp', ['myControllers', 'myDirectives']);

// Directive - Modifies HTML behaviour.
var myDirectives = (function () {
    var myDirectives = angular.module('myDirectives', []);

    // directive() is a factory method to create directives.
    myDirectives.directive('myStars', function () {
        return {
            restrict: 'A',
            replace: true,
            scope: { rating: '=' },
            link: function ($scope, elem, attrs, ctrl) {
                $scope.stars = [];
                for (var i = 0; i < $scope.rating; i++) {
                    $scope.stars.push({}); // push empty objects onto an array
                    console.log('adding star : ' + i);
                }
            },
            templateUrl: function (element, attr) { return 'views/stars.html' },
        }
    });
    return myDirectives;
}());

// Controller - dispatches inputs and outputs.
var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    // Controllers are defined by the controller function.
    myControllers.controller('AppCtrl', ['$scope', function ($scope) {
        $scope.title = "AngularJS Tutorial";
    }]);
    return myControllers;
}());
