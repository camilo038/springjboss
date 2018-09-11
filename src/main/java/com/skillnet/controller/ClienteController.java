package com.skillnet.controller;

import java.lang.ProcessBuilder.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.skillnet.Converter.ClientConverter;
import com.skillnet.Servicio.CLienService;
import com.skillnet.constan.viewConstan;
import com.skillnet.model.Cliente;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	// define a service constant

	// Argument contructor of controller, pass in the service
	// and Autowire it
	@Autowired
	@Qualifier("clienteService")
	private CLienService clienteService;

	@GetMapping("/cancel")
	public String cancel() {
		return "redirect:/clientes/vercliente";
	}

	/**
	 * Get all products
	 * 
	 * @param model to bind products to view
	 * @return the products.html page
	 */

	@GetMapping("/vercliente")
	public String getAll(Model model) {
		model.addAttribute("clientes", clienteService.findAllProducts());
		return "clientes";
	}

	/**
	 * Este metodo agrega cliente
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/clientesform")
	public String RedirectClienteForm(Model model) {
		Cliente cliente = new Cliente();
		model.addAttribute("cliente", cliente);
		return viewConstan.CLIENTE_FORM;
	}

	@GetMapping("/clientesEdit")
	public String RedirectEditForm(@RequestParam(name = "nit", required = false) int nit, Model model) {
		ClientConverter cliente = new ClientConverter();
		if (nit != 0) {
			cliente = clienteService.findClienteByNit(nit);
		}
		model.addAttribute("cliente", cliente);
		return viewConstan.CLIENTE_FORM;
	}

	@GetMapping("/addCliente")
	public String addCliente(@ModelAttribute(name = "cliente") Cliente cliente, Model model) {

		if (clienteService.findClienteByNit(cliente.getNit()).getNit()!=cliente.getNit()) {
			
			if (null != clienteService.addCliente(cliente)) {

				model.addAttribute("resul", 1);
			} else {
				model.addAttribute("resul", 0);
			}
		} else {
			
			if (null != clienteService.UpdateCliente(cliente)) {

				model.addAttribute("resul", 1);
			} else {
				model.addAttribute("resul", 0);
			}
		}

		return "redirect:/clientes/vercliente";
	}
	
	@GetMapping("/removecliente")
	public String removeCliente(@RequestParam(name="nit",required=false )int nit) {
		clienteService.removeCliente(nit);
		return "redirect:/clientes/vercliente";
	}
	
	

}
