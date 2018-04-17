// Declare module that references our controllers.
var myApp = angular.module('myApp', ['ngRoute',
                                     'myControllers']).config(function ($routeProvider) {
                                         $routeProvider.when("/home", {
                                             //templateUrl: 'views/list.html',
                                             //controller: 'ListCtrl'
                                         })
                                         .otherwise({ redirectTo: '/home' });
                                     });

var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    myControllers.controller('AppCtrl', ['$scope', 'simpleService',
                function ($scope, simpleService) {
                    $scope.title = "Angular JS!";
                    $scope.error = false;
                    var promise = simpleService.getData($scope);

                    promise.then(
                        function (numbers) {
                            $scope.numbers = numbers;
                        },
                        function (errorReason) {
                            $scope.error = true;
                            $scope.msg = "An error occurred while fetching data.";
                            console.log(errorReason);
                        });
                }]);
    return myControllers;
}());

myApp.factory("simpleService", ["$http", "$q", function ($http, $q) {
    var service = {
        getData: function ($scope) {
            var deferred = $q.defer(); // Set up deferral.
            $http.get("http://ssdprogram.ca/testJson.php")
                .success(function (data) {
                    deferred.resolve(data);                // Return resource.
                })
                .error(function () {
                    deferred.reject("*** Rejected! ****");  // Return rejection.
                });;
            return deferred.promise; // Promise to return something once available.
        }
    };
    return service;
}]);
