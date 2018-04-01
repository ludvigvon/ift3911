package client.operations;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import repository.Model;
import repository.Observer;
import reservation.Reservation;
import transport.Arret;
import transport.Itineraire;
import transport.Place;

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
	
	public String reserverPlace(String noItineraire, String sectionAbbrev) {
		Optional<Itineraire> itineraire = model.getItineraire(noItineraire);
		
		if (itineraire.isPresent()) {
			Reservation r = new Reservation(itineraire.get().getPlace(sectionAbbrev));
			return r.getId();		
		} 			
		
		return null;	
	}
	
	@Override
	public void update() {
		// TODO shared model has been modified. make necessary changes to synchronize view. 
	}

}
