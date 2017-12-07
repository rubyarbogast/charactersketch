package com.example.charactersketch.models.data;

import com.example.charactersketch.models.Relationships;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface RelationshipsDao extends CrudRepository<Relationships, Integer> {
}
