package org.iae.annecy.st1.etape1.controller;

import org.iae.annecy.st1.etape1.model.produit.Catalogue;

public class CatalogueController {
	
	private Catalogue cat;
	
	public Catalogue getCat() {
		return cat;
	}

	public void setCat(Catalogue cat) {
		this.cat = cat;
	}

	public String get(){
		return this.getCat().affiche();
	}

}
