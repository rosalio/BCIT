// Register our controller with the angular module.
var cardApp = angular.module('cardApp', []);

// The controller is a constructor function that takes a $scope parameter.
// The controller lets us establish data binding between the controller and the view.
// The model is initialized with the $scope parameter.
cardApp.controller('MainController', ['$scope', function ($scope) {
    // Scope ensures that any changes to the 
    // model are reflected in the controller.
    // Here we create an initialize a 'title' model.
    $scope.greeting = "AngularJS Hello World!";

    // Define cards model which stores an array of objects.
    $scope.cards = [
        { "number": "2", "suit": "Hearts", "numOrd": 2 },
        { "number": "10", "suit": "Spades", "numOrd": 10 },
        { "number": "5", "suit": "Spades", "numOrd": 5 },
        { "number": "Q", "suit": "Hearts", "numOrd": 12 }
    ];

    $scope.orderProp = "numOrd";
}]);
