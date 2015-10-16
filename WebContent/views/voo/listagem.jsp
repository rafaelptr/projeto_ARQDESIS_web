<%@page import="to.VooTO"%>
<%@page import="to.ListagemVooTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Voo"%>
<%@page import="utils.*"%>
<legend><%= Idioma.para(request, "consultar_voo")%></legend>
<a href="./CadastrarVoo" class='btn btn-success'><i class='glyphicon glyphicon-plus'></i>&ensp;Cadastrar</a>
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
				<%= Idioma.para(request,"preco") %>
			</th>
			<th>
				<%= Idioma.para(request,"aeronave") %>
			</th>
			<th>
				<%= Idioma.para(request,"data") %>
			</th>
			<th>
			</th>
		</tr>
	</thead>
	<tbody>
		<%
			if(request.getAttribute("listagem") != null ){
	 			ListagemVooTO lista = (ListagemVooTO)request.getAttribute("listagem");
				if(lista != null){
					for(VooTO voo : lista ){
						%>
						<tr>
							<td><%=voo.codigo %></td>
							<td><%=voo.nome %></td>
							<td><%= "R$"+voo.preco %></td>
							<td><%= voo.aeronave.nome %></td>
							<td><%= DataUtil.DataToString(voo.data) %></td>
							<td>
								<a href="ConsultarVoo?id=<%=voo.id%>"><i class="glyphicon glyphicon-eye-open"></i></a>
								<a href="AlterarVoo?id=<%=voo.id%>"><i class="glyphicon glyphicon-pencil"></i></a>
								<a href="ExcluirVoo?id=<%=voo.id%>"><i class="glyphicon glyphicon-trash"></i></a>
							</td>
						</tr>
						<%
					}
				}
			}
		%>
	</tbody>
</table>