package app.alg.PhylogeneticTree;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import app.gui.search.listeners.CVObject;

import java.util.TreeMap;

/**
 * proceseaza CV-urile
 * 
 * @author Eli
 *
 */
public class ProccesData
{
	DataMisc data = new DataMisc();
	
	final Map<String, WordApparitionObj> mapWords = new TreeMap<String, WordApparitionObj>();
	static double[][] relationArray = null;
	private ArrayList<String> cvArray = new ArrayList<String>();
	
	/**
	 * Cauta cuvintele relevante in continutul CV-urilor
	 */
	public void ProccesWords(Map<String, CVObject> aMap)
	{
		data.InitDictionaries();

		for (Entry<String, CVObject> entry: aMap.entrySet())
		{
			String[] words = entry.getValue().getContent().split(" ");

			// check WhiteLists
			for (int wordIndex = 0; wordIndex < words.length; wordIndex++)
			{
				//cut excess chars
				while (words[wordIndex] != words[wordIndex].replaceAll("(-|;|:|,)\\Z", ""))
				{
					words[wordIndex] = words[wordIndex].replaceAll("(-|;|:|,)\\Z", "");
				}
				
				if (data.Check(words[wordIndex], DataMisc.mapPLanguage)||data.Check(words[wordIndex], DataMisc.mapFLanguage))
					BuildWordMap(words[wordIndex], entry.getKey());
			}
		}
		
		BuildRelationArray(aMap);
	}
	
	/**
	 * Construieste matricea de rudenie
	 */
	private void BuildRelationArray(Map<String, CVObject> aMap)
	{
		relationArray = new double[aMap.size()][aMap.size()];
		
		for (Entry<String, CVObject> entry : aMap.entrySet())
			cvArray.add(entry.getKey());

		for (int cvIndex = 0; cvIndex < relationArray.length-1; cvIndex++)
		{
			relationArray[cvIndex][cvIndex] = 0;
			for (int cvIndex2 = cvIndex + 1; cvIndex2 < relationArray.length; cvIndex2++)
			{
				for (Entry<String, WordApparitionObj> entry2 : mapWords.entrySet())
				{
					if (entry2.getValue().cvList.contains(cvArray.get(cvIndex)))
						if (entry2.getValue().cvList.contains(cvArray.get(cvIndex2)))
						{
							relationArray[cvIndex][cvIndex2]++;
							relationArray[cvIndex2][cvIndex]++;
						}
				}
			}
		}
	}
	
	/**
	 * Retine CV-ul in care s-a gasit un cuvant relevant
	 * @param x cuvant
	 * @param y CV
	 */
	private void BuildWordMap(String x, String y)
	{
		if (mapWords.containsKey(x))
		{
			WordApparitionObj word = mapWords.get(x);
			word.cvList.add(y);
			word.app++;
			mapWords.put(x, word);
		} else
		{
			WordApparitionObj word = mapWords.get(x);
			word = new WordApparitionObj();
			word.cvList.add(y);
			word.app = 1;
			mapWords.put(x, word);
		}
	}
}
