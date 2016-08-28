/**
 * 
 */
package org.iae.annecy.st1.common.mvc;

/**
 * @author Djer1013
 *
 */
public interface Controller {
	DataView get(String name);
	void add(String name, Model model);
}
