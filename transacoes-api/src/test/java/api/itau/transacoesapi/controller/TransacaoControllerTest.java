package api.itau.transacoesapi.controller;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.kohsuke.rngom.digested.DEmptyPattern;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;

import api.itau.transacoesapi.TransacoesApiApplication;
import api.itau.transacoesapi.model.Transacao;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TransacaoControllerTest extends TransacoesApiApplication {
	
	@Autowired
	private TestRestTemplate restTemplate;

	@Autowired 
	private MockMvc mockMvc;	
	
	@Autowired
	private TransacaoController transacaoController;
	
	@Before
	public void setUp() {
	
	}
	
	@Test
	public void postTransacaoTest() 
	{
		/*Transacao transacao = new Transacao();
		
		
		BDDMockito.when(transacaoController.postTransacao().thenReturn()) */
	}
	
	
	
}
