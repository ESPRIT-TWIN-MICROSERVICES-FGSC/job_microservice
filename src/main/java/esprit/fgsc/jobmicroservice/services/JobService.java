package esprit.fgsc.jobmicroservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import esprit.fgsc.jobmicroservice.entities.Job;
import esprit.fgsc.jobmicroservice.repository.IJobRepository;

@Service
public class JobService {
	@Autowired
	private IJobRepository jobRepository;
	
	public Job addJob(Job job) {
		return jobRepository.save(job);
		
	}
	public List<Job>getAllJobs(){
		 return jobRepository.findAll();
	}
	
	public String deleteJob(String id) {   

		jobRepository.deleteById(id);
   	return "Job deleted";
	}
          
public Job updateJob(String id,Job newJob) {
	if(jobRepository.findById(id).isPresent()) {
		Job existingJob= jobRepository.findById(id).get();
		existingJob.setDepartement(newJob.getDepartement());
		existingJob.setDetails(newJob.getDetails());
		existingJob.setJobTitle(newJob.getJobTitle());
		existingJob.setLocation(newJob.getLocation());
		existingJob.setPositionType(newJob.getPositionType());
		existingJob.setQualifications(newJob.getQualifications());
		
		
		return jobRepository.save(existingJob);
		
	}else {
		return null;
	}
}

public Job getJobById(String id) {
	return jobRepository.findById(id).get();
	
}
}
