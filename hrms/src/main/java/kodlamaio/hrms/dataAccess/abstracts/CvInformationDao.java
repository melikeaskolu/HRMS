package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.CvInformation;

public interface CvInformationDao extends JpaRepository<CvInformation, Integer>{
	CvInformation getById(int id);

}
