package inicio;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teste1 {
	
	public void listador() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Digite os nomes\n");
		try{
			String[] vect = sc.nextLine().split(" ");
			System.out.println("Qual item deseja apresentar?\n");
			int position = sc.nextInt();
			System.out.println(vect[position]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("Invalid position!");
		}catch(InputMismatchException e) {
			System.out.println("Input Error");
		}
		System.out.println("End of program");
		sc.close();
	}

}
