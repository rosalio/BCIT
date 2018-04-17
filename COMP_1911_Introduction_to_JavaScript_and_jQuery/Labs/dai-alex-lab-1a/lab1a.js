// Change the source image to a cat
window.document.images[0].src = 'cat.jpg';

// Get user browser information
var userAgent = navigator.userAgent.toLowerCase();
var browser = {
	chrome:/chrome/.test(userAgent),
	firefox:/firefox/.test(userAgent),
	ie:/trident/.test(userAgent)
};

// Show messages in alert dialog boxes	
if (browser.firefox) {
	alert('What does the fox say?');
} else if (browser.chrome) {
	alert('Is Google doing any evil?');
} else if (browser.ie) {
	alert('What is Bill Gates\' net worth?');
} else {
	alert(navigator.appName);
}