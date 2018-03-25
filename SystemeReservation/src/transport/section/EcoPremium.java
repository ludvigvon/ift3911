package transport.section;

import java.util.List;

import transport.Place;
import transport.Section;

public class EcoPremium extends Section {

	public EcoPremium(List<Place> places, double pleinTarif) {
		super(places, pleinTarif, "P");
	}

	@Override
	protected int getPourcentagePleinTarif() {
		return 60;
	}

}
