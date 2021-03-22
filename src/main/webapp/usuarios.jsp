<%@include file="templates/navbar.jsp"%>

<div class="main-usuarios">
	<h1 class="text-center">Usuarios de la BDD</h1>
	<div class="card-group">
		<c:forEach items="${usuarios}" var="u">
			<div class="card">
				<img class="card-img-top text-center"
					src="https://image.freepik.com/vector-gratis/concepto-premio-al-empleado-mes_23-2148459375.jpg"
					alt="Card image cap" style="width: 160px">
				<div class="card-body">
					<h5 class="card-title">Datos de ${u.nombre}</h5>
					<p class="card-text"><span class="text-primary">E-Mail:</span>  ${u.correo}</p>
					<p class="card-text"><span class="text-primary">Direccion</span>:  ${u.direccion}</p>
					<p class="card-text"><span class="text-primary">Telefono</span>:  ${u.telefono}</p>
				</div>
			</div>
		</c:forEach>
	</div>


</div>

<%@include file="templates/footer.jsp"%>