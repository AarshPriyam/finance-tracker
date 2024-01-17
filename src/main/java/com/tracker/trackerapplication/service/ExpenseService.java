package com.tracker.trackerapplication.service;

import com.tracker.trackerapplication.model.Expense;
import com.tracker.trackerapplication.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExpenseService {

    @Autowired
    private ExpenseRepository expenseRepository;


    public List<Expense> getAllExpense() {
        return expenseRepository.findAll();
    }

    public void addExpense(Expense expense) {
        //json validation method
//
        expenseRepository.save(expense);
        //
    }

    public Expense getExpense(Integer id) {
        return expenseRepository.findById(id).get();
    }


    public void updateExpense(Integer id, Expense expense) {
//        Updation condition
        Expense a = expenseRepository.findById(id).get();
        if (expense.getCategory()!=null){ a.setCategory(expense.getCategory());}
        if (expense.getAmount()!= 0){a.setAmount(expense.getAmount());}
        if (expense.getDate()!=null){ a.setDate(expense.getDate()); }

        expenseRepository.save(a);
    }

    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }
}
