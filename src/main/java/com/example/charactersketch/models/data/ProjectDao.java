package com.example.charactersketch.models.data;

import com.example.charactersketch.models.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ProjectDao extends CrudRepository<Project, Integer>{
}
