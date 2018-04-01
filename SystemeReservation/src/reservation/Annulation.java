package reservation;

public class Annulation extends Changement {

	public Annulation(Reservation reservation) {
		super(reservation);
		reservation.setPlace(null);
	}

	@Override
	public void calculerSolde() {
		// calculer solde en tenant compte des regles d'affaires et de la penalite		
		this.solde = 500.0;		
	}

}
