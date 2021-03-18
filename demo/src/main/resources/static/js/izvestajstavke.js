 $(document).ready(function() {  

function prikazSvihIzvestaja() {

    var tabelaIzvestaja = $("#izvestajistavke");
    var tbodyIzvestaj = $("#tbodyIzvestaj");
    
    function prikaziIzvestaje(){
        $.ajax({
            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/salesystem/invoiceItems",
            success : function(result){
            	tabelaIzvestaja.show();
            	tbodyIzvestaj.empty();
                for(item in result){
                	tbodyIzvestaj.append(
                			 '<tr>'
                            +'<td class="kolicina" align="center">'+result[item].quantity+'</td>'
                            +'<td class="rabat" align="center">'+result[item].discount+'</td>'
                            +'<td classs="pdvOsnovica" align="center">'+result[item].pdvbase+'</td>'
                            +'<td class="pdv" align="center">'+result[item].pdvamount+'</td>'
                            +'<td class="ukupanIznos" align="center">'+result[item].totalAmount+'</td>'
                            +'<td>'
                    
                        +'</tr>'
                    )};
                       
             },
            error :function(e){
                alert('err');
            }
        });
    }
    prikaziIzvestaje();

    console.log('item');
}
 });

        