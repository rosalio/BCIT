/*global angular */

var cardAppControllers = (function () {
    var cardAppControllers = angular.module('cardAppControllers', []);

    // Declare the application controller and inject the scope reference.
    cardAppControllers.controller('AppCtrl', ['$scope', function ($scope) {
        // Define the title model.
        $scope.title = "Assignment 3";
    }]);
    // Inject the scope and reference into the controller.
    cardAppControllers.controller('ListCtrl', ['$scope', 
                                  function ($scope) {
                                      // Define the cards model.					  
                                    
                                  }]);
    // Inject scope, $routeParams  
    cardAppControllers.controller('DetailCtrl', ['$scope', '$routeParams', 
        function ($scope, $routeParams) {
            $scope.card = { "number": $routeParams.numberID, "suit": $routeParams.suitID };
        }]);
    // AddConfirmCtrl calls the service to add the card.
    cardAppControllers.controller('AddConfirmCtrl', ['$scope', '$routeParams', 
        function ($scope, $routeParams) {
            var cardNum  = $routeParams.numberID;
            var cardSuit = $routeParams.suitID;

            $scope.message = {
                "Msg": cardNum + ' '
                     + cardSuit + ' has been added.'
            };
        }]);

    cardAppControllers.controller('DeleteCtrl', ['$scope', '$routeParams',
        function ($scope, $routeParams) {
            var cardNum = $routeParams.numberID;
            var cardSuit = $routeParams.suitID;
            $scope.card = {"number": cardNum, "suit": cardSuit};

            $scope.delete = function () {
                var indexOfDelete = -1;

                for (var i = 0; i < $scope.cards.length; i++) {
                    if ($scope.cards[i].number === cardNum && $scope.cards[i].suit === cardSuit) {
                        indexOfDelete = i;
                        break;
                    }
                }

                if (indexOfDelete > -1) {
                    $scope.cards.splice(indexOfDelete, 1);
                    $scope.message = {
                        "Msg": cardNum + ' ' + cardSuit + ' has been deleted.'
                    }
                } else {
                    $scope.message = {
                        "Msg": 'Cannot delete ' + cardNum + ' ' + cardSuit
                    }
                }
            };
        }
    ]);

    // The $location service is injected to enable the redirect.
    cardAppControllers.controller('AddCtrl', ['$scope', '$location',
        function AddCtrl($scope, $location) {

            // When add is clicked, redirect to the confirm view and controller where
            // the card is actually added added.
            $scope.add = function (card) {
                var numOrd  = card.number;
                var cardNum = card.number.toUpperCase();
                if (cardNum == 'A')
                    numOrd = 1;
                else if (cardNum == 'J')
                    numOrd = 11;
                else if (cardNum == 'Q')
                    numOrd = 12;
                else if (cardNum == 'K')
                    numOrd = 13;

                $scope.isDuplicate = false;
                for (var i = 0; i < $scope.cards.length; i++) {
                    if ($scope.cards[i].number === cardNum && $scope.cards[i].suit === card.suit) {
                        $scope.isDuplicate = true;
                    }
                }

                if (!$scope.isDuplicate) {
                    var card = {"number": cardNum, "suit": card.suit, "numOrd": numOrd};
                    $scope.cards.push(card);
                    $location.path('/addconfirm/number/' + card.number + '/suit/' + card.suit);
                }
            };

            // When reset is clicked clear the ‘card’ model defined within the scope to
            // clear the form data.
            $scope.reset = function () {
                $scope.card = angular.copy($scope.master);
            };
        }]);

    return cardAppControllers;
}());
