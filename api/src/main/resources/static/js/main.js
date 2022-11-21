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
//-----------------------------------------//buscando o arquivo json e combinando com Regiao-----------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------

const BuscarRegiao = async searchText => {
	const resReg = await fetch('../data/estados.json');
	const RegiaoJson = await resReg.json();

	//pegando as combinações tendo com base digitado
	let combinaRegiao = RegiaoJson.filter(Reg => {
		const regexReg = new RegExp(`^${searchText}`, 'gi');
		return Reg.name.match(regexReg) || Reg.abbr.match(regexReg);
	});
	if (searchText.length == 0){
		combinaRegiao = [];
		CombinaRegiao.innerHTML = '';
	}
<<<<<<< Updated upstream
	outputHtmlReg(combinaRegiao);
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
};
//buscando o arquivo json e combinando com Estacao
const BuscarEstacao = async searchText => {
	const resEs = await fetch('../data/estados.json');
	const EstacaJson = await resEs.json();
=======
	
}
<<<<<<< Updated upstream
>>>>>>> Stashed changes

	//pegando as combinações tendo com base digitado
	let combinaEstacao = EstacaJson.filter(Estacaov => {
		const regexEstacao = new RegExp(`^${searchText}`, 'gi');
		return Estacaov.name.match(regexEstacao) || Estacaov.abbr.match(regexEstacao);
	});
	if (searchText.length == 0){
		combinaEstacao = [];
		CombinaEstacao.innerHTML = '';
	}
	outputHtmlEs(combinaEstacao);
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
	if (searchText.length == 0){
		combinaVariavel = [];
		CombinaVariavel.innerHTML = '';
	}
	outputHtmlVar(combinaVariavel);
};

//-----------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------Mostra o resultado no html-----------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------

//resultado das UF
const outputHtml = combinacao => {
	if (combinacao.length > 0){
		const html = combinacao.map(match => `
		<div class="card card-body mb-1">
			<h4>${match.name}</h4>
			<small>Lat: ${match.lat} / Long:${match.long}</small>
		</div>
		`)
		.join('');
		
		
		CombinaUF.innerHTML = html;
	}
};
//resultado das regiões
const outputHtmlReg = combinaRegiao => {
	if (combinaRegiao.length > 0){
		const htmlReg = combinaRegiao.map(matchReg => `
		<div class="card card-body mb-1">
			<h4>${matchReg.name}</h4>
			<small>Lat: ${matchReg.lat} / Long:${matchReg.long}</small>
		</div>
		`)
		.join('');
		
		CombinaRegiao.innerHTML = htmlReg;
	}
};
//Resultado dos estados
const outputHtmlEs = combinaEstacao => {
	if (combinaEstacao.length > 0){
		const htmlEs = combinaEstacao.map(matchEs => `
		<div class="card card-body mb-1">
			<h4>${matchEs.name}</h4>
			<small>Lat: ${matchEs.lat} / Long:${matchEs.long}</small>
		</div>
		`)
		.join('');
		
		CombinaEstacao.innerHTML = htmlEs;
	}
};
//Resultado das variaveis
const outputHtmlVar = combinaVariavel => {
	if (combinaVariavel.length > 0){
		const htmlVar = combinaVariavel.map(matchVar => `
		<div class="card card-body mb-1">
			<h4>${matchVar.name}</h4>
			<small>Lat: ${matchVar.lat} / Long:${matchVar.long}</small>
		</div>
		`)
		.join('');
		
		CombinaVariavel.innerHTML = htmlVar;
	}
};

//-----------------------------------------------------------------------------------------------------------------------------------------
//-------------------------------------------------Adicionando o evento aos inputs---------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
Regiao.addEventListener('input', () => BuscarRegiao(Regiao.value));
UF.addEventListener('input', () => BuscarUF(UF.value));
Estacao.addEventListener('input', () => BuscarEstacao(Estacao.value));
Variavel.addEventListener('input', () => BuscarVariavel(Variavel.value));

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
<<<<<<< Updated upstream
	//For Line chart
	dataset=addData('TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)', valor, 'black', 'green');
		drawchart(dataset, datas, 'line');
