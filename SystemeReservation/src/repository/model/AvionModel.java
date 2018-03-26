package repository.model;

import java.util.ArrayList;

import repository.Model;
import transport.Arret;
import transport.arret.Aeroport;
import transport.arret.AeroportFactory;
import transport.cie.CieAerienneFactory;
import transport.itineraire.VolFactory;

public class AvionModel extends Model {

	public AvionModel() {
		
		arrets.add(new Aeroport(new Lieu()));

	arretFactory=AeroportFactory.getInstance();cieFactory=CieAerienneFactory.getInstance();itineraireFactory=VolFactory.getInstance();
}

}
