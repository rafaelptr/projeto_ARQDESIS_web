<%@page import="to.*"%>
<% 
	AeroportoTO aeroportoTo = (AeroportoTO)request.getAttribute("aeroporto");
%>
<form class="form-horizontal">
	<fieldset>
	
	<legend><%= Idioma.para(request, "detalhes")%></legend>
	<a href="ListagemAeroporto" class='btn btn-default'><i class='glyphicon glyphicon-list-alt'></i>&ensp;Listagem</a>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"nomeCompleto")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeroportoTo.nomeCompleto %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"nome")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeroportoTo.nome %></div>
	  </div> 
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"codigo")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeroportoTo.codigo %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"estado")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeroportoTo.estado %></div>
	  </div>
	</div>
	
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"pais")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= aeroportoTo.pais %></div>
	  </div>
	</div>
	
	
	<div class="form-group">
	  <div class="col-md-3 col-md-offset-4">
		<a class='btn btn-primary' href="./AlterarAeroporto?id=<%= aeroportoTo.id %>" ><i class="glyphicon glyphicon-floppy-disk"></i>&ensp;<%= Idioma.para(request,"editar") %></a>
	  </div>
	</div>
	
	</fieldset>
</form>

