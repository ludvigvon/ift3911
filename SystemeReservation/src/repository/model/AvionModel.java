package repository.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import repository.Model;
import transport.Arret;
import transport.BaseSection;
import transport.Itineraire;
import transport.Place;
import transport.arret.Aeroport;
import transport.arret.AeroportFactory;
import transport.arret.Lieu;
import transport.cie.CieAerienne;
import transport.cie.CieAerienneFactory;
import transport.itineraire.Vol;
import transport.itineraire.VolFactory;
import transport.moyen.Avion;
import transport.place.Siege;
import transport.section.Affaire;
import transport.section.EcoPremium;
import transport.section.Economique;
import transport.section.Premiere;

public class AvionModel extends Model {

	public AvionModel() {

		loadVols();

		arretFactory = AeroportFactory.getInstance();
		cieFactory = CieAerienneFactory.getInstance();
		itineraireFactory = VolFactory.getInstance();
	}
	
    private void loadVols() {
    	arrets.add(new Aeroport("YUL", new Lieu("Montreal", "Canada")));
		arrets.add(new Aeroport("ABC", new Lieu("Toronto", "Canada")));
		arrets.add(new Aeroport("XYZ", new Lieu("Caire", "Egypte")));

		compagnies.add(new CieAerienne("AIRCAN", "Air Canada"));
		compagnies.add(new CieAerienne("AIRABC", "Air Abc"));
		compagnies.add(new CieAerienne("AIRXYZ", "Air Def"));

		List<Place> sieges = new ArrayList<Place>();
		List<BaseSection> sections = new ArrayList<BaseSection>();

		sections.add(new Premiere(sieges, 350));
		sections.add(new Affaire(sieges, 300));
		sections.add(new EcoPremium(sieges, 250));
		sections.add(new Economique(sieges, 200));
		
		for (BaseSection section : sections) {
			for (int i = 0; i < 50; i++) {
				sieges.add(new Siege(section));	
			}
		}
		
		Avion avion = new Avion("MODEL1", sections);
		
		List<Arret> aeroports = new ArrayList<Arret>();
		aeroports.add(arrets.get(0));    
		aeroports.add(arrets.get(1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDepart = "31-08-2017 10:20:00";
		String strArrivee = "31-08-2017 15:25:00";
		Date depart = null, arrivee = null;
		try {
			depart = sdf.parse(strDepart);
			arrivee = sdf.parse(strArrivee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
				
		itineraires.add(new Vol("AC481", aeroports, avion, compagnies.get(0), depart, arrivee));
		itineraires.add(new Vol("DE555", aeroports, avion, compagnies.get(0), depart, arrivee));
		itineraires.add(new Vol("YZ333", aeroports, avion, compagnies.get(0), depart, arrivee));
    }
    

}
