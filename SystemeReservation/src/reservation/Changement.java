package reservation;

public abstract class Changement {
	protected Reservation reservation;
	protected double penalite;
	protected double solde;
	
	public Changement(Reservation reservation) {
		this.reservation = reservation;
	}
	
	public abstract void calculerSolde();
	
	public double getSolde() {
		return this.solde;
	}
	

}
