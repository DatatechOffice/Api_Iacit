//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------AutoComplete-----------------------------------------------------------------------------
//------------------------------------------------------------------------------------Regiao--------------------------------------------------------------------------------
async function carregar_regiao(valRegiao){
	if(valRegiao.length >= 1){
		
		$.getJSON("/regiao", function(RegiaoJson) {
		
			var html = "<ul class='list-group' position-fixed>";

			for(let i = 0; i < RegiaoJson.length; i++){
				
				if(RegiaoJson[i].regSigla.toLowerCase().startsWith(valRegiao.toLowerCase())){
					html += "<li class='list-group-item list-group-item-action' onclick='get_name_Regiao("+JSON.stringify(RegiaoJson[i].regSigla)+
					")'>" + RegiaoJson[i].regSigla + "</li>";
				}
			}
			html += "</ul>";

			document.getElementById('pesquisa_regiao').innerHTML = html;

	});
		
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

		$.getJSON("/estado", function(UFJson) {
			var vRegiao = $("#Regiao").val();

			var html = "<ul class='list-group' position-fixed>";

			for(let i = 0; i < UFJson.length; i++){
				if(vRegiao == UFJson[i].regId.regSigla || vRegiao == ""){
				if(UFJson[i].etdUnidadeFederativa.toLowerCase().startsWith(valUF.toLowerCase())){
					html += "<li class='list-group-item list-group-item-action' onclick='get_name_UF("+
					JSON.stringify(UFJson[i].etdUnidadeFederativa)+
					","+JSON.stringify(UFJson[i].regId.regSigla)+
					")'>" + UFJson[i].etdUnidadeFederativa + "</li>";
				}}
			}
			html += "</ul>";
			document.getElementById('pesquisa_UF').innerHTML = html;
			});
	}else{
		document.getElementById('pesquisa_UF').innerHTML = '';
	}
}

function get_name_UF(name_UF, regiao_UF){
	document.getElementById("UF").value = name_UF;
	document.getElementById("Regiao").value = regiao_UF;
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

			var vUF = $("#UF").val();
			var vRegiao = $("#Regiao").val();

			var html = "<ul class='list-group' position-fixed>";
			for(let i = 0; i < estacaoJson.length; i++){
				if(vUF == estacaoJson[i].etdId.etdUnidadeFederativa || vUF == "" && vRegiao == estacaoJson[i].etdId.regId.regSigla || vRegiao == "" && vUF == ""){
				if(estacaoJson[i].estNomeEstacao.toLowerCase().startsWith(valestacao.toLowerCase())){
					html += "<li class='list-group-item list-group-item-action' onclick='get_name_estacao("+
					JSON.stringify(estacaoJson[i].estNomeEstacao)+
					","+JSON.stringify(estacaoJson[i].etdId.etdUnidadeFederativa)+
					","+JSON.stringify(estacaoJson[i].etdId.regId.regSigla)+")'>" 
					+ estacaoJson[i].estNomeEstacao + "</li>";
				}}
			}
			html += "</ul>";
			document.getElementById('pesquisa_estacao').innerHTML = html;
		});
	}else{
		document.getElementById('pesquisa_estacao').innerHTML = '';
	}
}
function get_name_estacao(name_estacao, uf_estacao, regiao_estacao){

	document.getElementById("Estacao").value = name_estacao;
	document.getElementById("UF").value = uf_estacao;
	document.getElementById("Regiao").value = regiao_estacao;
}

const fecharestacao = document.getElementById('Estacao');

