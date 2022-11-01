package com.tcci.gt.apidocument.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcci.gt.apidocument.util.CreateDocumentSimple;

@RestController
@RequestMapping("/documentController")
public class DocumentController {

	@GetMapping("/documento")
	ResponseEntity<String> documento(){
		CreateDocumentSimple simple = new CreateDocumentSimple();
		simple.creaDocumento();
		return ResponseEntity.ok("ok");
	}
	
}
