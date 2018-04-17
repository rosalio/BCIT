describe('Unit: myControllers', function () {
    beforeEach(module('myApp'));

    var ctrl, scope;

    beforeEach(inject(function ($controller, $rootScope) {
        scope = $rootScope.$new();
        ctrl = $controller('ExampleController', {
            $scope: scope
        });
    }));

    it('ExampleController should have expected values for mailService',
      function () {
          scope.update("The Mail Service");
          expect(scope.mailService).toBeDefined();
          expect(scope.mailService).toEqual("The Mail Service");
      });
})
