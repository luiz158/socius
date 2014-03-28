var PeregrinoProxy = {};

PeregrinoProxy.url = "api/member"

PeregrinoProxy.all = function($success, $error) {
    $.ajax({
		type : "GET",
		url : this.url,
		success : $success,
		error: $error
    });
};

PeregrinoProxy.load = function($id, $success, $error) {
    $.ajax({
		type : "GET",
		url : this.url + "/" + $id,
		success : $success,
		error: $error
    });
};

PeregrinoProxy.insert = function($form, $success, $error) {
    $.ajax({
		type : "POST",
		url : this.url,
		data : JSON.stringify($form),
		contentType : "application/json",
		success : $success,
		error : $error
    });
};

PeregrinoProxy.update = function($id, $form, $success, $error) {
    $.ajax({
    	type : "POST",
		url : this.url + "/" + $id,
		data : JSON.stringify($form),
		contentType : "application/json",
		success : $success,
		error : $error
    });
};

PeregrinoProxy.remove = function($ids, $success, $error) {
	$.ajax({
		type : "DELETE",
		url : this.url,
		data : JSON.stringify($ids),
		contentType : "application/json",
		success : $success,
		error : $error
	});
};
