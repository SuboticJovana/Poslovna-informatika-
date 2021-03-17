function highloghtRow(row){
	if(!$(row).hasClass("header")){
		$(".highlighted").removeClass("highlighted");
		$(row).addClass("highlighted");
	}
}

function getIdOfSelectedEntityPricelist(){
	var row = $(".highlighted");
    var id = row.find(".pricelist_id").html();
    if(id==undefined){
    	console.log("No entity selected!");
    	return null;
    }
    else{
    	return id;
    }  
}
