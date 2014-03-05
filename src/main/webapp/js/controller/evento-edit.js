$(function() {
	
	var proxy = new Proxy("api/evento"); 
	var id = $.url().param('id');
	
	if (id !== undefined){
		proxy.load(id, loadForm);
	}
	
	$("#voltar").click(function(){
		location.href="evento-list.html";
	});
	
    $("form").submit(
	    function(event) {
	    	$("[id$='-message']").hide();

			var form = {
			    'nome' : $("#nome").val().trim(),
			};
		
			if($("#id").val() === ""){
				proxy.create(form, success, error);
			} else {
				form.id = $("#id").val().trim();
				proxy.update(form, success, error);
			}
	
			return false;
	    }
    );
});

function success(data) {
	$("#global-message").html("Evento cadastrado com sucesso.").removeClass("alert-danger").addClass("alert-success").show();
}

function error(request) {
    switch (request.status) {
    	case 412:
    		$.each(request.responseJSON, function(index, value) {
    			$("#" + value.property + "-message").html(value.message).show();
    			if ($("#" + value.property)) {
    				$("#" + value.property).focus();
    			}
    		});
    		break;
    	default:
    		console.log(request);
    		$("#global-message").html("Erro ao cadastrar evento.").removeClass("alert-success").addClass("alert-danger").show();
    }
}

function loadForm(peregrino){
	$(Object.keys(peregrino)).each(function(index, property) {
		$("#" + property).val(peregrino[property]);
	});
}
