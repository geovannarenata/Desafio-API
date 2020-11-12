package api.itau.transacoesapi.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.itau.transacoesapi.model.Transacao;


@CrossOrigin("*")
@RestController
@RequestMapping("/transacao")
public class TransacaoController {
	
	private List<Transacao> repository = Transacao.getRepository();
	
	@PostMapping
	public synchronized ResponseEntity<Transacao> postTransacao(@Valid @RequestBody Transacao movimentacao)
	{		
			if (movimentacao.getValor() < 0  || movimentacao.getDataHora().isAfter(LocalDateTime.now())) 
			{
				return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(null);
			}
			else
			{
				repository.add(movimentacao);
				return ResponseEntity.status(HttpStatus.CREATED).body(null);
			} 
	}
	
	@DeleteMapping
	public synchronized ResponseEntity<Transacao> deleteTransacao()
	{
		repository.clear();
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	

}
