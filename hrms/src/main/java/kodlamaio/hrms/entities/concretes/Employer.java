package kodlamaio.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

	@Data
	@EqualsAndHashCode(callSuper=false)
	@Entity
	@AllArgsConstructor
	@NoArgsConstructor 
	@PrimaryKeyJoinColumn(name="id", referencedColumnName = "id")
	@Table(name="employer_users")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobs"})
	public class Employer extends User{
		@Column(name="company_name")
		private String company_name;
		
		@Column(name="web_address")
		private String web_address;

		@Column(name="phone_number")
		private String phone_number;
		


}
