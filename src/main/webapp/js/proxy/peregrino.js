PeregrinoProxy = function PeregrinoProxy() {
    this.url = "api/peregrino";
};

PeregrinoProxy.prototype.all = function($success) {
    $.ajax({
		type : "GET",
		url : this.url,
		contentType : "application/json",
		success : function(data) {
		    if ($success) {
		    	$success(data);
		    }
		}
    });
};

PeregrinoProxy.prototype.create = function($form, $success, $error) {
    $.ajax({
		type : "POST",
		url : this.url,
		data : JSON.stringify($form),
		contentType : "application/json",
		success : function(data) {
		    if ($success) {
		    	$success(data);
		    }
		},
		error : function(request) {
		    if ($error) {
		    	$error(request);
		    }
		}
    });
};

PeregrinoProxy.prototype.update = function($form, $success, $error) {
    $.ajax({
		type : "PUT",
		url : this.url,
		data : JSON.stringify($form),
		contentType : "application/json",
		success : function(data) {
		    if ($success) {
		    	$success(data);
		    }
		},
		error : function(request) {
		    if ($error) {
		    	$error(request);
		    }
		}
    });
};
