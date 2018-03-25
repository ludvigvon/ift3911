package repository.model;

import repository.Model;
import transport.arret.AeroportFactory;
import transport.cie.CieAerienneFactory;
import transport.itineraire.VolFactory;

public class AvionModel extends Model {

	public AvionModel() {
		arretFactory = AeroportFactory.getInstance();
		cieFactory = CieAerienneFactory.getInstance();
		itineraireFactory = VolFactory.getInstance();
	}

}