document.addEventListener('click', function(eventestacao){
	const validar_estacao = fecharestacao.contains(eventestacao.target);
	if(!validar_estacao){
		document.getElementById('pesquisa_estacao').innerHTML = '';
	}
});
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a tabela de dados------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------
	function tabela(){
	const Reg = document.getElementById('Regiao').value;
	var corpoTabela = document.querySelector('tbody');
	var vEstacao = $("#Estacao").val();
	$.getJSON("/estacao", function(DataTabela) {
		console.log(DataTabela);
		 for (let i = 0; i < DataTabela.length; i++){
			if(vEstacao == DataTabela[i].estNomeEstacao){
				var tr= document.createElement('tr');
				var tdCodigo= document.createElement('td');
				var tdEstacao= document.createElement('td');
				var tdAltitude = document.createElement('td');
				var tdLatitude = document.createElement('td');
				var tdLongitude = document.createElement('td');
				var tdEstado = document.createElement('td');
				var tdRegiao = document.createElement('td');


				tdCodigo.textContent = DataTabela[i].estCodigo;
				tdEstacao.textContent =  DataTabela[i].estNomeEstacao;
				tdAltitude.textContent = DataTabela[i].estAltitude;
				tdLatitude.textContent = DataTabela[i].estLatitude;
				tdLongitude.textContent = DataTabela[i].estLongitude;
				tdEstado.textContent = DataTabela[i].etdId.etdUnidadeFederativa;
				tdRegiao.textContent = DataTabela[i].etdId.regId.regSigla;

				tr.appendChild(tdCodigo);
				tr.appendChild(tdEstacao);
				tr.appendChild(tdAltitude);
				tr.appendChild(tdLatitude);
				tr.appendChild(tdLongitude);
				tr.appendChild(tdEstado);
				tr.appendChild(tdRegiao);


				corpoTabela.appendChild(tr);
	
			};
		}
		
		});
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a Grafico-------------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------,

	let myChart = null;


	$('#dataCourse').on('change', function(){


		var selected = $(this).find("option:selected").val();

		if(selected == 1){
			vVariavel  = 'pressao_atmosferica';
		}
		if(selected == 2){
			vVariavel  = 'precipitacao';
		}
		if(selected == 3){
			vVariavel  = 'radiacao_global';
		}
		if(selected == 4){
			vVariavel  = 'temperatura';
		}
		if(selected == 5){
			vVariavel  = 'temperatura_orvalho';
		}
		if(selected == 6){
			vVariavel  = 'umidade';
		}
		if(selected == 7){
			vVariavel  = 'vento';
		}

		//Recebendo as informações dos filtros e armazenando em variaveis
		var vRegiao = $("#Regiao").val();
		var vUF = $("#UF").val();
		var vDataInicio = $("#DataInicio").val();
		var vDataFim = $("#DataFim").val();
		var vEstacao = $("#Estacao").val();

		//Função ajax de atribuição do front para uma classe no java
		$.ajax({
			method: "POST", //Especificando qual o metodo
			url: vVariavel, //Definindo a url que conecta no mapeamento
			//Passando os atribuyos da classe e quais variaveis representa eles no front
			data: JSON.stringify({regiao : vRegiao , estado : vUF , variavel : vVariavel , dataInicio : vDataInicio , dataFim : vDataFim, estacao : vEstacao}), 
			contentType: "application/json; charset=utf-8", //Explicitando que se trata de um conteudo JSON
			//Alerta de sucesso ou falha no envio do JSON
			success: function (data){
				alert("Salvo com Sucesso!");
				plotcharts(data);

			}
		}).fail(function(xhr, status, errorThrow){
			alert("Erro ao comunicar: " + xhr.responseText);
		});

		function plotcharts(dataJS){
			var datas=[];
            var valorMax=[];
			var valorMin=[];
			var valor=[];
			for(let i =0; i <dataJS.length;i++){
				  datas.push(i);
                  valorMax.push(parseInt(dataJS[i].valorMax));
				  valorMin.push(parseInt(dataJS[i].valorMin));
				  valor.push(parseInt(dataJS[i].valor));
                }

			const data = {
			labels: datas,
			datasets: [{
			  label: "Maxima ",
			  data: valorMax,
			  backgroundColor: 'white',
			  borderColor: 'rgba(0,0,255)',
			  tension: 0.5,
			},{
				label: 'Minima',
				data: valorMin,
				backgroundColor: 'White',
				borderColor: 'rgba(255,0,0)',
				tension: 0.5,
			  },{
				label: 'valor',
				data: valor,
				backgroundColor: 'White',
				borderColor: 'rgba(0,255,0)',
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
			
		  const grafico = document.getElementById('plots').getContext('2d');

		  if(myChart != null){
			myChart.destroy();
		  }

		  myChart = new Chart(grafico, config);
	};




		});
		
function logout() {
	
	window.location.replace("/index");
}		
