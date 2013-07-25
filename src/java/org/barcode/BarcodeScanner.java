package org.barcode;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Reader;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.Result;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

import java.io.File;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

public class BarcodeScanner {

	public static String decodeFromFile( File barcode ) {

        try {
            BufferedImage image = ImageIO.read( barcode );
            LuminanceSource source = new BufferedImageLuminanceSource( image );
            BinaryBitmap bitmap = new BinaryBitmap( new HybridBinarizer( source ) );

            Reader reader = new MultiFormatReader();
            return "{:found true :number \"" + (reader.decode( bitmap )).getText() + "\"}";
        }
        catch ( com.google.zxing.NotFoundException e ) {
            return "{:found false :reason \"Barcode was not found for this image\"}";
        }
        catch ( Exception e ) {
            System.out.println( "[BarcodeScanner]: There was a problem: " + e.getMessage() );
            return "{:found false :reason \"There was a problem reading the barcode\"}";
        }
    }
}
