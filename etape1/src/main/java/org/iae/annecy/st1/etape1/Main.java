/**
 * 
 */
package org.iae.annecy.st1.etape1;

import org.iae.annecy.st1.common.mvc.Controller;
import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.View;
import org.iae.annecy.st1.etape1.controller.MainController;
import org.iae.annecy.st1.etape1.model.UserModel;
import org.iae.annecy.st1.etape1.view.UserTextFrenchView;
import org.iae.annecy.st1.tools.ConsoleHelper;

/**
 * @author Djer1013
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Controller mainController = new MainController();
		UserModel userModel = new UserModel();
		userModel.register(mainController);
		
		DataView userData = mainController.get("user_display");
		View userView = new UserTextFrenchView();
		
	ConsoleHelper.display(userView.build(userData));

	}

}
