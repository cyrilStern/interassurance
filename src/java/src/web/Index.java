/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.web;

import dao.PdfCreator;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author cyrilstern1
 */
@Controller
public class Index {
    @Autowired 
    private PdfCreator pdfcreator;
    public String string;
    
    @RequestMapping(value="/index")
    public String index(){
        System.out.println("passe par l'url");
           return "index"; 
    }
    @RequestMapping(value="/createPdf")
    public void createPdf(HttpServletResponse response) throws IOException{
        String [] rowTab = new String[3];
        List<String []> listOdRow = new ArrayList<>();
        listOdRow.add(rowTab);
       
        
         byte[] data =  pdfcreator.createGeneratePdf(listOdRow);//read PDF as byte stream
         System.out.println("datafromoperation: " + data.length);
        streamReport(response, data, "my_report.pdf");

    }
    
     protected void streamReport(HttpServletResponse response, byte[] data, String name)
            throws IOException {
                
        response.setContentType("application/pdf");
        response.setHeader("Content-disposition", "attachment; filename=" + name);
        response.setContentLength(data.length);
        response.getOutputStream().write(data);
        response.getOutputStream().flush();        
        
    }
}
