var myApp = angular.module('myApp', ['myControllers']);

// Controller - dispatches inputs and outputs.
var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    // Controllers are defined by the controller function.
    myApp.controller('ExampleController', ['$scope', function ($scope) {
        $scope.update = function (input) {
            $scope.mailService = input;
        }
    }]);
    return myControllers;
}());
