package reservation;

import transport.Place;

public class Modification extends Changement {

	public Modification(Reservation reservation, Place place) {
		super(reservation);
		reservation.setPlace(place);
	}

	@Override
	public void calculerSolde() {
		// calculer solde en tenant compte des regles d'affaires et de la penalite		
		this.solde = 100.0;
	}

}
