describe('Directive unit test: ', function () {
    var $compile, $scope;

    // Load the myApp module.
    beforeEach(module('myApp'));

    // Inject and store references to $rootScope and $compile.
    beforeEach(inject(function (_$compile_, _$rootScope_) {
        $compile = _$compile_;
        $scope = _$rootScope_.$new();
    }));

    it('Replaces the element with the appropriate content', function () {
        // Compile HTML containing the directive.
        var element = $compile("<my-header></my-header>")($scope);
        // Ensure the compiled element contains the templated content.
        expect(element.html()).toContain("Google - California!");
    });
});
