
<%@page import="to.AeronaveTO"%>
<%@page import="to.ListagemAeronaveTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Aeronave"%>
<legend><%= Idioma.para(request, "consultar_aeronave")%></legend>
<a href="./CadastrarAeronave" class='btn btn-success'><i class='glyphicon glyphicon-plus'></i>&ensp;Cadastrar</a>
<br/>
<div class='clear-fix'></div>
<br/>
<table class='table table-condensed table-bordered table-stripped'>
	<thead>
		<tr>
			<th>
				<%= Idioma.para(request,"codigo") %>
			</th>
			<th>
				<%= Idioma.para(request,"nome") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_a") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_b") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_c") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_verticais") %>
			</th>
			<th>
				<%= Idioma.para(request,"qtd_horizontais") %>
			</th>
			<th>
				<%= Idioma.para(request,"total_assentos") %>
			</th>
			<th>
			</th>
		</tr>
	</thead>
	<tbody>
		<%
			if(request.getAttribute("listagem") != null ){
	 			ListagemAeronaveTO lista = (ListagemAeronaveTO)request.getAttribute("listagem");
				if(lista != null){
					for(AeronaveTO aeronave : lista ){
						%>
						<tr>
							<td><%=aeronave.codigo %></td>
							<td><%=aeronave.nome %></td>
							<td><%=aeronave.qtdAssentosA%></td>
							<td><%=aeronave.qtdAssentosB %></td>
							<td><%=aeronave.qtdAssentosC %></td>
							<td><%=aeronave.qtdAssentosHorizontais %></td>
							<td><%=aeronave.qtdAssentosVerticais %></td>
							<td><% out.print(""+(aeronave.qtdAssentosA
									+
									aeronave.qtdAssentosB
									+
									aeronave.qtdAssentosC
									));%></td>
							<td>
								<a href="ConsultarAeronave?id=<%=aeronave.id%>"><i class="glyphicon glyphicon-eye-open"></i></a>
								<a href="AlterarAeronave?id=<%=aeronave.id%>"><i class="glyphicon glyphicon-pencil"></i></a>
								<a href="ExcluirAeronave?id=<%=aeronave.id%>"><i class="glyphicon glyphicon-trash"></i></a>
							</td>
						</tr>
						<%
					}
				}
			}
		%>
	</tbody>
</table>