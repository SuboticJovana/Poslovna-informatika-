function getRates(){
	readRates();
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