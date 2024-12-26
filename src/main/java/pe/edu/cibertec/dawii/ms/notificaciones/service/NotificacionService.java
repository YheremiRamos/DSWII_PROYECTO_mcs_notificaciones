package pe.edu.cibertec.dawii.ms.notificaciones.service;

import java.util.List;
import java.util.Optional;

import pe.edu.cibertec.dawii.ms.notificaciones.model.Notificacion;

public interface NotificacionService {

	
	List<Notificacion> obtenerTodosNotificaciones();

	Optional<Notificacion> obtenerNotificacionPorId(Long idNotificacion);

	Optional<Notificacion> obtenerNotificacionPorEmail(String email);

	Notificacion crearNotificacion(Notificacion notificacion);

}
