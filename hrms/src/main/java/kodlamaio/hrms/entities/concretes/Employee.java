package kodlamaio.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor 
@PrimaryKeyJoinColumn(name="user_id")
@Table(name="employees")
public class Employee extends User{
	
	@NotBlank(message="Name Field cannot be Empty") //Ad Alanı Boş olamaz
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Last Name Field cannot be empty") //Soyadı Alanı boş olamaz
	@Column(name="last_name")
	private String lastName;
	


}
