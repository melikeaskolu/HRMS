package kodlamaio.hrms.entities.concretes;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@AllArgsConstructor
@NoArgsConstructor 
@Table(name="cv_images")
public class CvImage extends Base{

	@Column(name = "url")
	private String url;
	
	
	@OneToOne(optional=false,fetch=FetchType.LAZY)
	@JoinColumn(name = "candidate_id", referencedColumnName = "user_id")
	private Candidate candidate;
	
	
	

}
