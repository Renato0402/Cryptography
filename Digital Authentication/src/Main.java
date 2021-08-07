import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) throws IOException  {

		BufferedReader br = new BufferedReader(new FileReader("src/Renard_-_Because_Maybe_pt._2_Blue_Dragon_Marathon.txt")); 
		Scanner teclado = new Scanner(System.in);

		Hash hash = new Hash();
		ArvoreAVL a = new ArvoreAVL();


		int escolha;

		do {

			System.out.println("\n1.Gerar codigo de autenticação");
			System.out.println("2.Verificação de autenticidade");

			escolha = teclado.nextInt();

			if(escolha == 1) {

				while(br.ready()){ 

					String linha = br.readLine(); 
					a.adicionar(linha);

				} 


				System.out.print("Codigo de autenticação:");

				System.out.print(a.hash());

			}

			if(escolha == 2) {

				System.out.println("Digite um codigo para verificar a autenticidade:");

				String codigo = teclado.next();

				while(br.ready()){ 

					String linha = br.readLine(); 
					a.adicionar(linha);
					
				} 

			

				if(codigo.equals(a.hash())) {

					System.out.println("\nO documento é autentico!");

				} else {

					System.out.println("\nO documento não é autentico");
				}
			}





		}while(escolha<3 && escolha > 0);

	}


}