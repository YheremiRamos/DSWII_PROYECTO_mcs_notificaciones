package pe.edu.cibertec.dawii.ms.notificaciones.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.dawii.ms.notificaciones.model.Notificacion;
import pe.edu.cibertec.dawii.ms.notificaciones.repository.NotificacionRepository;
import pe.edu.cibertec.dawii.ms.notificaciones.service.NotificacionService;

@Service
public class NotificacionServiceImpl implements NotificacionService {

	@Autowired
	private NotificacionRepository notificacionRepository;

	@Override
	public List<Notificacion> obtenerTodosNotificaciones() {
		return notificacionRepository.findAll();
	}

	@Override
	public Optional<Notificacion> obtenerNotificacionPorId(Long idNotificacion) {
		return notificacionRepository.findById(idNotificacion);
	}

	@Override
	public Optional<Notificacion> obtenerNotificacionPorEmail(String email) {
		return notificacionRepository.findByEmail(email);
	}

	@Override
	public Notificacion crearNotificacion(Notificacion notificacion) {
		notificacion.setFechaRegistro(new Date());
		return notificacionRepository.save(notificacion);
	}

}
