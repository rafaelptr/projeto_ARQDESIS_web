
<%@page import="to.AeroportoTO"%>
<%@page import="to.ListagemAeroportoTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Aeroporto"%>
<legend><%= Idioma.para(request, "consultar_aeronave")%></legend>
<a href="./CadastrarAeroporto" class='btn btn-success'><i class='glyphicon glyphicon-plus'></i>&ensp;Cadastrar</a>
<br/>
<div class='clear-fix'></div>
<br/>
<table class='table table-condensed table-bordered table-stripped'>
	<thead>
		<tr>
			<th>	
				<%= Idioma.para(request,"nomeCompleto") %>
			</th>
			<th>
				<%= Idioma.para(request,"nome") %>
			</th>
			<th>
				<%= Idioma.para(request,"codigo") %>
			</th>
			<th>
				<%= Idioma.para(request,"estado") %>
			</th>
			<th>
				<%= Idioma.para(request,"pais") %>
			</th>
			<th>
			</th>
		</tr>
	</thead>
	
	<tbody>
		<%
			if(request.getAttribute("listagem") != null ){
	 			ListagemAeroportoTO lista = (ListagemAeroportoTO)request.getAttribute("listagem");
				if(lista != null){
					for(AeroportoTO aeronave : lista ){
						%>
						<tr>
							<td><%=aeronave.nomeCompleto %></td>
							<td><%=aeronave.nome %></td>
							<td><%=aeronave.codigo %></td>
							<td><%=aeronave.estado %></td>
							<td><%=aeronave.pais %></td>
							<td>
								<a href="ConsultarAeroporto?id=<%=aeronave.id%>"><i class="glyphicon glyphicon-eye-open"></i></a>
								<a href="AlterarAeroporto?id=<%=aeronave.id%>"><i class="glyphicon glyphicon-pencil"></i></a>
								<a href="ExcluirAeroporto?id=<%=aeronave.id%>"><i class="glyphicon glyphicon-trash"></i></a>
							</td>
						</tr>
						<%
					}
				}
			}
		%>
	</tbody>
</table>