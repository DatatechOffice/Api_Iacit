//--------------------------------------------------------------------------------------------------------------------------------------------------------------------------
//---------------------------------------------------------------------------------AutoComplete-----------------------------------------------------------------------------
//------------------------------------------------------------------------------------Regiao--------------------------------------------------------------------------------


$.getJSON("/regiao", function(regiao) {
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
//----------------------------------------------------Botão de Filtros GRafico-------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------------------------------------
function filtra(){
	fetch('../data/estados.json')
	.then(response => response.json())
	.then(data => {
		
	
		const Reg = document.getElementById('Regiao').value;
		var corpoTabela = document.querySelector('tbody');
	
	
	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a tabela de dados------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------
		for (let i = 0; i < data.length; i++){
			if(data[i].name.toLowerCase().startsWith(Reg.toLowerCase())){
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
		}

	//-----------------------------------------------------------------------------------------------------------------------------------------
	//----------------------------------------------------Criando a Grafico--------------------------------------------------------------
	//-----------------------------------------------------------------------------------------------------------------------------------------

	//Pegando o elemnento canvas do HTML pelo id
	plots = document.getElementById("plots");
	
	$.getJSON("/regiao", function(DataGrafico) {
	console.log(DataGrafico);
	 //Status que fica na linha y
	var labels = DataGrafico.map(function(e) {
		return e.regSigla;
	 });
	 //Status que fica na linha y
	 var data = DataGrafico.map(function(e) {
		return e.regId;
	 });
	//Criando a isntancia do objeto chart
	new Chart(plots, {
		type: 'line', //declara o tipo do grafico
		data: {
			labels: labels, //Data do alinhamento X
			datasets: [{
				data: data, //Data do alinhamento y
				backgroundColor: '#5e440f',
				borderColor: 'white',
				fill: false, //Preenche as curvas abaixo da linha com a cor do fundo, normalmente por padrão é true
			}]
		},
	});
		
	});



});
	
}