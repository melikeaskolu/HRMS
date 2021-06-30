package kodlamaio.hrms.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.CvImageService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.concretes.CvImage;


@RestController
@RequestMapping("/api/images")
public class CvImagesController {

	private CvImageService cvImageService;
	private CandidateService candidateService;

	@Autowired
	public CvImagesController(CvImageService cvImageService, CandidateService candidateService) {
		super();
		this.cvImageService = cvImageService;
		this.candidateService = candidateService;
	}
	
	@PostMapping(value="/add")
	public Result add(@RequestParam(value = "id") int id, @RequestParam(value = "imageFile") MultipartFile imageFile ) {
		Candidate candidate = this.candidateService.getById(id).getData();
		CvImage cvImage = new  CvImage();
		cvImage.setCandidate(candidate);
		return this.cvImageService.add(cvImage, imageFile);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvImage cvImage){
		return this.cvImageService.update(cvImage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cvImageService.delete(id);
	}
	
	
	@GetMapping("/getById")
	public DataResult<CvImage> getById(@RequestParam("id") int id){
		return this.cvImageService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvImage>> getAll(){
		return this.cvImageService.getAll();
	}
	
	@GetMapping("/getByCandidateId")
	public DataResult<CvImage> getByCandidateId(@RequestParam int id){
		return this.cvImageService.getByCandidateId(id);
		}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
