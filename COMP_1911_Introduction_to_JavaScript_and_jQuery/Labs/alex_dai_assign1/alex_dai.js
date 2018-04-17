/**
 * Created by Rosalio on 12/6/14.
 */
window.onload = function() {
    var getImages = document.getElementsByTagName('img');
    for (var i = 0; i < getImages.length; i++) {
        getImages[i].onclick = function () {
            if (this.style.border.length == 0) {
                this.style.border = "solid red 5px";
            } else {
                this.style.border = "";
            }
        }
    }

    document.getElementById("myForm").onsubmit = function(){
        var user_name = document.getElementById("userName");
        var birth_year = document.getElementById("birthYear");

        if (user_name.value.length == 0) {
            alert("username required!");
            user_name.focus();
            return false;
        }

        if (birth_year.value.length != 0 && isNaN(birth_year.value)) {
            birth_year.select();
            return false;
        }

        if (birth_year.value.length != 0 && (birth_year.value < 1900 || birth_year.value > 2012)) {
            birth_year.style.backgroundColor = "yellow";
            return false;
        }

        alert("Successfully submitted.");
        return true;
    }
}