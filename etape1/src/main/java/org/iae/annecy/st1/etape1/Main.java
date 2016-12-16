/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.produit.Annuaire;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Client;
import org.iae.annecy.st1.etape1.model.produit.Commande;
import org.iae.annecy.st1.etape1.model.produit.Element;
import org.iae.annecy.st1.etape1.model.produit.HistoriqueCommandes;
import org.iae.annecy.st1.etape1.model.produit.Menu;
import org.iae.annecy.st1.etape1.model.produit.Produit;
import org.iae.annecy.st1.etape1.view.UserTextFrenchView;
import org.iae.annecy.st1.etape1.view.produit.DisplayCatalogue;
import org.iae.annecy.st1.tools.ConsoleHelper;

/**
 * Classe permetant de tester le MVC.
 * 
 * @author Djer1013
 */
public class Main {

	/**
	 * COntroller pemetant le traitement des actions d'exemple.
	 */
	private static MainController mainController;

	static {
		Main.mainController = new MainController();
	}

	/**
	 * Lance l'application.
	 * 
	 * @param args
	 *            command line parameters
	 */
	public static void main(final String[] args) {
		
		
			Produit p1 = new Produit("1E",1000,"post-it jaune fluo","Post-it","Ce post-it offre au client une qualité de papier extraordinaire");
			Produit p2 = new Produit("2F",30,"classeur vert","classeur","Ce classeur est doté d'une broche incassable, il est entièrement recyclable");
			Produit p3 = new Produit("3X",40.23, "Stylo plume Mont-Blanc","Stylo","Cet instrument d'écriture offre à son utilisateur un glissé magique sur la feuille");
			Produit p4 = new Produit("4D",78, "Bague Triniti Cartier","Bague","Bague aux trois anneaux qui se chevauchent");
			
			Client cl1 = new Client("1A","Vanotti","Marion",10);
			Client cl2 = new Client("2B","Meynet","Pauline",25);
			Client cl3 = new Client("3D","Pelloux","Anna",50);
			
			HistoriqueCommandes h1 = new HistoriqueCommandes();
			HistoriqueCommandes h2 = new HistoriqueCommandes();
			HistoriqueCommandes h3 = new HistoriqueCommandes();
			
			
			Annuaire a1 = new Annuaire();
			Catalogue c1 = new Catalogue();
			
			Commande co1 = new Commande();
			Commande co2 = new Commande();
			Commande co3 = new Commande();
			
			co3.setEtat("Envoyee");

	
		//Désérialisation du catalogue de produits
			try{
				FileInputStream fout = new FileInputStream("catalogue.txt");
				ObjectInputStream o = new ObjectInputStream(fout);
				
				c1 = (Catalogue) o.readObject();
			
				
				o.close();
				fout.close();
			
			}catch(FileNotFoundException e){
				
				
				c1.ajouterProduit(p1);
				c1.ajouterProduit(p2);
				c1.ajouterProduit(p3);
				c1.ajouterProduit(p4);
				
				
								
				co1.ajouterProduit(p1,2);
				co1.ajouterProduit(p2,1);
				co3.ajouterProduit(p3,4);
				co3.ajouterProduit(p4,5);
				co2.ajouterProduit(p1,3);
				co2.ajouterProduit(p2,2);	
				
			}catch(IOException e){
				ConsoleHelper.display(e.getMessage());
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			
	//désérialisation de l'annuaire de clients		
			try{
				
				FileInputStream fout2 = new FileInputStream("annuaire.txt");
				
				ObjectInputStream o2 = new ObjectInputStream(fout2);
				
				a1 = (Annuaire) o2.readObject();
				o2.close();
				
				
				fout2.close();
			}catch(FileNotFoundException e){
				
		
				a1.ajouterClient(cl1);
				a1.ajouterClient(cl2);
				a1.ajouterClient(cl3);
				
				/*cl1.setHistoriqueCommandes(h1);
				cl2.setHistoriqueCommandes(h2);
				cl3.setHistoriqueCommandes(h3);*/
				
				cl2.setCommande(co2);
				cl1.setCommande(co1);
				cl3.setCommande(co3);	
				
			}catch(IOException e){
				(new Element(e.getMessage())).initElement();
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} 
			
			Menu m = new Menu(c1,a1);			
			m.choixAction();
			
	

	}

}
