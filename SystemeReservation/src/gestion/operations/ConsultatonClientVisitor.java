package gestion.operations;

import java.util.Optional;

import gestion.ItineraireVisitor;
import transport.BaseSection;
import transport.Itineraire;

public class ConsultatonClientVisitor implements ItineraireVisitor {

	private String sectionAbbrev;
	
	public ConsultatonClientVisitor(String sectionAbbrev) {
		this.sectionAbbrev = sectionAbbrev;
	}
	
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

		String line = String.format("%s - %s:[%s](%s - %s)|%s", itineraire.arrets.get(0).getId(),
				itineraire.arrets.get(itineraire.arrets.size() - 1).getId(), itineraire.getId(),
				itineraire.depart.toString(), itineraire.arrivee.toString(), infoSection);

		System.out.println(line);

	}

}
