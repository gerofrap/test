package com.examenfit.services;


import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.examenfit.entities.Empresa;
import com.examenfit.entities.Movimiento;


@Service
public class ExcelService {


	public void validarXml(List<Empresa> lista) throws Exception {
		
		List<String> excepciones = new ArrayList<>();
		boolean condicion = true;
		
		if (lista == null || lista.isEmpty()) {
			excepciones.add("\nLa lista de empresas está vacía o no se encuentra en el formato adecuado");
			condicion = false;
		}
		
		int aux = 1;
		for (Empresa empresa : lista) {
			
			empresa.getMovimientos().forEach(t -> t.setNroContrato(empresa.getNroContrato()));
			
			if (empresa.getNroContrato() == null) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee Nro Contrato");
				condicion = false;
			}
			if (empresa.getCuit() == null || empresa.getCuit().isEmpty()) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee CUIT");
				condicion = false;
			}
			if (empresa.getDenominacion() == null || empresa.getDenominacion().isEmpty()) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee Denominación");
				condicion = false;
			}
			if (empresa.getDomicilio() == null || empresa.getDomicilio().isEmpty()) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee Domicilio");
				condicion = false;
			}
			if (empresa.getCodigoPostal() == null) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee Código Postal");
				condicion = false;
			}
			if (empresa.getOrganizador() == null || empresa.getOrganizador().isEmpty()) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee Organizador");
				condicion = false;
			}
			if (empresa.getProductor() == null || empresa.getProductor().isEmpty()) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee Productor");
				condicion = false;
			}
			if (empresa.getCiiu() == null || empresa.getCiiu().isEmpty()) {
				excepciones.add("\nLa empresa en posición " + aux + " no posee CIIU");
				condicion = false;
			}
			
			
			int aux2 = 1;
			for (Movimiento movimiento : empresa.getMovimientos()) {
				
				if (movimiento.getNroContrato() == null) {
					excepciones.add("\nLa empresa en posición " + aux + " no posee Nro Contrato en el movimiento de la posición " + aux2);
					condicion = false;
				}
				if (movimiento.getSaldoCtaCte() == null) {
					excepciones.add("\nLa empresa en posición " + aux + " no posee SaldoCtaCta en el movimiento de la posición " + aux2);
					condicion = false;
				}
				if (movimiento.getTipo() == null || movimiento.getTipo().isEmpty()) {
					excepciones.add("\nLa empresa en posición " + aux + " no posee Tipo en el movimiento de la posición " + aux2);
					condicion = false;
				}
				if (movimiento.getCodigoMovimiento() == null || movimiento.getCodigoMovimiento().isEmpty()) {
					excepciones.add("\nLa empresa en posición " + aux + " no posee CodigoMovimiento en el movimiento de la posición " + aux2);
					condicion = false;
				}
				if (movimiento.getConcepto() == null || movimiento.getConcepto().isEmpty()) {
					excepciones.add("\nLa empresa en posición " + aux + " no posee Concepto en el movimiento de la posición " + aux2);
					condicion = false;
				}
				if (movimiento.getImporte() == null) {
					excepciones.add("\nLa empresa en posición " + aux + " no posee Importe en el movimiento de la posición " + aux2);
					condicion = false;
				}
			}
			
			aux++;
		}
		
		
		if (!condicion) {
			throw new Exception(excepciones.toString());
		}
		
	}
	
	
	
	
	public XSSFWorkbook crearWorkbookEmpresas(List<Empresa> empresas) throws Exception {
				
			XSSFWorkbook workbook = new XSSFWorkbook(); 
        
	        // Creo hojas en blanco
	        XSSFSheet hojaEmpresas = workbook.createSheet("Empresas");
	        XSSFSheet hojaMovimientos = workbook.createSheet("Movimientos"); 
	        
	        
	        // Agrego nombres de las columnas
	        String[] cabeceraEmpresas = {"NroContrato", "CUIT", "DENOMINACION", "DOMICILIO", "CODIGOPOSTAL", "PRODUCTOR"};
	        String[] cabeceraMovimientos = {"NroContrato", "SaldoCtaCte", "Concepto", "Importe"};
	        
	        Row filaInicialEmpresas = hojaEmpresas.createRow(0);
	        Row filaInicialMovimientos = hojaMovimientos.createRow(0);
	        
	        int aux1 = 0;
	        int aux2 = 0;
	        
	        for (String c : cabeceraEmpresas) {
	           Cell cell = filaInicialEmpresas.createCell(aux1++);
	           cell.setCellValue(c);
	        }
	        for (String c : cabeceraMovimientos) {
	           Cell cell = filaInicialMovimientos.createCell(aux2++);
	           cell.setCellValue(c);
	        }
	
	        
	        // Relleno celdas con lista 'empresas'
	        int filaEmpresas = 1;
	        int filaMovimientos = 1;     
	        for (Empresa empresa : empresas) {
	        	
	            Row fila = hojaEmpresas.createRow(filaEmpresas++);
	            int auxEmp = 0;          
	            fila.createCell(auxEmp++).setCellValue(empresa.getNroContrato());
	            fila.createCell(auxEmp++).setCellValue(empresa.getCuit());
	            fila.createCell(auxEmp++).setCellValue(empresa.getDenominacion());
	            fila.createCell(auxEmp++).setCellValue(empresa.getDomicilio());
	            fila.createCell(auxEmp++).setCellValue(empresa.getCodigoPostal());
	            fila.createCell(auxEmp++).setCellValue(empresa.getProductor());
	
	            for (Movimiento movimiento : empresa.getMovimientos()) {
			            Row row = hojaMovimientos.createRow(filaMovimientos++);
			            int auxMov = 0;          
			            row.createCell(auxMov++).setCellValue(empresa.getNroContrato());
			            row.createCell(auxMov++).setCellValue(movimiento.getSaldoCtaCte());
			            row.createCell(auxMov++).setCellValue(movimiento.getConcepto());
			            row.createCell(auxMov++).setCellValue(movimiento.getImporte());
	            }
	
	        }
	    
	    return workbook;
			
	}
	
	
	public void guardarExcel(XSSFWorkbook workbook) {
		
        try {     	
        	String pattern = "MM-dd-yyyy";
        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        	String date = simpleDateFormat.format(new Date());
        	
            FileOutputStream out = new FileOutputStream(new File(date + "-empresas.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println(date + "-empresas.xlsx guardado.");
        } 
        
        catch (Exception e) {
            e.printStackTrace();
        }
		
	}
}
