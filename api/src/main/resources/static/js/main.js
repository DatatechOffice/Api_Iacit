//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------AutoComplete-----------------------------------------------------------------------------
//------------------------------------------------------------------------------------Regiao--------------------------------------------------------------------------------


$.getJSON("/regiao", function(regiao) {
			console.log(regiao)
			var itens = [];
			$.each(regiao, function(i){			
			//itens.push("<tr> <td>"+ this.placa +"</td><td>"+ this.espc.modelo + "</td><td>"+ this.espc.marca + "</td><td>"+ this.espc.cor + "</td></tr>");				
			});
									//$("#dadosCarro").append(itens);				
			});

async function carregar_regiao(valRegiao){
	if(valRegiao.length >= 1){
		
		const resReg = await fetch('../data/estados.json');
		const RegiaoJson = await resReg.json();

		var html = "<ul class='list-group' position-fixed>";

		for(let i = 0; i < RegiaoJson.length; i++){
			
			if(RegiaoJson[i].name.toLowerCase().startsWith(valRegiao.toLowerCase())){
				html += "<li class='list-group-item list-group-item-action' onclick='get_name_Regiao("+JSON.stringify(RegiaoJson[i].name)+")'>" + RegiaoJson[i].name + "</li>";
			}
		}
		html += "</ul>";

		document.getElementById('pesquisa_regiao').innerHTML = html;
		
	}else{
		document.getElementById('pesquisa_regiao').innerHTML = '';
	}
}

function get_name_Regiao(name_regiao){
	document.getElementById("Regiao").value = name_regiao;
}

const fecharReg = document.getElementById('Regiao');

document.addEventListener('click', function(eventReg){
	const validar_regiao = fecharReg.contains(eventReg.target);
	if(!validar_regiao){
		document.getElementById('pesquisa_regiao').innerHTML = '';
	}
});
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------AutoComplete-----------------------------------------------------------------------------
//---------------------------------------------------------------------------------------UF---------------------------------------------------------------------------------

async function carregar_UF(valUF){
	if(valUF.length >= 1){
		
		const resUF = await fetch('../data/estados.json');
		const UFJson = await resUF.json();

		var html = "<ul class='list-group' position-fixed>";
		for(let i = 0; i < UFJson.length; i++){
			if(UFJson[i].name.toLowerCase().startsWith(valUF.toLowerCase())){
				html += "<li class='list-group-item list-group-item-action' onclick='get_name_UF("+JSON.stringify(UFJson[i].name)+")'>" + UFJson[i].name + "</li>";
			}
		}
		html += "</ul>";
		document.getElementById('pesquisa_UF').innerHTML = html;
	}else{
		document.getElementById('pesquisa_UF').innerHTML = '';
	}
}

function get_name_UF(name_UF){
	document.getElementById("UF").value = name_UF;
}

const fecharUF = document.getElementById('UF');

document.addEventListener('click', function(eventUF){
	const validar_UF = fecharUF.contains(eventUF.target);
	if(!validar_UF){
		document.getElementById('pesquisa_UF').innerHTML = '';
	}
});
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------AutoComplete-----------------------------------------------------------------------------
//----------------------------------------------------------------------------------Estacação--------------------------------------------------------------------------------
async function carregar_estacao(valestacao){
	if(valestacao.length >= 1){

		const resestacao = await fetch('../data/estados.json');
		const estacaoJson = await resestacao.json();

		var html = "<ul class='list-group' position-fixed>";
		for(let i = 0; i < estacaoJson.length; i++){
			if(estacaoJson[i].name.toLowerCase().startsWith(valestacao.toLowerCase())){
				html += "<li class='list-group-item list-group-item-action' onclick='get_name_estacao("+JSON.stringify(estacaoJson[i].name)+")'>" + estacaoJson[i].name + "</li>";
			}
		}
		html += "</ul>";
		document.getElementById('pesquisa_estacao').innerHTML = html;
	}else{
		document.getElementById('pesquisa_estacao').innerHTML = '';
	}
}
function get_name_estacao(name_estacao){
	document.getElementById("Estacao").value = name_estacao;
}

const fecharestacao = document.getElementById('Estacao');

document.addEventListener('click', function(eventestacao){
	const validar_estacao = fecharestacao.contains(eventestacao.target);
	if(!validar_estacao){
		document.getElementById('pesquisa_estacao').innerHTML = '';
	}
});
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------AutoComplete-----------------------------------------------------------------------------
//------------------------------------------------------------------------------------Variavel-------------------------------------------------------------------------------
async function carregar_variavel(valvariavel){
	if(valvariavel.length >= 1){
		
		const resvariavel = await fetch('../data/estados.json');
		const variavelJson = await resvariavel.json();

		var html = "<ul class='list-group' position-fixed>";
		for(let i = 0; i < variavelJson.length; i++){
			if(variavelJson[i].name.toLowerCase().startsWith(valvariavel.toLowerCase())){
				html += "<li class='list-group-item list-group-item-action' onclick='get_name_variavel("+JSON.stringify(variavelJson[i].name)+")'>" + variavelJson[i].name + "</li>";
			}
		}
		html += "</ul>";
		document.getElementById('pesquisa_variavel').innerHTML = html;
	}else{
		document.getElementById('pesquisa_variavel').innerHTML = '';
	}	
}

function get_name_variavel(name_variavel){
	document.getElementById("Variavel").value = name_variavel;
}

const fecharvariavel = document.getElementById('Variavel');

document.addEventListener('click', function(eventvariavel){
	const validar_variavel = fecharvariavel.contains(eventvariavel.target);
	if(!validar_variavel){
		document.getElementById('pesquisa_variavel').innerHTML = '';
	}
});

