function getInvoiceItem(){
	readInvoice();
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
function readInvoice() {
	$.ajax({
		url : "http://localhost:8080/salesystem/invoiceItems"
	}).then(
			function(data, status, request){
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++){
					console.log(data[i].id)
					newRow = 
						"<tr>" 
							+ "<td class=\"quantity\">" + data[i].quantity + "</td>"
							+ "<td class=\"invoiceItems\">" + data[i].discount + "</td>"
							+ "<td class=\"invoiceItems\">" + data[i].unitPrice + "</td>"
							+ "<td class=\"invoiceItems\">" + data[i].pdvBase + "</td>"
							+ "<td class=\"invoiceItems\">" + data[i].pdvAmount + "</td>"
							+ "<td class=\"invoiceItems\">" + data[i].totalAmount + "</td>" +
						"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
}



function readServices(){
	$.ajax({
		url : "http://localhost:8080/salesystem/services/all"
	}).then(function(data){
		$("#robaSelect").empty();
		$.each(data, function(i,item){
			$('#robaSelect').append($('<option>',{
				value : item.services_id,
				text : item.name
			}));
		});
	});
}
