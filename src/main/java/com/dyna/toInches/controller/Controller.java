package com.dyna.toInches.controller;


import com.dyna.toInches.model.Model;
import com.dyna.toInches.repository.Repo;
import com.dyna.toInches.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/books/")
public class Controller {

    public Repo repo;
    private Service service;

    @Autowired
    public void setService(Service service){
        this.service = service;
    }

    @RequestMapping(path = "{title}", method = RequestMethod.GET)
    public Model getModel(@PathVariable(name = "title") String title){
        return service.getModel(title);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Model saveModel(@RequestBody Model model){
        return service.saveModel(model);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Model updateModel(@RequestBody Model model, @PathVariable(name = "title") String title){
        Model book = repo.findById(title).get();
        return service.updateModel(model, title);
    }

    @RequestMapping(path = "title", method = RequestMethod.DELETE)
    public void deleteModel(@PathVariable(name = "title") String title){
        service.deleteModel(title);
    }

}
