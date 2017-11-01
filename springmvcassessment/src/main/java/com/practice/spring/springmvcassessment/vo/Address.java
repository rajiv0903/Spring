package com.practice.spring.springmvcassessment.vo;

public class Address {
	private String address;
	private String state;

	/**
	 * @return String
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return String
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [address=");
		builder.append(address);
		builder.append(", state=");
		builder.append(state);
		builder.append("]");
		return builder.toString();
	}

}
