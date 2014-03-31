$(function() {
	
	$.get('menu.html').success(function(data) { 
		$('header').html(data); 
	});
	
	var proxy = new Proxy("api/register"); 
	
	$("#registrar").click(
		function() {
			$("[id$='-message']").hide();
			
			var form = {
			    'usuarioNome' : $("#usuarioNome").val().trim(),
			    'usuarioEmail' : $("#usuarioEmail").val().trim(),
			    'usuarioSenha' : $("#usuarioSenha").val().trim(),
			    'entidadeNome' : $("#entidadeNome").val().trim(),
			    'entidadeSigla' : $("#entidadeSigla").val().trim(),
			    'entidadeCnpj' : $("#entidadeCnpj").val().trim(),
			    'entidadeSite' : $("#entidadeSite").val().trim()
			};
		
			proxy.create(form, success, error);
	    }
    );
});

function success(data) {
	$("#global-message").html("Cadastrado efetuado com sucesso. Clique <a href='login.html'>aqui</a> para efetuar o login.").removeClass("alert-danger").addClass("alert-success").show();
	$("form")[0].reset();
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
    		$("#global-message").html("Erro ao cadastrar evento.").removeClass("alert-success").addClass("alert-danger").show();
    }
}

