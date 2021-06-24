package org.halim.ps;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {

    public static void main(String[] args) {
        validateWord();
        validatePDF();
    }

    private static void validateWord(){
        try {
            XWPFDocument doc = new XWPFDocument(Files.newInputStream(Paths.get("file.doc")));
        } catch (NotOfficeXmlFileException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void validatePDF(){
        try {
            File file = new File("file.pdf");
            PDDocument c = PDDocument.load(file);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
