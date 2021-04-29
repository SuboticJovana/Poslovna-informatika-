function getPartners(){
	readPartners();
	readCities();
	readEnterprises();
}

function readPartners() {
	$.ajax({
		url : "http://localhost:8080/salesystem/partners/all" 
	}).then(
			function(data, status, request) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].partner_id)
					newRow = 
					"<tr>" 
						+ "<td class=\"partner_name\">" + data[i].partner_name + "</td>"
						+ "<td class=\"address\">" + data[i].address + "</td>"
						+ "<td class=\"phone_number\">" + data[i].phone_number + "</td>"
						+ "<td class=\"fax\">" + data[i].fax + "</td>"
						+ "<td class=\"email\">" + data[i].email + "</td>"
						+ "<td class=\"city\">" + data[i].cityDTO.city_name + "</td>" +
						+ "<td class=\"enterprice\">" + data[i].enterpriseDTO.nameEnterprise + "</td>" +
					"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		addPartner();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
}

function readEnterprises(){
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/all"
	}).then(
		function(data) {
			$("#preduzeceSelect").empty();

				
			$.each(data, function (i, item) {
			    $('#preduzeceSelect').append($('<option>', { 
			        value: item.enterprise_id,
			        text : item.nameEnterprise

			    }));
			});	
		}
	);
}

function readCities(){
	$.ajax({
		url : "http://localhost:8080/salesystem/cities/all"
	}).then(
		function(data) {
			$("#gradSelect").empty();

				
			$.each(data, function (i, item) {
			    $('#gradSelect').append($('<option>', { 
			        value: item.city_id,
			        text : item.city_name

			    }));
			});	
		}
	);
}

function addPartner(){
	var nazivInput = $('#nazivInput');
	var adresaInput = $('#adresaInput');
	var telefonInput = $('#telefonInput');
	var faxInput = $('#faxInput');
	var gradSelect = $('#gradSelect');
	var preduzeceSelect = $('#preduzeceSelect');
	
		var partner_name = nazivInput.val();
		var address = adresaInput.val();
		var phone_number = telefonInput.val();
		var fax = faxInput.val();
		var cityDTO = preduzeceSelect.val();
		var enterpriseDTO = preduzeceSelect.val();

		
		console.log('partner_name: ' + partner_name);
		console.log('address: ' + address);
		console.log('phone_number: ' + phone_number);
		console.log('fax: ' + fax);
		console.log('cityDTO: ' + cityDTO);
		console.log('enterpriseDTO' + enterpriseDTO);
		
		if(partner_name == null || address == null || phone_number == null || fax == null || cityDTO == null || enterpriseDTO == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'partner_name': partner_name,
				'address' : address,
				'phone_number' : phone_number,
				'fax' : fax,
				'cityDTO': {
					'city_id' : cityDTO
				},
				'enterpriseDTO': {
					'enterprise_id' : enterpriseDTO
				}
		}
		

		
		$.ajax({
			url : 'http://localhost:8080/salesystem/partners/add',
			type:'POST',
			data: JSON.stringify(params),
			contentType:'application/json; charset=utf-8',
			dataType:'json',
			success:function(data){
				console.log('...')
				alert('Dodat je nov partner')
				readPartners();
				nazivInput.val("");
				adresaInput.val("");
				telefonInput.val("");
				faxInput.val("");
				gradSelect.val("");
				preduzeceSelect.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
}