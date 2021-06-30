package kodlamaio.hrms.entities.concretes;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


	@Data
	@EqualsAndHashCode(callSuper=false)
	@Entity
	@NoArgsConstructor 
	@Table(name="users")
	@Inheritance (strategy = InheritanceType.JOINED)
	public class User extends Base {
		
		@Column(name= "email")
		private String email;
		
		@Column(name= "password")
		private String password;

		public User(String email, String password) {
			super();
			this.email = email;
			this.password = password;
		}



}
