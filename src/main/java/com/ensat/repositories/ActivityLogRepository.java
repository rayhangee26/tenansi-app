package com.ensat.repositories;

import com.ensat.entities.ActivityLog;
import com.ensat.entities.Tenant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ActivityLogRepository extends PagingAndSortingRepository<ActivityLog, Integer> {

}
