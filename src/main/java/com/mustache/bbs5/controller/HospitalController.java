package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.repository.HospitalRepositoty;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/hospitals")
public class HospitalController {

    private final HospitalRepositoty hospitalRepositoty;

    public HospitalController(HospitalRepositoty hospitalRepositoty) {
        this.hospitalRepositoty = hospitalRepositoty;
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        Optional<Hospital> optHospital = hospitalRepositoty.findById(id);
        if (optHospital.isEmpty()) {
            return "hospital/error";
        } else {
            model.addAttribute("hospital", optHospital.get());
            return "hospital/show";
        }
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Hospital> hospitals = hospitalRepositoty.findAll();
        model.addAttribute("hospitals", hospitals);
        return "hospital/list";
    }
}
