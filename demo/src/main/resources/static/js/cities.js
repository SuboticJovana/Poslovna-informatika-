function getCities(){
	readCities();
}

function readCities() {
	$.ajax({
		url : "http://localhost:8080/salesystem/cities/all" 
	}).then(
			function(data, status, request) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].city_id)
					newRow = 
					"<tr>" 
						+ "<td class=\"ptt\">" + data[i].ptt + "</td>"
						+ "<td class=\"city_name\">" + data[i].city_name + "</td>" +
					"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
}