package app.alg.PhylogeneticTree;

import java.util.Map;
import java.util.TreeMap;

/**
 * Retine cuvintele relevante
 * 
 * @author Eli
 *
 */
public class DataMisc
{
	private final String[] pLanguage = { "java", "c", "c++", "c#", "phyton" ,"javascript"};

	private final String[] fLanguage = { "engleza", "germana", "franceza", "spaniola", "rusa" ,"english","german"};

	public Map<String, Integer> mapPLanguage = new TreeMap<String, Integer>();

	public Map<String, Integer> mapFLanguage = new TreeMap<String, Integer>();

	/**
	 * Initializeaza dictionarele
	 */
	public void InitDictionaries()
	{
		for (String index : pLanguage)
			mapPLanguage.put(index, null);

		for (String index : fLanguage)
			mapFLanguage.put(index, null);
	}
}
