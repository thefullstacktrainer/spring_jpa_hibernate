package com.excelr.entity.e4;

import javax.persistence.*;  

@Entity  
@Table(name="regularemployee104")  
@PrimaryKeyJoinColumn(name="ID")  
public class Regular_Employee4 extends Employee4{  
      
	@Column(name = "salary")
	private float salary;

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Column(name = "bonus")
	private int bonus;
  
//setters and getters  
}  