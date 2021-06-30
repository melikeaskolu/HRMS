package kodlamaio.hrms.api;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.hrms.business.abstracts.JobPostingService;
import kodlamaio.hrms.core.utilities.result.DataResult;
import kodlamaio.hrms.core.utilities.result.Result;
import kodlamaio.hrms.entities.concretes.JobPosting;


	@RestController
	@RequestMapping("/api/jobpostins")
	public class JobPostingsController {
		private JobPostingService jobPostingService;

		@Autowired
		public JobPostingsController(JobPostingService jobPostingService) {
			super();
			this.jobPostingService = jobPostingService;
		}
		
		@PostMapping("/add")
		
		public Result add(@RequestBody JobPosting jobPosting){
			return this.jobPostingService.add(jobPosting);
		}
	//	
//		@PostMapping("/update")
//	public Result add(@RequestBody JobPosting jobPosting){
	//	return this.jobPostingService.add(jobPosting);
//		}
	//	
//		@PostMapping("/delete")
//		public Result delete(@RequestParam("id") int id){
//			return this.jobPostingService.delete(id);
//		}
	//
		
		@GetMapping("/getById")
		public DataResult<JobPosting> getById(@RequestParam int id){
			return this.jobPostingService.getById(id);
		}
		
		@GetMapping("/getall")
		public DataResult<List<JobPosting>> getAll(){
			return this.jobPostingService.getAll();
		}
		
		@PostMapping("/changeOpenToClose")
		public Result changeOpenToClose(@RequestParam int id){
			return this.jobPostingService.changeOpenToClose(id);
		}
		
		@GetMapping("/getAllOpenJobPostingList")
		public DataResult<List<JobPosting>> getAllOpenJobPostingList(){
			return this.jobPostingService.getAllOpenJobPostingList();
		}
		
		@GetMapping("/findAllByOrderByReleaseDate")
		public DataResult<List<JobPosting>> findAllByOrderByReleaseDate(){
			return this.jobPostingService.findAllByOrderByReleaseDate();
		}
		
		@GetMapping("/getAllOpenJobPostingByEmployer")
		public DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(@RequestParam int id){
			return this.jobPostingService.getAllByOpenJobPostingByEmployer(id);
		}
	
	

}
