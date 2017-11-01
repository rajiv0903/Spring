package com.practice.spring.springmvcassessment.vo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class CustomerVO {
	private String name;
	private String password;
	private String confirmpassword;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private String gender;
	private Boolean isAgreed;
	private Address address;

	/**
	 * @return String
	 */
	public String getName() {
		return name;
	}

	public void setName(String customerName) {
		this.name = customerName;
	}

	/**
	 * @return String
	 */
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Date
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	/**
	 * @return String
	 */
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return Boolean
	 */
	public Boolean getIsAgreed() {
		return isAgreed;
	}

	public void setIsAgreed(Boolean isAgreed) {
		this.isAgreed = isAgreed;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerVO [customerName=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", isAgreed=");
		builder.append(isAgreed);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

}
