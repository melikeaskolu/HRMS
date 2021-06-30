package kodlamaio.hrms.business.concretes;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvForeignLanguageService;
import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.business.abstracts.CvJobExperienceService;
import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.business.abstracts.CvProgrammingSkillService;
import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@Service
public class CandidateManager implements CandidateService{


	private CandidateDao candidateDao;
	private CvJobExperienceService cvJobExperienceService;
	private CvForeignLanguageService cvForeignLanguageService;
	private CvImageService cvImageService;
	private CvProgrammingSkillService cvProgrammingSkillService;
	private CvLinkService cvLinkService;
	private CvSchoolService cvSchoolService;
	
	
	public CandidateManager(CandidateDao candidateDao, CvJobExperienceService cvJobExperienceService,
			CvForeignLanguageService cvForeignLanguageService, CvImageService cvImageService,
			CvProgrammingSkillService cvProgrammingSkillService, CvLinkService cvLinkService,
			CvSchoolService cvSchoolService) {
		super();
		this.candidateDao = candidateDao;
		this.cvJobExperienceService = cvJobExperienceService;
		this.cvForeignLanguageService = cvForeignLanguageService;
		this.cvImageService = cvImageService;
		this.cvProgrammingSkillService = cvProgrammingSkillService;
		this.cvLinkService = cvLinkService;
		this.cvSchoolService = cvSchoolService;
	}

	
	@Override
	public Result add(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate has been added.");
		
	}


	@Override
	public Result update(Candidate candidate) {
		this.candidateDao.save(candidate);
		return new SuccessResult("Candidate has been updated.");
	}

	@Override
	public Result delete(int id) {
		this.candidateDao.deleteById(id);
		return new SuccessResult("Candidate has been deleted.");
	}
	
	@Override
	public DataResult<Candidate> getById(int id) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getById(id));
	}
	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll());
	}


	@Override
	public DataResult<Candidate> getCandidateByIdentityNumber(String identityNumber) {
		return new SuccessDataResult<Candidate>(this.candidateDao.getCandidateByIdentityNumber(identityNumber));
	}


	@Override
	public DataResult<CandidateCvDto> getCandidateCvById(int id) {
		Candidate candidate = this.candidateDao.getById(id);
		CandidateCvDto cv = new CandidateCvDto();
		cv.experiences = candidate.getExperiences();
		cv.languages = candidate.getLanguages();
		cv.image = candidate.getImage();
		cv.links = candidate.getLinks();
		cv.programingSkills = candidate.getProgramingSkills();
		cv.schools = candidate.getSchools();
		return new SuccessDataResult<CandidateCvDto>(cv);
				
		
	}
	
}
