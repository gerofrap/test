package com.examenfit.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;


import com.examenfit.entities.Empresa;
import com.examenfit.services.ExcelService;




class ExcelServiceTest {
	
	@InjectMocks
	ExcelService excelService;
	
	private List<Empresa> empresas;
	

	
	
	
	
	@Test
	void testValidarXml() {
		empresas = null;
		System.out.println("-.");	

	}



}
