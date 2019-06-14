package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Product;
import com.ensat.entities.ActivityLog;
import com.ensat.repositories.ProductRepository;
import com.ensat.repositories.ActivityLogRepository;

@Service
public class ActivityLogServiceImpl implements ActivityLogService {
	private ActivityLogRepository activityLogRepository;
	
	@Autowired
    public void setActivityLogRepository(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    @Override
    public Iterable<ActivityLog> listAllActivityLog() {
        return activityLogRepository.findAll();
    }

    @Override
    public ActivityLog getActivityLogById(Integer activityLogId) {
        return activityLogRepository.findOne(activityLogId);
    }

    @Override
    public ActivityLog saveActivityLog(ActivityLog activityLog) {
        return activityLogRepository.save(activityLog);
    }

    @Override
    public void deleteActivityLog(Integer activityLogId) {
    	activityLogRepository.delete(activityLogId);
    }
}
