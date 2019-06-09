package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Tenant;
import com.ensat.services.TenantService;

@Controller
public class TenantController {
	private TenantService tenantService;

    @Autowired
    public void setTenantService(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    /**
     * List all tenant.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/tenants", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("tenants", tenantService.listAllTenant());
        System.out.println("Returning tenants:");
        return "tenants";
    }

    /**
     * View a specific product by its id.
     *
     * @param tenantId
     * @param model
     * @return
     */
    @RequestMapping("tenants/{tenantId}")
    public String showTenant(@PathVariable Integer tenantId, Model model) {
        model.addAttribute("tenant", tenantService.getTenantById(tenantId));
        return "tenantshow";
    }

    // Edit Tenant
    @RequestMapping("tenant/edit/{tenantId}")
    public String edit(@PathVariable Integer tenantId, Model model) {
        model.addAttribute("tenant", tenantService.getTenantById(tenantId));
        return "tenantform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("tenant/new")
    public String newTenant(Model model) {
        model.addAttribute("tenant", new Tenant());
        return "tenantform";
    }

    /**
     * Save product to database.
     *
     * @param tenant
     * @return
     */
    @RequestMapping(value = "tenant", method = RequestMethod.POST)
    public String saveTenant(Tenant tenant) {
        tenantService.saveTenant(tenant);
        //return "redirect:/tenant/" + tenant.getTenantId();
        return "redirect:/tenants";
    }

    /**
     * Delete product by its id.
     *
     * @param tenantid
     * @return
     */
    @RequestMapping("tenant/delete/{tenantId}")
    public String delete(@PathVariable Integer tenantId) {
        tenantService.deleteTenant(tenantId);
        return "redirect:/tenants";
    }

}
