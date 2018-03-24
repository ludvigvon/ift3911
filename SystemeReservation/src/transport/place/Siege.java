package transport.place;

import transport.section.BaseSection;

public class Siege extends Place {
	public String rangee, colonne;
	
	public Siege(BaseSection section) {
		super(section);
		generateRangeeColonne();
	}
	
	private void generateRangeeColonne() 
	{
		// TODO algo permettant de generer rangee et col selon la section
		this.rangee = "";
		this.colonne = "";
	}
}
