package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CvInformationService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.CvInformation;

@RestController
@RequestMapping("/api/cvInformations")
public class CvInformationsController {
	
	private CvInformationService cvInformationService;

	@Autowired
	public CvInformationsController(CvInformationService cvInformationService) {
		super();
		this.cvInformationService = cvInformationService;
	}
	
	@PostMapping("/add")
	public Result add(@RequestBody CvInformation cvInformation) {
		return this.cvInformationService.add(cvInformation);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody CvInformation cvInformation) {
		return this.cvInformationService.update(cvInformation);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.cvInformationService.delete(id);
		}
	
	@GetMapping("/getById")
	public DataResult<CvInformation> getById(@RequestParam("id") int id){
		return this.cvInformationService.getById(id);
	}
	
	@GetMapping("/getAll")
	public DataResult<List<CvInformation>> getAll(){
		return this.cvInformationService.getAll();
	}
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
