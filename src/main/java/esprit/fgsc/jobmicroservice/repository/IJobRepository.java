package esprit.fgsc.jobmicroservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import esprit.fgsc.jobmicroservice.entities.Job;

public interface IJobRepository extends MongoRepository<Job, String> {

}
