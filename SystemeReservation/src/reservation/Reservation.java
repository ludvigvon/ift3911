package reservation;

import java.util.Date;
import transport.Place;

public class Reservation {

	private String id;
	private Date dateHeureReservation;
	private Place place;

	public Reservation(Place place) {
		this.place = place;
		this.dateHeureReservation = new Date();
		this.id = generateNoReservation();
		
		place.goNextState(); // passe a l'etat Reserve
	}

	public String getId() {
		return id;
	}

	public Date getDateHeureReservation() {
		return dateHeureReservation;
	}

	public Place getPlace() {
		return place;
	}

	private String generateNoReservation() {
		return "noReservatioUnique";
	}

}
