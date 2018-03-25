package repository.model;

import repository.Model;
import transport.arret.GareFactory;
import transport.cie.CieTrainFactory;
import transport.itineraire.TrajetFactory;

public class TrainModel extends Model {

	public TrainModel() {
		arretFactory = GareFactory.getInstance();
		cieFactory = CieTrainFactory.getInstance();
		itineraireFactory = TrajetFactory.getInstance();
	}
}
