/**
 * 
 */

package org.iae.annecy.st1.common.mvc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Classe helper pour la representation des données. Stocke localement une
 * données (texte) à partir d'une clef (teste)
 * 
 * @author Djer1013
 */
public abstract class AbstractDataView implements DataView {

	/**
	 * Systeme interne de stockage des données.
	 */
	private final transient Map<String, String> datas;

	/**
	 * Constructeur par défaut. Intitialise une map pour la sauvegarde des
	 * données.
	 */
	public AbstractDataView() {
		datas = new ConcurrentHashMap<String, String>();
	}

	/**
	 * Check Interface. {@inheritDoc}
	 */
	public final String getData(final String key) {
		return datas.get(key);
	}

	/**
	 * Check Interface. {@inheritDoc}
	 */
	public final void add(final String key, final String data) {
		datas.put(key, data);
	}

}
