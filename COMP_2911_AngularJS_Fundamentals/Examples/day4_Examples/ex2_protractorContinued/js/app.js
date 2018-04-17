// Declare module that references our controllers.
var myApp = angular.module('myApp', ['myControllers']);

var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    myControllers.controller('AppCtrl', ['$scope', function ($scope) {
        $scope.title = "Angular JS!";
        $scope.firstName = "Josie";
        $scope.error = false;
        $scope.submittedName = '';
        $scope.numbers = ["1", "2", "3", "4", "5", "6", "7", "8", "9"];
        $scope.add = function (data) {
            $scope.submittedName = 'Greetings: ' + data;
        }
    }]);
    return myControllers;
}());
