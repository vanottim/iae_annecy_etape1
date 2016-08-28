/**
 * 
 */
package org.iae.annecy.st1.common.mvc;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Djer1013
 *
 */
public class AbstractDataView implements DataView {

	private Map<String, String> datas;

	/**
	 * 
	 */
	public AbstractDataView() {
		datas = new ConcurrentHashMap<String, String>();
	}

	public String getData(String key) {
		return datas.get(key);
	}

	public void add(String key, String data) {
		datas.put(key, data);
	}

}
