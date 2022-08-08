package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfilesService {


	 @Autowired
	 private ProfilesRepository repo;
	
	 public List<Profiles> listAll() {
	        return repo.findAll();
	    }
	 public void save(Profiles profiles) {
		 repo.save(profiles);
}
	  public Profiles get(long id) {
	        return repo.findById(id).get();
	    }
}