package com.tcci.gt.apidocument.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.util.Units;
import org.apache.poi.wp.usermodel.HeaderFooterType;
import org.apache.poi.xwpf.usermodel.Document;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFHeader;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class CreateDocumentSimple {

	String fileName = "D:\\test\\hello.docx";
	String imgFile = "D:\\test\\logo-renap.png";

	public CreateDocumentSimple() {
		// TODO Auto-generated constructor stub
	}

	public void creaDocumento() {
		try {
			XWPFDocument doc = new XWPFDocument();
			XWPFHeader header = doc.createHeader(HeaderFooterType.DEFAULT);
			
			XWPFParagraph p = header.createParagraph();
			
			XWPFTable table = header.createTable(1, 2);
			table.removeBorders();
			XWPFTableRow row1 = table.getRow(0);
			XWPFTableCell cell1 = row1.getCell(0);
			
		
			FileInputStream in = new FileInputStream(imgFile);
			XWPFRun run = p.createRun();
			run.addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg", Units.toEMU(100), Units.toEMU(50));
			in.close();
			cell1.addParagraph(p);
			cell1.setText("--- --- ---- --- ");
			cell1.setWidth("2%");
			XWPFTableCell cell2 = row1.getCell(1);
			cell2.setText("Dirección de Verificación de Identidad y Apoyo Social");
			
			/*
			 * FileInputStream in = new FileInputStream(imgFile);
			 * p.createRun().addPicture(in, Document.PICTURE_TYPE_JPEG, "samplePict.jpeg",
			 * Units.toEMU(100), Units.toEMU(50));
			 * 
			 * XWPFTable table = header.createTable(1,1); table.removeBorders();
			 * XWPFTableRow row1 = table.getRow(0);
			 * //row1.addNewTableCell().setParagraph(p.createRun().addPicture(new
			 * FileInputStream(imgFile), Document.PICTURE_TYPE_JPEG, "logo.png",
			 * Units.toEMU(100), Units.toEMU(50)));
			 * //row1.addNewTableCell().setParagraph(p); row1.addNewTableCell().
			 * setText("Dirección de Verificación de Identidad y Apoyo Social");
			 */
            FileOutputStream out = new FileOutputStream(fileName);
            doc.write(out);
            doc.close();
            out.close();
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
