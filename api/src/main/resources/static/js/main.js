//Lendo os inputs e o divs  de demonstração
const Regiao = document.getElementById('Regiao');
const CombinaRegiao = document.getElementById('combina-Regiao');

const UF = document.getElementById('UF');
const CombinaUF = document.getElementById('combina-UF');

const Estacao = document.getElementById('Estacao');
const CombinaEstacao = document.getElementById('combina-Estacao');

const Variavel = document.getElementById('Variavel');
const CombinaVariavel = document.getElementById('combina-Variavel');

//-----------------------------------------------------------------------------------------------------------------------------------------
//buscando o arquivo json e combinando com Regiao
const BuscarRegiao = async searchText => {
	const resReg = await fetch('../data/estados.json');
	const RegiaoJson = await resReg.json();

	//pegando as combinações tendo com base digitado
	let combinaRegiao = RegiaoJson.filter(Reg => {
		const regexReg = new RegExp(`^${searchText}`, 'gi');
		return Reg.name.match(regexReg) || Reg.abbr.match(regexReg);
	});

	console.log(combinaRegiao);
};
//busscando o arquivo json e combinando com UF
const BuscarUF = async searchText => {
	const res = await fetch('../data/estados.json');
	const estados = await res.json();

	//pegando as combinações tendo com base digitado
	let combinacao = estados.filter(estado => {
		const regex = new RegExp(`^${searchText}`, 'gi');
		return estado.name.match(regex) || estado.abbr.match(regex);
	});

	//se o campo estiver vazio não tem resultado
	if (searchText.length == 0){
		combinacao = [];
		CombinaUF.innerHTML = '';
	}
	outputHtml(combinacao);
	console.log(combinacao);
};
//buscando o arquivo json e combinando com Estacao
const BuscarEstacao = async searchText => {
	const resEs = await fetch('../data/estados.json');
	const EstacaJson = await resEs.json();

	//pegando as combinações tendo com base digitado
	let combinaEstacao = EstacaJson.filter(Estacaov => {
		const regexEstacao = new RegExp(`^${searchText}`, 'gi');
		return Estacaov.name.match(regexEstacao) || Estacaov.abbr.match(regexEstacao);
	});
	console.log(combinaEstacao);
}
//buscando o arquivo json e combinando com Variavel
const BuscarVariavel = async searchText => {
	const resVar = await fetch('../data/estados.json');
	const VariavelJson = await resVar.json();

	//pegando as combinações tendo com base digitado
	let combinaVariavel = VariavelJson.filter(Variavel => {
		const regexVariavel = new RegExp(`^${searchText}`, 'gi');
		return Variavel.name.match(regexVariavel) || Variavel.abbr.match(regexVariavel);
	});

	console.log(combinaVariavel);
};

//-----------------------------------------------------------------------------------------------------------------------------------------
//|Mostra o resultado no html
const outputHtml = combinacao => {
	if (combinacao.length > 0){
		const html = combinacao.map(match => `
		<div class="card card-body mb-1">
			<h4>${match.name} (${match.abbr}) <span class="text-primary">${match.capital}</span></h4>
			<small>Lat: ${match.lat} / Long:${match.long}</small>
		</div>
		`)
		.join('');
		
		
		CombinaUF.innerHTML = html;
	}
};


//-----------------------------------------------------------------------------------------------------------------------------------------
Regiao.addEventListener('input', () => BuscarRegiao(Regiao.value));
UF.addEventListener('input', () => BuscarUF(UF.value));
Estacao.addEventListener('input', () => BuscarEstacao(Estacao.value));
Variavel.addEventListener('input', () => BuscarVariavel(Variavel.value));



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
			
			
			
			
			/*function plotcharts(){
            	
              var apiUrl = data;
              var datas=[];
              var valor=[];
              fetch(apiUrl).then(response => {
                return response.json();
              }).then(data => {
                for(let i =0; i <data.length;i++){
                  datas.push(data[i]['dataHora']);
                  valor.push(parseInt(data[i]['temMax']));
                }
                //For Line chart
                dataset=addData('TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)', 'black', 'green');
                drawchart(dataset, datas, 'line');
              }).catch(err => {
                console.log(err);
              });
          }*/
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
                
