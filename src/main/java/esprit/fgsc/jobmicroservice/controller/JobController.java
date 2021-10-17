package esprit.fgsc.jobmicroservice.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import esprit.fgsc.jobmicroservice.entities.Job;
import esprit.fgsc.jobmicroservice.services.JobService;


@CrossOrigin(origins = "*")
@RestController
public class JobController {
	@Autowired
	private  JobService jobService;

	@PostMapping("/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Job> createJob(@RequestBody Job job) {
		return new ResponseEntity<>(jobService.addJob(job), HttpStatus.OK);
	}
	
	@GetMapping("/job")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Job> >getAllJobs(){
		 return new ResponseEntity<>(jobService.getAllJobs(),HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteJob(@PathVariable String id) {
	    return jobService.deleteJob(id.toString());
	}

	@PutMapping("/update/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Job> updateJob(@PathVariable("id") String id,@Valid @RequestBody Job job) {
		return new ResponseEntity<>(jobService.updateJob(id, job),HttpStatus.OK);
	}
}
