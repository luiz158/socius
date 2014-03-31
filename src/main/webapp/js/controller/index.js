$(function() {
	
	$.get('menu.html').success(function(data) { 
		$('header').html(data); 
	});
	
});
