describe('angularjs homepage todo list', function () {
    it('should add a todo', function () {
        // Add in your test url.
        browser.get('http://ssdprogram.ca/protractor/test.html');
        expect(browser.getTitle()).toEqual("Starting Angular");
        var inputElement = element(by.model('message'));

        // getText() does not work with input elements.
        expect(inputElement.getAttribute('value')).toEqual('Hello world!');
        expect(element(by.binding('message')).getText())
                                             .toEqual('Hello world!');
    });
});
