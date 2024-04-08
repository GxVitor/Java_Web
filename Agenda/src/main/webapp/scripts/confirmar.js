/**
 * 
 */

 
 function confirmar(id){
	 
	var r = confirm("Deseja Excluir o contato com o Id " + id);
	if (r==true){
	  window.location.href = "Excluir?id=" + id
	}else
	  {
	  	alert("Vai tomar no cu então")
	  }
}