package kodlamaio.hrms.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.CvJobExperienceService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvJobExperience;

@RestController
@RequestMapping("/api/experiences")
public class CvJobExperiencesController {

	private CvJobExperienceService cvJobExperiencesService;

	@Autowired
	public CvJobExperiencesController(CvJobExperienceService cvJobExperiencesService) {
		super();
		this.cvJobExperiencesService = cvJobExperiencesService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CvJobExperience cvJobExperience) {
		return this.cvJobExperiencesService.add(cvJobExperience);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CvJobExperience cvJobExperience) {
		return this.cvJobExperiencesService.update(cvJobExperience);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.cvJobExperiencesService.delete(id);
	}

	@GetMapping("/getById")
	public DataResult<CvJobExperience> getById(@RequestParam int id) {
		return this.cvJobExperiencesService.getById(id);
	}

	@GetMapping("/getAll")
	public DataResult<List<CvJobExperience>> getAll() {
		return this.cvJobExperiencesService.getAll();
	}

	@GetMapping("/getAllByCandidateIdOrderByEndDateDesc")
	public DataResult<List<CvJobExperience>> getAllByCandidateIdOrderByEndDateDesc(@RequestParam("id") int id) {
		return this.cvJobExperiencesService.getAllByCandidateIdOrderByEndDateDesc(id);
	}

	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvJobExperience>> getAllByCandidateId(@RequestParam int id) {
		return this.cvJobExperiencesService.getAllByCandidateId(id);
	}

}
