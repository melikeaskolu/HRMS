package kodlamaio.hrms.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.Candidate;
import kodlamaio.hrms.entities.dtos.CandidateCvDto;

@RestController
@RequestMapping("/api/candidates")
public class CandidatesController {
	private CandidateService candidateService;

	@Autowired
	public CandidatesController(CandidateService candidateService) {
		super();
		this.candidateService = candidateService;
	}
	  @PostMapping("/add")
	    public Result add(@RequestBody Candidate candidate) {
	    	return this.candidateService.add(candidate);
	    	
	  }
	//	
//		@PostMapping("/update")
//		public Result update(@RequestBody Candidate candidate){
//			return this.candidateService.update(candidate);
//		}
	//	
//		@PostMapping("/delete")
//		public Result delete(@RequestParam("id") int id){
//			return this.candidateService.delete(id);
//		}
	//	
//		@GetMapping("/getById")
//		public DataResult<Candidate> getById(@RequestParam("id") int id){
//			return this.candidateService.getById(id);
//		}
	@GetMapping("/getall")
	public DataResult<List<Candidate>> getAll(){
		return this.candidateService.getAll();
	}

	@GetMapping("/getCandidateCVById")
	public DataResult<CandidateCvDto> getCandidateCvById(@RequestParam int id){
		return this.candidateService.getCandidateCvById(id);
	}
	

}
