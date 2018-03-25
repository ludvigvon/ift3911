package transport.moyen;

import java.util.List;

import transport.BaseSection;
import transport.MoyenTransport;

public class Avion extends MoyenTransport {

	public Avion(String modele, List<BaseSection> sections) {
		super(modele, sections);
	}

}
