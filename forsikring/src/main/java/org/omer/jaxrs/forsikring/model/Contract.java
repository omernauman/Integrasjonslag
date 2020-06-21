package org.omer.jaxrs.forsikring.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Contract {
	private String contractNr;
	private String personalNr;
	private String customerNr;
	private String customerName;
	private String productName;
	private Date dateSigned;
	private String status;
	private boolean isAktive;

	public Contract() {

	}

	public String getContractNr() {
		return contractNr;
	}

	public void setContractNr(String contractNr) {
		this.contractNr = contractNr;
	}

	public String getPersonalNr() {
		return personalNr;
	}

	public void setPersonalNr(String personalNr) {
		this.personalNr = personalNr;
	}

	public String getCustomerNr() {
		return customerNr;
	}

	public void setCustomerNr(String customerNr) {
		this.customerNr = customerNr;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getDateSigned() {
		return dateSigned;
	}

	public void setDateSigned(Date dateSigned) {
		this.dateSigned = dateSigned;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isAktive() {
		return isAktive;
	}

	public void setAktive(boolean isAktive) {
		this.isAktive = isAktive;
	}

	@Override
	public String toString() {
		return "Contract [contractNr=" + contractNr + ", personalNr=" + personalNr + ", customerNr=" + customerNr
				+ ", customerName=" + customerName + ", productName=" + productName + ", dateSigned=" + dateSigned
				+ ", status=" + status + ", isAktive=" + isAktive + "]";
	}

}
