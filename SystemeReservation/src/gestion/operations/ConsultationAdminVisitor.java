package gestion.operations;

import gestion.ItineraireVisitor;
import transport.BaseSection;
import transport.Itineraire;

public class ConsultationAdminVisitor implements ItineraireVisitor {
	
	@Override
	public void visit(Itineraire itineraire) {
		
		String infoSections = "";
		for (BaseSection s : itineraire.transport.sections) {
			infoSections += String.format("%s(%s/%s)%s|", s.getAbbrev(), s.getNbPlacesDisponibles(), s.getNbPlacesTotales(), s.getPrix());
		}
		
		String line = String.format("%s - %s:[%s](%s - %s)|%s", 
				itineraire.arrets.get(0).getId(), 
				itineraire.arrets.get(itineraire.arrets.size()-1).getId(),
				itineraire.getId(),
				itineraire.depart.toString(), itineraire.arrivee.toString(),
				infoSections);
				
		System.out.println(line);

	}

}
