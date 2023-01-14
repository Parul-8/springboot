package com.expenseTracker.ExpenseTracker.services;

import java.util.List;

import com.expenseTracker.ExpenseTracker.beans.ExpenseBean;

public interface ExpenseService {

	public ExpenseBean addExpense(ExpenseBean expense) throws Exception;
	
	public List<ExpenseBean> listAllExpenses();
	
	public ExpenseBean getById(Long Id) throws Exception;
	
	public void deleteById(Long Id);
	
	public ExpenseBean updateExpense(ExpenseBean expense);
}
