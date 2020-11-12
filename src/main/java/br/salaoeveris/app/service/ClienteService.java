package br.salaoeveris.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.salaoeveris.app.model.Cliente;
import br.salaoeveris.app.repository.ClienteRepository;
import br.salaoeveris.app.request.ClienteRequest;
import br.salaoeveris.app.response.BaseResponse;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;

	private ClienteRepository _repository;

	public ClienteService(ClienteRepository repository) {
		_repository = repository;
	}

//	public BaseResponse inserir(ClienteRequest request) {
//		BaseResponse base = new BaseResponse();		
//		Cliente cliente = new Cliente();
//		
//		//incluir as regras de negócio (IFs)
//		
////		cliente.setCpf(request.getCpf());
////		cliente.setEndereco(request.getEndereco());
//		cliente.setNome(request.getNome());
//		cliente.setTelefone(request.getTelefone());
//		
//		repository.save(cliente);
//		base.statusCode = 201;
//		base.message = "Cliente inserido com sucesso";
//		return base;		
//	}
//	

//	GUARDA UNICO 

	public BaseResponse Inserir(ClienteRequest request) {
		BaseResponse base = new BaseResponse();
		Cliente cliente = new Cliente();
		base.statusCode = 400;

		if (request.getNome() == "" || request.getNome() == null) {
			base.message = "Insira seu nome: ";
			return base;
		}
		if (request.getEndereco() == null || request.getEndereco() == "") {
			base.message = "Insera seu Endereço corratamente: ";
			return base;
		}
		if (request.getCpf() == null || request.getCpf() == "") {
			;
			base.message = "Insira seu cpf: ";
			return base;
		}
		if (request.getTelefone() == "" || request.getTelefone() == null) {
			base.message = "Insira um telefone valido";
			return base;

		}

		cliente.setCpf(request.getCpf());
		cliente.setEndereco(request.getEndereco());
		cliente.setNome(request.getNome());
		cliente.setTelefone(request.getTelefone());

		repository.save(cliente);
		base.message = "Pronto... Ja est/a cadastrado!!";
		base.statusCode = 201;
		return base;

	}
}

//	
////	LISTAR UNICO 
	public BaseResponse listar(ClienteRequest request) {
		Optional<cliente> cliente = _repository.FindById(Id); 
		Cliente response = new Cliente();
		
		
		}

}
