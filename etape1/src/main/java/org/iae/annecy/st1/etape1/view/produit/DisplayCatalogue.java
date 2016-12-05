package org.iae.annecy.st1.etape1.view.produit;

import org.iae.annecy.st1.etape1.model.produit.Catalogue;

public class DisplayCatalogue {
	
	public String build(Catalogue c){
		return "mon catalogue :"+ c.getProduits();
		
	}

}
