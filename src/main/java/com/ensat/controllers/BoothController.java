package com.ensat.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ensat.entities.Booth;
import com.ensat.services.BoothService;

@Controller
public class BoothController {
	private BoothService boothService;

    @Autowired
    public void setBoothService(BoothService boothService) {
        this.boothService = boothService;
    }

    /**
     * List all booth.
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/booths", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("booths", boothService.listAllBooth());
        System.out.println("Returning booths:");
        return "booths";
    }

    /**
     * View a specific product by its id.
     *
     * @param boothId
     * @param model
     * @return
     */
    @RequestMapping("booths/{boothId}")
    public String showBooth(@PathVariable Integer boothId, Model model) {
        model.addAttribute("booth", boothService.getBoothById(boothId));
        return "boothshow";
    }

    // Edit Booth
    @RequestMapping("booth/edit/{boothId}")
    public String edit(@PathVariable Integer boothId, Model model) {
        model.addAttribute("booth", boothService.getBoothById(boothId));
        return "boothform";
    }

    /**
     * New product.
     *
     * @param model
     * @return
     */
    @RequestMapping("booth/new")
    public String newBooth(Model model) {
        model.addAttribute("booth", new Booth());
        return "boothform";
    }

    /**
     * Save product to database.
     *
     * @param booth
     * @return
     */
    @RequestMapping(value = "booth", method = RequestMethod.POST)
    public String saveBooth(Booth booth) {
        boothService.saveBooth(booth);
        //return "redirect:/booth/" + booth.getBoothId();
        return "redirect:/booths";
    }

    /**
     * Delete product by its id.
     *
     * @param boothid
     * @return
     */
    @RequestMapping("booth/delete/{boothId}")
    public String delete(@PathVariable Integer boothId) {
        boothService.deleteBooth(boothId);
        return "redirect:/booths";
    }

}
