/**
 * Created by Rosalio on 12/14/14.
 */
window.onload = function(){
    var getSports = document.getElementsByClassName('sports');
    for (var i = 0; i < getSports.length; i++) {
        getSports[i].style.border = 'solid green';
    }

    var getLife = document.getElementsByClassName('life');
    for (var i = 0; i < getLife.length; i++) {
        getLife[i].style.color = 'red';
    }

    var getBooks = document.getElementsByClassName('books');
    for (var i = 0; i < getBooks.length; i++) {
        getBooks[i].style.textAlign = 'right';
    }

    var getComedy = document.getElementsByClassName('comedy');
    for (var i = 0; i < getComedy.length; i++) {
        getComedy[i].style.fontSize = 'large';
    }

}