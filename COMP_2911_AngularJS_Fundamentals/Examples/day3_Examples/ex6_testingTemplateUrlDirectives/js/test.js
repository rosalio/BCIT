describe('Unit testing directive using templateURL', function () {
    var $compile, scope, $httpBackend, template;
    beforeEach(module('myApp'));

    beforeEach(inject(function (_$compile_, _$rootScope_, _$httpBackend_) {
        $compile = _$compile_;          // Need to create HTML drom directive.
        scope = _$rootScope_.$new(); // Create child of $rootScope.
        $httpBackend = _$httpBackend_;      // Needed to mock templateURL response.
        template = '<ul class="rating">'    // Create a mock template.
                 + '<li ng-repeat="star in stars" class="filled">&#9733;</li>'
                 + '</ul>';

        // Return mock template whenever 'views/stars.html' is called.
        $httpBackend.expectGET('views/stars.html').respond(template);
    }));

    it('Replaces the element with  appropriate content', function () {
        var starTag = '<div my-stars rating="3"></div>'; // Create tag with directive.
        var element = $compile(starTag)(scope);          // Compile to HTML.
        $httpBackend.flush();                            // Get mock response.
        var bullet = '<li ng-repeat="star in stars" class="filled ng-scope">★</li>';
        expect(element.html()).toContain(bullet);        // Check for bullet tag.
        var totalStars = element.children('li').length;  // Check star count.
        expect(totalStars).toEqual(3);
    });
});
