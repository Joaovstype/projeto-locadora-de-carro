package com.vstype.carRental.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vstype.carRental.entities.Carro;
import com.vstype.carRental.services.CarroService;

@RestController
@RequestMapping("/carro")
public class CarroController {

		@Autowired
		private CarroService carroService;
		
		@PostMapping("/save")
		public ResponseEntity<String> save(@RequestBody Carro carro){
			
			try {
				
				String mensagem = this.carroService.save(carro);
				return new ResponseEntity<String>(mensagem, HttpStatus.OK);
				
			}catch(Exception e) {
				
				return new ResponseEntity<String>("Erro ao salvar!", HttpStatus.BAD_REQUEST);
				
			}
		}
		
		
		@GetMapping("/findById/{id}")
		public ResponseEntity<Carro> findById(@PathVariable Long id){
			
			try {
				
				Carro carro = this.carroService.findById(id);
				return new ResponseEntity<>(carro, HttpStatus.OK);
				
			}catch(Exception e) {
				
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
			}
			
		}	
			
		@DeleteMapping("/delete/{id}")
		public ResponseEntity<Void> deleteCarro(@PathVariable Long id){
			
			
			try {
				
				Carro carro = carroService.findById(id); 
				
	            if (carro == null) {
	                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	            }
	            
				this.carroService.delete(carro);
				return new ResponseEntity<>(null, HttpStatus.OK);
				
			}catch(Exception e) {
				
				return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
				
			}
			
			
		}
			
	}
		

