package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvInformationDao;
import kodlamaio.hrms.entities.concretes.CvInformation;
@Service
public class CvInformationManager implements CvInformationService{
	
	private CvInformationDao cvInformationDao;

	@Autowired
	public CvInformationManager(CvInformationDao cvInformationDao) {
		super();
		this.cvInformationDao = cvInformationDao;
	}

	@Override
	public Result add(CvInformation cvInformation) {
		this.cvInformationDao.save(cvInformation);
		return new SuccessResult("Cv information has been added."); //Cv bilgileri eklendi.
	}

	@Override
	public Result update(CvInformation cvInformation) {
		this.cvInformationDao.save(cvInformation);
		return new SuccessResult("Cv information has been updated."); //Cv bilgileri güncellendi.
	}

	@Override
	public Result delete(int id) {
		this.cvInformationDao.deleteById(id);
        return new SuccessResult("Cv information has been deleted."); //Cv bilgileri silindi.
	}

	@Override
	public DataResult<CvInformation> getById(int id) {
		return new SuccessDataResult<CvInformation>(this.cvInformationDao.getById(id));
	}

	@Override
	public DataResult<List<CvInformation>> getAll() {
		return new SuccessDataResult<List<CvInformation>>(this.cvInformationDao.findAll());
	}

}
