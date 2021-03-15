function highloghtRow(row){
	if(!$(row).hasClass("header")){
		$(".highlighted").removeClass("highlighted");
		$(row).addClass("highlighted");
	}
}

