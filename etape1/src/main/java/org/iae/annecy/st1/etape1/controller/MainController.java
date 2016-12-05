/**
 * 
 */

package org.iae.annecy.st1.etape1.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.iae.annecy.st1.common.mvc.Controller;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.Model;
import org.iae.annecy.st1.etape1.model.UserData;

/**
 * Controller principal permetant de traiter les actions de l'exemple et ayant
 * acces aux modeles d'exemple.
 * 
 * @author Djer1013
 * 
 */
public class MainController implements Controller {

	/**
	 * Liste des modeles accesible via ce controller.
	 */
	private final transient Map<String, Model> models;

	/**
	 * Initialise le stockage des modeles accesibles.
	 */
	public MainController() {
		super();
		this.models = new ConcurrentHashMap<String, Model>();
	}

	/**
	 * Check Interface. {@inheritDoc}
	 */
	public DataView get(final String actionName) {
		final Model model = models.get(actionName);
		return getData(model);
	}

	/**
	 * Check Interface. {@inheritDoc}
	 */
	public void add(final String name, final Model model) {
		models.put(name, model);
	}

	private DataView getData(final Model model) {
		DataView datas;
		if (null == model) {
			datas = new UserData();
		} else {
			datas = model.get();
		}
		return datas;
	}
	
	

}
