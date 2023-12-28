package com.excelr.entity.e4;

import javax.persistence.*;

@Entity
@Table(name = "contractemployee104")
@PrimaryKeyJoinColumn(name = "ID")
public class Contract_Employee4 extends Employee4 {

	public float getPay_per_hour() {
		return pay_per_hour;
	}

	public void setPay_per_hour(float pay_per_hour) {
		this.pay_per_hour = pay_per_hour;
	}

	public String getContract_duration() {
		return contract_duration;
	}

	public void setContract_duration(String contract_duration) {
		this.contract_duration = contract_duration;
	}

	@Column(name = "pay_per_hour")
	private float pay_per_hour;

	@Column(name = "contract_duration")
	private String contract_duration;

	// setters and getters
}