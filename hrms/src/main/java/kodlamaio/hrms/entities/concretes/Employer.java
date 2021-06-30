package kodlamaio.hrms.entities.concretes;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

	@Data
	@EqualsAndHashCode(callSuper=false)
	@Entity
	@NoArgsConstructor 
	@PrimaryKeyJoinColumn(name="user_id")
	@Table(name="employers")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPostings"})
	public class Employer extends User{
		
		@NotBlank(message="Company Name Field Cannot Be Empty") //Firma Adı Alanı Boş Geçilemez
		@Column(name="company_name")
		private String companyName;
		
		@NotBlank(message="Website Field Cannot Be Empty") //Web Sitesi Alanı Boş Olamaz
		@Column(name="web")
		private String web;

		@NotBlank(message="Phone Number Field Cannot Be Empty") //Telefon Numarası Alanı Boş Olamaz
		@Column(name="phone_number")
		private String phoneNumber;
		
		@Column(name = "is_verified", columnDefinition = "boolean default false")
		private boolean isVerified = false;
		
			
		@OneToMany(mappedBy = "employer")
		private List<JobPosting> jobPostings;


}
