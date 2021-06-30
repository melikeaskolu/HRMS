package kodlamaio.hrms.entities.dtos;

import java.util.List;

import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;
import kodlamaio.hrms.entities.concretes.CvImage;
import kodlamaio.hrms.entities.concretes.CvJobExperience;
import kodlamaio.hrms.entities.concretes.CvLink;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkill;
import kodlamaio.hrms.entities.concretes.CvSchool;

public class CandidateCvDto {

	public Candidate candidate;
	public List<CvSchool> schools;
	public List<CvProgrammingSkill> programingSkills;
	public List<CvLink> links;
	public List<CvForeignLanguage> languages;
	public List<CvJobExperience> experiences;
	public CvImage image;

}
