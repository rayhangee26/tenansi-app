package com.ensat.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensat.entities.Product;
import com.ensat.entities.Booth;
import com.ensat.repositories.ProductRepository;
import com.ensat.repositories.BoothRepository;

@Service
public class BoothServiceImpl implements BoothService {
	private BoothRepository boothRepository;
	
	@Autowired
    public void setBoothRepository(BoothRepository boothRepository) {
        this.boothRepository = boothRepository;
    }

    @Override
    public Iterable<Booth> listAllBooth() {
        return boothRepository.findAll();
    }

    @Override
    public Booth getBoothById(Integer boothId) {
        return boothRepository.findOne(boothId);
    }

    @Override
    public Booth saveBooth(Booth booth) {
        return boothRepository.save(booth);
    }

    @Override
    public void deleteBooth(Integer boothId) {
    	boothRepository.delete(boothId);
    }
}
