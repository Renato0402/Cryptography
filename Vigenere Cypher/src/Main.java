
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		Cripto cripto = new Cripto();

		int tamanho;

		System.out.println("Digite um nome: ");

		String nome = teclado.nextLine();

		System.out.println("Voce deseja criptografar ou descriptografar " + nome);

		String escolha = teclado.next().toLowerCase();

		System.out.println("Digite  tamanho do bloco");

		tamanho = teclado.nextInt();

		if (escolha.equals("criptografar")) {

			System.out.println("Digite a chave de criptografia: ");

		}

		if (escolha.equals("descriptografar")) {

			System.out.println("Digite a chave de descriptografia: ");

		}

		String chave = teclado.next();

		cripto.pegaChave(chave);

		cripto.encriptografar(nome, escolha, chave, tamanho);

		cripto.exibir();

	}

}
