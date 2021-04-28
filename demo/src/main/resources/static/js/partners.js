function getPartners(){
	readPartners();
}

function readPartners() {
	$.ajax({
		url : "http://localhost:8080/salesystem/partners/all" 
	}).then(
			function(data, status, request) {
				console.log(data);
				$("#dataTableBody").empty();
				for (i = 0; i < data.length; i++) {
					console.log(data[i].partner_id)
					newRow = 
					"<tr>" 
						+ "<td class=\"partner_name\">" + data[i].partner_name + "</td>"
						+ "<td class=\"address\">" + data[i].address + "</td>"
						+ "<td class=\"phone_number\">" + data[i].phone_number + "</td>"
						+ "<td class=\"fax\">" + data[i].fax + "</td>"
						+ "<td class=\"email\">" + data[i].email + "</td>"
						+ "<td class=\"city\">" + data[i].cityDTO.city_name + "</td>" +
						+ "<td class=\"enterprice\">" + data[i].enterpriseDTO.nameEnterprise + "</td>" +
					"</tr>"
					$("#dataTableBody").append(newRow);
				}
			});
}