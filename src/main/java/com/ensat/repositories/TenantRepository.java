package com.ensat.repositories;

import com.ensat.entities.Tenant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TenantRepository extends PagingAndSortingRepository<Tenant, Integer> {

}
