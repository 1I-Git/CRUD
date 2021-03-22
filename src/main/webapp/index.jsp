

<%@include file="templates/navbar.jsp"%>

<div class="cont-informacion">
	<h1>CRUD:</h1>
	<p>
		En informatica, CRUD es el acronimo de "Crear, Leer, Actualizar y
		Borrar" (del original en ingles: Create, Read, Update and Delete), que
		se usa para referirse a las funciones basicas en bases de datos o la
		capa de persistencia en un software. <a class="a-wikipedia"
			href="https://es.wikipedia.org/wiki/CRUD#:~:text=En%20inform%C3%A1tica%2C%20CRUD%20es%20el,de%20persistencia%20en%20un%20software.">Wikipedia</a>
	</p>
	<br>
	<h2>Tabla CRUD:</h2>

	<table class="table table-striped table-dark">
		<thead>
			<tr>
				<th scope="col">Operaciones</th>
				<th scope="col">SQL</th>
				<th scope="col">RESTful</th>
				<th scope="col">XQuery</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th scope="row">Create</th>
				<td>Read</td>
				<td>Update</td>
				<td>Delete</td>
			</tr>
			<tr>
				<th scope="row">INSERT</th>
				<td>SELECT</td>
				<td>UPDATE</td>
				<td>DELETE</td>
			</tr>
			<tr>
				<th scope="row">POST, PUT</th>
				<td>GET, HEAD</td>
				<td>PUT, PATCH</td>
				<td>DELETE</td>
			</tr>
			<tr>
				<th scope="row">insert</th>
				<td>copy/modify/return</td>
				<td>replace, rename</td>
				<td>delete</td>
			</tr>
		</tbody>
	</table>

</div>

<%@include file="templates/footer.jsp"%>



