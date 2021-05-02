function getRates(){
	readRates();
	readCategories();
	addRateToSelect();
	addRateToSelect2();
	var rate = [];
	
	$(document).on("click",'tr',function(event){
		highlightRow(this);
		$('#dataTable').on('click','tr', function(event){ //ili izbrisati ovu liniju
			rate.length = 0;
			var selectedRow = $(this);
			var td = selectedRow.children('td');
			for (var i = 0; i < td.length; ++i) {
				rate.push(td.eq(i).text());
				
			}
		}); //i ovu
		console.log(rate);
	});
	
	$(document).on("click", '#add', function(event){
		readCategories();
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		addRate();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		readCategories2();
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		updateRate();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		$('#deletePromptModal').modal('show');
	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		deleteRate();
		$('#deletePromptModal').modal('hide');
	});
}

function readRates() {
	$.ajax({
		url : "http://localhost:8080/salesystem/pdvRates/all" 
	}).then(
			function(data, status, request) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].pdv_rate_id)
					newRow = 
					"<tr>" 
						+ "<td class=\"percentage\">" + data[i].percentage + "</td>"
						+ "<td class=\"date\">" + data[i].date + "</td>"
						+ "<td class=\"rate\">" + data[i].pdvCategoryDTO.name + "</td>" +
					"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
	
}

function addRateToSelect(){
	$.ajax({
		url : "http://localhost:8080/salesystem/pdvRates/all"
	}).then(
		function(data) {
			$("#stopaEditSelect").empty();
			$.each(data, function (i, item) {
			    $('#stopaEditSelect').append($('<option>', { 
			        value: item.pdv_rate_id,
			        text : item.percentage
			    }));
			});	
		}
	);
}

function addRateToSelect2(){
	$.ajax({
		url : "http://localhost:8080/salesystem/pdvRates/all"
	}).then(
		function(data) {
			$("#stopaDeleteSelect").empty();
			$.each(data, function (i, item) {
			    $('#stopaDeleteSelect').append($('<option>', { 
			        value: item.pdv_rate_id,
			        text : item.percentage
			    }));
			});	
		}
	);
}

function readCategories(){
	$.ajax({
		url : "http://localhost:8080/salesystem/pdvCategories/all"
	}).then(
		function(data) {
			$("#kategorijaSelect").empty();

				
			$.each(data, function (i, item) {
			    $('#kategorijaSelect').append($('<option>', { 
			        value: item.id,
			        text : item.name

			    }));
			});	
		}
	);
}

function readCategories2(){
	$.ajax({
		url : "http://localhost:8080/salesystem/pdvCategories/all"
	}).then(
		function(data) {
			$("#kategorijaIzmeniSelect").empty();

				
			$.each(data, function (i, item) {
			    $('#kategorijaIzmeniSelect').append($('<option>', { 
			        value: item.id,
			        text : item.name

			    }));
			});	
		}
	);
}

function addRate(){
	var procenatInput = $('#procenatInput');
	var datumInput = $('#datumInput');
	var kategorijaSelect = $('#kategorijaSelect');
	
		var percentage = procenatInput.val();
		var date = datumInput.val();
		var pdvCategoryDTO = kategorijaSelect.val();

		
		console.log('percentage: ' + percentage);
		console.log('date: ' + date);
		console.log('pdvCategoryDTO' + pdvCategoryDTO);
		
		if(percentage == null || date == null || pdvCategoryDTO == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'percentage': percentage,
				'date' : date,
				'pdvCategoryDTO': {
					'id' : pdvCategoryDTO
				}
		}
		

		
		$.ajax({
			url : 'http://localhost:8080/salesystem/pdvRates/add',
			type:'POST',
			data: JSON.stringify(params),
			contentType:'application/json; charset=utf-8',
			dataType:'json',
			success:function(data){
				console.log('...')
				alert('Dodata je nova stopa pdv-a')
				readRates();
				procenatInput.val("");
				datumInput.val("");
				kategorijaSelect.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
}

function updateRate() {
	var procenatIzmeniInput = $('#procenatIzmeniInput');
	var datumIzmeniInput = $('#datumIzmeniInput');
	var kategorijaIzmeniSelect = $('#kategorijaIzmeniSelect');
	var izaberiStopu = $('#stopaEditSelect');

	var percentage = procenatIzmeniInput.val();
	var date = datumIzmeniInput.val();
	var pdvCategoryDTO = kategorijaIzmeniSelect.val();
	var izabranaStopa = izaberiStopu.val();

	console.log('percentage: ' + percentage);
	console.log('date: ' + date);
	console.log('pdvCategoryDTO: ' + pdvCategoryDTO);
	console.log('izabranaStopa: ' + izabranaStopa);

		
	var params = {
			'pdv_rate_id': izabranaStopa,
			'date': date,
			'pdvCategoryDTO': {
				'id' : pdvCategoryDTO
			}
	}
	
	$.ajax({
		url:"http://localhost:8080/salesystem/pdvRates/" + izabranaStopa,
		type:"PUT",
		data: JSON.stringify(params),
		contentType:"application/json; charset=utf-8",
		dataType:"json",
		success:function(data){
			console.log(data);
			readRates();
			procenatIzmeniInput.val("");
			datumIzmeniInput.val("");
			kategorijaIzmeniSelect.val("");
		}
	});

	console.log('slanje poruke');
	event.preventDefault();
	return false;
	
	
// });
}
function deleteRate(){
	var izaberiStopu = $('#stopaDeleteSelect');
	var izabranaStopa = izaberiStopu.val();
	$.ajax({
    	url: "http://localhost:8080/salesystem/pdvRates/" + izabranaStopa,
    	type: "DELETE",
    	success: function(){
    		alert('Izbrisali ste stopu!');
    		readRates();
        }
	});
}