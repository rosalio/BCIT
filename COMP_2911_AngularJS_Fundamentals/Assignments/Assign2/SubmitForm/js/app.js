// Application module that injects routing, controller, and directive dependencies.
var myApp = angular.module('myApp', ['ngRoute', 'myControllers', 'myDirectives'])
        .config(function ($routeProvider) {
            $routeProvider.when("/home", {
                templateUrl: 'views/application.html',
                controller: 'ApplicationCtrl'
            }).when("/data", {
                templateUrl: 'views/data.html',
                controller: 'DataCtrl'
            })
            .otherwise({ redirectTo: '/home' });
        });

// Directive - Modifies HTML behaviour.
var myDirectives = (function () {
    var myDirectives = angular.module('myDirectives', []);

    // directive() is a factory method to create directives.
    myDirectives.directive('myForm', ['$location', function ($location) {
        return {
            restrict: 'A',
            link: function ($scope, elem, attrs, ctrl) {

                $scope.checkPassword = function () {
                    if ($scope.password === $scope.verifiedPassword) {
                        $scope.match = true;
                    } else {
                        $scope.match = false;
                    }
                };

                $scope.submitForm = function () {
                    alert('Successfully submitted form. Thank you!');
                    $location.path("/data");
                };
            },
            templateUrl: function (element, attr) { return 'views/form.html' }
        }
    }]);

    return myDirectives;
}());

// Controller - dispatches inputs and outputs.
var myControllers = (function () {
    var myControllers = angular.module('myControllers', []);

    // Controllers are defined by the controller function.
    myControllers.controller('AppCtrl', ['$scope', function ($scope) {
        $scope.title = "Submit the Form";

    }]);
    myControllers.controller('ApplicationCtrl', ['$scope', function ($scope) {
        $scope.password = null;
        $scope.verifiedPassword = null;
    }]);
    myControllers.controller('DataCtrl', ['$scope', 'dataService', function($scope, dataService) {
        $scope.error =false;
        var promise = dataService.getData($scope);
        promise.then(
            function (data) {
                $scope.data = data;
            },
            function (errorReason) {
                $scope.error = true;
                $scope.msg = "Error occurred.";
                console.log(errorReason);
            });
    }]);

    return myControllers;
}());

myApp.factory("dataService", ['$http', '$q', function ($http, $q) {
    var service = {
        getData: function ($scope) {
            var deferred = $q.defer(); // Set up deferral.
            $http.get("http://ssdprogram.ca/testjson2.php")
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