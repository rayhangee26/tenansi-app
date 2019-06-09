package com.ensat.services;

import com.ensat.entities.Booth;

public interface BoothService {

    Iterable<Booth> listAllBooth();

    Booth getBoothById(Integer boothId);

    Booth saveBooth(Booth booth);

    void deleteBooth(Integer boothId);
	
}
