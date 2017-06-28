function exibeNome(){
			var elementoNome = document.getElementById("txtnome");
			var nome = elementoNome.value;
			var elementoDisplay = document.getElementById("display");
			elementoDisplay.innerText = nome;

			
		}

		function novoContato() {
			var elementoContato = document.getElementById("listaContatos");
			var inputContato = document.createElement("input");
			inputContato.setAttribute("name","txtContato");
			var labelContato = document.createElement("label");
			var br = document.createElement("br");

			var btnExcluir = document.createElement("input");
			btnExcluir.setAttribute("type","button");
			btnExcluir.setAttribute("value","-");
			btnExcluir.onclick=function (){

				elementoContato.removeChild(divLinha);
			
			};

			labelContato.innerText="Contato: ";

			var divLinha = document.createElement("div");

			divLinha.appendChild(labelContato);
			divLinha.appendChild(inputContato);
			divLinha.appendChild(btnExcluir);
			divLinha.appendChild(br);

			elementoContato.appendChild(divLinha);
		}

		function imprimirDados(){

			var arrayInputsContatos = document.formContatos.txtContato;
			var saidaContatos = document.getElementById("saidaContatos");
			var saida = "";

			for (var i = 0; i < arrayInputsContatos.length; i++) {
				saida += arrayInputsContatos[i].value + "<br>";
			}

			saidaContatos.innerHTML = saida;
		}