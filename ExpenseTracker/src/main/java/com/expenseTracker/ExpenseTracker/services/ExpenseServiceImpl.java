package com.expenseTracker.ExpenseTracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import com.expenseTracker.ExpenseTracker.beans.ExpenseBean;
import com.expenseTracker.ExpenseTracker.repository.ExpenseRepository;

@Service
public class ExpenseServiceImpl implements ExpenseService{
	
	@Autowired
	ExpenseRepository expenseRepository;
	
	@Override
	public ExpenseBean addExpense(ExpenseBean expense) throws Exception {
		
		ExpenseBean local = this.expenseRepository.findByExpense(expense.getExpense());
		if (local != null) {
			System.out.println("This Expense Already Existed!!");
			throw new Exception("This Expense already added!!");
		} else {
			local = this.expenseRepository.save(expense);
		}
		return local;
	}

	@Override
	public List<ExpenseBean> listAllExpenses() {
		
		return this.expenseRepository.findAll();
	}

	@Override
	public ExpenseBean getById(Long Id) throws Exception {
		ExpenseBean local = this.expenseRepository.findById(Id).get();
		if (local != null) { 
			return local;
		}
		else {
			throw new Exception("expense id is invalid!!!");
		}
		 
	}

	@Override
	public void deleteById(Long Id) {
		this.expenseRepository.deleteById(Id);
		
	}

	@Override
	public ExpenseBean updateExpense(ExpenseBean expense) {
		
		return this.expenseRepository.save(expense);
	}

}
