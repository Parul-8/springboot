package com.expenseTracker.ExpenseTracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenseTracker.ExpenseTracker.beans.ExpenseBean;
import com.expenseTracker.ExpenseTracker.services.ExpenseService;

@RestController
@RequestMapping("/expense")
public class ExpenseController {
	
	@Autowired
	ExpenseService expenseService;
	
	@GetMapping("/home")
	public String home() {
		return "parul's home";
	}
	
	@PostMapping("/")
	public ExpenseBean addExpense(@RequestBody ExpenseBean expense) throws Exception {
		
		return this.expenseService.addExpense(expense);
		
		
	}
	
	@GetMapping("/")
	public List<ExpenseBean> listAllExpenses(){
		return this.expenseService.listAllExpenses();
	}
	
	@GetMapping("/{expenseId}")
	public ExpenseBean getExpense(@PathVariable("expenseId") Long expenseId) throws Exception {
		return this.expenseService.getById(expenseId);
		
	}
	
	@DeleteMapping("/{expenseId}")
	public void deleteExpense(@PathVariable("expenseId") Long expenseId) {
		 this.expenseService.deleteById(expenseId);
	}
	
	@PutMapping("/")
	public ExpenseBean updateExpense(@RequestBody ExpenseBean expense) {
		return this.expenseService.updateExpense(expense);
		
	}

}
