<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="to.*"%>
<%@page import="utils.*"%>
<form class="form-horizontal" action='CadastrarVoo' method='POST'>
	<fieldset>
	
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
	<legend><%= Idioma.para(request, "cadastrar_voo")%></legend>
	<a href="ListagemVoo" class='btn btn-default'><i class='glyphicon glyphicon-list-alt'></i>&ensp;Listagem</a>
	<br/>
	<div class='clear-fix'></div>
	<br/>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="nome"><%= Idioma.para(request,"nome")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="nome" name="nome" autofocus="autofocus"  placeholder="<%= Idioma.para(request,"nome")%>"  required="required" value="<%= voo.nome %>"/>
	  </div>
	</div>
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="codigo"><%= Idioma.para(request,"codigo")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="codigo" name="codigo" placeholder="<%= Idioma.para(request,"codigo")%>" required="required" value="<%= voo.codigo%>" />
	  </div>
	</div>
	
	
	<div class="form-group">
	  <label class="col-md-4 control-label" for="preco"><%= Idioma.para(request,"preco")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="preco" name="preco" placeholder="<%= Idioma.para(request,"preco")%>"  required="required" value="<%= voo.preco %>"/>
	  </div>
	</div>
	<div class="form-group">
	  <label class="col-md-4 control-label" for="data"><%= Idioma.para(request,"data")%></label>  
	  <div class="col-md-3">
		<input  class='form-control input-md'  id="data" name="data" placeholder="<%= Idioma.para(request,"data")%>"  
		required="required" value="<%= DataUtil.DataToString(voo.data)%>"/>
	  </div>
	</div>
<div class="form-group">
	  <label class="col-md-4 control-label" for="data"><%= Idioma.para(request,"aeronaves")%></label>  
	  <div class="col-md-3">
	  	<select class='chosen' name='aeronaveId' id="aeronaveId">
	  	<option value='0'><%= Idioma.para(request,"selecione") %></option>
	  		<%
	  			for(AeronaveTO aeronave: aeronaves){
	  				String selected = (aeronave.id == voo.aeronaveId ? "selected='selected'" : "");
	  				%>
		  				<option <%= selected %> value="<%= aeronave.id %>" ><%= "( "+ aeronave.codigo + " )"+aeronave.nome %></option>
	  				<%		
	  			}
	  		%>
	  	</select>
	  </div>
    </div>
    
    <div class="form-group">
	  <label class="col-md-4 control-label" for="data"><%= Idioma.para(request,"aeroporto_origem")%></label>  
	  <div class="col-md-3">
	  	<select class='chosen' name='aeroportoOrigemId' id="aeroportoOrigemId">
	  	<option value='0'><%= Idioma.para(request,"selecione") %></option>
	  		<%
	  			for(AeroportoTO aeroporto: aeroportos){
	  				String selected = (aeroporto.id == voo.aeroportoOrigemId ? "selected='selected'" : "");
	  				%>
		  				<option <%= selected %> value="<%= aeroporto.id %>" ><%= "( "+ aeroporto.codigo + " )"+aeroporto.nome %></option>
	  				<%		
	  			}
	  		%>
	  	</select>
	  </div>
    </div>
    
    <div class="form-group">
	  <label class="col-md-4 control-label" for="data"><%= Idioma.para(request,"aeroporto_destino")%></label>  
	  <div class="col-md-3">
	  	<select class='chosen' name='aeroportoDestinoId' id="aeroportoDestinoId">
	  		<option value='0'><%= Idioma.para(request,"selecione") %></option>
	  		<%
	  			for(AeroportoTO aeroporto: aeroportos){
	  				String selected = (aeroporto.id == voo.aeroportoDestinoId ? "selected='selected'" : "");
	  				%>
		  				<option <%= selected %> value="<%= aeroporto.id %>" ><%= "( "+ aeroporto.codigo  + " )"+aeroporto.nome %></option>
	  				<%		
	  			}
	  		
	  		%>
	  	</select>
	  </div>
    </div>
	<div class="form-group">
	  <div class="col-md-3 col-md-offset-4">
		<button class='btn btn-success' type="submit" ><i class="glyphicon glyphicon-floppy-disk"></i>&ensp;<%= Idioma.para(request,"salvar") %></button>
	  </div>
	</div>
	
	</fieldset>
</form>