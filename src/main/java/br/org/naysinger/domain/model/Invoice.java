package br.org.naysinger.domain.model;

import java.util.Optional;

public class Invoice {
    private final String id;
    private final String correlationId;
    private final String sourceSystem;
    private final Long invoiceNumber;
    private final String invoiceType;
    private final String fileName;
    private final String xmlName;
    private final String callbackUrl;

    private Invoice(Builder builder) {
        this.id = builder.id;
        this.correlationId = builder.correlationId;
        this.sourceSystem = builder.sourceSystem;
        this.invoiceNumber = builder.invoiceNumber;
        this.invoiceType = builder.invoiceType;
        this.fileName = builder.fileName;
        this.xmlName = builder.xmlName;
        this.callbackUrl = builder.callbackUrl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builderFrom(Invoice invoice) {
        return new Builder(invoice);
    }

    public String getId() {
        return id;
    }

    public String getCorrelationId() {
        return correlationId;
    }

    public String getSourceSystem() {
        return sourceSystem;
    }

    public Optional<Long> getInvoiceNumber() {
        return Optional.ofNullable(invoiceNumber);
    }

    public String getInvoiceType() {
        return invoiceType;
    }

    public Optional<String> getFileName() {
        return Optional.ofNullable(fileName);
    }

    public Optional<String> getXmlName() {
        return Optional.ofNullable(xmlName);
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public static class Builder {
        private String id;
        private String correlationId;
        private String sourceSystem;
        private Long invoiceNumber;
        private String invoiceType;
        private String fileName;
        private String xmlName;
        private String callbackUrl;

        public Builder() {
        }

        private Builder(Invoice invoice) {
            this.id = invoice.id;
            this.correlationId = invoice.correlationId;
            this.sourceSystem = invoice.sourceSystem;
            this.invoiceNumber = invoice.invoiceNumber;
            this.invoiceType = invoice.invoiceType;
            this.fileName = invoice.fileName;
            this.xmlName = invoice.xmlName;
            this.callbackUrl = invoice.callbackUrl;
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder correlationId(String correlationId) {
            this.correlationId = correlationId;
            return this;
        }

        public Builder sourceSystem(String sourceSystem) {
            this.sourceSystem = sourceSystem;
            return this;
        }

        public Builder invoiceNumber(Long invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
            return this;
        }

        public Builder invoiceType(String invoiceType) {
            this.invoiceType = invoiceType;
            return this;
        }

        public Builder fileName(String fileName) {
            this.fileName = fileName;
            return this;
        }


        public Builder xmlName(String xmlName) {
            this.xmlName = xmlName;
            return this;
        }


        public Builder callbackUrl(String callbackUrl) {
            this.callbackUrl = callbackUrl;
            return this;
        }

        public Invoice build() {
            return new Invoice(this);
        }
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "id='" + id + '\'' +
                ", correlationId='" + correlationId + '\'' +
                ", sourceSystem='" + sourceSystem + '\'' +
                ", invoiceNumber=" + invoiceNumber +
                ", invoiceType='" + invoiceType + '\'' +
                ", fileName='" + fileName + '\'' +
                ", xmlName='" + xmlName + '\'' +
                ", callbackUrl='" + callbackUrl + '\'' +
                '}';
    }
}