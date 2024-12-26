package pe.edu.cibertec.dawii.ms.notificaciones.rmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import pe.edu.cibertec.dawii.ms.notificaciones.model.Notificacion;
import pe.edu.cibertec.dawii.ms.notificaciones.service.NotificacionService;

@Component
public class NotificacionListener {

	private final NotificacionService notificacionService;
	
	public NotificacionListener (NotificacionService notificacionService) {
		this.notificacionService = notificacionService;
	}
	
	@RabbitListener(queues = RabbitMQConfig.QUEUE_NAME)
	public void recibirMensaje(Notificacion notificacion) {
		System.out.println("Notificación recibida con éxito " + notificacion);
		notificacionService.crearNotificacion(notificacion);
	}
	
}
