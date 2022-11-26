function logar(){
	//Recebendo as informações dos filtros e armazenando em variaveis
	var usuarioEmail = $("#email").val();
	var usuarioSenha = $("#password").val();

	//Função ajax de atribuição do front para uma classe no java
	$.ajax({
		method: 'POST', //Especificando qual o metodo
		url: '/Usuario', //Definindo a url que conecta no mapeamento
		//Passando os atribuyos da classe e quais variaveis representa eles no front
		data: JSON.stringify({
			"email": usuarioEmail,
			"senha": usuarioSenha
		}), 
		contentType: "application/json; charset=utf-8", //Explicitando que se trata de um conteudo JSON
		//Alerta de sucesso ou falha no envio do JSON
		success: function (){
			login();
		}
	}).fail(function(xhr){
		alert("Senha ou E-mail incorreto" + xhr.responseText);
	});
}

function login() {
	debugger;
	
	window.location.replace("/index");
}
