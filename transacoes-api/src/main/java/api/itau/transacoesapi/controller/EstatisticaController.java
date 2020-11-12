package api.itau.transacoesapi.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import api.itau.transacoesapi.model.Transacao;

@RestController
@RequestMapping("/estatistica")
@CrossOrigin("*")
public class EstatisticaController {

	private List<Transacao> repository = Transacao.getRepository();
	
	@GetMapping
	public synchronized ResponseEntity<DoubleSummaryStatistics> getEstatistica()
	{
		DoubleSummaryStatistics estatisticas = new DoubleSummaryStatistics();
		repository.stream().filter(resp -> resp.getDataHora().isAfter(LocalDateTime.now().minusMinutes(1)))
		
		.forEach(resposta -> estatisticas.accept(resposta.getValor()));
		return ResponseEntity.status(HttpStatus.OK).body(estatisticas);
	}
	
}
