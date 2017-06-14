$(document).ready(function() {

	//load of datatable
	loadDatatable();
	
	// dblclik on datatable
	var table = $('#actorTable').DataTable();
	$('#actorTable tbody').on( 'dblclick', 'tr', function () {
	    let dataRow = table.row( this ).data();
	    $("#id").val(dataRow.id);
		$("#lastUpdate").val(dataRow.lastUpdate);
		$("#firstname").val(dataRow.firstName);
		$("#lastname").val(dataRow.lastName);
	} );
	
	//click on POST
	$("#btn-post").click(function() {
		actor_submit($("#btn-post"), "POST");
	});

	//click on PUT
	$("#btn-put").click(function() {
		actor_submit($("#btn-put"), "PUT");
	});

	//click on RESET
	$("#btn-reset").click(function() {
		resetForm();
	});

	//click on GET
	$("#btn-get").click(function() {
		getActor();
	});

	//click on DELETE
	$("#btn-delete").click(function() {
		deleteActor();
	});
});

function loadDatatable() {
	$('#actorTable').DataTable({
		"columnDefs": [
	            {
	                "targets": [ 0 ],
	                "visible": false,
	                "searchable": false
	            },
	            {
	                "targets": [ 3 ],
	                "visible": false
	            }
	        ],
		"ajax" : {
			url : '/api/actor',
			dataSrc : ''
		},
		"columns" : [ 
			{"data" : "id"},
			{"data" : "firstName"},
			{"data" : "lastName"}, 
			{"data" : "lastUpdate"} ]
	});
	
}

function actor_submit(button, httpVerb) {

	var actor = {}
	actor["id"] = $("#id").val();
	actor["firstName"] = $("#firstname").val();
	actor["lastName"] = $("#lastname").val();
	actor["lastUpdate"] = $("#lastUpdate").val();

	button.prop("disabled", true);

	$.ajax({
		type : httpVerb,
		contentType : "application/json",
		url : "/api/actor",
		data : JSON.stringify(actor),
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedbackactor').html(json);

			console.log("SUCCESS : ", data);
			button.prop("disabled", false);

		},
		error : function(e) {

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedbackactor').html(json);

			console.log("ERROR : ", e);
			button.prop("disabled", false);

		}
	});
}

function resetForm() {
	$('#actor-form')[0].reset();
	$('#feedbackactor').html("");
}

function getActor() {

	var idActor = $("#id").val();

	$.ajax({
		type : "GET",
		contentType : "application/json",
		url : "/api/actor/" + idActor,
		data : {},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedbackactor').html(json);
			$("#id").val(data.id);
			$("#lastUpdate").val(data.lastUpdate);
			$("#firstname").val(data.firstName);
			$("#lastname").val(data.lastName);
			console.log("SUCCESS : ", data);
			button.prop("disabled", false);

		},
		error : function(e) {

			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedbackactor').html(json);

			console.log("ERROR : ", e);
			button.prop("disabled", false);
		}
	});
}

function deleteActor() {

	var idActor = $("#id").val();

	$.ajax({
		type : "DELETE",
		contentType : "application/json",
		url : "/api/actor/" + idActor,
		data : {},
		dataType : 'json',
		cache : false,
		timeout : 600000,
		success : function(data) {

			var json = "<h4>Ajax Response</h4><pre>"
					+ JSON.stringify(data, null, 4) + "</pre>";
			$('#feedbackactor').html(json);
			console.log("SUCCESS : ", data);
			button.prop("disabled", false);

		},
		error : function(e) {
			var json = "<h4>Ajax Response</h4><pre>" + e.responseText
					+ "</pre>";
			$('#feedbackactor').html(json);
			console.log("ERROR : ", e);
		}
	});

}
