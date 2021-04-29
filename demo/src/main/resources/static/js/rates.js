function getRates(){
	readRates();
	readCategories();
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		addRate();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
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