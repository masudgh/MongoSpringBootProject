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

    @RequestMapping("/people/{name}")
    public List<People> getRecognition(@PathVariable("lastName") String lastName){
        return repository.findByLastName(lastName);
    }

    @RequestMapping("/people")
    public List<People> getColleagues(){
        return repository.findAll();
    }

    @PostMapping("/people")
    
    public ResponseEntity<String> addColleague(@RequestBody People people){
        repository.save(people);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    //This is of course a very naive implementation! We are assuming unique names...
    @DeleteMapping("/people/{lname}")
    public ResponseEntity<String> deleteColleague(@PathVariable  String name){
        List<People> colleagues = repository.findByLastName(name);
        if(colleagues.size() == 1) {
            People colleague = colleagues.get(0);
            repository.delete(colleague);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
