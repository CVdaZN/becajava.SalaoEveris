package br.salaoeveris.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;
import br.salaoeveris.app.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@PostMapping
	public ResponseEntity inserir(@RequestBody ClienteRequest request) {
		try {
			BaseResponse response = service.Inserir(request);
			return ResponseEntity.status(response.statusCode).body(response);
		} catch (Exception e) {
			return ResponseEntity.status(500).body("aa");
		}

	}

}

//	@GetMapping
//	public Request
//}
