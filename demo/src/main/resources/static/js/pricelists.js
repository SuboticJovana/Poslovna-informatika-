function getPricelists(){
	readPricelists();
	readEnterprises();
	readEnterprises2();
	readPricelists2();
	//var selectedRow;
	var pricelist = [];

	$(document).on("click",'tr',function(event){
		highlightRow(this);
		$('#dataTable').on('click','tr', function(event){ //ili izbrisati ovu liniju
			pricelist.length = 0;
			var selectedRow = $(this);
			var td = selectedRow.children('td');
			for (var i = 0; i < td.length; ++i) {
				pricelist.push(td.eq(i).text());
				
			}
		}); //i ovu
		console.log(pricelist);
	});
	
	
	$(document).on("click", '#add', function(event){
		$('#addModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doAdd', function(event){
		addPricelist();
		$('#addModalScrollable').modal('hide');				
	});
	
	$(document).on("click", '.addModalClose', function(event){
		$('#addModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#edit', function(event){
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		updatePricelist();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityPricelist();
		if(name!=null){
			$('#deletePromptText').text("Obrisati cenovnik sa datumom: " + name);
			$('#deletePromptModal').modal('show');
		}
	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		deletePricelist();
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#copy', function(event){
		$('#copyModalScrollable').modal('show');
	});
	
	$(document).on("click", '#doCopy', function(event){
		copyPricelist();
		$('#copyModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.copyModalClose', function(event){
		$('#copyModalScrollable').modal('hide');
	});
	
//	$(document).on("click", '#kopirajCenovnik', function(event){
//		var name = getNameOfSelectedEntityPricelist();
//		if(name!=null){
//			$('#copyPromptText').text("Kopiraj cenovnik sa datumom: " + name);
//			$('#copyPromptModal').modal('show');
//		}
//	});
//	
//	$(document).on("click", '.copyPromptClose', function(event){
//		$('#copyPromptModal').modal('hide');
//	});
//	
//	$(document).on("click", '#doCopy', function(event){
//		copyPricelist();
//		$('#copyPromptModal').modal('hide');
//	});
}

function readPricelists() {
		$.ajax({
			url : "http://localhost:8080/salesystem/pricelists/all" 
		}).then(
				function(data, status, request) {
					console.log(data);
					$("#dataTableBody").empty();
					for (i = 0; i < data.length; i++) {
						console.log(data[i].pricelist_id)
						newRow = 
						"<tr>" 
							+ "<td class=\"dateFrom\">" + data[i].date_from + "</td>"
							+ "<td class=\"enterprice\">" + data[i].enterpriseDTO.nameEnterprise + "</td>" +
						"</tr>"
						$("#dataTableBody").append(newRow);
					}
				});
}

function readPricelists2(){
	console.log('test');
	$.ajax({
		url : "http://localhost:8080/salesystem/pricelists/all"
	}).then(
			function(data){
				console.log('Data' + data);
				$("#cenovnikSelect").empty();
				
				$.each(data, function(i, item){
					$('#cenovnikSelect').append($('<option>', {
					value : item.pricelist_id,
					text : item.date_from
				}));
				
			});
		}	
	);
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

function readEnterprises2() {
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/all"
	}).then(
		function(data) {
			$("#preduzeceIzmeniSelect").empty();
			
			$.each(data, function (i, item) {
			    $('#preduzeceIzmeniSelect').append($('<option>', { 
			        value: item.enterprise_id,
			        text : item.nameEnterprise
			    }));
			});	
		}
	);
}

function addPricelist(){
	var datumInput = $('#datumInput');
	var preduzeceSelect = $('#preduzeceSelect');
	var procenatCenovnikInput = $('#procenatCenovnikInput');
	
	// $('#doAdd').on('click', function(event){
		var date_from = datumInput.val();
		var enterpriseDTO = preduzeceSelect.val();
		var percentage = procenatCenovnikInput.val();

		
		console.log('date_from: ' + date_from);
		console.log('enterpriseDTO: ' + enterpriseDTO);
		console.log('percentage' + percentage);
		
		if(date_from == null || enterpriseDTO == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'date_from': date_from,
				'percentage' : percentage,
				'enterpriseDTO': {
					'enterprise_id' : enterpriseDTO
				}
		}
		

		
		$.ajax({
			url : 'http://localhost:8080/salesystem/pricelists/add',
			type:'POST',
			data: JSON.stringify(params),
			contentType:'application/json; charset=utf-8',
			dataType:'json',
			success:function(data){
				console.log('...')
				alert('Dodat je novi cenovnik')
				readPricelists();
				datumInput.val("");
				preduzeceSelect.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	// });
}

function copyPricelist(){
	var cenovnikSelect = $('#cenovnikSelect');
	var procenatInput =$('#procenatInput')
	
	// $('#doCopy').on('click', function(event){
		var pricelist_id = cenovnikSelect.val();
		var percentage = procenatInput.val();
		console.log('pricelist_id' + pricelist_id);
		
		if(pricelist_id == null || percentage == null){
			alert('Morate izabrati cenovnik')
		}
		
		var params = {
				'pricelists' : {
					'pricelist_id' : pricelist_id,
					'percentage' : percentage
				}
				
		}
		
		console.log(params);
		$.ajax({
			url : 'http://localhost:8080/salesystem/pricelists/copy/' + pricelist_id + '/' + percentage,
			type : 'POST',
			data: JSON.stringify(params),
			contentType:'application/json; charset=utf-8',
			dataType:'json',
			success : function(data){
				alert('Cenovnik je kopiran')
				cenovnikSelect.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	// });	
}


function updatePricelist() {
	
	var pricelist = [];

	$(document).on("click",'tr',function(event){
		highlightRow(this);
		$('#dataTable').on('click','tr', function(event){ //ili izbrisati ovu liniju
			pricelist.length = 0;
			var selectedRow = $(this);
			var td = selectedRow.children('td');
			for (var i = 0; i < td.length; ++i) {
				pricelist.push(td.eq(i).text());
				
			}
		}); //i ovu
		console.log(pricelist);
	});
	
	var datumIzmeniInput = $('#datumIzmeniInput');
	var preduzeceIzmeniSelect = $('#preduzeceIzmeniSelect');
	
	
	// $("#doUpdate").on("click", function(event) {
		var datum_vazenja = datumIzmeniInput.val();
		var preduzece = preduzeceIzmeniSelect.val();
		

		console.log('datum_vazenja: ' + datum_vazenja);
		console.log('preduzece: ' + preduzece);
			
		var params = {
//				'pricelist_id': pricelist_id,
				'date_from': datum_vazenja,
				'enterpriseDTO': {
					'enterprise_id' : preduzece
				}
				
		}
		
		$.ajax({
			url:"http://localhost:8080/salesystem/pricelists/" + pricelist.pricelist_id,
			type:"PUT",
			data: JSON.stringify(params),
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				console.log(data);
				alert('Izmena cenovnika');
				datumIzmeniInput.val("");
				preduzeceIzmeniSelect.val("");
			}
		});

		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	// });
}

function deletePricelist(){
	var pricelist_id = getIdOfSelectedEntityPricelist();
	console.log(pricelist_id);
	$.ajax({
    	url: "http://localhost:8080/salesystem/pricelists/" + pricelist.pricelist_id,
    	type: "DELETE",
    	success: function(){
    		readPricelists();
        }
	});
}

