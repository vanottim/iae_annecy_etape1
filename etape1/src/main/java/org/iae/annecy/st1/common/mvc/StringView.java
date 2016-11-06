/**
 * 
 */

package org.iae.annecy.st1.common.mvc;

/**
 * Définie le comportement d'une vue.
 * 
 * @author Djer1013
 */
public interface StringView {

    /**
     * Construit une representation des données.
     * @param datas Données à intégrer dans la representation
     * @return Une chaine de caractère representant les données pour un utilisateur
     */
    String build(DataView datas);

}
