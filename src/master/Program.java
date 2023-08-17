package master;

/*
 * Fahen Oliver
 * 15/08/2023
 * Caruaru - PE | Brasil
 * Estudo de programação Java
 * Exceções em Java
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.excecoes.DomainException;
import model.excecoes.Reservation1;

public class Program {

	public static void main(String[] args) {
		// Teste1 tst = new Teste1();
		// tst.listador();
		/*
		 * Implementação da solução muito ruim Implement 01
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			System.out.println("Room number");
			int number = sc.nextInt();
			System.out.println("Check-in date (dd/MM/yyyy): ");
			Date checkIn = sdf.parse(sc.next());
			System.out.println("Check-out date (dd/MM/yyyy): ");
			Date checkOut = sdf.parse(sc.next());

			Reservation1 reservation = new Reservation1(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);

			// atualização das datas
			/*
			 * Essa é uma solução ruim, apenas para aprendizado
			 */
			System.out.println("\n\nEnter data to update the reservation: ");
			System.out.println("Enter the updated check-in date (dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("Enter the updated check-out date (dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());

			reservation.updateDates(checkIn, checkOut);

			System.out.println("Reservation: " + reservation);
		} catch (ParseException e) {
			System.out.println("Invalid date format\n" + e);
		}catch (DomainException e) {
			System.out.println("Error in reservation: " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("Unexpected Error!\n" + e.getMessage());
		}
		//fim da tratativa de erros
		sc.close();
	}// fim de main

}// fim da classe