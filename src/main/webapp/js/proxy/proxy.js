Proxy = function Proxy(path) {
    this.url = path;
};

Proxy.prototype.all = function($success) {
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

Proxy.prototype.load = function($id, $success, $error) {
    $.ajax({
		type : "GET",
		url : this.url + "/" + $id,
		contentType : "application/json",
		success : function(data) {
		    if ($success) {
		    	$success(data);
		    }
		}
    });
};

Proxy.prototype.create = function($form, $success, $error) {
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

Proxy.prototype.update = function($form, $success, $error) {
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
