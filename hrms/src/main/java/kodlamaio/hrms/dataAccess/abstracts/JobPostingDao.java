package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer>{
	@Query("From JobPosting where isOpen = true")
	List<JobPosting> getAllOpenJobPostingList();
	
	
	@Query("From JobPosting where isActive = true and employer_id =:id")
	List<JobPosting> getAllByOpenJobPostingByEmployer(int id);
	
	@Query("From JobPosting where isActive = true Order By releaseDate Desc")
	List<JobPosting> findAllByOrderByReleaseDate();
	
	JobPosting getById(int id);






}
