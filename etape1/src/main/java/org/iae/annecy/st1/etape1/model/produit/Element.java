package org.iae.annecy.st1.etape1.model.produit;

public class Element {
	
	// attributs
		private String nom;
		
		// getters et setters
		public String getNom() {
			return nom;
		}
		public void setNom(String nom) {
			this.nom = nom;
		}
		
		// constructeur
		public Element(String nom) {
			this.nom = nom;
		}
		
		//affichage
		public void affichage(String monAffichage){
			System.out.println(monAffichage);
		}
		
		// init
		public void initElement(){
			this.affichage(this.getNom());
		}

}
