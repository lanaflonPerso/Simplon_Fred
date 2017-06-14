$(document).ready(function() {

		// dblclik on datatable
	var table = $('#CategoryTable').DataTable();
	$('#CategoryTable tbody').on( 'dblclick', 'tr', function () {
	    let dataRow = table.row( this ).data();
	    $("#idCategory").val(dataRow.id);
		$("#lastUpdateCategory").val(dataRow.lastUpdate);
		$("#nameCategory").val(dataRow.name);
	} );
	
	//click on POST
	$("#btnCategory-post").click(function() {
		Category_submit($("#btnCategory-post"), "POST");
	});

	//click on PUT
	$("#btnCategory-put").click(function() {
		Category_submit($("#btnCategory-put"), "PUT");
	});

	//click on RESET
	$("#btnCategory-reset").click(function() {
		resetFormCategory();
	});

	//click on GET
	$("#btnCategory-get").click(function() {
		getCategory();
	});

	//click on DELETE
	$("#btnCategory-delete").click(function() {
		deleteCategory();
	});
});

function loadDatatableCategory() {
	$('#categoryTable').DataTable({
		"columnDefs": [
	            {
	                "targets": [ 0 ],
	                "visible": false,
	                "searchable": false
	            },
	            {
	                "targets": [ 2 ],
	                "visible": false
	            }
	        ],
		"ajax" : {
			url : '/api/category',
			dataSrc : ''
		},
		"columns" : [ 
			{"data" : "id"},
			{"data" : "name"},
			{"data" : "lastUpdate"} ]
	});
	
}

function Category_submit(button, httpVerb) {

	var Category = {}
	Category["id"] = $("#idCategory").val();
	Category["name"] = $("#nameCategory").val();
	Category["lastUpdate"] = $("#lastUpdateCategory").val();

	button.prop("disabled", true);

	$.ajax({
		type : httpVerb,
		contentType : "application/json",
		url : "/api/Category",
		data : JSON.stringify(Category),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedbackCategory').html(json);

			console.log("SUCCESS : ", data);
			button.prop("disabled", false);

		},
		error : function(e) {

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedbackCategory').html(json);

			console.log("ERROR : ", e);
			button.prop("disabled", false);

		}
	});
}

function resetFormCategory() {
	$('#category-form')[0].reset();
	$('#feedbackCategory').html("");
}

function getCategory() {

	var idCategory = $("#idCategory").val();
	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/Category/" + idCategory,
		data : {},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedbackCategory').html(json);
			$("#idCategory").val(data.id);
			$("#lastUpdateCategory").val(data.lastUpdate);
			$("#nameCategory").val(data.name);
			console.log("SUCCESS : ", data);
			button.prop("disabled", false);

		},
		error : function(e) {

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedbackCategory').html(json);

			console.log("ERROR : ", e);
			button.prop("disabled", false);
		}
	});
}

function deleteCategory() {

	var idCategory = $("#idCategory").val();

	$.ajax({
		type : "DELETE",
		contentType : "application/json",
		url : "/api/Category/" + idCategory,
		data : {},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedbackCategory').html(json);
			console.log("SUCCESS : ", data);
			button.prop("disabled", false);

		},
		error : function(e) {
			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedbackCategory').html(json);
			console.log("ERROR : ", e);
		}
	});

}
