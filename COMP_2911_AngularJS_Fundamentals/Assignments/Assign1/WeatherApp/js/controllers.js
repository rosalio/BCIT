/*global angular */

var weatherControllers = (function () {
    var weatherControllers = angular.module('weatherControllers', []);

    // Declare the application controller and inject the scope reference.
    weatherControllers.controller('AppCtrl', ['$scope', 'noteService', function ($scope, noteService) {
        // Define the title model.
        $scope.title = "The Weather Forecast";
        $scope.temperatureUnit = "fahrenheit";
        noteService.setUnit($scope.temperatureUnit);

        $scope.convertUnit = function () {
            if ($scope.temperatureUnit === 'celsius') {
                noteService.setUnit('celsius');
            } else {
                noteService.setUnit('fahrenheit');
            }
        };
    }]);
    // Inject the scope and new weatherService reference into the controller.
    weatherControllers.controller('ListCtrl', ['$scope', 'weatherService', 'noteService', function ($scope, weatherService, noteService) {
        // Call another controller.
        weatherService.getWeather($scope);
        noteService.setCurrentData($scope.forecast);
        noteService.setAllData($scope.forecastOfAll);

        $scope.$watch(function () {
            $scope.temperatureUnit = noteService.getUnit();
        });
    }]);
    // Inject the scope and new weatherService reference into the controller.
    weatherControllers.controller('WeatherCtrl', ['$scope', '$routeParams', 'noteService', function ($scope, $routeParams, noteService) {
        $scope.cityName = $routeParams.cityName;
        $scope.allData = noteService.getAllData();

        for (var i = 0; i < $scope.allData.length; i++) {
            if ($scope.allData[i].cityName === $scope.cityName) {
                $scope.cityData = $scope.allData[i];
            }
        }

        $scope.$watch(function () {
            $scope.temperatureUnit = noteService.getUnit();
        });
    }]);
    return weatherControllers;
}());
