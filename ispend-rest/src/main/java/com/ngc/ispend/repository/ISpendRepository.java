package com.ngc.ispend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ngc.ispend.model.SpendPlan;


public interface ISpendRepository extends JpaRepository<SpendPlan, Long> {
  List<SpendPlan> findByPublished(boolean published);

  List<SpendPlan> findByTitleContaining(String title);
}