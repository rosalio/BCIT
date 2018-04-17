describe('nameService tests: ', function () {
    var nameService;

    beforeEach(function () {              // Execute before each "it" test is run.
        module('myApp');                  // Load module.

        // Inject service for testing.
        inject(function (_nameService_) { // The _underscores_ are for convenience 
            nameService = _nameService_;  // so local service can have same name.
        });
    });

    it('Should show Mary.', function () { // Test service method.
        var result = nameService.getName();
        expect(result.First).toBe('Mary');
    });
});
