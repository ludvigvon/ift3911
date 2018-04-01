package paiement;

import reservation.Reservation;

public class Paiement {

	Reservation reservation;
	Client client;
	String noConfirmation;
	
	public Paiement(Reservation reservation, Client client) {
		this.reservation = reservation;
		this.client = client;
		
		reservation.getPlace().goNextState(); // confirme
		
		Confirmation c = new Confirmation(this);
		this.noConfirmation = c.getId();
	}
	
	public String getNoConfirmation() {
		return noConfirmation;
	}
}
