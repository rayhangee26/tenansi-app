package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.ActivityLog;
import com.ensat.services.ActivityLogService;
import com.ensat.services.BoothService;
import com.ensat.services.EventService;
import com.ensat.services.TenantService;

@Controller
public class ActivityLogController {
	private ActivityLogService activityLogService;
	private BoothService boothService;
	private TenantService tenantService;
	private EventService eventService;

    @Autowired
    public void setActivityLogService(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }
    
    @Autowired
    public void setBoothService(BoothService boothService) {
        this.boothService = boothService;
    }

    
    @Autowired
    public void setTenantService(TenantService tenantService) {
        this.tenantService = tenantService;
    }
    
    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    /**
     * List all activityLog.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/activityLogs", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("activityLogs", activityLogService.listAllActivityLog());
        System.out.println("Returning activityLogs:");
        return "activityLogs";
    }

    /**
     * View a specific product by its id.
     *
     * @param activityLogId
     * @param model
     * @return
     */
    @RequestMapping("activityLogs/{activityLogId}")
    public String showActivityLog(@PathVariable Integer activityLogId, Model model) {
        model.addAttribute("activityLog", activityLogService.getActivityLogById(activityLogId));
        return "activityLogshow";
    }

    // Edit ActivityLog
    @RequestMapping("activityLog/edit/{activityLogId}")
    public String edit(@PathVariable Integer activityLogId, Model model) {
        model.addAttribute("activityLog", activityLogService.getActivityLogById(activityLogId));
        return "activityLogform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("activityLog/new")
    public String newActivityLog(Model model) {
        model.addAttribute("activityLog", new ActivityLog());
        model.addAttribute("booth", boothService.listAllBooth());
        model.addAttribute("tenant", tenantService.listAllTenant());
        model.addAttribute("event", eventService.listAllEvent());
        return "activityLogform";
    }

    /**
     * Save product to database.
     *
     * @param activityLog
     * @return
     */
    @RequestMapping(value = "activityLog", method = RequestMethod.POST)
    public String saveActivityLog(ActivityLog activityLog) {
        activityLogService.saveActivityLog(activityLog);
        //return "redirect:/activityLog/" + activityLog.getActivityLogId();
        return "redirect:/activityLogs";
    }

    /**
     * Delete product by its id.
     *
     * @param activityLogid
     * @return
     */
    @RequestMapping("activityLog/delete/{activityLogId}")
    public String delete(@PathVariable Integer activityLogId) {
        activityLogService.deleteActivityLog(activityLogId);
        return "redirect:/activityLogs";
    }

}
