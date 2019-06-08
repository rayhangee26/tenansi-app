package com.ensat.services;

import com.ensat.entities.Tenant;

public interface TenantService {

    Iterable<Tenant> listAllTenant();

    Tenant getTenantById(Integer id);

    Tenant saveTenant(Tenant tenant);

    void deleteTenant(Integer id);
	
}
