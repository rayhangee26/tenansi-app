package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Product;
import com.ensat.entities.Tenant;
import com.ensat.repositories.ProductRepository;
import com.ensat.repositories.TenantRepository;

@Service
public class TenantServiceImpl implements TenantService {
	private TenantRepository tenantRepository;
	
	@Autowired
    public void setTenantRepository(TenantRepository tenantRepository) {
        this.tenantRepository = tenantRepository;
    }

    @Override
    public Iterable<Tenant> listAllTenant() {
        return tenantRepository.findAll();
    }

    @Override
    public Tenant getTenantById(Integer id) {
        return tenantRepository.findOne(id);
    }

    @Override
    public Tenant saveTenant(Tenant tenant) {
        return tenantRepository.save(tenant);
    }

    @Override
    public void deleteTenant(Integer id) {
    	tenantRepository.delete(id);
    }
}
