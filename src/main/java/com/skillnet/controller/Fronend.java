package com.skillnet.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.skillnet.model.Persona;


@Controller
@RequestMapping("/ejemplo")
public class Fronend {

	
	
	
	// desclaracion para hacer realitovo el nomre ubicacion
		public static final String EXAMPLE_VIER = "example";

		// creo segundo contexto

		@GetMapping("/ejemploString")
		public String ejemploString(Model model) {

			// lleno el span del tempal exmaple
			// llamada a la lista
			model.addAttribute("people", getPeople());
			return EXAMPLE_VIER;

		}

		// otra forma

		private Object getPeople() {
			// TODO Auto-generated method stub
			return null;
		}

		@GetMapping("/ejemploMVA")
		public ModelAndView ejemploMVA() {

			ModelAndView mav = new ModelAndView(EXAMPLE_VIER);
			// llamado de la lista

			mav.addObject("people", getPeople());
			return mav;
		}

	
		//creo  la lista  la  asocio  a la clase  java
		private List<Persona> getPeople1(){
			List<Persona> people = new ArrayList<>();
			people.add(new  Persona("insernombre con lista", 23));
			people.add(new  Persona("Juan", 24));
			people.add(new  Persona("jorge", 23));


			return people;
		}  

		
	}


	

