function getPricelists(){
	readPricelists();
	readEnterprices();
		
function readPricelists() {
		var pageNo = 0; 
		var pricelistPagination = $('#cenovnik-page');
		var nmbSelect = $('#nmb-select');
		var pageSize = nmbSelect.find(":selected").text();
		$.ajax({
			url : "http://localhost:8080/api/pricelists/p?pageNo=" + pageNo + "&pageSize=" + pageSize
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
	}

function readEnterprices() {}	
}