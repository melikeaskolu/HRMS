package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvForeignLanguageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvForeignLanguageDao;
import kodlamaio.hrms.entities.concretes.CvForeignLanguage;
@Service
public class CvForeignLanguageManager implements CvForeignLanguageService {
	private CvForeignLanguageDao CvForeignLanguageDao;

	@Autowired
	public CvForeignLanguageManager(CvForeignLanguageDao cvForeignLanguageDao) {
		super();
		CvForeignLanguageDao = cvForeignLanguageDao;
	}

	@Override
	public Result add(CvForeignLanguage cvForeignLanguage) {
		this.CvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("Foreign language has been added.");  //Yabancı dil eklendi.
	}

	@Override
	public Result update(CvForeignLanguage cvForeignLanguage) {
		this.CvForeignLanguageDao.save(cvForeignLanguage);
		return new SuccessResult("Foreign language has been updated.");  //Yabancı dil güncellendi.
	}

	@Override
	public Result delete(int id) {
		this.CvForeignLanguageDao.deleteById(id);;
		return new SuccessResult("Foreign language has been deleted.");  //Yabancı dil silindi.
	}

	@Override
	public DataResult<CvForeignLanguage> getById(int id) {
		return new SuccessDataResult<CvForeignLanguage>(this.CvForeignLanguageDao.getById(id));

	}

	@Override
	public DataResult<List<CvForeignLanguage>> getAll() {
		return new SuccessDataResult<List<CvForeignLanguage>>(this.CvForeignLanguageDao.findAll());

	}

	@Override
	public DataResult<List<CvForeignLanguage>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvForeignLanguage>>(this.CvForeignLanguageDao.getAllByCandidate_id(id));

	}

}
