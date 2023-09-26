/*
package br.com.pizzaria.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.pizzaria.service.GeraRelatorioService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/relatorios")
@RequiredArgsConstructor
public class RelatoriosController {
	
	private final GeraRelatorioService service;
	
	@GetMapping("/lista-de-clientes/") 
	public void docDevolucao(@RequestParam Map<String, Object> parametros, HttpServletResponse response) throws JRException, IOException, ParseException, URISyntaxException {
		service.gerarRelatorioClientes(parametros, response);
	}

}
*/
