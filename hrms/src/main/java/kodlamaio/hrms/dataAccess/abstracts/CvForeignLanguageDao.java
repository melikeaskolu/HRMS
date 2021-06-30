package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvForeignLanguage;

public interface CvForeignLanguageDao extends JpaRepository<CvForeignLanguage, Integer>{
	CvForeignLanguage getById(int id);
	List<CvForeignLanguage> getAllByCandidate_id(int id);
}
