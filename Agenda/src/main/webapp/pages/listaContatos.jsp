<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="model.JavaBeans" %>

<% ArrayList<JavaBeans> listaContatos = (ArrayList<JavaBeans>) request.getAttribute("lista");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<nav class="navbar navbar-expand-lg bg-primary">
  <div class="container-fluid ">
    <a class="navbar-brand text-light" href="#">Lista de Contatos</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active text-light" aria-current="page" href="/Agenda/index.html">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="pages/novocontato.html">Novo Contato</a>
        </li>
        <li class="nav-item">
          <a class="nav-link text-light" href="#">Lista de Contatos</a>
        </li>
        
        <li>
        	<a href="baixar" class="btn btn-danger">Baixar</a>
        </li>
        
      </ul>
    </div>
  </div>
</nav>
	
	<form class="form" name="frmLista">
		<table id="tabela" class="table table-sm table-hover align-middle table-dark">
			<thead class="table-dark">
				<tr>
		            <th scope="col">Id:</th>
		            <th scope="col">Nome:</th>
		            <th scope="col">Fone:</th>
		            <th scope="col">Email:</th>
		            <th scope="col">Editar:</th>
		            <th scope="col">Delete:</th>
		        </tr> 
		        
		     </thead>
	    	<% for(int i=0; i < listaContatos.size() ;i++) { %>
				<tr>
					<td><%= listaContatos.get(i).getId() %></td>
					<td><%= listaContatos.get(i).getNome() %></td>
					<td><%= listaContatos.get(i).getFone() %></td>
					<td><%= listaContatos.get(i).getEmail() %></td>
					<td><a href="select?id=<%= listaContatos.get(i).getId() %>" class="btn btn-primary">Editar</a></td>
					<td><a href="javascript:confirmar(<%= listaContatos.get(i).getId() %>)" class="btn btn-danger">Excluir</a></td>
				</tr>
			<% } %>
			
		</table>
	</form>
</body>
<script type="text/javascript" src="scripts/confirmar.js"></script>
</html>