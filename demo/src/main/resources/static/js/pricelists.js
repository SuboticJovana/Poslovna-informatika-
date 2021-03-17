function getPricelists(){
	readPricelists();
	readEnterprises();
	readEnterprises2();
	
	$(document).on("click",'tr',function(event){
		highlightRow(this);
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
		console.log(getIdOfSelectedEntityPricelist());
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
		var name = getNameOfSelectedEntityCenovnik();
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
}

function readPricelists() {
		var pageNo = 0; 
		var pricelistPagination = $('#cenovnik-page');
		var nmbSelect = $('#nmb-select');
		var pageSize = nmbSelect.find(":selected").text();
		$.ajax({
			url : "http://localhost:8080/salesystem/pricelists/all" 
		}).then(
				function(data, status, request) {
					console.log(data);
					pricelistPagination.empty();
					$("#dataTableBody").empty();
					console.log(request.getResponseHeader('total'));
					for(var j=0; j<request.getResponseHeader('total'); j++){
						pricelistPagination.append(`<li class="page-item  ${pageNo==j? 'active':''}">` +
	                        `<${pageNo==j? 'span':'a'} class="page-link" pageNo="${j}">${j+1}</${pageNo==j? 'span':'a'}></li>`);
	                }
					for (i = 0; i < data.length; i++) {
						console.log(data[i].pricelist_id)
						newRow = 
						"<tr>" 
							+ "<td class=\"dateFrom\">" + data[i].dateFrom + "</td>"
							+ "<td class=\"enterprice\">" + data[i].enterprise.nameEnterprise + "</td>"
							+ "<td class=\"pricelist_id\"  style:display:none>" + data[i].pricelist_id + "</td>" +
						"</tr>"
						$("#dataTableBody").append(newRow);
					}
				});
		
		$("#first").click(function(){
			goFirst()
		 });
		
		$("#next").click(function(){
			goNext()
		 });
		
		nmbSelect.on('change',function (event){
			event.preventDefault();
			pageSize = $(this).val();
			readPricelists();
		});
		pricelistPagination.on("click","a.page-link",function(event){
			event.preventDefault();
			pageNo = $(this).attr("pageno");
			readPricelists();
		});
}

function readEnterprises(){
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/all"
	}).then(
		function(data) {
			$("#preduzeceSelect").empty();
			$('#preduzeceSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
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
			$('#preduzeceIzmeniSelect').append($('<option>', {
			    value: 1,
			    text: ''
			}));
			
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
	
	$('#doAdd').on('click', function(event){
		var datum_vazenja = datumInput.val();
		var preduzece = preduzeceSelect.find(":selected").text();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('preduzece: ' + preduzece);
		
		if(datum_vazenja == null || preduzece == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'datum_vazenja': datum_vazenja,
				'preduzece': preduzece
		}
		$.post("http://localhost/salesystem/pricelists/addPricelist", params, function(data){
			console.log('...')
			alert('Dodat je novi cenovnik')
			readPricelists();
			datumInput.val("");
			preduzeceSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

function updatePricelist() {
	var id = getIdOfSelectedEntityPricelist();
	console.log(id);
	
	var datumIzmeniInput = $('#datumIzmeniInput');
	var preduzeceIzmeniSelect = $('#preduzeceIzmeniSelect');
	
	$("#doUpdate").on("click", function(event) {
		var datum_vazenja = datumIzmeniInput.val();
		var preduzece = preduzeceIzmeniSelect.find(":selected").text();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('preduzece: ' + preduzece);
		
		var params = {
				'id': id,
				'datum_vazenja': datum_vazenja,
				'preduzece': preduzece
				
		}
		$.post("http://localhost:8080/salesystem/pricelists/updatePricelist", params, function(data) {
			console.log('ispis...')
			console.log(data);
			
			alert('Izmena cenovnika');
			
			readPricelists();
			datumIzmeniInput.val("");
			preduzeceIzmeniSelect.val("");
		});
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
}

function deletePricelist(){
	var id = getIdOfSelectedEntityPricelist();
	console.log(id);
	$.ajax({
    	url: "http://localhost:8080/salesystem/pricelists/deletePricelist/" + id,
    	type: "DELETE",
    	success: function(){
    		readPricelists();
        }
	});
}

