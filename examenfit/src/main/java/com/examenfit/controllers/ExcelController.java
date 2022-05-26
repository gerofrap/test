package com.examenfit.controllers;


import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.examenfit.entities.Empresa;
import com.examenfit.services.ExcelService;


	


@RestController
public class ExcelController {


	@Autowired
	ExcelService excelService;
	



	@GetMapping(value = "/getExcel", consumes = "application/xml")
    public ResponseEntity<?> getExcel(@RequestBody(required = false) List<Empresa> empresas) throws Exception {
		
        try {
        	excelService.validarXml(empresas);
        	
        	
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            XSSFWorkbook workbook = excelService.crearWorkbookEmpresas(empresas);
        
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "force-download"));
            header.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=Empresas.xlsx");
            workbook.write(stream);
            workbook.close();
            return new ResponseEntity<>(new ByteArrayResource(stream.toByteArray()), header, HttpStatus.CREATED);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST + ": " + e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
	
	
	@PostMapping(value = "/saveExcel")
    public void saveExcel(@RequestBody List<Empresa> empresas) throws Exception {
		
        try {
        	excelService.validarXml(empresas);
       	
            XSSFWorkbook workbook = excelService.crearWorkbookEmpresas(empresas);
            excelService.guardarExcel(workbook);
            workbook.close();
           
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    
}
