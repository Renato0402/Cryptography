
public class Fila {

	private No primeiro;
	private No ultimo;
	
	
	
	public Fila(){
		
		primeiro = null;
		ultimo = null;
		
	}
	

	public boolean vazio() {
		
		if(primeiro == null) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
	
	  
	public void enqueue(String bloco1) {
		
		No novo = new No(bloco1);
		
		if(primeiro == null) {
			
			primeiro = novo;
			ultimo = novo;
			
		} else {
			
			ultimo.setProximo(novo);
			
			ultimo = novo;
		}
		
	}
	

	
	
	public String dequeue() {
		
		No aux  = null;
		
		if(primeiro == null) {
			
			System.out.println("Fila vazia");
			
		} else {
			
			aux = primeiro;
			
			primeiro = primeiro.getProximo();
			
			aux.setProximo(null);
		}
		
		return aux.getBloco1();
	}

		
		
		
}

