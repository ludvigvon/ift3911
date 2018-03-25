package repository;

import transport.arret.PortFactory;
import transport.cie.CieCroisiereFactory;
import transport.itineraire.CroisiereFactory;

public class CroisiereModel extends Model {

	public CroisiereModel() {
		arretFactory = PortFactory.getInstance();
		cieFactory = CieCroisiereFactory.getInstance();
		itineraireFactory = CroisiereFactory.getInstance();
	}

	

}
