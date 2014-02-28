$(function() {
	
	$("#novo").click(function(){
		location.href="peregrino-edit.html";
	});
	
	new PeregrinoProxy().all(drawTable);

	$( document ).on( "click", ".edit", function(){
		location.href = "peregrino-edit.html?id=" + this.getAttribute("data-id");
	});
	
	/*
	$( document ).on( "click", ".remove", function(){
		$this = $(this);
	  if(confirm('Deseja realmente apagar esse registro?')){
			 $.when(
			 		persistenceService.remove("modality", this.getAttribute("data-id")) 
   ).done(function(){
	  			var $row = $this.parents('tr:first');
        	footable.removeRow($row);
   });
		}
	})
	*/;
  
});

function drawTable(peregrinos){
	$.each(peregrinos, function(idx, obj){
		console.log(obj);
		var row = '<tr>';
		$.each(obj, function(key, value) {
			if(key=="id" || key=="numerosocio" || key=="nome" || key=="email")
			row += '<td>' + value + '</td>';
		});
		row += '<td><button type="button" class="btn btn-sm btn-success edit" style="width:60px" data-id="' + obj.id + '">Editar</button></td>';
		row += '<td><button type="button" class="btn btn-sm btn-danger remove" style="width:60px" data-id="' + obj.id + '">Excluir</button></td>';
		row += '</tr>';
		$("#peregrino").append(row);
	});
}
