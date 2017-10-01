/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.sun.mail.iap.ByteArray;
import java.io.ByteArrayInputStream;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author cyrilstern1
 */

public interface PdfCreator {
    public byte[] createGeneratePdf(List<String []> list);
}
