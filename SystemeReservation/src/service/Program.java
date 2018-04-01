package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import transport.Arret;
import transport.arret.Aeroport;
import transport.arret.Lieu;
import transport.cie.CieAerienne;
import transport.itineraire.Vol;
import transport.moyen.Avion;

public class Program {

	private static SystemeReservation systemeReservation;
	
	public static void main(String[] args) {
		systemeReservation = new SystemeReservation();		
		
		// Volet admin
		gererAeroports();
		gererCieAeriennes();
		gererVols();
		consulation();
		
		// volet client
		verificationVolsDisponibles();
		reservationSiege();
		paiementSiege();
		consulation();
		changement();
	}

	private static void gererAeroports() {		
		Aeroport aeroport = (Aeroport)systemeReservation.getAdminVols().createArret("XXX", new Lieu("ville", "pays"));
		systemeReservation.getAdminVols().modifyArret(aeroport.getId(), new Lieu("corection", "pays"));
		systemeReservation.getAdminVols().deleteArret(aeroport.getId());
		systemeReservation.getAdminVols().undo();
	}
	
	private static void gererCieAeriennes() {
		CieAerienne cie = (CieAerienne)systemeReservation.getAdminVols().createCie("CIEAER", "cie bidon");
		systemeReservation.getAdminVols().modifyCie(cie.getId(), "CIEZZZ");
		systemeReservation.getAdminVols().deleteCie(cie.getId());
		systemeReservation.getAdminVols().undo();
	}

	private static void gererVols() {
		List<Arret> aeroports = new ArrayList<Arret>();
		Aeroport a1 = (Aeroport)systemeReservation.getAdminVols().getArret("YUL");
		Aeroport a2 = (Aeroport)systemeReservation.getAdminVols().getArret("ABC");
		
		aeroports.add(a1); aeroports.add(a2); 
		
		CieAerienne c = (CieAerienne)systemeReservation.getAdminVols().getCie("AIRCAN");
		
		Avion avion = (Avion)systemeReservation.getAdminVols().getMoyenTransport("AIRCAN", "MODEL_AVION");
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDepart = "15-04-2018 10:20:00";
		String strArrivee = "15-04-2018 15:25:00";
		Date depart = null, arrivee = null;
		try {
			depart = sdf.parse(strDepart);
			arrivee = sdf.parse(strArrivee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// corriger heure arrivee
		Vol vol = (Vol)systemeReservation.getAdminVols().createItineraire("VOL123", aeroports, avion, c, depart, arrivee);		
		strArrivee = "15-04-2018 15:45:00";
		try {			
			arrivee = sdf.parse(strArrivee);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		systemeReservation.getAdminVols().modifyItineraire(vol.getId(), vol.arrets, vol.transport, vol.cie, vol.depart, vol.arrivee);
		
		systemeReservation.getAdminVols().deleteItineraire(vol.getId());
		systemeReservation.getAdminVols().undo();
	}
	
	private static void consulation() {
		systemeReservation.getAdminVols().consulterItineraires("AIRCAN");		
	}

	private static void verificationVolsDisponibles() {
		Aeroport origine = (Aeroport)systemeReservation.getAdminVols().getArret("YUL");
		Aeroport destination = (Aeroport)systemeReservation.getAdminVols().getArret("ABC");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDepart = "15-04-2018 10:20:00";		
		Date depart = null, arrivee = null;
		try {
			depart = sdf.parse(strDepart);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		systemeReservation.getClientVols().verifierDisponibilites(origine, destination, depart, "A");	
	}

	private static void reservationSiege() {
		// on suppose que le client aura choisi un siege parmi les sièges affichés par l'operation verifierDisponibilites()
		
	}
	
	private static void paiementSiege() {
				
	}
	
	private static void changement() {
				
	}

	
	


	



	

}