=======
});
//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------AutoComplete-----------------------------------------------------------------------------
//------------------------------------------------------------------------------------Variavel-------------------------------------------------------------------------------
async function carregar_variavel(valvariavel){
	if(valvariavel.length >= 1){
		
		
		$.getJSON("/regiao", function(variavelJson) {

				var html = "<ul class='list-group' position-fixed>";
				for(let i = 0; i < variavelJson.length; i++){
					if(variavelJson[i].regSigla.toLowerCase().startsWith(valvariavel.toLowerCase())){
						html += "<li class='list-group-item list-group-item-action' onclick='get_name_variavel("+JSON.stringify(variavelJson[i].regSigla)
						+")'>" + variavelJson[i].regSigla + "</li>";
=======

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
		
		$.getJSON("/estado", function(UFJson) {
			console.log(UFJson);
	
			var html = "<ul class='list-group' position-fixed>";
			for(let i = 0; i < UFJson.length; i++){
				if(UFJson[i].etdUnidadeFederativa.toLowerCase().startsWith(valUF.toLowerCase())){
					html += "<li class='list-group-item list-group-item-action' onclick='get_name_UF("+JSON.stringify(UFJson[i].etdUnidadeFederativa)+
					")'>" + UFJson[i].etdUnidadeFederativa + "</li>";
				}
			}
			html += "</ul>";
			document.getElementById('pesquisa_UF').innerHTML = html;
			});

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

		$.getJSON("/estacao", function(estacaoJson) {

			var html = "<ul class='list-group' position-fixed>";
			for(let i = 0; i < estacaoJson.length; i++){
				if(estacaoJson[i].estNomeEstacao.toLowerCase().startsWith(valestacao.toLowerCase())){
					html += "<li class='list-group-item list-group-item-action' onclick='get_name_estacao("+JSON.stringify(estacaoJson[i].estNomeEstacao)+")'>" 
					+ estacaoJson[i].estNomeEstacao + "</li>";
				}
			}
			html += "</ul>";
			document.getElementById('pesquisa_estacao').innerHTML = html;
		});
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
		
		
		$.getJSON("/variavel", function(variavelJson) {

				var html = "<ul class='list-group' position-fixed>";
				for(let i = 0; i < variavelJson.length; i++){
					if(variavelJson[i].toLowerCase().startsWith(valvariavel.toLowerCase())){
						html += "<li class='list-group-item list-group-item-action' onclick='get_name_variavel("+JSON.stringify(variavelJson[i])
						+")'>" + variavelJson[i] + "</li>";
>>>>>>> Stashed changes
					}
				}
				html += "</ul>";
				document.getElementById('pesquisa_variavel').innerHTML = html;
		});

	}else{
		document.getElementById('pesquisa_variavel').innerHTML = '';
	}	
>>>>>>> Stashed changes
}

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
<<<<<<< Updated upstream
	//For Line chart
	dataset=addData('TEMPERATURA MÍNIMA NA HORA ANT. (AUT) (°C)', valor, 'black', 'green');
	drawchart(dataset, datas, 'line');
}
=======
});

//-----------------------------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------Botão de Filtros GRafico-------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
function filtra(){		
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a tabela de dados------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------
<<<<<<< Updated upstream
	const Reg = document.getElementById('Regiao').value;
	var corpoTabela = document.querySelector('tbody');

	$.getJSON("/estacao", function(DataTabela) {
		
		 for (let i = 0; i < DataTabela.length; i++){
			if(DataTabela[i].estNomeEstacao.toLowerCase().startsWith(Reg.toLowerCase())){
				var tr= document.createElement('tr');
				var tdCodigo= document.createElement('td');
				var tdEstacao= document.createElement('td');
				var tdId= document.createElement('td');
				var tdTempBulbo= document.createElement('td');
				var tdTempMax= document.createElement('td');
				var tdTempMin= document.createElement('td');
				var tdDataH= document.createElement('td');
				
				tdCodigo.textContent = DataTabela[i].estCodigo;
				tdEstacao.textContent =  DataTabela[i].estNomeEstacao;
				tdId.textContent = 'null';
				tdTempBulbo.textContent = 'null'; 
				tdTempMax.textContent = 'null';
				tdTempMin.textContent = 'null';
				tdDataH.textContent =  'null';
				
				tr.appendChild(tdCodigo);
				tr.appendChild(tdEstacao);
				tr.appendChild(tdId);
				tr.appendChild(tdTempBulbo);
				tr.appendChild(tdTempMax);
				tr.appendChild(tdTempMin);
				tr.appendChild(tdDataH);
				corpoTabela.appendChild(tr);
	
			};
		}
		
		});
=======
	//Metodo script responsavel por receber e enviar os dados do front para o back atraves de um JSON
	//Recebendo as informações dos filtros e armazenando em variaveis
	var vRegiao = $("#Regiao").val();
	var vUF = $("#UF").val();
	var vVariavel = $("#Variavel").val();
	var vDataInicio = $("#DataInicio").val();
	var vDataFim = $("#DataFim").val();
	var vEstacao = $("#Estacao").val();
	//Função ajax de atribuição do front para uma classe no java
	$.ajax({
		method: "POST", //Especificando qual o metodo
		url: "/"+vVariavel, //Definindo a url que conecta no mapeamento
		//Passando os atribuyos da classe e quais variaveis representa eles no front
		dataJson: JSON.stringify({regiao : vRegiao , estado : vUF , variavel : vVariavel , dataInicio : vDataInicio , dataFim : vDataFim, estacao : vEstacao}), 
		contentType: "application/json; charset=utf-8", //Explicitando que se trata de um conteudo JSON
		//Alerta de sucesso ou falha no envio do JSON
		success: function (dataJson){
			alert("Salvo com Sucesso!");
			
			plotcharts(dataJson);

		}
	}).fail(function(xhr, status, errorThrow){
		
		alert("Erro ao Salvar: " + xhr.responseText);
		console.log(dataJson);
	});



>>>>>>> Stashed changes

	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a Grafico--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------

	//Pegando o elemnento canvas do HTML pelo id
	
<<<<<<< Updated upstream
	$.getJSON("/regiao", function(DataGrafico) {
	console.log(DataGrafico);
=======
	
>>>>>>> Stashed changes

	 //Status que fica na linha y
	//var labels = DataGrafico.map(function(e) {
		//return e.regSigla;
	// });

	 //Status que fica na linha y
	 //var data = DataGrafico.map(function(e) {
	//	return e.regId;
	// });

<<<<<<< Updated upstream
	    // setup 
		const data = {
			labels: ['Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun'],
			datasets: [{
			  label: 'Maxima',
			  data: [18, 12, 6, 9, 12, 3, 9],
			  backgroundColor: 'white',
			  borderColor: 'rgba(0,0,255)',
			  tension: 0.5,
			},{
				label: 'Minima',
				data: [10, 5, 3, 7, 4, 3, 1],
				backgroundColor: 'White',
				borderColor: 'rgba(255,0,0)',
				tension: 0.5,
			  }]
		  };
	  
		  // config 
		  const config = {
			type: 'line',
			data,
			options: {
			  scales: {
				y: {
				  beginAtZero: true
				}
			  }
			}
		  };
	  
		  // render init block
		  const myChart = new Chart(
			document.getElementById('plots'),
			config
		  );		
	});	
}
=======
	    // setup 		


			}
function plotcharts(dataJson){
			var datas=[];
            var valor=[];
			for(let i =0; i <dataJson.length;i++){
                  datas.push(dataJson[i]['dataHora']);
                  valor.push(parseInt(dataJson[i][vVariavel]));
                }
				const data = {
					labels: datas,
					datasets: [{
					  label: vVariavel,
					  data: valor,
					  backgroundColor: 'white',
					  borderColor: 'rgba(0,0,255)',
					  tension: 0.5,
					},{
						label: vVariavel,
						data: valor,
						backgroundColor: 'White',
						borderColor: 'rgba(255,0,0)',
						tension: 0.5,
					  }]
				  };
			  
				  // config 
				  const config = {
					type: 'line',
					data,
					options: {
					  scales: {
						y: {
						  beginAtZero: true
						}
					  }
					}
				  };
			  
				  // render init block
				  const myChart = new Chart(
					document.getElementById('plots'),
					config
				  );		
                }
>>>>>>> Stashed changes
>>>>>>> Stashed changes
