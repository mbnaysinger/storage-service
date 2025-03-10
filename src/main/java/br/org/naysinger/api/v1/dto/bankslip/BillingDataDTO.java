package br.org.naysinger.api.v1.dto.bankslip;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class BillingDataDTO {

    @NotBlank(message = "dto.branchNumber.required")
    private String branchNumber;

    @NotBlank(message = "dto.saleOrderType.required")
    private String saleOrderType;

    @NotBlank(message = "dto.paymentCondition.required")
    private String paymentCondition;

    @NotBlank(message = "dto.automaticInvoicing.required")
    private String automaticInvoicing;

    @NotBlank(message = "dto.series.required")
    private String series;

    @NotBlank(message = "dto.sourceSystem.required")
    private String sourceSystem;

    @NotBlank(message = "dto.operationNumber.required")
    private String operationNumber;

    @NotBlank(message = "dto.financialNature.required")
    private String financialNature;

    @NotNull(message = "dto.finSecuritiesType.required")
    private Integer finSecuritiesType;

    private Long operationId;

    private String callbackUrl;

    public String getBranchNumber() {
        return branchNumber;
    }

    public void setBranchNumber(String branchNumber) {
        this.branchNumber = branchNumber;
    }

    public String getSaleOrderType() {
        return saleOrderType;
    }

    public void setSaleOrderType(String saleOrderType) {
        this.saleOrderType = saleOrderType;
    }

    public String getPaymentCondition() {
        return paymentCondition;
    }

    public void setPaymentCondition(String paymentCondition) {
        this.paymentCondition = paymentCondition;
    }

    public String getAutomaticInvoicing() {
        return automaticInvoicing;
    }

    public void setAutomaticInvoicing(String automaticInvoicing) {
        this.automaticInvoicing = automaticInvoicing;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public void setSourceSystem(String sourceSystem) {
        this.sourceSystem = sourceSystem;
    }

    public String getOperationNumber() {
        return operationNumber;
    }

    public void setOperationNumber(String operationNumber) {
        this.operationNumber = operationNumber;
    }

    public String getFinancialNature() {
        return financialNature;
    }

    public void setFinancialNature(String financialNature) {
        this.financialNature = financialNature;
    }

    public Integer getFinSecuritiesType() {
        return finSecuritiesType;
    }

    public void setFinSecuritiesType(Integer finSecuritiesType) {
        this.finSecuritiesType = finSecuritiesType;
    }

    public Long getOperationId() {
        return operationId;
    }

    public void setOperationId(Long operationId) {
        this.operationId = operationId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    @Override
    public String toString() {
        return "BillingDataDTO{" +
                "branchNumber='" + branchNumber + '\'' +
                ", saleOrderType='" + saleOrderType + '\'' +
                ", paymentCondition='" + paymentCondition + '\'' +
                ", automaticInvoicing='" + automaticInvoicing + '\'' +
                ", series='" + series + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", operationNumber='" + operationNumber + '\'' +
                ", financialNature='" + financialNature + '\'' +
                ", finSecuritiesType=" + finSecuritiesType +
                ", operationId=" + operationId +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}
