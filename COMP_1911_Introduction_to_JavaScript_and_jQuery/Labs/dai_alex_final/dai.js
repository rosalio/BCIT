/**
 * Created by Rosalio on 12/14/14.
 */
window.onload = function(){
    document.getElementById('myForm').onsubmit = function(){
        for (var i = 0; i < this.elements.length; i++) {
            if (this.elements[i].className.indexOf('required') != -1){
                if(this.elements[i].value.length == 0){
                    alert(this.elements[i].name + ' is required.');
                    this.elements[i].focus();
                    return false;
                }
            }
        }

        var  userName = document.getElementById('userName');
        if(userName.value.length < 5 || userName.value.length > 10) {
            alert('Username must be 5 - 10 characters long.');
            return false;
        }

        var email = document.getElementById('email');
        if(email.value.indexOf('@') == -1 || email.value.indexOf('.') == -1) {
            alert('This is not a valid email address.');
            return false;
        }

        var address = document.getElementById('address');
        if(address.value.length > 0 && isNaN(address.value[0])) {
            alert('The street address must start with a number');
            return false;
        }

        var year = document.getElementById('year');
        if(isNaN(year.value)) {
            alert('The year of birth must be numeric only');
            return false;
        }

    }
}