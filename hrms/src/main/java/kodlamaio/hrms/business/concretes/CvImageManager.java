package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.core.imageUpload.ImageUploadService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.core.utilities.result.SuccessDataResult;
import kodlamaio.hrms.core.utilities.result.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CvImageDao;
import kodlamaio.hrms.entities.concretes.CvImage;

@Service
public class CvImageManager implements CvImageService {
	private CvImageDao cvImageDao;
	private ImageUploadService imageUploadService;

	@Autowired
	public CvImageManager(CvImageDao cvImageDao, ImageUploadService imageUploadService) {
		super();
		this.cvImageDao = cvImageDao;
		this.imageUploadService = imageUploadService;
	}

	@Override
	public Result add(CvImage cvImage, MultipartFile imageFile) {
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Image has been added.");  //Resim eklendi.
	}

	@Override
	public Result update(CvImage cvImage) {
		this.cvImageDao.save(cvImage);
		return new SuccessResult("Image has been updated."); //Resim güncellendi.
	}

	@Override
	public Result delete(int id) {
		this.cvImageDao.deleteById(id);
		return new SuccessResult("Image has been deleted."); //Resim silindi.
	}

	@Override
	public DataResult<CvImage> getById(int id) {
		return new SuccessDataResult<CvImage>(this.cvImageDao.getById(id));
	}

	@Override
	public DataResult<List<CvImage>> getAll() {
		return new SuccessDataResult<List<CvImage>>(this.cvImageDao.findAll());	}

	@Override
	public DataResult<CvImage> getByCandidateId(int id) {
		return new SuccessDataResult<CvImage>(this.cvImageDao.getByCandidate_id(id));
	}

}
