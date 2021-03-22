

<%@include file="templates/navbar.jsp" %> 

<!-- Tabla CRUD -->
 <div class="container">
        <div class="table-wrapper">
            <div class="table-title">
                <div class="row">
                    <div class="col-sm-6">
						<h2>Gestion <b>Usuario</b></h2>
					</div>
					<div class="col-sm-6">
						<a id="añadirUsuario" href="#addEmployeeModal" class="btn btn-success" data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Añadir Nuevo Usuario</span></a>						
					</div>
                </div>
            </div>
            <table class="table table-striped table-hover">
                <thead>
                    <tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>#ID</th>
                        <th>Nombre</th>
                        <th>E-Mail</th>
						<th>Direccion</th>
                        <th>Telefono</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
				<c:forEach items="${usuarios}" var="u">
					<tr>
						<td><span class="custom-checkbox"> <input
								type="checkbox" id="checkbox1" name="options[]" value="1">
								<label for="checkbox1"></label>
						</span></td>
						<td>${ u.id }</td>
						<td>${ u.nombre }</td>
						<td>${ u.correo }</td>
						<td>${ u.direccion }</td>
						<td>${ u.telefono }</td>
						<td><a href="editar?id=${u.id }" class="edit"
							data-toggle="modal"><i class="material-icons"
								data-toggle="tooltip" title="Editar">&#xE254;</i></a> <a
							href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i
								class="material-icons eliminarUsuario" data-toggle="tooltip"
								title="Eliminar">&#xE872;</i></a></td>
					</tr>
				</c:forEach>
			</tbody>
            </table>
			<div class="clearfix">
                <ul class="pagination">
                    <li class="page-item disabled"><a href="#">Anterior</a></li>
                    <li class="page-item"><a href="#" class="page-link">1</a></li>
                    <li class="page-item"><a href="#" class="page-link">2</a></li>
                    <li class="page-item active"><a href="#" class="page-link">3</a></li>
                    <li class="page-item"><a href="#" class="page-link">4</a></li>
                    <li class="page-item"><a href="#" class="page-link">5</a></li>
                    <li class="page-item"><a href="#" class="page-link">Siguiente</a></li>
                </ul>
            </div>
        </div>
    </div>
	<!-- Edit Modal HTML -->
	<div id="addEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="crear" method="post">
					<div class="modal-header">						
						<h4 class="modal-title">Añadir Usuario</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<div class="form-group">
							<label>Nombre</label>
							<input type="text" name="nombre" class="form-control" required>
						</div>
						<div class="form-group">
							<label>E-Mail</label>
							<input type="email" name="correo" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Direccion</label>
							<input type="text" name="direccion" class="form-control" required>
						</div>
						<div class="form-group">
							<label>Telefono</label>
							<input type="text" name="telefono" class="form-control" required>
						</div>					
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Salir">
						<input type="submit" class="btn btn-success" value="Añadir">
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Delete Modal HTML -->
	<div id="deleteEmployeeModal" class="modal fade">
		<div class="modal-dialog">
			<div class="modal-content">
				<form action="eliminar" method="post">
					<div class="modal-header">						
						<h4 class="modal-title text-danger">Eliminar Usuario</h4>
						<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					</div>
					<div class="modal-body">					
						<p>Si estas seguro de querer eliminar el Usuario introduce el Id</p>
						<div class="form-group">
							<input type="text" name="id" class="form-control" placeholder="Introduce el ID" required>
						</div>
						<p class="text-danger"><small>Esta accion no puede ser modificada.</small></p>
					</div>
					<div class="modal-footer">
						<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
						<input type="submit" class="btn btn-danger" value="Eliminar">
					</div>
				</form>
			</div>
		</div>
	</div>
	
<%@include file="templates/footer.jsp" %> 
