describe('Testing a service with $httpBackend.', function () {
    var myService, $httpBackend;                        // Local instances.

    beforeEach(function () {
        module('myApp');                                // Load module.

        inject(function (_myService_, _$httpBackend_) { // Inject services.
            $httpBackend = _$httpBackend_;
            myService = _myService_;
        });
    });

    it("Test 'myService' with mock $http service.", function () {
        // For this request, fake (mock) success response for any
        // request to http://ssdprogram.ca/testJson.php.
        $httpBackend.expectGET('http://ssdprogram.ca/testJson.php')
                    .respond(400, [1, 2]);

        var myData;
        var response = myService.getNumbers();
        response.then(
              function (data) {
                  myData = data;
              },
              function (errorReason) {
                  myData = errorReason;
              });

        expect(myData[1]).not.toEqual(2);
        $httpBackend.flush(); // Invoke mock http request.

        console.log("$httpBackEnd test results: " + myData);
    });
});
