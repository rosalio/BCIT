// Register our controller with the angular module.
var cardApp = angular.module('cardApp', []);

// The controller is a constructor function that takes a $scope parameter.
// The controller lets us establish data binding between the controller and the view.
// The model is initialized with the $scope parameter.
cardApp.controller('MainController', ['$scope', function ($scope) {
    // Scope ensures that any changes to the 
    // model are reflected in the controller.
    // Here we create an initialize a 'greeting' model.
    $scope.greeting = "AngularJS Hello World!";
	console.log($scope.greeting);
}]);
