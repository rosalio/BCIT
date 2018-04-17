describe('Unit: AppCtrl', function () {
    // Load the module with AppCtrl
    beforeEach(module('cardApp'));

    var ctrl, scope;
    // inject the $controller and $rootScope services
    // in the beforeEach block
    beforeEach(inject(function ($controller, $rootScope) {
        // Create a new scope that's a child of the $rootScope
        scope = $rootScope.$new();
        // Create the controller
        ctrl = $controller('AddCtrl', {
            $scope: scope
        });
    }));

    it('AddCtrl tests: ',
      function () {
          // Check first card that was added to the root scope (see app.js)
          expect(scope.cards[0].number).toEqual("2");
          expect(scope.cards[0].suit).toEqual("Hearts");

          // Add new card and ensure it is included with other cards.
          var card = {};
          scope.card = card;
          scope.card.number = 'A';
          scope.card.suit = 'Clubs';
          var added = scope.add(card);
          var newIndex   = scope.cards.length - 1;
          expect(scope.cards[newIndex].number).toEqual("A");
          expect(scope.cards[newIndex].suit).toEqual("Clubs");
      });

    it('AddCtrl duplicate tests: ',
        function () {
            // Try to add the first card again
            var oldLength = scope.cards.length;
            var card = scope.cards[0];
            scope.add(card);
            var newLength = scope.cards.length;

            // If Adding duplicate card is disallowed, the number of added cards does not change.
            // And the last card remains the same
            expect(newLength).toEqual(oldLength);
            expect(scope.cards[newLength-1].number).toEqual("Q");
            expect(scope.cards[newLength -1].suit).toEqual("Hearts");
        });
});

describe('Unit: DeleteCtrl', function () {
    // Load the module with AppCtrl
    beforeEach(module('cardApp'));

    var ctrl, scope;
    // inject the $controller and $rootScope services
    // in the beforeEach block
    beforeEach(inject(function ($controller, $rootScope) {
        // Create a new scope that's a child of the $rootScope
        scope = $rootScope.$new();
        // Create the controller
        ctrl = $controller('DeleteCtrl', {
            $scope: scope,
            $routeParams: {numberID: "2", suitID: "Hearts"}
        });
    }));

    it('Delete card tests: ',
        function () {
            // Compare the size of cards before and after deleting
            // After deleting the first card, the new first card should be the second card before deletion
            var oldLength = scope.cards.length;
            scope.delete();
            var newLength = scope.cards.length;

            expect(newLength).toEqual(oldLength - 1);
            expect(scope.cards[0].number).toEqual("10");
            expect(scope.cards[0].suit).toEqual("Spades");
        });
});

