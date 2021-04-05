function getInvoiceItem(){
	readInvoice();


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
							+'<td><a href="displayReport.html?id=' + data[i].id + '">' + data[i].quantity + '</a></td>' 
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
function prikaziOdredjenIzvestaj(id){

	
    console.log("Funckija: "+id);
    $.ajax({
        url: 'http://localhost:8080/salesystem/invoiceItems/'+id,
    }).then(
    		
    		function(data,status,request){
    		console.log(data);
            var idI = $("#idIzvestaja");
            var kolicinaI = $("#kolicina");
            var popustI = $("#popust");
            var cenaI = $("#cena");
            var osnovicaI = $("#osnovica");
            var pdvI = $("#pdv");
            var ukI = $("#ukupaniznos");
          
            idI.val(data[i].id);
            kolicinaI.val(data[i].quantity);
            popustI.val(data[i].discount);
            cenaI.val(data[i].unitPrice);
            osnovicaI.val(data[i].pdvBase);
            pdvI.val(data[i].pdvAmount);
            ukI.val(data[i].totalAmount);
            
            
           

    		});
    	
}

