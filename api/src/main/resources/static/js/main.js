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
		debugger;

		$.post(
			"/hello",
			JSON.stringify({ name: vDataInicio, name: vDataFim }),
			function(data) {
				if (data[0].status == 0) {
					window.location.href = "/hello1";
				} else {
					sessionStorage.setItem("userNameADM", data[0].userName);

					window.location.href = "/hello2";
				}
			},
			"json"
		);
	});


	var OnClickDeletar = function() {
		$("#relatorio").click(function() {
			var idFuncao = $(this).attr("data-idElemento");

			Swal.fire({
				title: 'Tem certeza que deseja deletar alguma Função?',
				text: "Essa ação não poderá ser revertida!",
				icon: 'warning',
				showCancelButton: true,
				confirmButtonColor: '#3085d6',
				cancelButtonColor: '#d33',
				confirmButtonText: 'Sim, deletar!',
				cancelButtonText: 'Não, cancelar!',
			}).then((result) => {
				if (result.isConfirmed) {


					KTApp.blockPage({
						overlayColor: '#000000',
						state: 'primary',
						message: 'Carregando...'
					});

					$.ajax({
						async: true,
						type: "GET",
						url: "/name",
						success: function(json) {
							KTApp.unblockPage();


							if (json.resultado == "OK") {
								Swal.fire(
									'Deletado!',
									'Função deletado com sucesso.',
									'success'
								);
								window.location.reload();
							}
							if (json.resultado == "ERROR") {
								Swal.fire(
									'Erro!',
									'Houve um erro ao se comunicar com o servido, tente novamente mais tarde.',
									'error'
								);
							}
						}
					})

				};
			})
		})
	}


	$("#busca").click(function() {
		var modelo = $("#modelo option:selected").text();
		var marca = $("#marca option:selected").text();
		var cor = $("#cor option:selected").text();

		$("#dadosCarro").empty();

		var url = "/carro/" + modelo + "/" + marca + "/" + cor + "";

		$.getJSON(url, function(data) {
			var itens = [];

			$.each(data, function(i) {
				itens.push(
					"<tr> <td>" +
					this.placa +
					"</td><td>" +
					this.espc.modelo +
					"</td><td>" +
					this.espc.marca +
					"</td><td>" +
					this.espc.cor +
					"</td></tr>"
				);
			});

			$("#dadosCarro").append(itens);
		});
	});
});
