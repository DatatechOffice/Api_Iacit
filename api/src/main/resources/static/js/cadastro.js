const BuscarRegiao = async searchText => {
	const resReg = await fetch('../data/cadastro.json');
	const RegiaoJson = await resReg.json();
}