describe('Testing AppCtrl: ', function () {
    "use strict";
    var myService, $httpBackend, ctrl, scope;

    beforeEach(function () {
        module('myApp');

        inject(function (_myService_, $controller, $rootScope,
                         _$httpBackend_) {
            // Pretend we are loading controller for 1st time
            // so we pass it a child of the $rootScope.
            scope = $rootScope.$new();

            // Assign the controller.
            ctrl = $controller('AppCtrl', {
                $scope: scope // Assign child of rootScope.
            });
            myService = _myService_;
            $httpBackend = _$httpBackend_;
        });
    }
    );

    it('AppCtrl properly invokes myService', function () {
        // Send request and get mock response.
        $httpBackend.expectGET('http://ssdprogram.ca/testJson.php')
                     .respond(200, ["21", "22"]);
        expect(scope).toBeDefined();
        expect(scope.getData).toBeDefined();
        scope.getData();
        $httpBackend.flush();
        expect(scope.numbers[0]).toBe("21");
        expect(scope.error).toBeFalsy();
    });
});
