package transport;

import java.util.List;

import transport.place.LibreState;

public abstract class BaseSection {
	protected String abbrev;
	public List<Place> places;
	protected double pleinTarif;
	
	public BaseSection(List<Place> places, double pleinTarif, String abbrev) {
		this.places = places;
		this.pleinTarif = pleinTarif;
	}
	
	public double getPrix() {
		return this.pleinTarif * (double)(getPourcentagePleinTarif() / 100.0);
	}
	
	public String getAbbrev() {
		return this.abbrev;
	}

	public int getNbPlacesTotales() {
		return places.size();
	}
	
	public long getNbPlacesDisponibles() {
		long count = places.stream().filter(p -> p.getState().getClass() == LibreState.class).count();
		return count;			
	}
	
	protected abstract int getPourcentagePleinTarif();
	
}
