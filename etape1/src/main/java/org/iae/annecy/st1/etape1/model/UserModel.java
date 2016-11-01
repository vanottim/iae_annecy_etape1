/**
 * 
 */

package org.iae.annecy.st1.etape1.model;

import org.iae.annecy.st1.common.mvc.Controller;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.Model;

public class UserModel implements Model {

    /**
     * 
     */
    public DataView get() {
	DataView datas = new UserData();

	datas.add("name", "jérémie");

	return datas;
    }

    public String getPath() {
	return "user:display";
    }

    public void register(Controller controller) {
	controller.add(getPath(), this);
    }

}
