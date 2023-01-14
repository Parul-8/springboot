package com.expenseTracker.ExpenseTracker.beans;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Component
@Entity
@Table(name="expenses")
public class ExpenseBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long expenseId;
	private String expense;
	private String expenseCategory;
	private Float expenseAmount;
	
	public ExpenseBean(Long expenseId, String expense, String expenseCategory, Float expenseAmount) {
		super();
		this.expenseId = expenseId;
		this.expense = expense;
		this.expenseCategory = expenseCategory;
		this.expenseAmount = expenseAmount;
	}

	public ExpenseBean() {
		
	}

	public Long getExpenseId() {
		return expenseId;
	}

	public void setExpenseId(Long expenseId) {
		this.expenseId = expenseId;
	}

	public String getExpense() {
		return expense;
	}

	public void setExpense(String expense) {
		this.expense = expense;
	}

	public String getExpenseCategory() {
		return expenseCategory;
	}

	public void setExpenseCategory(String expenseCategory) {
		this.expenseCategory = expenseCategory;
	}

	public Float getExpenseAmount() {
		return expenseAmount;
	}

	public void setExpenseAmount(Float expenseAmount) {
		this.expenseAmount = expenseAmount;
	}

	@Override
	public String toString() {
		return "ExpenseBean [expenseId=" + expenseId + ", expense=" + expense + ", expenseCategory=" + expenseCategory
				+ ", expenseAmount=" + expenseAmount + "]";
	}
	
	

}
