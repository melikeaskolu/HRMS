package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

	@Data
	@Entity
	@AllArgsConstructor
	@NoArgsConstructor 
	@Table(name="employer_users")
	public class Employer extends User{
		@Column(name="company_name")
		private int company_name;
		
		@Column(name="web_address")
		private String web_address;
		

}
