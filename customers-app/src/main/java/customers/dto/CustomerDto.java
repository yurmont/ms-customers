package customers.dto;

import java.util.Date;

public class CustomerDto  {

	private String companyId;
	private String ruc;
	private String documentId;
	private String documentReference;
	private String logisticCenterId;
	private String logisticCenterDescription;
	private String materialId;
	private String materialDescription;	
	private Date issueDate;
	private Date expirationDate;
	private String currencyId;
	private String currencyDescription;	
	private double amount;
	private double amountToPay;
	private String documentClass;
	private int fiscalYear;
	private String positionSap;
	private String segment;
	
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getDocumentId() {
		return documentId;
	}
	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}
	public String getDocumentReference() {
		return documentReference;
	}
	public void setDocumentReference(String documentReference) {
		this.documentReference = documentReference;
	}
	public String getLogisticCenterId() {
		return logisticCenterId;
	}
	public void setLogisticCenterId(String logisticCenterId) {
		this.logisticCenterId = logisticCenterId;
	}
	public String getLogisticCenterDescription() {
		return logisticCenterDescription;
	}
	public void setLogisticCenterDescription(String logisticCenterDescription) {
		this.logisticCenterDescription = logisticCenterDescription;
	}
	public String getMaterialId() {
		return materialId;
	}
	public void setMaterialId(String materialId) {
		this.materialId = materialId;
	}
	public String getMaterialDescription() {
		return materialDescription;
	}
	public void setMaterialDescription(String materialDescription) {
		this.materialDescription = materialDescription;
	}
	public Date getIssueDate() {
		return issueDate;
	}
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public String getCurrencyId() {
		return currencyId;
	}
	public void setCurrencyId(String currencyId) {
		this.currencyId = currencyId;
	}
	public String getCurrencyDescription() {
		return currencyDescription;
	}
	public void setCurrencyDescription(String currencyDescription) {
		this.currencyDescription = currencyDescription;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getDocumentClass() {
		return documentClass;
	}
	public void setDocumentClass(String documentClass) {
		this.documentClass = documentClass;
	}
	public int getFiscalYear() {
		return fiscalYear;
	}
	public void setFiscalYear(int fiscalYear) {
		this.fiscalYear = fiscalYear;
	}
	public double getAmountToPay() {
		return amountToPay;
	}
	public void setAmountToPay(double amountToPay) {
		this.amountToPay = amountToPay;
	}
	public String getPositionSap() {
		return positionSap;
	}
	public void setPositionSap(String positionSap) {
		this.positionSap = positionSap;
	}
	public String getSegment() {
		return segment;
	}
	public void setSegment(String segment) {
		this.segment = segment;
	}	
	
}
