/*global angular */

var weatherControllers = (function () {
    var weatherControllers = angular.module('weatherControllers', []);

    // Declare the application controller and inject the scope reference.
    weatherControllers.controller('AppCtrl', ['$scope', 'weatherService', function ($scope, weatherService) {
        // Define the title model.
        $scope.title = "AngularJS Tutorial";
	    // Define the forecast data.					  
        weatherService.getWeather($scope);	
    }]);
    // Inject the scope and new weatherService reference into the controller.
    weatherControllers.controller('ListCtrl', ['$scope', 'weatherService',
                                  function ($scope, weatherService) {
                                      // Call another controller.				  
                                      weatherService.doSomething($scope);
                                  }]);
    // Inject the scope and new weatherService reference into the controller.
    weatherControllers.controller('WeatherCtrl', ['$scope', 
                                  function ($scope) {

                                      
                                  }]);
    return weatherControllers;
}());
