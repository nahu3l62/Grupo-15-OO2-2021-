package com.unla.nahuel.util;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.unla.nahuel.entities.Perfiles;
import com.unla.nahuel.helpers.ViewRouteHelper;

@Component("perfil/lista")
public class ListaPerfilesPdf extends AbstractPdfView{
	
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			List<Perfiles> lista = (List<Perfiles>) model.get("lista");
			
			//Fuentes
			//Font fuenteTitulo = FontFactory.getFont("Ubuntu",20,Color.WHITE);
			Font fuenteTitulo = FontFactory.getFont("Ubuntu",20,new  Color(48, 10, 174));
			Font fuenteTituloColumnas = FontFactory.getFont("Ubuntu",12,Color.WHITE);
			Font fuenteDatos = FontFactory.getFont("Ubuntu",11,Color.BLACK);

			
			//Tipo de hoja
			document.setPageSize(PageSize.A4/*.rotate()*/);
			document.setMargins(-40, -40, 40, 20);
			document.open();
			PdfPCell celda = null;

			
			//Titulo
			PdfPTable tablaTitulo = new PdfPTable(1);
			
						
			celda =  new PdfPCell(new Phrase("Lista de Perfiles", fuenteTitulo));
			celda.setBorder(0);
			//celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setPadding(15);
			
			tablaTitulo.addCell(celda);
			tablaTitulo.setSpacingAfter(15);
			
			//Tabla Lista
			PdfPTable tablaLista = new PdfPTable(1);
			//tablaLista.setWidths(new float[] {2f, 2f, 1.5f, 3.5f, 3.5f, 2f});
			
			//Titulo Columnas
			
			celda = new PdfPCell(new Phrase("Rol", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(48, 10, 174));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			

			//Bucle datos clientes
			
			for(Perfiles perfil : lista) {
				celda = new PdfPCell(new Phrase(perfil.getRol(), fuenteDatos));
				celda.setHorizontalAlignment(Element.ALIGN_CENTER);
				celda.setVerticalAlignment(Element.ALIGN_CENTER);
				celda.setPadding(5);
				tablaLista.addCell(celda);


			}
					
		document.add(tablaTitulo);
		document.add(tablaLista);	
			
	}

}
