describe('Protractor tutorial.', function () {
    // Added this helper function. getText() does not work with <input/> element.
    var myGetText = function (element) {
        var inputText = element.getAttribute('value');
        return inputText;
    }

    it('Checking page items.', function () {
        var firstNameElement = element(by.model('firstName'));
        var nameInputText;

        // Must get address from live server.
        browser.get('http://localhost:63342/ex2_protractorContinued/index.html');

        // Check Title
        expect(browser.getTitle()).toEqual('Starting Angular');

        // Check input box contents. 
        nameInputText = myGetText(firstNameElement);
        expect(nameInputText).toEqual('Josie');

        // Check input box.
        element(by.model('firstName')).sendKeys(' Louis');
        nameInputText = myGetText(firstNameElement);
        expect(nameInputText).toEqual('Josie Louis');

        // Check submitted input in paragraph tag.
        var btnName = element(by.id('btnName'));
        btnName.click();
        var elemGreeting = element(by.binding('submittedName'));
        expect(elemGreeting.getText()).toEqual('Greetings: Josie Louis');

        // Check cleared input box.
        element(by.model('firstName')).clear();
        nameInputText = myGetText(firstNameElement);
        expect(nameInputText).toEqual('');

        // Check number count.
        var history = element.all(by.repeater('number in numbers'));
        expect(history.count()).toEqual(9);
    });
});
