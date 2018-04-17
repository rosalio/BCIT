// Declare module that references our controllers.
var myApp = angular.module('myApp', ['myControllers']);

var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);
    myControllers.controller('AppCtrl', ['$scope', 'myService',
        function ($scope, myService) {
            console.log('Controller is initializing.');

            $scope.title = "Angular JS!";
            $scope.error = false;
            $scope.numbers = [];

            $scope.getData = function () {
                var promise = myService.getNumbers();

                promise.then(
                    function (numbers) {
                        $scope.numbers = numbers;
                        console.log('AppCtrl: ' + numbers);
                    },
                    function (errorReason) {
                        $scope.error = true;
                        $scope.msg = "Error while getting data.";
                        console.log('AppCtrl: ' + 'error!');
                    });
            }
        }]);
    return myControllers;
}());

myApp.factory('myService', ["$http", "$q", function ($http, $q) {
    var myService = {
        getNumbers: function () {
            var deferred = $q.defer();

            // Could also be written as 
            // $http.get("http://ssdprogram.ca/testJson.php")
            $http({
                method: 'GET',
                url: 'http://ssdprogram.ca/testJson.php'
            }).success(function (data) {
                console.log("myService success: " + data);
                deferred.resolve(data);
            }).error(function () {
                console.log("myService fail: Rejected!");
                deferred.reject("Rejected!"); // Return rejection.
            });
            return deferred.promise;          // Promise to return return 
            // resource when available.
        }
    };
    return myService;
}]);
