package com.ensat.repositories;

import com.ensat.entities.Booth;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BoothRepository extends PagingAndSortingRepository<Booth, Integer> {

}
