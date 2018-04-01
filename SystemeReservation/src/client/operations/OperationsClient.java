package client.operations;

import java.util.Date;
import java.util.List;
import paiement.Client;
import repository.Model;
import repository.Observer;
import reservation.Annulation;
import reservation.Modification;
import transport.Arret;
import transport.Itineraire;

public class OperationsClient implements Observer {

	private Model model;
	
	public OperationsClient(Model model) {
		this.model = model;
	}

	public void verifierDisponibilites(Arret origine, Arret destination, Date depart, String section) {
		List<Itineraire> itineraires = model.getItineraires(origine, destination, depart);
		for (Itineraire i : itineraires) {
			i.accept(new ConsultatonClientVisitor(section));
		}	
	}
	
	public String reserver(String noItineraire, String sectionAbbrev) {
		return model.createReservation(noItineraire, sectionAbbrev).getId();			
	}
	
	public String payer(String noReservation, Client client) {
		return model.payerReservation(noReservation, client);
	}
	
	public Annulation annuler(String noReservation) {
		
	}
	
	public Modification modifier(String noItineraire, String sectionAbbrev) {
		
	}
	
	@Override
	public void update() {
		// TODO modele a ete modifie, faire les modifs necessaires pour synchroniser vue
	}

}
