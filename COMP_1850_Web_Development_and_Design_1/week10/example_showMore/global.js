function hasClass(myElementID, myClass) {
	var myElement = document.getElementById(myElementID);
	return myElement.className.match(new RegExp('(\\s|^)' + myClass + '(\\s|$)'));
}

function addClass(myElementID, myClass){
	var myElement = document.getElementById(myElementID);
	myElement.className += " " + myClass;
}

function removeClass(myElementID, myClass){
	var myElement = document.getElementById(myElementID);
	var reg = new RegExp('(\\s|^)' + myClass + '(\\s|$)');
	myElement.className = myElement.className.replace(reg, ' ');
}

function changeClass(myElementID,myClass){
	if(hasClass(myElementID,myClass)){
		removeClass(myElementID,myClass);
	}else{
		addClass(myElementID, myClass);
	}
}