package org.halim.ps;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) {
        if (isValidOfficeDocument())
            System.out.println("write your logic in this block");

        if (isValidPDF())
            System.out.println("write your logic in this block");

        if (isValidImage("file.png"))
            System.out.println("write your logic in this block");

        if (isValidImage("file.jpg"))
            System.out.println("write your logic in this block");

    }

    private static boolean isValidOfficeDocument() {
        try {
            new XWPFDocument(Files.newInputStream(Paths.get("file.doc")));
            return Boolean.TRUE;
        } catch (NotOfficeXmlFileException | IOException e) {
            //TODO:: invalid office file, write your logic here
            return Boolean.FALSE;
        }
    }

    private static boolean isValidPDF() {
        try {
            PDDocument.load(new File("file.pdf"));
            return Boolean.TRUE;
        } catch (IOException e) {
            //TODO:: invalid pdf file, write your logic here
            return Boolean.FALSE;
        }
    }

    private static boolean isValidImage(String file) {
        try {
            if (ImageIO.read(new File(file)) == null)
                //TODO:: invalid image file, write your logic here
                return Boolean.FALSE;

            return Boolean.TRUE;
        } catch (IOException e) {
            //TODO:: invalid image file, write your logic here
            return Boolean.FALSE;
        }
    }

}
