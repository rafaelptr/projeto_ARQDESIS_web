		

        <div class="row">
			<div class="col-sm-6 col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<strong> <%= Idioma.para(request, "login_para_continuar") %></strong>
					</div>
					<div class="panel-body">
					<%
						String erro = (String)request.getAttribute("ErrorMsg");
						if(erro != null){
					%>
					<div class='alert alert-danger'>
						<%
							out.print(erro);
						%>
					</div>
					<%
						}
					%>
						<form role="form" action="./Login"  method="POST">
							<fieldset>
								<div class="row">
									<div class="col-sm-12 col-md-10  col-md-offset-1 ">
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span> 
												<input class="form-control" placeholder="<%= Idioma.para(request, "usuario") %>" name="usuario" type="text" autofocus required="required">
											</div>
										</div>
										<div class="form-group">
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-lock"></i>
												</span>
												<input class="form-control" placeholder="<%= Idioma.para(request, "senha") %>" name="senha" type="password" value="" required="required">
											</div>
										</div>
										<div class="form-group">
											<input type="submit" class="btn btn-lg btn-primary btn-block" value="<%= Idioma.para(request, "login") %>">
										</div>
									</div>
								</div>
							</fieldset>
						</form>
					</div>
					<div class="panel-footer ">	
						<p class="help-block">
							administrador/123<br/>							
							atendente/123
						</p>
					</div>
                </div>
			</div>
		</div>