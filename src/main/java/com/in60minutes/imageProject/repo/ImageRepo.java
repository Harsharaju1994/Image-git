package com.in60minutes.imageProject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in60minutes.imageProject.model.Images;

public interface ImageRepo extends JpaRepository<Images,Integer> {

}
