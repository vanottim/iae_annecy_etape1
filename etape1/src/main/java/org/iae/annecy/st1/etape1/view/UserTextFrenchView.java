/**
 * 
 */
package org.iae.annecy.st1.etape1.view;

import org.iae.annecy.st1.common.mvc.DataView;
import org.iae.annecy.st1.common.mvc.View;

/**
 * @author Djer1013
 *
 */
public class UserTextFrenchView implements View{

	public String build(DataView datas){
		
		String textView = "Votre nom : " + datas.getData("name");
		
		return textView;
	}

}
