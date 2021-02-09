package com.example.demo.configuration;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.Compra;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class CompraPDFExporter {
	
private Compra compra;
	
	/*
	@Autowired
	private DozerBeanMapper dozer;
	*/
	
	public CompraPDFExporter(Compra compra) {
		this.compra = compra;
	}
	
	private void writeTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.BLACK);
		
		cell.setPhrase(new Phrase("CompraModel ID", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Fecha", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Precio", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Paciente ID", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Medicamentos", font));
		table.addCell(cell);
	}
	
	private void writeTableData(PdfPTable table) {
		table.addCell(String.valueOf(compra.getIdCompra()));
		table.addCell(String.valueOf(compra.getFecha()));
		table.addCell(String.valueOf(compra.getPrecio()));
		table.addCell(String.valueOf(compra.getPaciente()));
		table.addCell(String.valueOf(compra.getMedicamentos()));
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLUE);
		
		Paragraph p = new Paragraph("Recibo de la compra", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable table = new PdfPTable(5);
		table.setWidthPercentage(100f);
		table.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
		table.setSpacingBefore(10);
		
		writeTableHeader(table);
		writeTableData(table);
		
		document.add(table);
		
		document.close();
	}
	
}
