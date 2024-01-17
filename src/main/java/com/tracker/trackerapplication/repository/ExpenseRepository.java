package com.tracker.trackerapplication.repository;

import com.tracker.trackerapplication.model.Expense;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
//@Repository
public interface ExpenseRepository extends CrudRepository<Expense, Integer> {
    List<Expense> findAll();
    Optional<Expense> findById(Integer id);
}
