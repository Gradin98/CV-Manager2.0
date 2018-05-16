package app.alg.PhylogeneticTree;
import java.util.ArrayList;
import java.util.List;

/**
 * stocheaza numarul de aparitii si lista CV-urilor in care a aparut un cuvant
 * 
 * @author Eli
 *
 */
public class WordApparitionObj
{
	int app;
	List<String> cvList = new ArrayList<String>();

	/**
	 * returneaza numarul de aparitii si lista cu CV-urile in care apare un cuvant
	 */
	public String toString()
	{
		return app + " " + cvList;
	}

}