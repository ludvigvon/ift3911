package transport.section;

import java.util.List;
import transport.place.Place;

public abstract class BaseSection {
	public List<Place> places;
	protected double pleinTarif;
	
	public BaseSection(List<Place> places, double pleinTarif) {
		this.places = places;
		this.pleinTarif = pleinTarif;
	}
	
	public double getPrix() {
		return this.pleinTarif * (double)(getPourcentagePleinTarif() / 100.0);
	}
	
	protected abstract int getPourcentagePleinTarif();
	
}
