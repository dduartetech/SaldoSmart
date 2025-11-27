package com.projetouninove.saldosmart.infrastructure.entity;

import java.math.BigDecimal;
import java.time.LocalDate;

public record TransactionFilters(
    String description,
    LocalDate startDate,
    LocalDate endDate,
    BigDecimal minAmount,
    BigDecimal maxAmount,
    Long categoryId
) {}
