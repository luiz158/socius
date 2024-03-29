$(function() {
	$("#new").focus();

	$(document).ready(function() {
		findAllOk();
	});

	$("form").submit(function(event) {
		event.preventDefault();
	});

	$("#new").click(function() {
		location.href = "member-edit.html";
	});

	$("#delete").click(function() {
		var ids = [];

		$("input:checked").each(function(index, value) {
			ids.push($(value).val());
		});

		if (ids.length == 0) {
			alert('Nenhum registro selecionado');
		} else if (confirm('Tem certeza que deseja apagar?')) {
			BookmarkProxy.remove(ids, removeOk);
		}
	});
});

function findAllOk(data) {
	var oTable = $('#resultList').dataTable({
		"aoColumns" : [ {
			"aTargets" : [ 0 ],
			"mData" : "id",
			"mRender" : function(id) {
				return '<input id="remove-' + id + '" type="checkbox" value="' + id + '">';
			}
		}, {
			"aTargets" : [ 1 ],
			"mData" : "description",
			"mRender" : function(data, type, full) {
				return '<a href="bookmark-edit.html?id=' + full.id + '">' + full.description + '</a>';
			}
		}, {
			"aTargets" : [ 2 ],
			"mData" : "link",
			"mRender" : function(link) {
				return '<a href="' + link + '" target="_blank">' + link + '</a>';
			}
		} ],
		"oLanguage" : {
			"sInfo" : "Mostrando _START_ a _END_ de _TOTAL_ registros",
			"sEmptyTable" : "Não há dados disponíveis na tabela",
			"sLengthMenu" : "Mostrar _MENU_ registros",
			"sInfoThousands" : "",
			"oPaginate" : {
				"sFirst" : "Primeiro",
				"sLast" : "Último",
				"sNext" : "Próximo",
				"sPrevious" : "Anterior"
			}
		},
		"bFilter" : false,
		"bRetrieve" : true,
		"sPaginationType" : "bs_full",
		"sAjaxSource" : 'api/member/datatables',
		"bServerSide" : true,
		"bSort" : false
	});
	oTable.fnClearTable();
}

function removeOk(data) {
	findAllOk();
}
