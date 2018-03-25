package gestion.operations;



import gestion.ItineraireVisitor;
import transport.Itineraire;

public class ConsultationAdminVisitor implements ItineraireVisitor {
	
	@Override
	public void visit(Itineraire itineraire) {
		String line = String.format("%s - %s:[%s]", 
				itineraire.arrets.get(0).getId(), 
				itineraire.arrets.get(itineraire.arrets.size()-1).getId());
		
		System.out.println(line);

	}

}
