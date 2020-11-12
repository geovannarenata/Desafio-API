package api.itau.transacoesapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import api.itau.transacoesapi.model.Transacao;

@Service
public class TransacaoService {
	
	public List<Transacao> repository = new ArrayList<>();

}
