<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="to.*"%>
<%@page import="utils.*"%>
<%
		VooTO voo = new VooTO();
		ListagemAeronaveTO aeronaves = new ListagemAeronaveTO();
		ListagemAeroportoTO aeroportos = new ListagemAeroportoTO();
		if(request.getAttribute("voo")!=null){
			voo = (VooTO) request.getAttribute("voo");
		}	
		if(request.getAttribute("aeronaves")!=null){
			aeronaves = (ListagemAeronaveTO) request.getAttribute("aeronaves");
		}
		if(request.getAttribute("aeroportos")!=null){
			aeroportos = (ListagemAeroportoTO) request.getAttribute("aeroportos");
		}
	%>
<form class="form-horizontal">
	<fieldset>
	
	<legend><%= Idioma.para(request, "detalhes")%></legend>
	<a href="ListagemVoo" class='btn btn-default'><i class='glyphicon glyphicon-list-alt'></i>&ensp;Listagem</a>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"nomeCompleto")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= voo.codigo %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"nome")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= voo.nome %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"estado")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= voo.preco %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"estado")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><%= DataUtil.DataToString(voo.data) %></div>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"aeronave")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><a href="./ConsultarAeronave?id=<%= voo.aeronaveId %>"><%= voo.aeronave.nome %></a></div>
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"aeroporto_origem")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><a href="./ConsultarAeroporto?id=<%= voo.aeroportoOrigemId %>"><%= voo.aeroportoOrigem.nome %></a></div>
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label"><%= Idioma.para(request,"aeroporto_destino")%></label>  
	  <div class="col-md-3">
		<div  class='form-control input-md'  ><a href="./ConsultarAeroporto?id=<%= voo.aeroportoDestinoId %>"><%= voo.aeroportoDestino.nome %></a></div>
	  </div>
	</div>
	
	
	</fieldset>
</form>

