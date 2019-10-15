package pe.edu.upn.marriott.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import pe.edu.upn.marriott.models.entity.Habitacion;
import pe.edu.upn.marriott.services.HabitacionService;

@Controller
@RequestMapping("/habitacion")
@SessionAttributes("habitaciones")
public class HabitacionController {
	@Autowired
	private HabitacionService habitacionService;
	
	@GetMapping
	private String inicio(Model model) {
		try {
			List<Habitacion> habitaciones=habitacionService.findAll();
			model.addAttribute("habitaciones", habitaciones);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitacion/inicio";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion=new Habitacion();
		model.addAttribute("habitacion",habitacion);
		
		return "/habitacion/nuevo";
	}

}
