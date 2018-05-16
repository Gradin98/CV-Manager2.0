package app.alg.PhylogeneticTree;

import java.util.Map;

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

		RConnection r = null;
		r = new RConnection();
		final int height = ProccesData.relationArray.length*20;
		final int width = height*3/4 ;
		final String sWidth = ",width=" + width;
		final String sHeight = ",height=" + height;
		r.eval("png(filename=\""+ System.getenv("APPDATA") + "/CV-Reader/PhylogeneticTree.png\"" + sWidth + sHeight + ")");
		r.eval("library(ape)");
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
		r.eval("png(filename=\""+ System.getenv("APPDATA") + "/CV-Reader/K-Means.png\"" + sWidth + sHeight + ")");
		r.eval("library(kmeans)");
		r.eval("require(graphics)");
		r.assign("aMatrix", REXP.createDoubleMatrix(ProccesData.relationArray));
		r.eval("(cl <-kmeans(aMatrix,"+ProccesData.relationArray.length+",nstart = 1)");
		r.eval("plot(aMatrix, col = cl$cluster)");
		r.eval("points(cl$centers, col = 1:"+ProccesData.relationArray.length+", pch = 8)");
		r.eval("dev.off()");
		
	}

}
