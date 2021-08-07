
public class No {

	private String nome;
	private No esquerdo;
	private No direito;
	private int altura;
	private No pai;
	private Hash shai = new Hash();
	
	public No(String nome) {
		
		this.nome = nome;
		esquerdo = null;
		direito = null;
		altura = 1;
		pai = null;
	
	}
	
	

	public No getPai() {
		return pai;
	}



	public void setPai(No pai) {
		this.pai = pai;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public No getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(No esquerdo) {
		this.esquerdo = esquerdo;
	}

	public No getDireito() {
		return direito;
	}

	public void setDireito(No direito) {
		this.direito = direito;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}



	public Hash getShai() {
		return shai;
	}



	public void setShai(Hash shai) {
		this.shai = shai;
	}
	
	
	
}
