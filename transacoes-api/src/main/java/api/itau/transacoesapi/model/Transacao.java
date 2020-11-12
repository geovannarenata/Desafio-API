package api.itau.transacoesapi.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Transacao {
	
	private static List<Transacao> repository = new ArrayList<>();
	
	/*@PositiveOrZero(message = "Insira um valor válido.") */
	private double valor;
	
	@NotNull
	@PastOrPresent(message = "Insira uma data válida.")
	@DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", iso = ISO.DATE_TIME)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'") 
	private LocalDateTime dataHora; 
	
	/*Getters e Setters */ 
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public LocalDateTime getDataHora() {
		return dataHora;
	}
	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}
	public static List<Transacao> getRepository() {
		return repository;
	}
	public static void setRepository(List<Transacao> repository) {
		Transacao.repository = repository;
	}
	
	
	
	

}
