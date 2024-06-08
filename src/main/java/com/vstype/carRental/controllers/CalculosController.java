package com.vstype.carRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vstype.carRental.entities.Entradas;
import com.vstype.carRental.entities.Resultado;
import com.vstype.carRental.services.CalculosService;

@RestController
@RequestMapping("/calculos")
public class CalculosController {
	
	@Autowired
	private CalculosService calculosService;
	
	@GetMapping("/somar")
	public ResponseEntity<Resultado> somar(@RequestBody Entradas entrada){
		try {
			
			Resultado resultado = this.calculosService.somar(entrada);
			return new ResponseEntity<Resultado> (resultado, HttpStatus.OK);
			
		}catch (Exception e) {
			
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
			
		}
	}
}