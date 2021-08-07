
public class Cripto {

    private String c2;
    
    private Fila fila;
    private Fila fila2; 
	
	private int posicoes[];
	private String bloco;
	
	
	private char[]alfabeto = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
	private char[]alfabeto2 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
	
	
	public Cripto() {
		
		 fila = new Fila();
		 fila2 = new Fila();
	
	}
	
	 public void pegaChave(String chave) {
			
		  posicoes = new int [chave.length()];
		  
		  
		  for(int i = 0; i < chave.length();i++) {
			  
			  for(int a = 0; a < alfabeto.length;a++) {
				  
				  if(chave.charAt(i) == alfabeto[a] || chave.charAt(i) == alfabeto2[a]) {
					  
					  posicoes[i] = a ;
				  }
				  
			  }
		  }
		
	}
	 
	 
	 public void encriptografar(String nome,String escolha,String chave,int tamanho) {

			int indice = 0;
			int aux = tamanho;
			  
			while(indice < nome.length()) {
				
				
				bloco = nome.substring(indice,Math.min(aux,nome.length()));
				
			
			
				
				fila.enqueue(bloco);
				
				indice += tamanho;
				aux+=tamanho;
				

			}
			
		
			
			
			while(!fila.vazio()) {
			
		
				fila2.enqueue(encriptografarR(fila.dequeue(), escolha, chave, tamanho));
				
				
				
			}
			
			
		}
	 
	 public String encriptografarR(String bloco,String escolha,String chave,int tamanho) {
			
			int pos = 0;

			int aux = 0;
			

		  
		    
		     c2 = "";


			for(int i  = 0; i < bloco.length();i++) {



				for(int a = 0; a < alfabeto.length;a++) {



					if(bloco.charAt(i) == alfabeto[a] || bloco.charAt(i) == alfabeto2[a]) {
						
						


						if(escolha.equals("criptografar")) {



							pos = a + posicoes[aux] ;

							aux++;

							if(aux == chave.length()) {

								
								
								aux = 0;
							}

							while(pos > 25) {

								pos = pos - alfabeto.length;
							}

						}

						if(escolha.equals("descriptografar")) {



							pos = a - posicoes[aux] ;

							aux ++;

							if(aux == chave.length()) {

								aux = 0;
							}

							while(pos < 0) {

								pos = alfabeto.length + pos;
							}

						}

						if(bloco.charAt(i) == alfabeto[a]) {

						     c2 += alfabeto[pos];



						} else {

							c2 += alfabeto2[pos];


						}
						

					
					

					}
				}




				if(bloco.charAt(i) < 'A' || bloco.charAt(i) > 'Z') {

					if(bloco.charAt(i) < 'a' || bloco.charAt(i) > 'z') {


						c2 += bloco.charAt(i);

	                     aux++;
	                     

							if(aux == chave.length()) {

								aux = 0;
							}
						
					}

				}
				
				
				
				
				

			}
			
			return c2;
			
		
		

		}
	 
		
		public void exibir() {
			
			
			
			while(!fila2.vazio()) {
				
				System.out.print(fila2.dequeue());
				
				
				
			}
			
		
			
			
		}

			
}
