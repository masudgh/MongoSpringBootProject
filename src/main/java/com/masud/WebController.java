package com.masud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

	@Autowired
    private PeopleRepository repository;

    @RequestMapping("/people/{lastName}")
    public List<People> getRecognition(@PathVariable("lastName") String lastName){
    		List<People> lp = repository.findByLastName(lastName);
    		return lp;
    }

    @RequestMapping("/people")
    public List<People> getPeople(){
        return repository.findAll();
    }

    @PostMapping("/people")
    
    public ResponseEntity<String> addPeople(@RequestBody People people){
        repository.save(people);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //This is of course a very naive implementation! We are assuming unique names...
    @DeleteMapping("/people/{lastName}")
    public ResponseEntity<String> deletePeople(@PathVariable("lastName")  String lastName){
        List<People> people = repository.findByLastName(lastName);
        if(people.size() == 1) {
            People p = people.get(0);
            repository.delete(p);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
