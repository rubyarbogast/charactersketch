package com.example.charactersketch.models.data;

import com.example.charactersketch.models.Appearance;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AppearanceDao extends CrudRepository<Appearance, Integer>{
}
