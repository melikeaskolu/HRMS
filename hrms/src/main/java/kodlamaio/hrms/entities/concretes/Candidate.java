package kodlamaio.hrms.entities.concretes;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="candidates")
public class Candidate extends User {
	
	@NotBlank(message="Name Field cannot be Empty") //Ad Alanı Boş olamaz
	@Size(min = 3, message = "You must use at least 3 characters in the name field")  //Ad alanında en az 3 karakter kullanmalısınız
	@Column(name = "first_name")
	private String firstName;

	@NotBlank(message="Last Name Field cannot be empty") //Soyadı Alanı boş olamaz
	@Column(name = "last_name")
	private String lastName;

	@NotBlank(message="TR Identity Number Field Cannot Be Empty")  //TC Kimlik No Alanı Boş Bırakılamaz
	@Size(min = 11, max=11, message = "TR ID Number must be 11 digits") //TC Kimlik Numarası 11 haneli olmalıdır
	@Column(name = "identity_number")
	private String identityNumber;

	@NotBlank(message="Birth Year Field Cannot Be Empty") //Doğum Yılı Alanı Boş Geçilemez
	@Column(name = "birth_date")
	private Date birthDate;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvSchool> schools;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvProgrammingSkill> programingSkills;

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvForeignLanguage> languages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvJobExperience> experiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvInformation> informations;	

	@JsonIgnore
	@OneToOne(mappedBy = "candidate", fetch=FetchType.LAZY)
	private CvImage image;
	

	@JsonIgnore
	@OneToMany(mappedBy = "candidate")
	private List<CvLink> links;




}
