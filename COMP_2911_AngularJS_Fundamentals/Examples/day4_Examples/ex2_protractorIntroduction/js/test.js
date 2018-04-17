describe('angularjs homepage todo list', function () {
    it('should add a todo', function () {
        // Add in your test url.
        browser.get('http://localhost:63342/ex1_protractorIntroduction/index.html');
        expect(browser.getTitle()).toEqual("Check boxes");
        var inputElement = element(by.model('chk1'));

        // getText() does not work with input elements.
        expect(inputElement.getAttribute('value')).toBeTruthy();
        expect(element(by.binding('chk2')).getText())
                                             .toEqual('Hello');
    });
});
