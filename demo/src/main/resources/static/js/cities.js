function getCities(){
	readCities();
}

function readCities() {
	$.ajax({
		url : "http://localhost:8080/salesystem/cities/all" 
	}).then(
			function(data, status, request) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].city_id)
					newRow = 
					"<tr>" 
						+ "<td class=\"ptt\">" + data[i].ptt + "</td>"
						+ "<td class=\"city_name\">" + data[i].city_name + "</td>" +
					"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		addCity();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
}

function addCity(){
	var pttInput = $('#pttInput');
	var nazivInput = $('#nazivInput');
	
		var ptt = pttInput.val();
		var city_name = nazivInput.val();
		
		console.log('ptt: ' + ptt);
		console.log('city_name: ' + city_name);
		
		if(ptt == null || city_name == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'ptt': ptt,
				'city_name' : city_name,
		}
		

		
		$.ajax({
			url : 'http://localhost:8080/salesystem/cities/add',
			type:'POST',
			data: JSON.stringify(params),
			contentType:'application/json; charset=utf-8',
			dataType:'json',
			success:function(data){
				console.log('...')
				alert('Dodat je nov grad')
				readCities();
				pttInput.val("");
				nazivInput.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
}