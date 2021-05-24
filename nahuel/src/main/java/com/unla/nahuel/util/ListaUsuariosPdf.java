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
import com.unla.nahuel.entities.Usuario;
import com.unla.nahuel.helpers.ViewRouteHelper;

@Component(ViewRouteHelper.USUARIO_LISTA)
public class ListaUsuariosPdf extends AbstractPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			List<Usuario> lista = (List<Usuario>) model.get("lista");
			
			//Fuentes
			//Font fuenteTitulo = FontFactory.getFont("Ubuntu",20,Color.WHITE);
			Font fuenteTitulo = FontFactory.getFont("Ubuntu",20,new  Color(255,113,51));
			Font fuenteTituloColumnas = FontFactory.getFont("Ubuntu",12,Color.WHITE);
			Font fuenteDatos = FontFactory.getFont("Ubuntu",11,Color.BLACK);

			
			//Tipo de hoja
			document.setPageSize(PageSize.A4.rotate());
			document.setMargins(-40, -40, 40, 20);
			document.open();
			PdfPCell celda = null;

			
			//Titulo
			PdfPTable tablaTitulo = new PdfPTable(1);
			
			
			
			celda =  new PdfPCell(new Phrase("Lista de Usuarios", fuenteTitulo));
			celda.setBorder(0);
			//celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setVerticalAlignment(PdfPCell.ALIGN_CENTER);
			celda.setPadding(15);
			
			tablaTitulo.addCell(celda);
			tablaTitulo.setSpacingAfter(15);
			
			//Tabla Lista
			PdfPTable tablaLista = new PdfPTable(7);
			tablaLista.setWidths(new float[] {2f, 2f, 3f, 2f, 3.5f, 3.5f, 2f});
			
			//Titulo Columnas
			
			celda = new PdfPCell(new Phrase("Nombre", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Apellido", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Tipo de documento", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			
			celda = new PdfPCell(new Phrase("Documento", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Correo Electronico", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Usuario", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);
			
			celda = new PdfPCell(new Phrase("Perfil", fuenteTituloColumnas));
			celda.setBackgroundColor(new  Color(255,113,51));
			celda.setHorizontalAlignment(Element.ALIGN_CENTER);
			celda.setVerticalAlignment(Element.ALIGN_CENTER);
			celda.setPadding(5);
			tablaLista.addCell(celda);

			//Bucle datos clientes
			
			for(Usuario usuario : lista) {
				celda = new PdfPCell(new Phrase(usuario.getNombre(), fuenteDatos));
				celda.setPadding(5);
				tablaLista.addCell(celda);

				celda = new PdfPCell(new Phrase(usuario.getApellido(), fuenteDatos));
				celda.setPadding(5);
				tablaLista.addCell(celda);
				
				celda = new PdfPCell(new Phrase(usuario.getTipoDocumento(), fuenteDatos));
				celda.setPadding(5);
				tablaLista.addCell(celda);
				
				Integer documento = usuario.getDocumento();
				celda = new PdfPCell(new Phrase(documento.toString(), fuenteDatos));
				celda.setPadding(5);
				tablaLista.addCell(celda);
				
				celda = new PdfPCell(new Phrase(usuario.getCorreoElectronico(), fuenteDatos));
				celda.setPadding(5);
				tablaLista.addCell(celda);
				
				celda = new PdfPCell(new Phrase(usuario.getNombreDeUsuario(), fuenteDatos));
				celda.setPadding(5);
				tablaLista.addCell(celda);
				
				celda = new PdfPCell(new Phrase(usuario.getPerfiles().getRol(), fuenteDatos));
				celda.setPadding(5);
				tablaLista.addCell(celda);
			}
			
			/*lista.forEach(usuario ->{
				tablaLista.addCell(usuario.getNombre());
				tablaLista.addCell(usuario.getApellido());
				Integer documento = usuario.getDocumento();
				tablaLista.addCell(documento.toString());
				tablaLista.addCell(usuario.getCorreoElectronico());
				tablaLista.addCell(usuario.getNombreDeUsuario());
				tablaLista.addCell(usuario.getPerfiles().getRol());
				
			});*/
		
		document.add(tablaTitulo);
		document.add(tablaLista);	
			
	}

}
