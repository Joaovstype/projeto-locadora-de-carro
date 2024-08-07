package com.vstype.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.vstype.carRental.services.CarroService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CarroServiceTest {

	@Autowired
	CarroService carroService;
	
	@Test
	void cenario01() {
		
		boolean retorno = this.carroService.verificarNomeCarro("Jeep Compass", 2006);
		
		assertEquals(true, retorno);
	}

}	
