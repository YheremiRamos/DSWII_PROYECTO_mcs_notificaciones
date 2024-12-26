package pe.edu.cibertec.dawii.ms.notificaciones.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity				  // marcar a la clase como una entidad JPA
@Data				  // set y get + toString + equals + hashcode	
@NoArgsConstructor    //agregar un constructor sin paràmetros
@AllArgsConstructor   //agregar un constructor con paràmetros
public class Notificacion implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //indicar que serà autogenerado el campo
	private Long id;
	@Column(length = 50)
	private String asunto;
	@Column(length = 100)
	private String contenido;
	@Column(length = 50)
	private String email;
	private Date fechaRegistro;
	
}
