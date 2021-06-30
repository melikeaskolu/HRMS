package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvJobExperience;

public interface CvJobExperienceDao extends JpaRepository<CvJobExperience, Integer> {
	CvJobExperience getById(int id);
	List<CvJobExperience> getAllByCandidate_idOrderByEndDateDesc(int id);
	List<CvJobExperience> getAllByCandidate_id(int id);

}