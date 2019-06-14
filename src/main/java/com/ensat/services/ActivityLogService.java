package com.ensat.services;

import com.ensat.entities.ActivityLog;

public interface ActivityLogService {

    Iterable<ActivityLog> listAllActivityLog();

    ActivityLog getActivityLogById(Integer activityLogId);

    ActivityLog saveActivityLog(ActivityLog activityLog);

    void deleteActivityLog(Integer activityLogId);
	
}
