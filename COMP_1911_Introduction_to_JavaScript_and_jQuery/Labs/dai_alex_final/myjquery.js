/**
 * Created by Rosalio on 12/14/14.
 */
$.validator.setDefaults({
    submitHandler: function() {
        alert('submitted!');
    }
});

$.validator.addMethod("startWithNumber", function(input, element){
   return !input || input.match(/^[0-9]/);
}, 'This field must start with a number');

$(document).ready(function() {
    $('#myForm').validate({
        rules: {
            userName: {
                required: true,
                minlength: 5,
                maxlength: 10
            },
            email: {
                required: true,
                email: true
            },
            address: {
                required: false,
                'startWithNumber': true
            },
            year: {
                required: true,
                number: true
            }
        }
    });
});