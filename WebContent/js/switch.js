$(document).ready(function() {
	$('.switch').unbind("click").click(function(){
		console.log("toggling visibility");
	   $('.form').toggle();
	});
});
