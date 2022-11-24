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
		$.getJSON("/regiao", function(variavelJson) {
				var html = "<ul class='list-group' position-fixed>";
				for(let i = 0; i < variavelJson.length; i++){
					if(variavelJson[i].regSigla.toLowerCase().startsWith(valvariavel.toLowerCase())){
						html += "<li class='list-group-item list-group-item-action' onclick='get_name_variavel("+JSON.stringify(variavelJson[i].regSigla)
						+")'>" + variavelJson[i].regSigla + "</li>";
					}
				}
				html += "</ul>";
				document.getElementById('pesquisa_variavel').innerHTML = html;
		});
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
//----------------------------------------------------Botão de Filtros GRafico-------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
function filtra(){		
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a tabela de dados------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------
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
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a Grafico--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//Pegando o elemnento canvas do HTML pelo id
	
	$.getJSON("/regiao", function(DataGrafico) {
	console.log(DataGrafico);

	 //Status que fica na linha y
	//var labels = DataGrafico.map(function(e) {
		//return e.regSigla;
	// });

	 //Status que fica na linha y
	 //var data = DataGrafico.map(function(e) {
	//	return e.regId;
	// });

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