describe('Unit: AppCtrl', function () {
    // Load the module with AppCtrl
    beforeEach(module('myApp'));

    var ctrl, scope;
    // inject the $controller and $rootScope services
    // in the beforeEach block
    beforeEach(inject(function ($controller, $rootScope) {
        // Create a new scope that's a child of the $rootScope
        scope = $rootScope.$new();
        // Create the controller
        ctrl = $controller('AppCtrl', {
            $scope: scope
        });
    }));

    it('AppCtrl should have expected values for title, StartNum, StartString',
      function () {
          // expect(scope.greeting).toBeUndefined();
          // scope.sayHello();
          expect(scope.title).toEqual("AngularJS Tutorial");
          expect(scope.StartNum).toEqual(10);
          expect(scope.StartString).toEqual("Hello!");
      });
})
