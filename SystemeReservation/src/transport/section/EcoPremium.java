package transport.section;

import java.util.List;

import transport.place.Place;

public class EcoPremium extends Section {

	public EcoPremium(List<Place> places, double pleinTarif) {
		super(places, pleinTarif);
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 60;
	}

}
