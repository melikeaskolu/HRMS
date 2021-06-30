package kodlamaio.hrms.core.imageUpload;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.result.DataResult;

public interface ImageUploadService {
	DataResult<Map> uploadImageFile(MultipartFile imageFile);

}
