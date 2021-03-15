function getPricelists(){
	readPricelists();
	readEnterprices();
	
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
	
	$(document).on("click",'#refresh',function(event){
		readPricelists();
	});
		
function readPricelists() {
		var pageNo = 0; 
		var pricelistPagination = $('#cenovnik-page');
		var nmbSelect = $('#nmb-select');
		var pageSize = nmbSelect.find(":selected").text();
		$.ajax({
			url : "http://localhost:8080/salesystem/pricelists/p?pageNo=" + pageNo + "&pageSize=" + pageSize
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
		
		nmbSelecr.on('change',function (event){
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

function readEnterprices(){
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/"
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

