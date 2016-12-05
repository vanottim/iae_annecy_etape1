/**
 * 
 */

package org.iae.annecy.st1.etape1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.StringView;
import org.iae.annecy.st1.etape1.controller.CatalogueController;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.model.produit.Annuaire;
import org.iae.annecy.st1.etape1.model.produit.Catalogue;
import org.iae.annecy.st1.etape1.model.produit.Client;
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
		
		//DisplayCatalogue d = new DisplayCatalogue();
		
		//ConsoleHelper.display(d.build(c1));		
		
		
		
		/*initUserModel();

		final DataView userData = mainController.get("user:display");
		final StringView userView = new UserTextFrenchView();

		ConsoleHelper.display(userView.build(userData));*/
		
			
			Produit p1 = new Produit("1EZF",1000,"post-it jaune fluo","Post-it","Ce post-it offre au client une qualité de papier extraordinaire");
			Produit p2 = new Produit("2FDG",30,"classeur vert","classeur","Ce classeur est doté d'une broche incassable, il est entièrement recyclable");
			Produit p3 = new Produit("3DER",40.23, "Stylo plume Mont-Blanc","Stylo","Cet instrument d'écriture offre à son utilisateur un glissé magique sur la feuille");
			Produit p4 = new Produit("4DFF",78, "Bague Triniti Cartier","Bague","Bague aux trois anneaux qui se chevauchent");
			
			Client cl1 = new Client("1","Vanotti","Marion","456FRE");
			Client cl2 = new Client("2","Meynet","Pauline","789FRE");
			Client cl3 = new Client("3","Pelloux","Anna","456ERF");
			
			Annuaire a1 = new Annuaire();
			
			a1.ajouterClient(cl1);
			a1.ajouterClient(cl2);
			a1.ajouterClient(cl3);
			
			Catalogue c1 = new Catalogue();
			
			c1.ajouterProduit(p1);
			c1.ajouterProduit(p2);
			c1.ajouterProduit(p3);
			c1.ajouterProduit(p4);
			
			
			Menu m = new Menu(c1,a1);
			
			System.out.println(c1.affiche());
			m.choixAction();
			
			/*CatalogueController cat = new CatalogueController();
			cat.setCat(c1);
			System.out.println(cat.get());
			
			try{
				
				File fichier = new File("catalogue.txt");
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));
				Catalogue c2 = (Catalogue) ois.readObject();
			
			}catch(FileNotFoundException e){
				Catalogue c2 = new Catalogue();
			}*/
			
			
			
			
			

		

	}

	private static void initUserModel() {
		final UserModel userModel = new UserModel();
		userModel.register(mainController);
	}

}
