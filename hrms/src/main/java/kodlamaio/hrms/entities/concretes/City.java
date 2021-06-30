package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)

@NoArgsConstructor
@Entity
@Table(name="cities")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "jobPostings"})
public class City extends Base{

	@NotBlank(message="This field cannot be left blank.") //Bu alan boş bırakılamaz.
	@Column(name="city_name")
	private String cityName;
	
	@OneToMany(mappedBy = "city")
	private List<JobPosting> jobPostings;
	 
	public City(String cityName, List<JobPosting> jobPostings) {
		super();
		this.cityName = cityName;
		this.jobPostings = jobPostings;
	}
	
	
	

}
