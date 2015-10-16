<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="to.*"%>
<form class="form-horizontal" action='CadastrarAeroporto' method='POST'>
	<fieldset>
	
	<%
		AeroportoTO aeroporto = new AeroportoTO();
		if(request.getAttribute("aeroporto")!=null){
			aeroporto = (AeroportoTO) request.getAttribute("aeroporto");
		}	
	%>
	<legend><%= Idioma.para(request, "cadastrar_aeroporto")%></legend>
	<a href="ListagemAeroporto" class='btn btn-default'><i class='glyphicon glyphicon-list-alt'></i>&ensp;Listagem</a>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	
	
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="nomeCompleto"><%= Idioma.para(request,"nomeCompleto")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="nomeCompleto" name="nomeCompleto" autofocus="autofocus"  placeholder="<%= Idioma.para(request,"nomeCompleto")%>"  required="required" value="<%= aeroporto.nomeCompleto %>"/>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="nome"><%= Idioma.para(request,"nome")%></label>  
	  <div class="col-md-3"> 
		<input  class='form-control input-md'  id="nome" name="nome" placeholder="<%= Idioma.para(request,"nome")%>" required="required" value="<%= aeroporto.nome%>" />
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="codigo"><%= Idioma.para(request,"codigo")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="codigo" name="codigo" placeholder="<%= Idioma.para(request,"codigo")%>" required="required" value="<%= aeroporto.codigo%>" />
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="estado"><%= Idioma.para(request,"estado")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="estado" name="estado" placeholder="<%= Idioma.para(request,"estado")%>"  required="required" value="<%= aeroporto.estado %>"/>
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="pais"><%= Idioma.para(request,"pais")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="pais" name="pais" placeholder="<%= Idioma.para(request,"pais")%>"  required="required" value="<%= aeroporto.pais %>"/>
	  </div>
	</div>
	
	<div class="form-group">
	  <div class="col-md-3 col-md-offset-4">
		<button class='btn btn-success' type="submit" ><i class="glyphicon glyphicon-floppy-disk"></i>&ensp;<%= Idioma.para(request,"salvar") %></button>
	  </div>
	</div>
	
	</fieldset>
</form>