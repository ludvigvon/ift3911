package paiement;

import reservation.Reservation;

public class Paiement {

	Reservation reservation;
	Client client;
	String noConfirmation;
	
	public Paiement(Reservation reservation) {
		this.reservation = reservation;
		reservation.getPlace().goNextState(); // confirme
		
		Confirmation c = new Confirmation(this);
		this.noConfirmation = c.getId();
	}
	
	public String getNoConfirmation() {
		return noConfirmation;
	}
}
