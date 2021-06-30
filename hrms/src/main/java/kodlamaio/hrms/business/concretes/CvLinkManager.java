package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CvLinkService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvLinkDao;
import kodlamaio.hrms.entities.concretes.CvLink;

@Service
public class CvLinkManager implements CvLinkService{
	
	private CvLinkDao cvLinkDao;

	@Autowired
	public CvLinkManager(CvLinkDao cvLinkDao) {
		super();
		this.cvLinkDao = cvLinkDao;
	}

	@Override
	public Result add(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link has been added.");  //Bağlantı eklendi.
	}

	@Override
	public Result update(CvLink cvLink) {
		this.cvLinkDao.save(cvLink);
		return new SuccessResult("Link has been updated.");  //Bağlantı güncellendi.
	}

	@Override
	public Result delete(int id) {
		this.cvLinkDao.deleteById(id);
		return new SuccessResult("Link has been deleted.");  //Bağlantı silindi.
	}

	@Override
	public DataResult<CvLink> getById(int id) {
		return new SuccessDataResult<CvLink>(this.cvLinkDao.getById(id));
	}

	@Override
	public DataResult<List<CvLink>> getAll() {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.findAll());

	}

	@Override
	public DataResult<List<CvLink>> getAllByCandidateId(int id) {
		return new SuccessDataResult<List<CvLink>>(this.cvLinkDao.getAllByCandidate_id(id));

	}

}
