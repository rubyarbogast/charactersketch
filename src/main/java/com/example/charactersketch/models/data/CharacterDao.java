package com.example.charactersketch.models.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface CharacterDao extends CrudRepository<Character, Integer> {
}
