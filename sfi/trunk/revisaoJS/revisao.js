function exibeNome(){
	var elNome = document.getElementById('txtNome');
	var strNome = elNome.value;
	var elDisplay = document.getElementById("display");
	 
	elDisplay.innerText = strNome;


}

function novoItem(){
	
	var elListaItens = document.getElementById('itens');
	var labelLista = document.createElement("label");
	var inputItem = document.createElement("textArea");
	var br = document.createElement("br");
	var btnExcluir = document.createElement("input");
	var divLista = document.createElement("div");

	btnExcluir.setAttribute("type","button");
	btnExcluir.setAttribute("value", "-");

	btnExcluir.onclick=function(){
		elListaItens.removeChild(divLista);
	}

	labelLista.innerText="Item:";

	elListaItens.appendChild(divLista);

	divLista.appendChild(labelLista);
	divLista.appendChild(inputItem);
	divLista.appendChild(btnExcluir);
	divLista.appendChild(br);

}