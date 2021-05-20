function getEnterprise(){
	readEnterprise();
}

function readEnterprise() {
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/all" 
	}).then(
			function(data, status, request) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].enterprise_id)
					newRow = 
					"<tr>" 
						+ "<td class=\"name\">" + data[i].nameEnterprise + "</td>"
						+ "<td class=\"city_name\">" + data[i].address + "</td>"
                        + "<td class=\"city_name\">" + data[i].phone + "</td>" 
                        + "<td class=\"city_name\">" + data[i].fax + "</td>"
                        + "<td class=\"cityes\">" + data[i].cityDTO.city_name + "</td>"  +
					"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
 function readCityes(){
        $.ajax({
            url : "http://localhost:8080/salesystem/cityes/all"
        }).then(function(data){
                    $("#citySelect").empty();
                    $.each(data, function(i,item){
                        $('#citySelect').append($('<option>',{
                            value : item.city_id,
                            text : item.city_name
                        }));
                    });
                });
            }
            
	
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
	
	$(document).on("click", '#edit', function(event){
		addCityToSelect();
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		updateCity();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		readCityes();
		$('#deletePromptModal').modal('show');
	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		deleteCity();
		$('#deletePromptModal').modal('hide');
	});
}

function addEnterprise(){
	var telefonInput = $('#telefonInput');
	var nazivInput = $('#nazivInput');
    var adresaInput =$('#adresaInput');
    var faxInput =$('#faxInput');
    var citySelect = ('#robaSelect')



	
		var phone = telefonInput.val();
		var nameEnterprise = nazivInput.val();
        var addresss = adresaInput.val();
        var fax = faxInput.val();
        var cityDTO = citySelect.val();

		
		
		console.log('city_name: ' + city_name);
		
		if(telefon == null || adresa == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'ptt': ptt,
				'city_name' : city_name,
		}
		

		
		$.ajax({
			url : 'http://localhost:8080/salesystem/enterprises/add',
			type:'POST',
			data: JSON.stringify(params),
			contentType:'application/json; charset=utf-8',
			dataType:'json',
			success:function(data){
				console.log('...')
				alert('Dodato je novo preduzece')
				readEnterprise();
				nazivInput.val("");
				citySelect.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
} 
function addCitytToSelect(){
	$.ajax({
		url : "http://localhost:8080/salesystem/cityes/all"
	}).then(
		function(data) {
			$("#gradIzmeniSelect").empty();
			$.each(data, function (i, item) {
			    $('#cenovnikEditSelect').append($('<option>', { 
			        value: item.city_id,
			        text : item.city_name
			    }));
			});	
		}
	);
}
function updateEnterprise() {
	var nazivIzmeniInput = $('#nazivIzmeniInput');
	var telefonIzmeniInput = $('#telefonIzmeniInput');
	var adresaIzmeniInput = $('#adresaIzmeniInput');
	var faxIzmeniInput = $('#faxIzmeniInput');
	var izaberiGrad = $('#gradIzmeniSelect');

	var naziv = nazivIzmeniInput.val();
	var telefon = telefonIzmeniInput.val();
	var adresa = adresaIzmeniInput.val();
	var fax = faxIzmeniInput.val();
	var izabranGrad = izaberiGrad.val();

	console.log('naziv: ' + naziv);
	console.log('telefon: ' + telefon);
	console.log('adresa: ' + adresa);
	console.log('fax: ' + fax);
	console.log('izabranGrad: ' + izabranGrad);
		
	var params = {
			'city_id': izabranGrad,
			'naziv': naziv,
			'telefon': telefon,
			'fax': fax,
			'adresa': adresa
	}
	
	$.ajax({
		url:"http://localhost:8080/salesystem/cities/" + izabranGrad,
		type:"PUT",
		data: JSON.stringify(params),
		contentType:"application/json; charset=utf-8",
		dataType:"json",
		success:function(data){
			console.log(data);
			readCities();
			pttIzmeniInput.val("");
			nazivIzmeniInput.val("");
		}
	});

	console.log('slanje poruke');
	event.preventDefault();
	return false;
	
}

function deleteCity(){
	var izaberiGrad = $('#gradDeleteSelect');
	var izabranGrad = izaberiGrad.val();
	$.ajax({
    	url: "http://localhost:8080/salesystem/cities/" + izabranGrad,
    	type: "DELETE",
    	success: function(){
    		alert('Izbrisali ste grad!');
    		readCities();
        }
	});
}