//-----------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------Criando a tabela de dados------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
fetch('../data/estados.json')
	.then(response => response.json())
	.then(data => {
		
		var corpoTabela = document.querySelector('tbody');

		for (let i = 1; i < data.length; i++){

			var tr= document.createElement('tr');
			var tdCodigo= document.createElement('td');
			var tdEstacao= document.createElement('td');
			var tdId= document.createElement('td');
			var tdTempBulbo= document.createElement('td');
			var tdTempMax= document.createElement('td');
			var tdTempMin= document.createElement('td');
			var tdDataH= document.createElement('td');
			
			tdCodigo.textContent = data[i].name;
			tdEstacao.textContent =  data[i].capital;
			tdId.textContent = data[i].abbr;
			tdTempBulbo.textContent = data[i].lat; 
			tdTempMax.textContent = data[i].lat;
			tdTempMin.textContent = data[i].long;
			tdDataH.textContent =  data[i].abbr;
			
			tr.appendChild(tdCodigo);
			tr.appendChild(tdEstacao);
			tr.appendChild(tdId);
			tr.appendChild(tdTempBulbo);
			tr.appendChild(tdTempMax);
			tr.appendChild(tdTempMin);
			tr.appendChild(tdDataH);
			corpoTabela.appendChild(tr);

		};
	});

//-----------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------Criando a tabela de dados------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
(function($) {
	"use strict";

	// Spinner
	var spinner = function() {
		setTimeout(function() {
			if ($("#spinner").length > 0) {
				$("#spinner").removeClass("show");
			}
		}, 1);
	};
	spinner();

	// Calender
	$("#calender").datetimepicker({
		inline: true,
		format: "L",
	});

	// Calender
	$("#calender2").datetimepicker({
		inline: true,
		format: "L",
	});
})(jQuery);

function lista() {
	google.charts.load("current", { packages: ["corechart"] });
google.charts.setOnLoadCallback(drawChart);
 }



var getData1 = function() {
	var dataHoje = new Date();
	dataHoje.setMinutes(dataHoje.getMinutes() - dataHoje.getTimezoneOffset());
	var input = $("#dataInicio").val();

	/*  if ($("#dataHorarioAcordado").hasClass("d-none")) return null;
	  if (input == "" || input == " ") return "vazio";  */

	var dataInput = new Date(Date.parse(input));
	dataInput.setMinutes(dataInput.getMinutes() - dataInput.getTimezoneOffset());
	if (dataHoje >= dataInput) {
		return "erro";
	}

	return dataInput;
};

$(document).ready(function() {
	$(document).on("click", "#btnEnviarDados", function() {
		//debugger;

		// Valores da data de inico e fim que foram inseridas nas entradas de data.
		var vDataInicio = $("#dataInicio").val();
		var vDataFim = $("#dataFim").val();
		var vDadoDesejado = "";
		debugger;

		$.post(
			"/filtrar/vDadoDesejado",
			//corpo da requisição <body> == {}
			JSON.stringify({ dataInicio: vDataInicio, dataFinal: vDataFim }),
			function(data) {
				if (data[0].status == 0) {
					debugger;
					window.location.href = "/index";
				} else {
					debugger;
					sessionStorage.setItem("userNameADM", data[0].userName);

					window.location.href = "/temperatura";
				}
			},
			"json"
		);
	});


	var OnClickLeo = function() {
		$("#relatorio").click(function() {
			debugger

			$.getJSON({
				url: "/testeIndex",
				success: function(data) {
					//KTApp.unblockPage();


					if (data.resultado == "OK") {
						debugger
						window.location.reload("/testeIndex");
					}
					if (data.resultado == "ERROR") {
						debugger
						Swal.fire(
							'Erro!',
							'Houve um erro ao se comunicar com o servido, tente novamente mais tarde.',
							'error'
						);
					}
				}
			})

		});
	}


	OnClickLeo();


})


//Metodo script responsavel por receber e enviar os dados do front para o back atraves de um JSON
function salvarUsuario(){

	//Recebendo as informações dos filtros e armazenando em variaveis
	var vRegiao = $("#Regiao").val();
	var vUF = $("#UF").val();
	var vVariavel = $("#Variavel").val();
	var vDataInicio = $("#DataInicio").val();
	var vDataFim = $("#DataFim").val();
	var vEstacao = $("#Estacao").val();
	debugger;
	//Função ajax de atribuição do front para uma classe no java
	$.ajax({
		method: "POST", //Especificando qual o metodo
		url: "/temperatura", //Definindo a url que conecta no mapeamento
		//Passando os atribuyos da classe e quais variaveis representa eles no front
		data: JSON.stringify({regiao : vRegiao , estado : vUF , variavel : vVariavel , dataInicio : vDataInicio , dataFim : vDataFim, estacao : vEstacao}), 
		contentType: "application/json; charset=utf-8", //Explicitando que se trata de um conteudo JSON
		//Alerta de sucesso ou falha no envio do JSON
		success: function (data){
			alert("Salvo com Sucesso!");
			plotcharts(data);
		}
	}).fail(function(xhr, status, errorThrow){
		alert("Erro ao Salvar: " + xhr.responseText);
	});
}
function plotcharts(data){
			var datas=[];
            var valor=[];
			for(let i =0; i <data.length;i++){
                  datas.push(data[i]['dataHora']);
                  valor.push(parseInt(data[i]['temMax']));
                }
			//For Line chart
			dataset=addData('TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)', valor, 'black', 'green');
                drawchart(dataset, datas, 'line');
                }
                
