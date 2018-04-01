package repository.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import repository.Model;
import transport.Arret;
import transport.BaseSection;
import transport.Place;
import transport.arret.Gare;
import transport.arret.GareFactory;
import transport.arret.Lieu;
import transport.cie.CieAerienne;
import transport.cie.CieTrain;
import transport.cie.CieTrainFactory;
import transport.itineraire.Croisiere;
import transport.itineraire.TrajetFactory;
import transport.moyen.Train;
import transport.place.Siege;
import transport.section.Affaire;
import transport.section.EcoPremium;
import transport.section.Economique;
import transport.section.Premiere;

public class TrainModel extends Model {

	public TrainModel() {
		arretFactory = GareFactory.getInstance();
		cieFactory = CieTrainFactory.getInstance();
		itineraireFactory = TrajetFactory.getInstance();
	}

	@Override
	protected void loadModel() {
		arrets.add(new Gare("MTL", new Lieu("Montreal", "Canada")));
		arrets.add(new Gare("GHI", new Lieu("Toronto", "Canada")));
		arrets.add(new Gare("EVL", new Lieu("Vancouver", "Canada")));

		compagnies.add(new CieTrain("TRNCAN", "Rails Canada"));
		compagnies.add(new CieAerienne("TRNABC", "Rails Abc"));
		compagnies.add(new CieAerienne("TRNXYZ", "Rails Def"));

		List<BaseSection> sections = new ArrayList<BaseSection>();

		sections.add(new Premiere(new ArrayList<Place>(), 350));
		sections.add(new Affaire(new ArrayList<Place>(), 300));
		sections.add(new EcoPremium(new ArrayList<Place>(), 250));
		sections.add(new Economique(new ArrayList<Place>(), 200));

		for (BaseSection section : sections) {
			for (int i = 0; i < 50; i++) {				
				section.places.add(new Siege(section));	
			}
		}
		
		Train train = new Train("MODEL_TCHOU", sections);

		List<Arret> gares = new ArrayList<Arret>();
		gares.add(arrets.get(0));
		gares.add(arrets.get(1));
		gares.add(arrets.get(2));

		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDepart = "20-08-2017 11:15:00";
		String strArrivee = "27-08-2017 15:15:00";
		Date depart = null, arrivee = null;
		try {
			depart = sdf.parse(strDepart);
			arrivee = sdf.parse(strArrivee);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		itineraires.add(new Croisiere("BF458", gares, train, compagnies.get(0), depart, arrivee));
		itineraires.add(new Croisiere("TR444", gares, train, compagnies.get(0), depart, arrivee));
		itineraires.add(new Croisiere("ES999", gares, train, compagnies.get(0), depart, arrivee));
	}
}
