const UF = document.getElementById('UF');
const combinaUF = document.getElementById('combina-UF');

//busscando o arquivo json
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
		combinaUF.innerHTML = '';
	}
	outputHtml(combinacao);
	console.log(combinacao);
};

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
		
		
		combinaUF.innerHTML = html;
	}
};

UF.addEventListener('input', () => BuscarUF(UF.value))
;

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

function lista() { }

google.charts.load("current", { packages: ["corechart"] });
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
	var data = google.visualization.arrayToDataTable([
		["Element", "Density", { role: "style" }],
		["Temp Bulbo Seco", 20.94, "#b87333"],
		["Temp Max", 10.49, "silver"],
		["Temp Min", 19.3, "gold"],
	]);

	var view = new google.visualization.DataView(data);
	view.setColumns([
		0,
		1,
		{
			calc: "stringify",
			sourceColumn: 1,
			type: "string",
			role: "annotation",
		},
		2,
	]);

	var options = {
		title: "Temperatura",
		width: 600,
		height: 400,
		bar: { groupWidth: "95%" },
		legend: { position: "none" },
	};

	var chart = new google.visualization.ColumnChart(
		document.getElementById("columnchart_values")
	);
	chart.draw(view, options);
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
		sucess: function (response){
			alert("Salvo com Sucesso!");
		}
	}).fail(function(xhr, status, errorThrow){
		alert("Erro ao Salvar: " + xhr.responseText);
	});
}
