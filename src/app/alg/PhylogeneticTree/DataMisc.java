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
	private final static String[] pLanguage = { "java", "c", "c++", "c#", "phyton" };

	private final static String[] fLanguage = { "engleza", "germana", "franceza", "spaniola", "rusa" };

	public static final Map<String, Integer> mapPLanguage = new TreeMap<String, Integer>();

	public static final Map<String, Integer> mapFLanguage = new TreeMap<String, Integer>();

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
	
	/**
	 * Verifica daca un cuvant este relevant
	 * 
	 * @param x cuvantul cautat
	 * @param y dictionarul in care este cautat
	 * @return daca a gasit sau nu cuvantul
	 */
	public boolean Check(String x, Map<String, Integer> y)
	{
		if (y.containsKey(x))
			return true;
		else
			return false;
	}
}
