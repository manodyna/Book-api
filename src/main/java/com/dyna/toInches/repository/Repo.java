package com.dyna.toInches.repository;

import com.dyna.toInches.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@org.springframework.stereotype.Repository
public interface Repo extends JpaRepository<Model, String> {

}
