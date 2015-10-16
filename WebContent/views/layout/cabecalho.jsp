<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="languages.Idioma" %>
<%@ page import="utils.DadosSessao" %>
<%
	boolean logado = DadosSessao.logado(request); 
	Idioma.inicializar(request);
%>
<!DOCTYPE html >
<html>
	<head>
		<meta charset="UTF-8" />
		<title><%= Idioma.para(request, "titulo")%></title>
		<link href='http://fonts.googleapis.com/css?family=Handlee' rel='stylesheet' type='text/css'>
		<link href="./assets/css/bootstrap.min.css" type="text/css" rel="stylesheet" />
		<link href="./assets/css/style.css" type="text/css" rel="stylesheet" />
	</head>
	<body>
	  <header class='container-fluid'>
	  	<img src="https://www.google.com.br//images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"  />
	  	<div class='language'>
	  			<input type="hidden" id="idiomaSelecionado" value="<%=
	  				(request.getSession().getAttribute("idiomaSelecionado") != null ?request.getSession().getAttribute("idiomaSelecionado") :"0")
	  			%>">
		  		<select name="idiomaIndex" id="language_page">
		  			<option value='0'>PT-BR</option>
		  			<option value='1'>EN-US</option>
		  			<option value='2'>ES-US</option> 
		  		</select>
	  	</div>
	  </header>
	  <nav class="navbar navbar-inverse">
	    <div class="container-fluid">
	    	<% if(logado){ %>
		    <!-- Brand and toggle get grouped for better mobile display -->
		    <div class="navbar-header">
		      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		      </button>
		    </div>
		
		    <!-- Collect the nav links, forms, and other content for toggling -->
		    <div class="collapse navbar-collapse" >
		      <ul class="nav navbar-nav">
		        <li class="active"><a href="./"><%= Idioma.para(request, "inicio")%></a></li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= Idioma.para(request, "aeroporto") %><span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="./CadastrarAeroporto"><%= Idioma.para(request, "cadastrar") %></a></li>
		            <li><a href="./ListagemAeroporto"><%= Idioma.para(request, "consultar") %></a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= Idioma.para(request, "voo") %><span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="./CadastrarVoo"><%= Idioma.para(request, "cadastrar") %></a></li>
		            <li><a href="./ListagemVoo"><%= Idioma.para(request, "consultar") %></a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= Idioma.para(request,"aeronave") %><span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="./CadastrarAeronave"><%= Idioma.para(request,"cadastrar") %></a></li>
		            <li><a href="./ListagemAeronave"><%= Idioma.para(request,"consultar") %></a></li>
		          </ul>
		        </li>
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%= Idioma.para(request, "passagem") %><span class="caret"></span></a>
		          <ul class="dropdown-menu">
		            <li><a href="#"><%= Idioma.para(request, "cadastrar") %></a></li>
		            <li><a href="#"><%= Idioma.para(request, "consultar") %></a></li>
		          </ul>
		        </li>
		      </ul>
<!-- 		      <form class="navbar-form navbar-left" role="search"> -->
<!-- 		        <div class="form-group"> -->
<!-- 		          <input type="text" class="form-control" placeholder="Search"> -->
<!-- 		        </div> -->
<!-- 		        <button type="submit" class="btn btn-default">Submit</button> -->
<!-- 		      </form> -->
		      <ul class="nav navbar-nav navbar-right">
		        <li class="dropdown">
		          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
		          	<%= Idioma.para(request, "ola") +"&ensp;"+ DadosSessao.usuarioLogado(request)%> &ensp;<span class="caret"></span>
		          </a>
		          <ul class="dropdown-menu">
		            <li><a href="./Login?acao=logoff"><%= Idioma.para(request, "sair") %></a></li>
		          </ul>
		        </li>
		      </ul>
		    </div><!-- /.navbar-collapse -->
		    <% } %>
		  </div><!-- /.container-fluid -->
		</nav>
		<% 
			if(request != null){
				String url = request.getRequestURI();
				String[] urls = url.split("/");
				boolean paginaLogin = (urls[urls.length-1].equals("login.jsp") ? true : false);
				if(!logado && !paginaLogin){
		   			RequestDispatcher rd = request.getRequestDispatcher("/Login");
		   			rd.forward(request, response);
					
				}
			}		
		
		%>
	<div class="container-fluid">
	<% if(request.getAttribute("erroMsg")!= null){ %>
		<div class="alert alert-danger"><%= Idioma.para(request, ""+request.getAttribute("erroMsg")) %></div>	
	<%} %>
	<% if(request.getAttribute("succMsg")!= null){ %>
		<div class="alert alert-success"><%= Idioma.para(request, ""+request.getAttribute("succMsg")) %></div>	
	<%} %>
	<% if(request.getAttribute("infoMsg")!= null){ %>
		<div class="alert alert-info"><%= Idioma.para(request, ""+request.getAttribute("infoMsg")) %></div>	
	<%} %>
	<% if(request.getAttribute("warnMsg")!= null){ %>
		<div class="alert alert-warning"><%= Idioma.para(request, ""+request.getAttribute("warnMsg")) %></div>	
	<%} %>