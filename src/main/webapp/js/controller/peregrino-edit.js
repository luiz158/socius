$(function() {

	$("#voltar").click(function(){
		location.href="peregrino-list.html";
	});
	
    $("form").submit(
	    function(event) {
		$("[id$='-message']").hide();

		var form = {
		    'numerosocio' : $("#numerosocio").val().trim(),
		    'nome' : $("#nome").val().trim(),
		    'sangue' : $("#sangue").val().trim(),
		    'sexo' : $("#sexo").val().trim(),
		    'datanascimento' : $("#datanascimento").val().trim(),
		    'rg' : $("#rg").val().trim(),
		    'cpf' : $("#cpf").val().trim(),
		    'email' : $("#email").val().trim(),
		    'telefoneresidencial' : $("#telefoneresidencial").val().trim(),
		    'telefonecelular' : $("#telefonecelular").val().trim(),
		    'endereco' : $("#endereco").val().trim(),
		    'bairro' : $("#bairro").val().trim(),
		    'municipio' : $("#municipio").val().trim(),
		    'estado' : $("#estado").val().trim(),
		    'pais' : $("#pais").val().trim(),
		    'cep' : $("#cep").val().trim()
		};
		
		if($("#id").val() === ""){
			new PeregrinoProxy().create(form, success, error);
		} else {
			form.id = $("#id").val().trim();
			new PeregrinoProxy().update(form, success, error);
		}

		return false;
	    });
});

function success(data) {
	console.log('x');
	$("#global-message").html("Peregrino cadastrado com sucesso.").removeClass("alert-danger").addClass("alert-success").show();
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
    		$("#global-message").html("Erro ao cadastrar peregrino.").removeClass("alert-success").addClass("alert-danger").show();
    }
}
