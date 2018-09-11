package com.skillnet.Servicio;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.skillnet.Converter.ClientConverter;
import com.skillnet.model.Cliente;

@Service("clienteService")
public class CLienService {

	// define a RestTemplate object
	private final RestTemplate restTemplate;

	// web service resources endpoints
	private final String GET_URL_CONSULTAR = "http://172.18.48.140:8280/say/consultar";
	private final String GET_URL_CONSULTARID = "http://172.18.48.140:8280/say/consultarId";
	private final String GET_URL_INSERTAR = "http://172.18.48.140:8280/say/insertar";
	private final String GET_URL_ACTUALIZAR = "http://172.18.48.140:8280/say/actualizar";
	private final String GET_URL_ELIMINAR = "http://172.18.48.140:8280/say/eliminar";

	@Autowired
	public CLienService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public List<Cliente> findAllProducts() {
		return Arrays.stream(restTemplate.getForObject(GET_URL_CONSULTAR, Cliente[].class))
				.collect(Collectors.toList());
	}

	/**
	 * Recibe parametro nit para consumir el servicio de consulta por nit. El json
	 * lo convierte en un objeto java tipo array y luego se tramsforma a un objeto
	 * normal
	 * 
	 * @param nit
	 * @return
	 */
	public ClientConverter findClienteByNit(int nit) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("nit", String.valueOf(nit));
		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<Cliente[]> response = restTemplate.exchange(GET_URL_CONSULTARID, HttpMethod.GET, entity,
				Cliente[].class);
		Cliente[] cliente = response.getBody();
		ClientConverter converter = new ClientConverter();
		for (Cliente cliente2 : cliente) {
			converter.setNit(cliente2.getNit());
			converter.setRazonsocial(cliente2.getRazonsocial());
			converter.setCorreo(cliente2.getCorreo());
			converter.setTelefono(cliente2.getTelefono());
			converter.setUsuario(cliente2.getUsuario());
		}
		return converter;
	}

	public Cliente addCliente(Cliente cliente) {

		HttpHeaders headers = new HttpHeaders();
		headers.set("nit", String.valueOf(cliente.getNit()));
		headers.set("razonsocial", cliente.getRazonsocial());
		headers.set("correo", cliente.getCorreo());
		headers.set("telefono", cliente.getTelefono());
		headers.set("usuario", cliente.getUsuario());

		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(GET_URL_INSERTAR, HttpMethod.GET, entity, String.class);
		return cliente;
	}

	public Cliente UpdateCliente(Cliente cliente) {
		HttpHeaders headers = new HttpHeaders();
		headers.set("nit", String.valueOf(cliente.getNit()));
		headers.set("razonSocial", cliente.getRazonsocial());
		headers.set("correo", cliente.getCorreo());
		headers.set("telefono", cliente.getTelefono());
		headers.set("usuario", cliente.getUsuario());

		HttpEntity entity = new HttpEntity(headers);
		ResponseEntity<String> response = restTemplate.exchange(GET_URL_ACTUALIZAR, HttpMethod.POST, entity,
				String.class);
		return cliente;
	}

	public void removeCliente(int nit) {

		if (0 != nit) {
			HttpHeaders headers = new HttpHeaders();
			headers.set("nit", String.valueOf(nit));
			HttpEntity entity = new HttpEntity(headers);
			ResponseEntity<String> response = restTemplate.exchange(GET_URL_ELIMINAR, HttpMethod.PUT, entity,
					String.class);
		}

	}

}
