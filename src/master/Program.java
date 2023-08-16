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

import model.excecoes.Reservation1;

public class Program {

	public static void main(String[] args) throws ParseException {
		// Teste1 tst = new Teste1();
		// tst.listador();
		/*
		 * Implementação da solução muito ruim Implement 01
		 */

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.println("Room number");
		int number = sc.nextInt();
		System.out.println("Check-in date (dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check-out date (dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		} else {
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
			
			String error = reservation.updateDates(checkIn, checkOut);
			if (error != null) {
				System.out.println("Error in reservation: " + error);
			}else {
				System.out.println("Reservation: " + reservation);
			}
			
		} // fim de if/else
		sc.close();
	}// fim de main

}// fim da classe