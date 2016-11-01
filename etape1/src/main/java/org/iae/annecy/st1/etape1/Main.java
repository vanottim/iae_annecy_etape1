/**
 * 
 */
package org.iae.annecy.st1.etape1;

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

	private static MainController mainController;

	static {
		Main.mainController = new MainController();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		initUserModel();

		DataView userData = mainController.get("user:display");
		View userView = new UserTextFrenchView();

		ConsoleHelper.display(userView.build(userData));

	}

	private static void initUserModel() {
		UserModel userModel = new UserModel();
		userModel.register(mainController);
	}

}
