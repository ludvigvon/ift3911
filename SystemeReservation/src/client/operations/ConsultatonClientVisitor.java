package client.operations;

import java.util.Optional;

import gestion.ItineraireVisitor;
import transport.BaseSection;
import transport.Itineraire;

public class ConsultatonClientVisitor implements ItineraireVisitor {

	private String sectionAbbrev;
	
	public ConsultatonClientVisitor(String sectionAbbrev) {
		this.sectionAbbrev = sectionAbbrev;
	}
	
	
	
	/*
	 * YUL-YYZ:[AIRCAN]AC481(2014.11.28:06.00-2014.11.28:07:24)|237.00|E50 (exemple pour les vols d'avion). 
	 * Cette donnée représente le vol AC481 par AIRCAN partant de YUL le 28/11/2014 à 6h arrivant à YYZ le même jour 
	 * à 7h24 ayant 50 sièges disponibles en classe Économie au prix de 237$.
	 * 
	 */
	@Override
	public void visit(Itineraire itineraire) {

		String infoSection = null;

		Optional<BaseSection> section = itineraire.transport.sections.stream()
				.filter(p -> p.getAbbrev() == this.sectionAbbrev).findFirst();

		if (section.isPresent()) {
			BaseSection s = section.get();
			infoSection = String.format("%s(%s/%s)%s|", s.getAbbrev(), s.getNbPlacesDisponibles(),
					s.getNbPlacesTotales(), s.getPrix());
		}

		String line = String.format("%s - %s:[%s]%s(%s - %s)|%s", 
				itineraire.arrets.get(0).getId(),
				itineraire.arrets.get(itineraire.arrets.size() - 1).getId(),
				itineraire.cie.getId(),
				itineraire.getId(),
				itineraire.depart.toString(), 
				itineraire.arrivee.toString(), 
				infoSection);

		System.out.println(line);

	}

}
