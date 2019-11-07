package br.com.pizzaria.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pizzaria.domain.dto.RelatorioClientesDto;
import br.com.pizzaria.service.ClientesService;
import br.com.pizzaria.service.GeraRelatorioService;
import lombok.RequiredArgsConstructor;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

@Service
@RequiredArgsConstructor
public class GeraRelatorioServiceImpl implements GeraRelatorioService {

	@Autowired
	private ClientesService service;

	@Override
	public void gerarRelatorioClientes(Map<String, Object> parametros, HttpServletResponse response) throws JRException, IOException {		


		//Busca o arquivo na raiz e compila gerando o .jasper
		//JasperCompileManager.compileReportToFile("clientes.jrxml");
		
		
		//Exemplo de passagem de parametros para jrxml
		/*ClassPathResource res = new ClassPathResource("/relatorios/");
		
		String caminhoRaiz = res.getPath();
		
		String caminhoLogo = caminhoRaiz + "logo.jpg";
		String caminhoTitulo = caminhoRaiz + "titulo.jpg";		
	
		parametros = parametros == null ? parametros = new HashMap<>() : parametros;
		
		parametros.put("IMG_LOGO", caminhoLogo);
		parametros.put("IMG_TITULO", caminhoTitulo);*/
		
		//ListRelatorioClientesDto> clientes = service.buscar(null,null,null);
		
		//JRDataSource dataSource = new JRBeanCollectionDataSource(clientes, false);

		InputStream jasperStream = this.getClass().getResourceAsStream("/relatorios/clientes.jasper");

		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, dataSource);

		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=clientes.pdf");

		final OutputStream outStream = response.getOutputStream();
		//JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);

	}

}
