package kodlamaio.hrms.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Table(name="cv_programming_skills")
public class CvProgrammingSkill extends Base {
	
		@Column(name = "skill_name")
		private String skillName;
		
		
		@ManyToOne()
		@JoinColumn(name = "candidate_id")
		private Candidate candidate;
		
		
		

	}

