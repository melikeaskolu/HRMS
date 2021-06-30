package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.CvSchoolService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvSchool;

@RestController
@RequestMapping("/api/schools")
public class CvSchoolsController {
	
	private CvSchoolService cvSchoolService;

	@Autowired
	public CvSchoolsController(CvSchoolService cvSchoolService) {
		super();
		this.cvSchoolService = cvSchoolService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvSchool cvSchool){
		return this.cvSchoolService.add(cvSchool);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvSchool cvSchool){
		return this.cvSchoolService.update(cvSchool);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.cvSchoolService.delete(id);
	}
	@GetMapping("/getById")
	public DataResult<CvSchool> getById(@RequestParam int id) {
		return this.cvSchoolService.getById(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<CvSchool>> getAll() {
		return this.cvSchoolService.getAll();
	}

	@GetMapping("/getAllByCandidateIdOrderByEndDateDesc")
	public DataResult<List<CvSchool>> getAllByCandidateIdOrderByEndDateDesc(@RequestParam("id") int id) {
		return this.cvSchoolService.getAllByCandidateIdOrderByEndSchoolDesc(id);
	}

	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvSchool>> getAllByCandidateId(@RequestParam int id) {
		return this.cvSchoolService.getAllByCandidateId(id);
	}

	

}
