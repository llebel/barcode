package controllers;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import net.sourceforge.barbecue.Barcode;
import net.sourceforge.barbecue.BarcodeException;
import net.sourceforge.barbecue.BarcodeFactory;
import net.sourceforge.barbecue.BarcodeImageHandler;
import net.sourceforge.barbecue.output.OutputException;
import play.Logger;
import play.mvc.Controller;
import play.mvc.Http.Response;

public class Application extends Controller {

	public static void index(String label, long from, long to) {
		render(from, to, label);
	}

	public static void barcode(String data) {
		try {
			Barcode barcode = BarcodeFactory.createCode128(data);
			barcode.setBarHeight(50);

			BufferedImage bi = BarcodeImageHandler.getImage(barcode);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write(bi, "png", baos);
			ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());

			Response.current().contentType = "image/png";
			renderBinary(bais);

		} catch (BarcodeException e) {
			Logger.warn("BarcodeException", e);
		} catch (OutputException e) {
			Logger.warn("OutputException", e);
		} catch (IOException e) {
			Logger.warn("IOException", e);
		}

	}

}