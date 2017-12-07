package com.example.charactersketch.models.data;

import com.example.charactersketch.models.PastAndFuture;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PastAndFutureDao extends CrudRepository<PastAndFuture, Integer> {
}
