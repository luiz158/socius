$(function() {
	
	$("#novo").click(function(){
		location.href="peregrino-edit.html";
	});
	
	new PeregrinoProxy().all(drawTable);

  
});

function drawTable(peregrinos){
	$.each(peregrinos, function(idx, obj){
		console.log(obj);
		var row = '<tr>';
		$.each(obj, function(key, value) {
			if(key=="id" || key=="numerosocio" || key=="nome" || key=="email")
			row += '<td>' + value + '</td>';
		});
		row += '</tr>';
		$("#peregrino").append(row);
	});
}
