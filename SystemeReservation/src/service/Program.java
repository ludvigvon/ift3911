package service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import paiement.Client;
import transport.Arret;
import transport.arret.Aeroport;
import transport.arret.Lieu;
import transport.cie.CieAerienne;
import transport.itineraire.Vol;
import transport.moyen.Avion;

public class Program {

	private static SystemeReservation systemeReservation;

	public static void main(String[] args) {
		
		/***** ex des principaux cas d'utilsation de l'application *****/
		
		systemeReservation = new SystemeReservation();

		/*** volet admin ***/
		gererAeroports();
		System.out.println();
		
		gererCieAeriennes();
		System.out.println();
		
		gererVols();
		System.out.println();
		
		consulation();
		System.out.println();
		
		
		/*** volet client ***/
		verificationVolsDisponibles();		
		System.out.println();
		
		String noReservation = reservationSiege("AC481", "A");
		System.out.println();
		
		paiement(noReservation, new Client());
		System.out.println();
		
		changement(noReservation, "AC481", "E"); // on modifie la section
		System.out.println();
		
		annulation(noReservation);
		System.out.println();
	}

	private static void gererAeroports() {
		Aeroport aeroport = (Aeroport) systemeReservation.getAdminVols().createArret("XXX", new Lieu("ville", "pays"));
		System.out.printf("Cr�ation d'un nouvel a�roport: %s\n", aeroport.getId());
		
		systemeReservation.getAdminVols().modifyArret(aeroport.getId(), new Lieu("corection", "pays"));
		System.out.printf("Modification d'un a�roport: %s\n", aeroport.getId());
		
		systemeReservation.getAdminVols().deleteArret(aeroport.getId());
		System.out.println("Suppression d'un a�roport");
		
		systemeReservation.getAdminVols().undo();
		System.out.println("Annulation de la commande Suppression d'un a�roport");
	}

	private static void gererCieAeriennes() {
		CieAerienne cie = (CieAerienne) systemeReservation.getAdminVols().createCie("CIEAER", "cie bidon");
		System.out.printf("Cr�ation d'une nouvelle compagnie a�rienne: %s\n", cie.getId());
		
		systemeReservation.getAdminVols().modifyCie(cie.getId(), "CIEZZZ");
		System.out.printf("Modification d'une compagnie: %s\n", cie.getId());
		
		systemeReservation.getAdminVols().deleteCie(cie.getId());
		System.out.println("Suppression d'une compagnie");
		
		systemeReservation.getAdminVols().undo();
		System.out.println("Annulation de la commande Suppression d'une compagnie");
	}

	private static void gererVols() {
		List<Arret> aeroports = new ArrayList<Arret>();
		Aeroport a1 = (Aeroport) systemeReservation.getAdminVols().getArret("YUL");
		Aeroport a2 = (Aeroport) systemeReservation.getAdminVols().getArret("ABC");

		aeroports.add(a1);
		aeroports.add(a2);

		CieAerienne c = (CieAerienne) systemeReservation.getAdminVols().getCie("AIRCAN");

		Avion avion = (Avion) systemeReservation.getAdminVols().getMoyenTransport("AIRCAN", "MODEL_AVION");

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
		Vol vol = (Vol) systemeReservation.getAdminVols().createItineraire("VOL123", aeroports, avion, c, depart,
				arrivee);
		System.out.printf("Cr�ation d'un nouveau vol: %s\n", vol.getId());
		
		strArrivee = "15-04-2018 15:45:00";
		try {
			arrivee = sdf.parse(strArrivee);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		systemeReservation.getAdminVols().modifyItineraire(vol.getId(), vol.arrets, vol.transport, vol.cie, vol.depart,
				vol.arrivee);
		System.out.printf("Modification d'une compagnie: %s\n", vol.getId());
		
		systemeReservation.getAdminVols().deleteItineraire(vol.getId());
		System.out.println("Suppression d'un vol");
		
		systemeReservation.getAdminVols().undo();
		System.out.println("Annulation de la commande Suppression d'un vol");
	}

	private static void consulation() {
		System.out.println("Consultation en mode admin:");
		systemeReservation.getAdminVols().consulterItineraires("AIRCAN");
	}

	private static void verificationVolsDisponibles() {
		System.out.println("Verification des vols disponibles en mode client:");
		Aeroport origine = (Aeroport) systemeReservation.getAdminVols().getArret("YUL");
		Aeroport destination = (Aeroport) systemeReservation.getAdminVols().getArret("ABC");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String strDepart = "15-04-2017 00:00:00";
		Date depart = null;
		try {
			depart = sdf.parse(strDepart);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		systemeReservation.getClientVols().verifierDisponibilites(origine, destination, depart, "A");
	}

	private static String reservationSiege(String noItineraire, String sectionAbbrev) {
		System.out.println("R�servation d'un si�ge");
		return systemeReservation.getClientVols().reserver(noItineraire, sectionAbbrev);
	}

	private static void paiement(String noReservation, Client client) {
		System.out.println("Paiement d'une r�servation");
		systemeReservation.getClientVols().payer(noReservation, client);
	}

	private static void annulation(String noReservation) {
		System.out.println("Annulation d'une r�servation");
		systemeReservation.getClientVols().annuler(noReservation);

	}

	private static void changement(String noReservation, String noItineraire, String sectionAbbrev) {
		System.out.println("Modification d'une r�servation");
		systemeReservation.getClientVols().modifier(noReservation, noItineraire, sectionAbbrev);
	}
}
