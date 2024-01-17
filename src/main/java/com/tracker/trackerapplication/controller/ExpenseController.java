package com.tracker.trackerapplication.controller;

import com.tracker.trackerapplication.service.ExpenseService;
import com.tracker.trackerapplication.model.Expense;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ExpenseController {

    @Autowired   //declears the dependency
    private ExpenseService expenseService;
//fetch all the ids
    @RequestMapping("/expense")
    public List<Expense> getAllExpense()
    {
        return expenseService.getAllExpense();
    }
//    Fetch certain id
    @RequestMapping("/expense/{id}")
    public Expense getExpense(@PathVariable Integer id) {
        return expenseService.getExpense(id);
    }
//  Insert expense
    @RequestMapping(method = RequestMethod.POST, value = "/expense")
    public void addExpense(@Valid @RequestBody Expense expense){
        expenseService.addExpense(expense);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/expense/{id}")
    public void updateExpense(@RequestBody Expense expense,@PathVariable Integer id){
        expenseService.updateExpense(id,expense);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/expense/{id}")
    public void deleteExpense(@PathVariable Integer id){
        expenseService.deleteExpense(id);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
