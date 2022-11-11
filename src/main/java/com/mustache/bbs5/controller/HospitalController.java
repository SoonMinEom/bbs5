package com.mustache.bbs5.controller;

import com.mustache.bbs5.domain.entity.Hospital;
import com.mustache.bbs5.repository.HospitalRepository;
import com.mustache.bbs5.service.HospitalService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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

    private final HospitalRepository hospitalRepository;
    private final HospitalService hospitalService;

    public HospitalController(HospitalRepository hospitalRepository, HospitalService hospitalService) {
        this.hospitalRepository = hospitalRepository;
        this.hospitalService = hospitalService;
    }

    @GetMapping("")
    public String index() {
        return String.format("redirect:/articles/list");
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Integer id, Model model) {
        Optional<Hospital> optHospital = hospitalRepository.findById(id);
        if (optHospital.isEmpty()) {
            return "hospital/error";
        } else {
            model.addAttribute("hospital", optHospital.get());
            return "hospital/show";
        }
    }

    @GetMapping("/list")
    public String list(Model model, @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.ASC)Pageable pageable) {
        model.addAttribute("hospitals", hospitalService.getHospitalList(pageable));
        model.addAttribute("previous", pageable.previousOrFirst().getPageNumber());
        model.addAttribute("next",pageable.next().getPageNumber());
        return "hospital/list";
    }


}
