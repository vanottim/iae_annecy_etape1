/**
 * 
 */

package org.iae.annecy.st1.etape1.controller;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.iae.annecy.st1.common.mvc.Controller;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.Model;

/**
 * @author Djer1013
 *
 */
public class MainController implements Controller {

    private Map<String, Model> models;

    public MainController() {
	super();
	this.models = new ConcurrentHashMap<String, Model>();
    }

    /**
     * Search for a view for a given path
     * 
     * @param name
     *            name
     */
    public DataView get(String name) {
	Model model = models.get(name);
	DataView datas = null;
	if (null != model) {
	    datas = model.get();
	}
	return datas;
    }

    public void add(String name, Model model) {
	models.put(name, model);
    }

}
