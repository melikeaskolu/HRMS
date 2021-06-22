package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


	@Data
	@Entity
	@AllArgsConstructor
	@NoArgsConstructor 
	@Table(name="activation_codes")
	public class ActivationCode {
		@Id
		@GeneratedValue
		@Column(name="id")
		private int id;
		
		@Column(name="activation_code")
		private String code;
		
		@Column(name="is_confirmed")
		private String is_confirmed;
		
		@Column(name="confirmed_date")
		private String confirmed_date;
		
		
		
		



}
