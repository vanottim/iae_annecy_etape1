package org.iae.annecy.st1.etape1.model.produit;

import java.io.Serializable;
import java.util.ArrayList;

public class Produit implements Serializable {
	
	//private int ref;
	private double prix;
	private String desc, descLongue, ref, nom;
	private int qteCommandee=0;
	
	
	
	public int getQteCommandee() {
		return qteCommandee;
	}
	public void setQteCommandee(int qteCommandee) {
		this.qteCommandee = qteCommandee;
	}
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
		return "- Reference : "+ this.getRef() + " - Nom : " + this.getNom() +  " - Prix : " + Double.toString(this.getPrix()) + " € - Description : "+this.getDesc() + "\n- Description longue : " + this.descLongue+ "\n\n";
	}
	
	public String afficheAcQte(){
		return "- Reference : "+ this.getRef() + " - Nom : " + this.getNom() +  " - Prix : " + Double.toString(this.getPrix()) + " € - Quantitee commandée : " + this.getQteCommandee() + " - Prix par ligne produit : "+ this.getPrix()*this.getQteCommandee()+" € \n\n";
	}
	
	public String affiche2(){
		return "Reference : "+ this.getRef() + " - Nom : " + this.getNom() +  " \nACHETEURS : \n \n";
	}
	
	public String affiche3(){
		return "Reference : "+ this.getRef() + " - Nom : " + this.getNom() +  " - Prix : "+ this.getPrix()+"\n \n";
	}
	
	
	public double calculeMontant(){
		double mt = this.getPrix()*this.getQteCommandee();
		return mt;
	}
	

}
