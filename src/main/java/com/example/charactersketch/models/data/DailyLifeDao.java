package com.example.charactersketch.models.data;

import com.example.charactersketch.models.DailyLife;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface DailyLifeDao extends CrudRepository<DailyLife, Integer>{
}
