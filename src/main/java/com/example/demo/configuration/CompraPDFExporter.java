package com.example.demo.configuration;

import java.awt.Color;
import java.io.IOException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import com.example.demo.entity.Compra;
import com.example.demo.entity.ItemCompra;
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
	
	public CompraPDFExporter(Compra compra) {

		this.compra = compra;
	}
	
	private void writeCustomerTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.BLACK);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Fecha", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Precio", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Paciente", font));
		table.addCell(cell);
	}
	
	private void writeCustomerTableData(PdfPTable table) {
		table.addCell(String.valueOf(compra.getIdCompra()));
		table.addCell(String.valueOf(compra.getFecha()));
		table.addCell(String.valueOf(compra.getPrecio()));
		table.addCell(String.valueOf(compra.getPaciente().getNombre() + " " + compra.getPaciente().getApellidos()));
	}
	
	private void writeProductsTableHeader(PdfPTable table) {
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(Color.LIGHT_GRAY);
		cell.setPadding(5);
		
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.BLACK);
		
		cell.setPhrase(new Phrase("ID", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Nombre", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Descripción", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Precio", font));
		table.addCell(cell);
		
		cell.setPhrase(new Phrase("Receta", font));
		table.addCell(cell);
	}
	
	private void writeProductsTableData(PdfPTable table) {
		Set<ItemCompra> items = compra.getItems();
		for(ItemCompra item : items) {
			table.addCell(String.valueOf(item.getMedicamento().getIdMedicamento()));
			table.addCell(String.valueOf(item.getMedicamento().getNombre()));
			table.addCell(String.valueOf(item.getMedicamento().getDescripcion()));
			table.addCell(String.valueOf(item.getMedicamento().getPrecio()));
			table.addCell(String.valueOf(item.getMedicamento().getReceta()));
		}
		
	}
	
	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		Font font = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		font.setSize(18);
		font.setColor(Color.BLACK);
		
		Paragraph p = new Paragraph("Recibo de la compra", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);
		
		document.add(p);
		
		PdfPTable customerTable = new PdfPTable(4);
		customerTable.setWidthPercentage(100f);
		customerTable.setWidths(new float[] {1.5f, 3.5f, 1.5f, 3.5f});
		customerTable.setSpacingBefore(10);
		
		PdfPTable productsTable = new PdfPTable(5);
		productsTable.setWidthPercentage(100f);
		productsTable.setWidths(new float[] {1.5f, 3.5f, 3.0f, 3.0f, 1.5f});
		productsTable.setSpacingBefore(10);
		
		writeCustomerTableHeader(customerTable);
		writeCustomerTableData(customerTable);
		
		writeProductsTableHeader(productsTable);
		writeProductsTableData(productsTable);
		
		document.add(customerTable);
		document.add(productsTable);
		
		document.close();
	}
	
}
