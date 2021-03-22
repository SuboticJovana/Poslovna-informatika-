function getPricelists(){
	readPricelists();
	readEnterprises();
	readEnterprises2();
	
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
	
	$(document).on("click", '#edit', function(event){
//		console.log(getIdOfSelectedEntityPricelist());
		$('#updateModalScrollable').modal('show');
	});
	
	$(document).on("click", "#doUpdate", function(event) {
		updatePricelist();
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '.updateModalClose', function(event) {
		$('#updateModalScrollable').modal('hide');
	});
	
	$(document).on("click", '#delete', function(event){
		var name = getNameOfSelectedEntityPricelist();
		if(name!=null){
			$('#deletePromptText').text("Obrisati cenovnik sa datumom: " + name);
			$('#deletePromptModal').modal('show');
		}
	});
	
	$(document).on("click", '.deletePromptClose', function(event){
		$('#deletePromptModal').modal('hide');
	});
	
	$(document).on("click", '#doDelete', function(event){
		deletePricelist();
		$('#deletePromptModal').modal('hide');
	});
}

function readPricelists() {
		$.ajax({
			url : "http://localhost:8080/salesystem/pricelists/all" 
		}).then(
				function(data, status, request) {
					console.log(data);
					$("#dataTableBody").empty();
					for (i = 0; i < data.length; i++) {
						console.log(data[i].pricelist_id)
						newRow = 
						"<tr>" 
							+ "<td class=\"dateFrom\">" + data[i].date_from + "</td>"
							+ "<td class=\"enterprice\">" + data[i].enterpriseDTO.nameEnterprise + "</td>" +
						"</tr>"
						$("#dataTableBody").append(newRow);
					}
				});
}

function readEnterprises(){
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/all"
	}).then(
		function(data) {
			$("#preduzeceSelect").empty();
//			$('#preduzeceSelect').append($('<option>', {
//			    value: 1,
//			    text: ''
//			}));
			
//			$.get('SviFilmoviServlet', function(data) {
//				var sviFilmovi = data.sviFilmovi;
//				for (item in data) {
//					$('#preduzeceSelect').append(
//						'<option value="'+item.enterprise_id+ '">' + item.nameEnterprise+ '</option>'
//					)}
			
			$.each(data, function (i, item) {
//		        console.log('enterprise_id' + item);
			    $('#preduzeceSelect').append($('<option>', { 
			        value: item.enterprise_id,
			        text : item.nameEnterprise

			    }));
			});	
		}
	);
}

function readEnterprises2() {
	$.ajax({
		url : "http://localhost:8080/salesystem/enterprises/all"
	}).then(
		function(data) {
			$("#preduzeceIzmeniSelect").empty();
//			$('#preduzeceIzmeniSelect').append($('<option>', {
//			    value: 1,
//			    text: ''
//			}));
			
			$.each(data, function (i, item) {
			    $('#preduzeceIzmeniSelect').append($('<option>', { 
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
		var date_from = datumInput.val();
		var enterpriseDTO = preduzeceSelect.val();
//		var preduzece = preduzeceSelect.find(":selected").value;
		
		console.log('date_from: ' + date_from)
		console.log('enterpriseDTO: ' + enterpriseDTO);
		
		if(date_from == null || enterpriseDTO == null){
			alert('Niste uneli potrebne podatke')
		}
		
		var params = {
				'date_from': date_from,
				'enterpriseDTO': {
					'enterprise_id' : enterpriseDTO
				}
		}
		

		
		$.ajax({
			url : 'http://localhost:8080/salesystem/pricelists/add',
			type:'POST',
			data: JSON.stringify(params),
			contentType:'application/json; charset=utf-8',
			dataType:'json',
			success:function(data){
				console.log('...')
				alert('Dodat je novi cenovnik')
				readPricelists();
				datumInput.val("");
				preduzeceSelect.val("");
			}
		})
		console.log('slanje poruke');
		event.preventDefault();
		return false;
	});
}

//var table = $('#myTable').DataTable();
//
//$('#myTable').on( 'click', 'tr', function () {
//    var id = table.row( this ).id();
// 
//    alert( 'Clicked row id '+id );
//} );


//$('#tabelaProjekcija').on('click', '#izbrisiProjekciju', function(){
//	$(this).closest ('tr').remove ();

//$(".table > tbody > tr").each(function()
//        console.log($(this).attr("id"));
//);

//$(function() {
//    $('#userTable').on('click', 'tbody tr', function(event) {
//      $(this).addClass('highlight').siblings().removeClass('highlight');
//    });

//var getHighlightRow = function() {
//    return $('table > tbody > tr.highlight');
//  }

//var rows = getHighlightRow();
//if (rows != undefined) {
//  alert(rows.attr('id'));
//}


//$(function() {
//    $('#userTable').on('click', 'tbody tr', function(event) {
//      $(this).addClass('highlight').siblings().removeClass('highlight');
//    });
//
//    $('#btnRowClick').click(function(e) {
//      var rows = getHighlightRow();
//      if (rows != undefined) {
//        alert(rows.attr('id'));
//      }
//    });
//
//    var getHighlightRow = function() {
//      return $('table > tbody > tr.highlight');
//    }
//
//  });

function updatePricelist() {
		
	$(function(){
		$('#dataTableBody').on('click','tbody tr', function(event){
			$(this).addClass('highlight').siblings().removeClass('highlight');
		});
		
		$('#doUpdate').click(function(e){
			var rows = getHighlightRow();

		});
		var getHighlightRow = function(){
			return $('table > tbody > tr.highlight');
		}
	});
	
//	var table = $('#dataTableBody').DataTable();
	
//	$(".table > tbody > tr").each(function()
////			console.log('kliknuto');
//	        console.log($(this).attr("enterprise_id"));
//	);
	
//	$('#dataTableBody').on('click', 'tr', function(){
//		var id = table.row(this).enterprise_id;
//		console.log("kliknuto" );
//	})
	
//	var pricelist_id = getIdOfSelectedEntityPricelist();
//	console.log("izabrani id:" + pricelist_id);
//	
	var datumIzmeniInput = $('#datumIzmeniInput');
	var preduzeceIzmeniSelect = $('#preduzeceIzmeniSelect');
	
//	setovanje
	
	$("#doUpdate").on("click", function(event) {
		var datum_vazenja = datumIzmeniInput.val();
		var preduzece = preduzeceIzmeniSelect.val();
		
		console.log('datum_vazenja: ' + datum_vazenja)
		console.log('preduzece: ' + preduzece);
		
		var params = {
				'pricelist_id': pricelist_id,
				'date_from': datum_vazenja,
				'enterpriseDTO': {
					'enterprise_id' : preduzece
				}
				
		}
		
		$.ajax({
			url:"http://localhost:8080/salesystem/pricelists/" + pricelist_id,
			type:"PUT",
			data: JSON.stringify(params),
			contentType:"application/json; charset=utf-8",
			dataType:"json",
			success:function(data){
				console.log(data);
				alert('Izmena cenovnika');
				datumIzmeniInput.val("");
				preduzeceIzmeniSelect.val("");
			}
		});

		console.log('slanje poruke');
		event.preventDefault();
		return false;
		
		
	});
}

function deletePricelist(){
	var pricelist_id = getIdOfSelectedEntityPricelist();
	console.log(pricelist_id);
	$.ajax({
    	url: "http://localhost:8080/salesystem/pricelists/" + pricelist_id,
    	type: "DELETE",
    	success: function(){
    		readPricelists();
        }
	});
}

