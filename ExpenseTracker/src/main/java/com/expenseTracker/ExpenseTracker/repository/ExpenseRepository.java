package com.expenseTracker.ExpenseTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.expenseTracker.ExpenseTracker.beans.ExpenseBean;

public interface ExpenseRepository extends JpaRepository<ExpenseBean, Long> {
	
	public ExpenseBean findByExpense(String expense);

}
