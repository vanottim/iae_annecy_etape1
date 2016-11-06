/**
 * 
 */

package org.iae.annecy.st1.common.mvc;

/**
 * Definie le comportement des données accesibles au vues.
 * 
 * @author Djer1013
 */
public interface DataView {

    /**
     * Recherche les données à partir d'un identifiant.
     * @param key Clef de recherche de la données
     * @return Une chaine de texte 
     */
    String getData(String key);

    /**
     * Sauvegarde une nouvelle données.
     * @param key clef permetant de retrouver cette donénes
     * @param data La données la sauvegarder
     */
    void add(String key, String data);

}
