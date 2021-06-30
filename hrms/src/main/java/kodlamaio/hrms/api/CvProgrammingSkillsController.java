package kodlamaio.hrms.api;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.CvProgrammingSkillService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvProgrammingSkill;

@RestController
@RequestMapping("/api/programmingSkills")
public class CvProgrammingSkillsController {
	
	private CvProgrammingSkillService cvProgrammingSkillService;
	
	@Autowired
	public CvProgrammingSkillsController(CvProgrammingSkillService cvProgrammingSkillService) {
		super();
		this.cvProgrammingSkillService = cvProgrammingSkillService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvProgrammingSkill cvProgrammingSkill){
		return this.cvProgrammingSkillService.add(cvProgrammingSkill);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvProgrammingSkill cvProgrammingSkill){
		return this.cvProgrammingSkillService.update(cvProgrammingSkill);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.cvProgrammingSkillService.delete(id);
	}
	@GetMapping("/getById")
	public DataResult<CvProgrammingSkill> getById(@RequestParam("id") int id){
		return this.cvProgrammingSkillService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<CvProgrammingSkill>> getAll(){
		return this.cvProgrammingSkillService.getAll();
	}
	
	@GetMapping("/getAllByCandidateId")
	public DataResult<List<CvProgrammingSkill>> getAllByCandidateId(@RequestParam int id){
		return this.cvProgrammingSkillService.getAllByCandidateId(id);
	}

}
