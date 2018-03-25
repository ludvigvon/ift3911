package transport.moyen;

import java.util.List;

import transport.BaseSection;
import transport.MoyenTransport;

public class Paquebot extends MoyenTransport {

	public Paquebot(String modele, List<BaseSection> sections) {
		super(modele, sections);
	}

}
