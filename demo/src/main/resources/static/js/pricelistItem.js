function getPricelistItem(){
	readItems();
	readPricelists();
	readServices();


$(document).on("click", '#add', function(event){
	$('#addModalScrollable').modal('show');
});

$(document).on("click", '#doAdd', function(event){
	addPricelistItem();
	$('#addModalScrollable').modal('hide');				
});

$(document).on("click", '.addModalClose', function(event){
	$('#addModalScrollable').modal('hide');
});

}
function readItems() {
	$.ajax({
		url : "http://localhost:8080/salesystem/priceListItems"
	}).then(
			function(data, status, request){
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++){
					console.log(data[i].price_list_item_id)
					newRow = 
						"<tr>" 
							+ "<td class=\"price\">" + data[i].price + "</td>"
							+ "<td class=\"pricelist\">" + data[i].pricelist.date_from + "</td>"
							+ "<td class=\"services\">" + data[i].services.name + "</td>" +
						"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
}

function readPricelists(){
	$.ajax({
		url:"http://localhost:8080/salesystem/pricelists/all"
	}).then(
			function(data){
				$("#cenovnikSelect").empty();
				$.each(data, function(i,item){
					$('#cenovnikSelect').append($('<option>',{
						value : item.pricelist_id,
						text : item.date_from
					}));
				});
			});
}

function readServices(){
	$.ajax({
		url : "http://localhost:8080/salesystem/services/all"
	}).then(function(data){
		$("#robaSelect").empty();
		$.each(data, function(i,item){
			$('#robaSelect').append($('<option>',{
				value : item.service_id,
				text : item.name
			}));
		});
	});
}

function addPricelistItem(){
	var cenaInput = ('#cenaInput');
	var cenovnikSelect = ('#cenovnikSelect')
	var robaSelect = ('#robaSelect')
	
	$('#doAdd').on('click',function(event){
		var price = cenaInput.value;
		var pricelist = cenovnikSelect.value;
		var services = robaSelect.value;
		
		console.log('price' + price);
		console.log('pricelist' + pricelist);
		console.log('services' + services);
		
		if(price == null || pricelist == null || services == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'price' : price,
				'pricelist' : {
					'pricelist_id' : pricelist
				},
				'services' : {
					'service_id' : services
				}
		}
		
		$.ajax({
			url : 'http://localhost:8080/salesystem/priceListItems/add',
			type : 'POST',
			data : JSON.stringify(params),
			contentType : 'application/json; charset=utf-8',
			dataType:'json',
			success:function(data){
				alert('Dodata je nova stavka cenovnika')
				readItems();
				cenaInput.val("");
				cenovnikSelect.val("");
				robaSelect.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
	});
	
}