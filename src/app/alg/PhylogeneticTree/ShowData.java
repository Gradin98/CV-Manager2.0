package app.alg.PhylogeneticTree;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.REngineException;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

/**
 * Afiseaza datele procesate
 * 
 * @author Eli
 *
 */
public class ShowData
{
	/**
	 * Deseneaza arborele philogenetic
	 * 
	 * @throws REXPMismatchException
	 * @throws REngineException
	 */
	public void DrawPhTree() throws RserveException
	{

		RConnection r = new RConnection();
		final int height = ProccesData.relationArray.length*20;
		final int width = height*3/4 ;
		final String sWidth = ",width=" + width;
		final String sHeight = ",height=" + height;
		r.eval("library(ape)");
		r.eval("setwd(\""+System.getenv("APPDATA").replaceAll("\\\\", "/")+"/CV-Reader\")");
		r.eval("png(filename=\"PhylogeneticTree.png\"" + sWidth + sHeight + ")");
		r.assign("aMatrix", REXP.createDoubleMatrix(ProccesData.relationArray));
		r.eval("plot(nj(dist(aMatrix)))");
		r.eval("dev.off()");

	}
	
	public void DrawKMeans() throws RserveException
	{
		
		RConnection r = null;
		r = new RConnection();
		final int height = ProccesData.relationArray.length*20;
		final int width = height*3/4 ;
		final String sWidth = ",width=" + width;
		final String sHeight = ",height=" + height;
		r.eval("setwd(\""+System.getenv("APPDATA").replaceAll("\\\\", "/")+"/CV-Reader\")");
		r.eval("png(filename=\"Kmeans.png\"" + sWidth + sHeight + ")");
		r.eval("library(kmeans)");
		r.eval("require(graphics)");
		r.assign("aMatrix", REXP.createDoubleMatrix(ProccesData.relationArray));
		r.eval("(cl <-kmeans(aMatrix,"+ProccesData.relationArray.length+",nstart = 1)");
		r.eval("plot(aMatrix, col = cl$cluster)");
		r.eval("points(cl$centers, col = 1:"+ProccesData.relationArray.length+", pch = 8)");
		r.eval("dev.off()");
		
	}
	
	/**
	 * scrie un fisier care contine matricea de relatii
	 * 
	 * @throws FileNotFoundException
	 * @throws UnsupportedEncodingException
	 */
	public static void WriteRelationArray() throws FileNotFoundException, UnsupportedEncodingException
	{
		double[][] array = ProccesData.relationArray;
		PrintWriter writer = new PrintWriter(System.getenv("APPDATA").replaceAll("\\\\","/")+"/CV-Reader/RelationArray.txt", "UTF-8");
		for (int index = 0; index < array.length; index++)
		{
			for (int index2 = 0; index2 < array.length; index2++)
			{
				writer.print(array[index][index2] + "\t");
			}
			writer.print("\n");
		}
		writer.close();
	}

}
