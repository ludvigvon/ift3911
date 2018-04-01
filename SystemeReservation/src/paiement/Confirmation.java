package paiement;

public class Confirmation {

	String id;
	Paiement paiement;

	public Confirmation(Paiement paiement) {
		this.paiement = paiement;
		generateNoConfirmation();
	}

	private void generateNoConfirmation() {
		this.id = "noConfirmationBidon";		
	}

	public String getId() {
		return id;
	}
	
	
}
