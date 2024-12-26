package pe.edu.cibertec.dawii.ms.notificaciones.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.cibertec.dawii.ms.notificaciones.model.Notificacion;
import pe.edu.cibertec.dawii.ms.notificaciones.service.NotificacionService;



@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionController {

	@Autowired
	NotificacionService NotificacionService;
	
	@GetMapping
	public List<Notificacion> listarNotificacions(){
		return NotificacionService.obtenerTodosNotificaciones();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Notificacion> obtenerNotificacionPorId(@PathVariable Long id){
		Optional<Notificacion> Notificacion = NotificacionService.obtenerNotificacionPorId(id);
		return Notificacion
				.map(ResponseEntity::ok)  // 200 en caso de encontrar
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no existe
	}
	
	@GetMapping("/filtros/email")
	public ResponseEntity<Notificacion> obtenerNotificacionPorEmail(@RequestParam String email){
		Optional<Notificacion> Notificacion = NotificacionService.obtenerNotificacionPorEmail(email);
		return Notificacion
				.map(ResponseEntity::ok)  // 200 en caso de encontrar
				.orElseGet(() -> ResponseEntity.notFound().build()); // 404 si no existe
	}
	
	@PostMapping
	public Notificacion crearNotificacion(@RequestBody Notificacion Notificacion) {
		return NotificacionService.crearNotificacion(Notificacion);
	}
	
	
	
}
