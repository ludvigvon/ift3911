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
import transport.arret.Lieu;
import transport.arret.Port;
import transport.arret.PortFactory;
import transport.cie.CieAerienne;
import transport.cie.CieCroisiere;
import transport.cie.CieCroisiereFactory;
import transport.itineraire.Croisiere;
import transport.itineraire.CroisiereFactory;
import transport.moyen.Paquebot;
import transport.place.Siege;
import transport.section.Deluxe;
import transport.section.Famille;
import transport.section.Interieur;
import transport.section.Ocean;
import transport.section.Suite;

public class CroisiereModel extends Model {

	public CroisiereModel() {
		arretFactory = PortFactory.getInstance();
		cieFactory = CieCroisiereFactory.getInstance();
		itineraireFactory = CroisiereFactory.getInstance();
	}

	@Override
	protected void loadModel() {
		arrets.add(new Port("MTL", new Lieu("Montreal", "Canada")));
		arrets.add(new Port("DEF", new Lieu("Toronto", "Canada")));
		arrets.add(new Port("TUV", new Lieu("Caire", "Egypte")));

		compagnies.add(new CieCroisiere("EAUCAN", "Eau Canada"));
		compagnies.add(new CieAerienne("EAUABC", "Eau Abc"));
		compagnies.add(new CieAerienne("EAUXYZ", "Eau Def"));

		List<BaseSection> sections = new ArrayList<BaseSection>();
		
		sections.add(new Interieur(new ArrayList<Place>(), 4));
		sections.add(new Famille(new ArrayList<Place>(), 2));
		sections.add(new Deluxe(new ArrayList<Place>(), 5));
		sections.add(new Ocean(new ArrayList<Place>(), 6));
		sections.add(new Suite(new ArrayList<Place>(), 6));
		
		for (BaseSection section : sections) {
			for (int i = 0; i < 6; i++) {				
				section.places.add(new Siege(section));	
			}
		}
		
		Paquebot paquebot = new Paquebot("MODEL_BATEAU", sections);
		
		List<Arret> ports = new ArrayList<Arret>();
		ports.add(arrets.get(0));    
		ports.add(arrets.get(1));
		ports.add(arrets.get(2));
		ports.add(arrets.get(0));
				
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDepart = "15-08-2017 10:05:00";
		String strArrivee = "15-09-2017 15:45:00";
		Date depart = null, arrivee = null;
		try {
			depart = sdf.parse(strDepart);
			arrivee = sdf.parse(strArrivee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		itineraires.add(new Croisiere("BF458", ports, paquebot, compagnies.get(0), depart, arrivee));
		itineraires.add(new Croisiere("TR444", ports, paquebot, compagnies.get(0), depart, arrivee));
		itineraires.add(new Croisiere("ES999", ports, paquebot, compagnies.get(0), depart, arrivee));
	}

}
