package com.ngc.ispend.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ngc.ispend.model.SpendPlan;
import com.ngc.ispend.repository.ISpendRepository;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api")
public class ISpendController {

  @Autowired
  ISpendRepository db;

  @GetMapping("/plan")
  public ResponseEntity<List<SpendPlan>> getAllPlans(@RequestParam(required = false) String title) {
    try {
      List<SpendPlan> plans = new ArrayList<SpendPlan>();

      if (title == null)
        db.findAll().forEach(plans::add);
      else
        db.findByTitleContaining(title).forEach(plans::add);

      if (plans.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(plans, HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/plan/{id}")
  public ResponseEntity<SpendPlan> getPlanById(@PathVariable("id") long id) {
    Optional<SpendPlan> plan = db.findById(id);
    if (plan.isEmpty()) {
      return new ResponseEntity<SpendPlan>(HttpStatus.NOT_FOUND);
    }
    return new ResponseEntity<SpendPlan>(plan.get(), HttpStatus.OK);
  }

  @PostMapping("/plan")
  public ResponseEntity<SpendPlan> createSpendPlan(@RequestBody SpendPlan plan) {
    SpendPlan svd = db.save(plan);
    return new ResponseEntity<SpendPlan>(svd, HttpStatus.OK);
  }

  @PutMapping("/plan/{id}")
  public ResponseEntity<SpendPlan> updateSpendPlan(@PathVariable("id")long id, @RequestBody SpendPlan plan ){
    SpendPlan svd = db.save(plan);
    return new ResponseEntity<SpendPlan>(svd, HttpStatus.OK); 
  }
}