package org.iae.annecy.st1.etape1.model.produit;

public class Produit {
	
	//private int ref;
	private double prix;
	private String desc, descLongue, ref, nom;
	
		
	public String getDescLongue() {
		return descLongue;
	}
	public void setDescLongue(String descLongue) {
		this.descLongue = descLongue;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public Produit(){
		
	}
	
	
	public Produit( String ref,double prix, String desc, String nom, String descL) {
		
		this.prix = prix;
		this.desc = desc;
		this.ref = ref;
		this.nom = nom;
		this.descLongue = descL;
	}
	public String affiche(){
		return "Reference : "+ this.getRef() + " - Nom : " + this.getNom() +  " - Prix : " + Double.toString(this.getPrix()) + " - Description : "+this.getDesc() + "\n Description longue : " + this.descLongue+ "\n\n";
	}
	
	
	
	

}
