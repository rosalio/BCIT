<?php

/*
after the following section
the $page variable has as its value
the name of the page
eg: if script filename is 'partners.php'
then $page = 'partners'
*/

$scriptname = explode('/', $_SERVER["SCRIPT_NAME"]);
$page = ereg_replace(".php$", "", trim($scriptname[count($scriptname) - 1]));


/*
START of the code snippet
alter to reflect the page names
use one for each page in the nav
*/

if($page == "index"){
	//display the link as unclickable
	echo '<p class="navcurrent">Home</p>';
}else{
	//or display a functioning hyperlink
	echo '<p><a href="index.php">Home</a></p>';
}

if($page == "partners"){
	//display the link as unclickable
	echo '<p class="navcurrent">Partners</p>';
}else{
	//or display a functioning hyperlink
	echo '<p><a href="partners.php">Partners</a></p>';
}


if($page == "stuff"){
	//display the link as unclickable
	echo '<p class="navcurrent">Stuff</p>';
}else{
	//or display a functioning hyperlink
	echo '<p><a href="stuff.php">Stuff</a></p>';
}

if($page == "contact"){
	//display the link as unclickable
	echo '<p class="navcurrent">Contact</p>';
}else{
	//or display a functioning hyperlink
	echo '<p><a href="contact.php">Contact</a></p>';
}


/*
END code snippet
*/

?>
