
public class ArvoreAVL {

	private No raiz;


	public ArvoreAVL() {


		raiz = null;
	}

	public No adicionar(No n,String nome) {

		No novo = new No(nome);

		if(nome.compareTo(n.getNome()) == 0) {

			return n;

		} else if(nome.compareTo(n.getNome()) > 0) {

			if(n.getDireito() == null) {

				n.setDireito(novo);
				n.getDireito().setPai(n);

			} else {

				n.setDireito(adicionar(n.getDireito(), nome));
				n.getDireito().setPai(n);

			}

		} else if(nome.compareTo(n.getNome()) < 0) {

			if(n.getEsquerdo() == null) {

				n.setEsquerdo(novo);
				n.getEsquerdo().setPai(n);

			} else {

				n.setEsquerdo(adicionar(n.getEsquerdo(), nome));
				n.getEsquerdo().setPai(n);
			}

		}


		n.setAltura(ValorMax(altura(n.getDireito()),altura(n.getEsquerdo()))+ 1);


		if(FB(n) > 1) {

			if(FB(n.getEsquerdo()) > 0) {

				return rodaDireita(n);


			} else {

				n.setEsquerdo(rodaEsquerda(n.getEsquerdo()));
				return rodaDireita(n);
			}
		}

		if(FB(n) < -1) {

			if(FB(n.getDireito()) < 0) {

				return rodaEsquerda(n);

			} else {

				n.setDireito(rodaDireita(n.getDireito()));
				return rodaEsquerda(n);
			}
		}


		return n;
	}

	public void adicionar(String nome) {

		No novo = new No(nome);

		if(raiz == null) {

			raiz = novo;

		} else {

			raiz = adicionar(raiz,nome);
		}
	}

	public int ValorMax(int x,int y) {

		if(x > y) {

			return x;

		} else {

			return y;
		}
	}

	public No rodaDireita(No n) {

		No aux1 = n.getEsquerdo();
		No aux2 = aux1.getDireito();

		aux1.setDireito(n);
		n.setEsquerdo(aux2);

		n.setPai(aux1);

		if(aux2!= null)
			aux2.setPai(n);

		aux1.setPai(null);

		n.setAltura(ValorMax(altura(n.getEsquerdo()),altura(n.getDireito()))+ 1);
		aux1.setAltura(ValorMax(altura(aux1.getEsquerdo()),altura(aux1.getDireito()))+ 1);

		return aux1;

	}


	public No rodaEsquerda(No n) {

		No aux1 = n.getDireito();
		No aux2 = aux1.getEsquerdo();

		aux1.setEsquerdo(n);
		n.setDireito(aux2);

		n.setPai(aux1);

		if(aux2!= null)
			aux2.setPai(n);

		aux1.setPai(null);


		n.setAltura(ValorMax(altura(n.getEsquerdo()),altura(n.getDireito()))+ 1);
		aux1.setAltura(ValorMax(altura(aux1.getEsquerdo()),altura(aux1.getDireito()))+ 1);

		return aux1;
	}

	public int altura(No n) {

		if(n == null) {

			return 0;

		} else {

			return n.getAltura();
		}
	}

	public int FB(No n) {

		if(n == null) {

			return 0;

		} else {

			return altura(n.getEsquerdo()) - altura(n.getDireito());
		}

	}


	public String hash(No n) {

		String hash1 = "";
		String hash2 = "";


		if(n.getEsquerdo() != null) {

			hash1 = hash(n.getEsquerdo());
		}
		if(n.getDireito() != null) {

			hash2 = hash(n.getDireito());

		}

		if(n.getEsquerdo() == null && n.getDireito() == null) {

			return n.getShai().hashing(n.getNome());

		} else {

			return n.getShai().hashing(hash1 + hash2);

		}
	}

	public String hash() {

		if(raiz != null) {

			return hash(raiz);

		} else {
			
			return "Documento em branco";
		}
	}

	public No getRaiz() {
		return raiz;
	}

	public void setRaiz(No raiz) {
		this.raiz = raiz;
	}


}
