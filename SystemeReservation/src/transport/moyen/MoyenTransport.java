package transport.moyen;

import java.util.List;
import transport.section.BaseSection;

public abstract class MoyenTransport {
	public String modele;
	public List<BaseSection> sections;
	
	public MoyenTransport(String modele, List<BaseSection> sections) {
		this.modele = modele;
		this.sections = sections;
	}
	
}
