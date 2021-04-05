function getBookItem(){
	readBook();



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
function readBook() {
	$.ajax({
		url : "http://localhost:8080/salesystem/invoices"
	}).then(
			function(data, status, request){
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++){
					console.log(data[i].id)
					//ovde za local var 
					var datum= data[i].date_currency;
					newRow = 
						"<tr>" 
							+ "<td class=\"id\">" + data[i].id + "</td>"
							+ "<td class=\"date\">" + data[i].date_invoice + "</td>"
							+ "<td class=\"enterprises\">" + data[i].enterpriseDTO.nameEnterprise + "</td>"
							+ "<td class=\"enterprises\">" + new Date(datum).toLocaleDateString() + "</td>"
							+ "<td class=\"date\">" + data[i].invoice_number + "</td>" +
						"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
}





