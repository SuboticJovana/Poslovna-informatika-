function getEnterprise(){
	readEnterprise();
	var enterprise = [];

	$(document).on("click",'tr',function(event){
		highlightRow(this);
		$('#dataTable').on('click','tr', function(event){ //ili izbrisati ovu liniju
			pricelist.length = 0;
			var selectedRow = $(this);
			var td = selectedRow.children('td');
			for (var i = 0; i < td.length; ++i) {
				city.push(td.eq(i).text());
				
			}
		}); //i ovu
		console.log(enterprise);
	});
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		addEnterprise();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		addCityToSelect();
		$('#updateModalScrollable').modal('show');
	});
	
//	$(document).on("click", "#doUpdate", function(event) {
//		updateCity();
//		$('#updateModalScrollable').modal('hide');
//	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		addCityToSelect2();
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
var citiesArray = [];

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

		
		
		console.log('enterprise_name: ' + nameEnterprise);
		
		if(phone == null || address == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'phone': phone,
				'nameEnterprise' : nameEnterprise,
				'address': address,
				'fax' : fax,
				'cityDTO': {
					'id' : cityDTO
				}
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
		url : "http://localhost:8080/salesystem/enterprise/all"
	}).then(
		function(data) {
			$("#gradEditSelect").empty();
			$.each(data, function (i, item) {
			    $('#gradEditSelect').append($('<option>', { 
			        value: item.enterprise_id,
			        text : item.nameEnterprise
			    }));
			});	
		}
	);
}
function addCityToSelect2(){
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/all"
	}).then(
		function(data) {
			$("#gradDeleteSelect").empty();
			$.each(data, function (i, item) {
			    $('#gradDeleteSelect').append($('<option>', { 
			        value: item.enterprise_id,
			        text : item.nameEnterprise
			    }));
			});	
		}
	);
}
//EDIT

$(document).on("click", '#fillOutCityFieldsEdit', function(event) {
	var id = document.getElementById("gradEditSelect").value;
	if(!id) {
		alert("Morate izabrati preduzece da biste izvrsili izmenu");
	}
	var chosenCityData = citiesArray.filter(enterprise => enterprise.enterprise_id == id);
	console.log(chosenCityData[0].nameEnterprise);
	$('#nazivIzmeniInput').val(chosenCityData[0].nameEnterprise);
	$('#adresaIzmeniInput').val(chosenCityData[0].address);
	$('#telefonIzmeniInput').val(chosenCityData[0].phone);
	$('#faxIzmeniInput').val(chosenCityData[0].fax);
	event.preventDefault();
});


$(document).on("click", '#doUpdate', function(event){
	if(!document.getElementById("gradEditSelect").value){
		alert('Izaberite preduzece za izmenu');
		return;
	}
var nazivIzmeniInput = $('#nazivIzmeniInput');
var adresaIzmeniInput =$('#adresaIzmeniInput');
var telefonIzmeniInput =$('#telefonIzmeniInput');
var faxIzmeniInput =$('#faxIzmeniInput');
var izaberiGrad = $('#gradEditSelect');

var nameEnterprise = nazivIzmeniInput.val();
var address = adresaIzmeniInput.val();
var phone = telefonIzmeniInput.val();
var fax = faxIzmeniInput.val();


var cityDTO = gradIzmeniSelect.val();

var izabranGrad = izaberiGrad.val();

console.log('nameEnterprise: ' + nameEnterprise);
console.log('address: ' + address);
console.log('phone: ' + phone);
console.log('fax: ' + fax);
console.log('izabranGrad: ' + izabranGrad);
	
var params = {
		'enterprise_id': izabranGrad,
		'nameEnterprise': nameEnterprise,
		'phone': phone,
		'fax': phone,
		'cityDTO': {
			'id' : cityDTO
		}
}

$.ajax({
	url:"http://localhost:8080/salesystem/enterprises/" + izabranGrad,
	type:"PUT",
	data: JSON.stringify(params),
	contentType:"application/json; charset=utf-8",
	dataType:"json",
	success:function(data){
		console.log(data);
		readEnterprise();
		nazivIzmeniInput.val("");
		adresaIzmeniInput.val("");
		telefonIzmeniInput.val("");
		faxIzmeniInput.val("");
		
		$('#updateModalScrollable').modal('hide');
	}
});
});

function deleteCity(){
	var izaberiGrad = $('#gradDeleteSelect');
	var izabranGrad = izaberiGrad.val();
	$.ajax({
    	url: "http://localhost:8080/salesystem/enterprise/" + izabranGrad,
    	type: "DELETE",
    	success: function(){
    		alert('Izbrisali ste grad!');
    		readCities();
        }
	});
}
}