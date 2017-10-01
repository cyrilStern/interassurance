/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.mail.iap.ByteArray;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author cyrilstern1
 */
public class PdfCreatorImpl implements PdfCreator{
   
    @Override
    public byte[] createGeneratePdf(List<String[]> list) {
          ByteArrayOutputStream out = new ByteArrayOutputStream();            
          Document document = new Document();
	  PdfPTable table = new PdfPTable(new float[] { 2, 1, 2 });
	  table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
	  table.addCell("Name");
          table.addCell("Age");
          table.addCell("Location");
	  table.setHeaderRows(1);
	  PdfPCell[] cells = table.getRow(0).getCells(); 
	  for (int j=0;j<cells.length;j++){
	     cells[j].setBackgroundColor(BaseColor.GRAY);
	  }
          for (int i=1;i<5;i++){
    	     table.addCell("Name:"+i);
             table.addCell("Age:"+i);
             table.addCell("Location:"+i);
          }
        try {
            PdfWriter.getInstance(document, new FileOutputStream("camere.pdf"));
            PdfWriter.getInstance(document, out);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfCreatorImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PdfCreatorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
	  document.open();
        try {
            document.add(table);
        } catch (DocumentException ex) {
            Logger.getLogger(PdfCreatorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        document.close();
        byte[] pdfBytes = out.toByteArray();
        System.out.println("pdfbyte : " + pdfBytes.length);
        return pdfBytes;
    }
    
}
