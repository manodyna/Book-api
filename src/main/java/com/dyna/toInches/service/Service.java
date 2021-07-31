package com.dyna.toInches.service;

import com.dyna.toInches.model.Model;
import com.dyna.toInches.repository.Repo;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.stereotype.Service

public class Service {
    private Repo repo;

    

    @Autowired
    public void setRepository(Repo repo){
        this.repo = repo;
    }

    public Model getModel(String title){
        return repo.findById(title).get();
    }

    public Model saveModel(Model model){
        return repo.save(model);
    }

    public Model updateModel(Model model, String title){
           Model book= repo.findById(title).get();
           if (book!=null){
               book.setTitle(book.getTitle());
               book.setAuthor(book.getAuthor());
               book.setPrice(book.getPrice());
               return repo.save(book);
           }else{
//               LOG.info("no book found with given details");
               return book;
           }
    }

    public void deleteModel(String title){
        Model book = repo.findById(title).get();
        if (book != null){
            repo.delete(book);
        } else {
//             LOG.info("no book found with given details");
        }    
    }
}
