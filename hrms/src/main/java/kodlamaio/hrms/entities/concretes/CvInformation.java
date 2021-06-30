package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;


import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Table(name="cv_informations")
public class CvInformation extends Base{
	
	@Column(name="cover_letter")
	private String coverLetter;
	
	public CvInformation(String coverLetter, int candidateId) {
		super();
		this.coverLetter = coverLetter;
		this.candidate.setId(candidateId);
	}
	
	@ManyToOne()
	@JoinColumn(name = "candidate_id")
	@JsonIgnore
	private Candidate candidate;
	
	

	
	

}
