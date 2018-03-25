package gestion;

import transport.Itineraire;

public interface ItineraireVisitor {
	public void visit(Itineraire itineraire);
}
