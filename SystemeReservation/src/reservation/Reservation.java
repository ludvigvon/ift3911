package reservation;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import paiement.Paiement;
import transport.Place;

public class Reservation {

	private String id;
	private Date dateHeureReservation;
	private Place place;
	public List<Changement> changements = new ArrayList<Changement>();
	public Paiement paiement;
	
	public Reservation(Place place) {
		this.place = place;
		this.dateHeureReservation = new Date();
		this.id = generateNoReservation();
		
		place.reservation = this;
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
	
	public void setPlace(Place place) {
		this.place = place;
	}
	
	public Changement modifier(Place place) {
		Changement c = new Modification(this, place);
		changements.add(c);
		return c;
	}
	
	public Changement annuler() {
		Changement c = new Annulation(this);
		changements.add(c);
		return c;
	}
	
	private String generateNoReservation() {
		return "noReservatioUnique";
	}

}
