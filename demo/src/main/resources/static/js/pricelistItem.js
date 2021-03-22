function getPricelistItem(){
	readItems();
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