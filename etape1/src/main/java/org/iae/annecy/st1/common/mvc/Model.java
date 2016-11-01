/**
 * 
 */

package org.iae.annecy.st1.common.mvc;

/**
 * @author Djer1013
 *
 */
public interface Model {
    DataView get();

    String getPath();

    void register(Controller controller);
}
