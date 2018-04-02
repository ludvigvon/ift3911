package admin.operations;

import gestion.ItineraireVisitor;
import transport.BaseSection;
import transport.Itineraire;

public class ConsultationAdminVisitor implements ItineraireVisitor {
	
	
	/*
	 * YUL-YYZ:[AIRCAN]AC481(2014.11.28:06.00-2014.11.28:07:24)|PS(0/12)474.00|AM(5/16)355.50|EL(150/200)237.00 
	 * vol AC481 par AIRCAN partant de YUL le 28/11/2014 � 6h arrivant � YYZ le m�me jour � 7h24 ayant une classe Premi�re �troite avec 0 si�ges r�serv�s sur 12 chacun co�tant 474$, 
	 * une classe Affaire moyenne avec 5 si�ges r�serv�s sur 16 chacun co�tant 355.50$ et une classe �conomie large avec 150 si�ges r�serv�s sur 200 chacun co�tant 237$.
	 *  
	 */
	@Override
	public void visit(Itineraire itineraire) {
		String infoSections = "";

		for (BaseSection s : itineraire.transport.sections) {
			infoSections += String.format("%s(%s/%s)%s|", s.getAbbrev(), s.getNbPlacesDisponibles(), s.getNbPlacesTotales(), s.getPrix());
		}
		
		
		String line = String.format("%s-%s:[%s]%s(%s-%s)|%s", 
				itineraire.arrets.get(0).getId(), 
				itineraire.arrets.get(itineraire.arrets.size()-1).getId(),
				itineraire.cie.getId(),
				itineraire.getId(),
				itineraire.depart.toString(), 
				itineraire.arrivee.toString(),
				infoSections);

		System.out.println(line);
	}

}
