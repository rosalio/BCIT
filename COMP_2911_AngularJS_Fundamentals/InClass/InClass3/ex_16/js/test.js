describe('Unit testing directive using templateURL', function () {
    var $compile, scope, $httpBackend, template;
    beforeEach(module('myApp'));

    beforeEach(inject(function (_$compile_, _$rootScope_, _$httpBackend_) {
        $compile = _$compile_;          // Need to create HTML drom directive.
        scope = _$rootScope_.$new(); // Create child of $rootScope.
        $httpBackend = _$httpBackend_;      // Needed to mock templateURL response.

        var template = function () {
            return '<div ng-form="myform">' +
                '<div class="control-group" class="{{options.class}}">' +
                '<div class="control-label">{{options.label || "Radio"}} {{ options.required ? "*" : ""}} </div>' +
                '<div class="controls">' +
                '<div class="radio" ng-repeat="(key, option) in options.valueList">' +
                '<label> <input type="radio" name="myfield" ng-value="option.value" ng-model="$parent.ngModel" ng-required="options.required" />{{option.text}} </label>' +
                '</div>' +
                '<div class="field-validation-error" data-ng-show="myform.myfield.$invalid && myform.myfield.$dirty"> ' +
                '<div data-ng-show="myform.myfield.$error.required">{{options.label}} is required!!!</div>' +
                '</div>' +
                '</div>' +
                '</div>' +
                '</div>';
        };

        // Return mock template whenever 'views/stars.html' is called.
        $httpBackend.expectGET('views/mailOption.html').respond(template);
    }));

    it('Replaces the element with  appropriate content', function () {
        var mailTag = '<cs-radio-field options="mailOptions" ng-model="mailValue"></cs-radio-field>';
        var element = $compile(mailTag)(scope);          // Compile to HTML.
        $httpBackend.flush();                            // Get mock response.

        var mailStatus
        expect(mailStatus).toEqual("Do Not Mail");
    });
});
