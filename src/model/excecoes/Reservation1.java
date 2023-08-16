package model.excecoes;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation1 {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	public Reservation1() {
	}

	public Reservation1(Integer roomNumber, Date checkIn, Date checkOut) {
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	/*
	 * fim dos construtores
	 * 
	 */

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	/*
	 * fim dos getters and setters
	 * 
	 */

	// métodos elaborados
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}// fim de long duration

	public String updateDates(Date checkIn, Date checkOut) {

		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Error in reservation: Reservation dates for update must be future dates";
		}
		if (!checkOut.after(checkIn)) {
			return "Error in reservation: Check-out date must be after check-in date";
		}
		/*
		 * else { reservation.updateDates(checkIn, checkOut);
		 * System.out.println("Reservation: " + reservation); }//fim de if/else
		 */
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		return null;
	}

	@Override
	public String toString() {
		return "Room: " + roomNumber + ", checkIn: " + sdf.format(checkIn) + ", checkOut: " + sdf.format(checkOut)
				+ ", " + duration() + " nights";
	}// fim de toString

}// fim da classe