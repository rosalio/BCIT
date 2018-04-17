﻿/*global angular */

var cardAppControllers = (function () {
    var cardAppControllers = angular.module('cardAppControllers', []);

    // Declare the application controller and inject the scope reference.
    cardAppControllers.controller('AppCtrl', ['$scope', function ($scope) {
        // Define the title model.
        $scope.title = "AngularJS Tutorial";
    }]);
    // Inject the scope and new cardService reference into the controller.
    cardAppControllers.controller('ListCtrl', ['$scope', 'cardService',
                                  function ($scope, cardService) {
                                      // Define the cards model.					  
                                      cardService.getCards($scope);
                                  }]);
    // Inject scope, $routeParams, and cardService  
    cardAppControllers.controller('DetailCtrl', ['$scope', '$routeParams', 'cardService',
        function ($scope, $routeParams, cardService) {
            cardService.getCard($scope, $routeParams.numberID, $routeParams.suitID);
        }]);
    // AddConfirmCtrl calls the service to add the card.
    cardAppControllers.controller('AddConfirmCtrl', ['$scope', '$routeParams', 'cardService',
        function ($scope, $routeParams, cardService) {
            cardService.addCard($scope, $routeParams.numberID, $routeParams.suitID);
        }]);

    // The $location service is injected to enable the redirect.
    cardAppControllers.controller('AddCtrl', ['$scope', '$location', 'cardService',
        function AddCtrl($scope, $location, cardService) {
            // Create an empty object.
            $scope.master = {};

            // When add is clicked, redirect to the confirm view and controller where
            // the card is actually added added.
            $scope.add = function (card) {
                $location.path('/addconfirm/number/' + card.number + '/suit/' + card.suit);
            };
            // When reset is clicked clear the ‘card’ model defined within the scope to
            // clear the form data.
            $scope.reset = function () {
                $scope.card = angular.copy($scope.master);
            };
        }]);

    return cardAppControllers;
}());
