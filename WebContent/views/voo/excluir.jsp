<%@page import="to.*"%>
<% 
	AeroportoTO aeroportoTo = (AeroportoTO)request.getAttribute("aeroporto");
%>
<form class="form-horizontal" method="POST" action="./ExcluirAeroporto">
	<fieldset>
	
	<legend><%= Idioma.para(request, "detalhes")%></legend>
	<a href="ListagemVoo" class='btn btn-default'><i class='glyphicon glyphicon-list-alt'></i>&ensp;Listagem</a>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	
	<input type="hidden" name="id" value="<%= aeroportoTo.id %>">
	
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
		<button class='btn btn-danger'  type="submit" ><i class="glyphicon glyphicon-floppy-disk"></i>&ensp;<%= Idioma.para(request,"remover") %></button>
	  </div>
	</div>
	</fieldset>
</form>

