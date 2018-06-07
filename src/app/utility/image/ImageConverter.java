package app.utility.image;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.ImageIO;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import javafx.scene.image.Image;

public class ImageConverter {

	public String convert(File file) throws InvalidPasswordException, IOException {
		PDDocument document = PDDocument.load(file);
		PDFRenderer pdfRenderer = new PDFRenderer(document);
		for (int page = 0; page < document.getNumberOfPages(); ++page)
		{ 
			
		    BufferedImage bim;
			bim = pdfRenderer.renderImageWithDPI(0, 300, ImageType.RGB);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( bim, "jpg", baos );
			baos.flush();
			byte[] imageInByte = baos.toByteArray();
			baos.close();
			String encodedfile = Base64.getEncoder().encodeToString(imageInByte).toString();
			
            return encodedfile;
			
		}
		document.close();
		return null;
	}
}
