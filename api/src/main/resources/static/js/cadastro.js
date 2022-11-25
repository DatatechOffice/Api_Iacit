function cadastrar(){
	//Recebendo as informações dos filtros e armazenando em variaveis
	debugger;
	//var usuarioNome = $("#inputNome").val();
	//var usuarioEmail = $("#inputEmail").val();
	//var usuarioSenha = $("#inputPassword").val();

	var usuarioNome = "inputNome";
	var usuarioEmail = "a";
	var usuarioSenha = "inputPassword";

	debugger;
	//Função ajax de atribuição do front para uma classe no java
	$.ajax({
		method: 'POST', //Especificando qual o metodo
		url: '/UsuarioCadastro', //Definindo a url que conecta no mapeamento
		//Passando os atribuyos da classe e quais variaveis representa eles no front
		data: JSON.stringify({nome : usuarioNome , email : usuarioEmail , senha : usuarioSenha}), 
		contentType: "application/json; charset=utf-8", //Explicitando que se trata de um conteudo JSON
		//Alerta de sucesso ou falha no envio do JSON
		success: function (data){
			alert("Salvo com Sucesso!");
		}
	}).fail(function(xhr, status, errorThrow){
		alert("Erro ao Salvar: " + xhr.responseText);
	});
}