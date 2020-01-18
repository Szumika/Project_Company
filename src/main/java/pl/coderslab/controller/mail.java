package pl.coderslab.controller;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;


/**

 */
public class mail {
    public static final String DEST = "results/chapter01/raport.pdf";

    public static void main(String test) throws IOException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new mail().createPdf(DEST, test);
    }

    public void createPdf(String dest, String teks) throws IOException {
        File file = new File(dest);
        file.getParentFile().mkdirs();
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);

        // Initialize document
        Document document = new Document(pdf);

        //Add paragraph to the document
        document.add(new Paragraph(teks));

        //Close document
        document.close();
    }
}