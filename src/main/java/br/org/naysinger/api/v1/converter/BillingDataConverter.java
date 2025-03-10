package br.org.naysinger.api.v1.converter;

import java.util.List;
import java.util.stream.Collectors;
//
//public class BillingDataConverter {
//
//    private final BankSlipDetailConverter bankSlipDetailConverter;
//    private final BankSlipItemConverter bankSlipItemConverter;
//    private final BankSlipConverter bankSlipConverter;
//    private final PersonConverter personConverter;
//
//    public BillingDataConverter(BankSlipDetailConverter bankSlipDetailConverter, BankSlipItemConverter bankSlipItemConverter,
//                                BankSlipConverter bankSlipConverter, PersonConverter personConverter) {
//        this.bankSlipDetailConverter = bankSlipDetailConverter;
//        this.bankSlipItemConverter = bankSlipItemConverter;
//        this.bankSlipConverter = bankSlipConverter;
//        this.personConverter = personConverter;
//    }
//
//    public BillingData convertToEntity(BillingDataDTO billingDataDTO) {
//
//        List<BankSlipDetail> BankSlipDetails = billingDataDTO.getFinancialSecurities().stream()
//                .map(bankSlipDetailConverter::convertToEntity)
//                .collect(Collectors.toList());
//
//        List<BankSlipItem> BankSlipItems = billingDataDTO.getItems().stream()
//                .map(bankSlipItemConverter::convertToEntity)
//                .collect(Collectors.toList());
//
//        return new BillingData.Builder()
//                .branchNumber(billingDataDTO.getBranchNumber())
//                .saleOrderType(billingDataDTO.getSaleOrderType())
//                .payer(personConverter.convert(billingDataDTO.getPayer()))
//                .paymentCondition(billingDataDTO.getPaymentCondition())
//                .automaticInvoicing(billingDataDTO.getAutomaticInvoicing())
//                .series(billingDataDTO.getSeries())
//                .sourceSystem(billingDataDTO.getSourceSystem())
//                .operationNumber(billingDataDTO.getOperationNumber())
//                .financialNature(billingDataDTO.getFinancialNature())
//                .finSecuritiesType(billingDataDTO.getFinSecuritiesType())
//                .operationId(billingDataDTO.getOperationId())
//                .financialSecurities(BankSlipDetails)
//                .callbackUrl(billingDataDTO.getCallbackUrl())
//                .instructions(bankSlipConverter.convert(billingDataDTO.getInstructions()))
//                .items(BankSlipItems)
//                .build();
//    }
//
//    public BillingData convertInvoiceDtoToBillingData(InvoiceAdvancedRequestDTO invoiceAdvRequestDTO) {
//
//        List<BankSlipDetail> bankSlipDetails = new ArrayList<>();
//
//        List<BankSlipItem> BankSlipItems = invoiceAdvRequestDTO.getItems().stream()
//                .map(bankSlipItemConverter::convertInvoiceItemDtoToBankSlipItem)
//                .collect(Collectors.toList());
//
//        return new BillingData.Builder()
//                .branchNumber(invoiceAdvRequestDTO.getBranchNumber())
//                .saleOrderType(invoiceAdvRequestDTO.getSaleOrderType())
//                .payer(personConverter.convert(invoiceAdvRequestDTO.getPayer()))
//                .paymentCondition(invoiceAdvRequestDTO.getPaymentCondition())
//                .automaticInvoicing(invoiceAdvRequestDTO.getAutomaticInvoicing())
//                .series(invoiceAdvRequestDTO.getSeries())
//                .sourceSystem(invoiceAdvRequestDTO.getSourceSystem())
//                .operationNumber(invoiceAdvRequestDTO.getOperationNumber())
//                .financialNature(invoiceAdvRequestDTO.getFinancialNature())
//                .finSecuritiesType(invoiceAdvRequestDTO.getFinSecuritiesType())
//                .callbackUrl(invoiceAdvRequestDTO.getCallbackUrl())
//                .items(BankSlipItems)
//                .financialSecurities(bankSlipDetails)
//                .build();
//    }
//
//    public BankSlip convertBillingToBankSlip (BillingData b) {
//        return BankSlip.builder()
//                .withCorrelationId(b.getIntegrationId()) //para rastrear registro prévio
//                .withSourceSystem(b.getSourceSystem())
//                .withCallbackUrl(b.getCallbackUrl())
//                .withPayer(b.getPayer())
//                .withInstructions(b.getInstructions())
//                .withAmount(convertBillingDataToBankSlipDetail(b).getInstallment())
//                .withDueDate(convertBillingDataToBankSlipDetail(b).getDueDate())
//                .withOurNumber(b.getOurNumber())
//                .withStatus(b.getStatus())
//                .build();
//    }
//
//    public BankSlipDetail convertBillingDataToBankSlipDetail(BillingData b) {
//        if (b.getFinancialSecurities() == null || b.getFinancialSecurities().isEmpty()) {
//            throw new IllegalArgumentException("BillingData não contém informações financeiras válidas");
//        }
//
//        BankSlipDetail paymentInfo = b.getFinancialSecurities().get(0);
//
//        return new BankSlipDetail.Builder()
//                .dueDate(paymentInfo.getDueDate())
//                .installment(paymentInfo.getInstallment())
//                .build();
//    }
