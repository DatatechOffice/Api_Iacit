function logar(){
	//Recebendo as informações dos filtros e armazenando em variaveis
	debugger;
	//var usuarioEmail = $("#inputEmail").val();
	//var usuarioSenha = $("#inputPassword").val();

	var usuarioEmail = "a@a";
	var usuarioSenha = "123";

	debugger;
	//Função ajax de atribuição do front para uma classe no java
	$.ajax({
		method: 'POST', //Especificando qual o metodo
		url: '/Usuario', //Definindo a url que conecta no mapeamento
		//Passando os atribuyos da classe e quais variaveis representa eles no front
		data: JSON.stringify({email : usuarioEmail , senha : usuarioSenha}), 
		contentType: "application/json; charset=utf-8", //Explicitando que se trata de um conteudo JSON
		//Alerta de sucesso ou falha no envio do JSON
		success: function (data){
			login();
		}
	}).fail(function(xhr, status, errorThrow){
		alert("Senha ou E-mail incorreto" + xhr.responseText);
	});
}

function login() {
    $.ajax({
		method: 'GET', //Especificando qual o metodo
		url: '/index' //Definindo a url que conecta no mapeamento
		//Passando os atribuyos da classe e quais variaveis representa eles no front
		//Alerta de sucesso ou falha no envio do JSON
    })
}