
public class No {

    private String bloco1;
	private No proximo;
	
	
	public No(String bloco1) {
		
		
		this.bloco1 = bloco1;
		this.proximo = null;
	}
	
  



	public String getBloco1() {
		return bloco1;
	}



	public void setBloco1(String bloco1) {
		this.bloco1 = bloco1;
	}





	public No getProximo() {
		return proximo;
	}



	public void setProximo(No proximo) {
		this.proximo = proximo;
	}




	
}
