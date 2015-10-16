<%@page import="to.*"%>
<% 
	AeronaveTO aeronaveTo = (AeronaveTO)request.getAttribute("aeronave");
%>
<form class="form-horizontal">
	<fieldset>
	
	<legend><%= Idioma.para(request, "detalhes")%></legend>
	<a href="ListagemAeronave" class='btn btn-default'><i class='glyphicon glyphicon-list-alt'></i>&ensp;Listagem</a>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" ><%= Idioma.para(request,"codigo")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeronaveTo.codigo %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"nome")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeronaveTo.nome %></div>
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"qtd_assentos_A")%></label>  
	  <div class="col-md-3">
		<div class='form-control input-md'  ><%= aeronaveTo.qtdAssentosA %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" ><%= Idioma.para(request,"qtd_assentos_B")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeronaveTo.qtdAssentosB %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"qtd_assentos_C")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeronaveTo.qtdAssentosC %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" ><%= Idioma.para(request,"qtd_assentos_horizontais")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeronaveTo.qtdAssentosHorizontais %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"qtd_assentos_verticais")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeronaveTo.qtdAssentosVerticais %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <div class="col-md-3 col-md-offset-4">
		<a class='btn btn-primary' href="./AlterarAeronave?id=<%= aeronaveTo.id %>" ><i class="glyphicon glyphicon-floppy-disk"></i>&ensp;<%= Idioma.para(request,"editar") %></a>
	  </div>
	</div>
	
	</fieldset>
</form>

