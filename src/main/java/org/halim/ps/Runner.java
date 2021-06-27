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
        validateWord();
        validatePDF();
        validateImage("file.png");
        validateImage("file.jpg");
    }

    private static void validateWord() {
        try {
            new XWPFDocument(Files.newInputStream(Paths.get("file.doc")));
        } catch (NotOfficeXmlFileException | IOException e) {
            //TODO:: invalid office file, write your logic here
            System.out.println(e.getMessage());
        }
    }

    private static void validatePDF() {
        try {
            PDDocument.load(new File("file.pdf"));
        } catch (IOException e) {
            //TODO:: invalid pdf file, write your logic here
            System.out.println(e.getMessage());
        }
    }

    private static void validateImage(String file) {
        try {
            if (ImageIO.read(new File(file)) == null)
                //TODO:: invalid image file, write your logic here
                System.out.println("Empty Content");

        } catch (IOException e) {
            //TODO:: invalid image file, write your logic here
            System.out.println(e.getMessage());
        }
    }

}
