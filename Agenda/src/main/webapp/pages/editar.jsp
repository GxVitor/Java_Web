<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<script type="text/javascript" src="../scripts/validacao.js"></script>

		 <div class="container">
        <form class="form" action="edit" name="frmEdit">
            <p class="title">Novo Contato</p>
            <table>
            	<tr>
	            	<td><input placeholder="Id" class="username input" type="text" name="id" value="<%= request.getAttribute("id") %>" readonly hidden="true"></td>
	            </tr>
            	<tr>
	            	<td><input placeholder="Nome" class="username input" type="text" name="nome" value="<%= request.getAttribute("nome") %>"></td>
	            </tr>
	            <tr>
	            	<td><input placeholder="Telefone" class="username input" type="number" name="fone" value="<%= request.getAttribute("fone") %>"></td>
	            </tr>
	            <tr>
	            	<td><input placeholder="E-Mail" class="username input" type="email" name="email" value="<%= request.getAttribute("email") %>"></td>
	            </tr>
            </table>
            <button class="btn" type="submit" onclick="ValidarEdit()">Adicionar</button>
        </form>
    </div>

</body>
</html>