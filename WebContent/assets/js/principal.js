$(document).ready(function(){
	$('#language_page option[value="'+$("#idiomaSelecionado").val()+'"]').prop("selected","selected");
	$('#language_page').change(function(){
		pathArray = location.href.split( '/' );
		protocol = pathArray[0];
		host = pathArray[2];
		url = protocol + '//' + host + "/"+pathArray[3];
		$.ajax({
			method: "POST",
			url: url+"/IdiomaControl",
			cache:false,
			data: {"idioma" : $(this).val()}
		})
		.success(function(resposta){
			location.reload();
		});
	});
});