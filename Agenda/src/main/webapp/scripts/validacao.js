/**
 * 
 * Validação de Formulario
 * @author Vitor Gabriel
 * 
 */

function Validar(){
	 nome = frmContato.Nome.value
	 fone = frmContato.fone.value


	if(nome === ""){
		alert("Preenchar o campo nome");
		frmContato.Nome.focus();
		return false;
	}else if(fone === ""){
		alert("Preenchar o campo Telefone");
		frmContato.fone.focus();
		return false;
	}else{
		document.forms["frmContato"].submit();
	}
 }
 
 function ValidarEdit(){
	 nome = frmEdit.Nome.value
	 fone = frmEdit.fone.value


	if(nome === ""){
		alert("Preenchar o campo nome");
		frmEdit.Nome.focus();
		return false;
	}else if(fone === ""){
		alert("Preenchar o campo Telefone");
		frmEdit.fone.focus();
		return false;
	}else{
		document.forms["frmEdit"].submit();
	}
 }