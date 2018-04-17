// Declare module that references our controllers.
var myApp = angular.module('myApp', ['myControllers']);

var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);
    myControllers.controller('AppCtrl', ['$scope', 'myService',
        function ($scope, myService) {
            $scope.title = "Angular JS!";
            $scope.error = false;
            var promise = myService.getNumbers();

            promise.then(
                function (numbers) {
                    $scope.numbers = numbers;
                },
                function (errorReason) {
                    $scope.error = true;
                    $scope.msg = "An error occurred while fetching data.";
                });
        }]);
    return myControllers;
}());

myApp.factory('myService', ["$http", "$q", function ($http, $q) {
    var myService = {
        getNumbers: function () {
            var deferred = $q.defer();

            $http({
                method: 'GET',
                url: 'http://ssdprogram.ca/testJson.php'
            }).success(function (data) {
                console.log("Success: " + data);
                deferred.resolve(data);
            }).error(function (data) {
                console.log("Fail: Rejected!");
                deferred.reject("Rejected!"); // Return rejection.
            });
            return deferred.promise; // Promise to return return 
        }                            // resource when available.
    };
    return myService;
}]);
