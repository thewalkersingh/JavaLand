package com.lld.stockbroker.model;

import java.util.Objects;

public class EquityHoldingEntry implements Entry {
    private Company company;
    private Integer quantity;
    private Double averagePrice;
    private Double investedAmount;

    // Dynamic data
    private Double absoluteAmountChange;
    private Double absoluteChangePercentage;

    public EquityHoldingEntry(Company company, Integer quantity, Double investedAmount) {
        this.company = company;
        this.quantity = quantity;
        this.investedAmount = investedAmount;
    }

    public EquityHoldingEntry union(EquityHoldingEntry other) {
        this.quantity += other.quantity;
        this.investedAmount += other.investedAmount;
        this.averagePrice = this.investedAmount / this.quantity;
        return this;
    }

    @Override
    public Company getCompany() {
        return this.company;
    }

    @Override
    public Integer getQuantity() {
        return this.quantity;
    }

    @Override
    public Double getAveragePrice() {
        return this.investedAmount / this.quantity;
    }

    @Override
    public Double getTotalInvestedAmount() {
        return this.investedAmount;
    }

    @Override
    public AmountChange getAbsoluteAmountChange() {
        return null;
    }

    @Override
    public AmountChange getPercentageAmountChange() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquityHoldingEntry that)) return false;
        return Objects.equals(getCompany(), that.getCompany());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCompany());
    }

    @Override
    public String toString() {
        return "EquityPortfolioEntry{" +
                "company=" + getCompany() +
                ", quantity=" + getQuantity() +
                ", averagePrice=" + getAveragePrice() +
                ", investedAmount=" + getTotalInvestedAmount() +
                ", absoluteAmountChange=" + getAbsoluteAmountChange() +
                ", absoluteChangePercentage=" + getPercentageAmountChange() +
                '}';
    }
}
