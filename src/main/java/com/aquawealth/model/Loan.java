package com.aquawealth.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loanId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    private double interestRate;

    @Column(nullable = false) // Ensure it's not null in DB
    private int termMonths;

    @Column(length = 255)
    private String purpose;

    @Column(length = 255)
    private String collateralDetails;

    @Column(nullable = false)
    private LocalDate startDate = LocalDate.now();
}

//package com.aquawealth.model;
//
//import jakarta.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.AllArgsConstructor;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "loans")
//public class Loan {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long loanId;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", nullable = false)
//    private User user; // Corrected: Now properly linked to User entity
//
//    @Column(nullable = false, precision = 10, scale = 2)
//    private BigDecimal amount;
//
//    private double interestRate;
//
//    private int termMonths;
//
//    public Long getLoanId() {
//        return loanId;
//    }
//
//    public void setLoanId(Long loanId) {
//        this.loanId = loanId;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//
//    public BigDecimal getAmount() {
//        return amount;
//    }
//
//    public void setAmount(BigDecimal amount) {
//        this.amount = amount;
//    }
//
//    public double getInterestRate() {
//        return interestRate;
//    }
//
//    public void setInterestRate(double interestRate) {
//        this.interestRate = interestRate;
//    }
//
//    public int getTermMonths() {
//        return termMonths;
//    }
//
//    public void setTermMonths(int termMonths) {
//        this.termMonths = termMonths;
//    }
//
//    public String getPurpose() {
//        return purpose;
//    }
//
//    public void setPurpose(String purpose) {
//        this.purpose = purpose;
//    }
//
//    public String getCollateralDetails() {
//        return collateralDetails;
//    }
//
//
//    public void setCollateralDetails(String collateralDetails) {
//        this.collateralDetails = collateralDetails;
//    }
//
//
//
//    @Column(length = 255)
//    private String purpose;
//
//    @Column(length = 255)
//    private String collateralDetails;
//    @Column(nullable = false)
//    private LocalDate startDate = LocalDate.now();
//
//    public LocalDate getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(LocalDate startDate) {
//        this.startDate = startDate;
//    }
//    @Override
//    public String toString() {
//        return "Loan{" +
//                "loanId=" + loanId +
//                ", user=" + (user != null ? user.getUserId() : null) +
//                ", amount=" + amount +
//                ", interestRate=" + interestRate +
//                ", termMonths=" + termMonths +
//                ", purpose='" + purpose + '\'' +
//                ", collateralDetails='" + collateralDetails + '\'' +
//                '}';
//    }
//
//
//}
////package com.aquawealth.model;
////
////import jakarta.persistence.*;
////import java.math.BigDecimal;
////import lombok.Data;
////import lombok.NoArgsConstructor;
////import lombok.AllArgsConstructor;
////
////@Data
////@NoArgsConstructor
////@AllArgsConstructor
////@Entity
////@Table(name = "loans")
////public class Loan {
////
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    private Long loanId;
////
////    @ManyToOne
////    @JoinColumn(name = "user_id", nullable = false)
////    private User user;
////
////    @Column(nullable = false, precision = 10, scale = 2)
////    private BigDecimal amount;
////
////    @Column(nullable = false)
////    private double interestRate;
////
////    @Column(nullable = false)
////    private int termMonths;
//////
//////    @Column(nullable = false, length = 3)  // ✅ New Field for Collateral (YES/NO)
//////    private String collateral;
////
////    @Column(length = 255)
////    private String purpose;
////
////    @Column(length = 255)
////    private String collateralDetails;
////
////    public Long getLoanId() {
////        return loanId;
////    }
////
////    public void setLoanId(Long loanId) {
////        this.loanId = loanId;
////    }
////
////    public User getUser() {
////        return user;
////    }
////
////    public void setUser(User user) {
////        this.user = user;
////    }
////
////    public BigDecimal getAmount() {
////        return amount;
////    }
////
////    public void setAmount(BigDecimal amount) {
////        this.amount = amount;
////    }
////
////    public double getInterestRate() {
////        return interestRate;
////    }
////
////    public void setInterestRate(double interestRate) {
////        this.interestRate = interestRate;
////    }
////
////    public int getTermMonths() {
////        return termMonths;
////    }
////
////    public void setTermMonths(int termMonths) {
////        this.termMonths = termMonths;
////    }
////
//////    public String getCollateral() {
//////        return collateral;
//////    }
//////
//////    public void setCollateral(String collateral) {
//////        this.collateral = collateral;
//////    }
////
////    public String getPurpose() {
////        return purpose;
////    }
////
////    public void setPurpose(String purpose) {
////        this.purpose = purpose;
////    }
////
////    public String getCollateralDetails() {
////        return collateralDetails;
////    }
////
////    public void setCollateralDetails(String collateralDetails) {
////        this.collateralDetails = collateralDetails;
////    }
////
////    @Override
////    public String toString() {
////        return "Loan{" +
////                "loanId=" + loanId +
////                ", user=" + user +
////                ", amount=" + amount +
////                ", interestRate=" + interestRate +
////                ", termMonths=" + termMonths +
////                ", purpose='" + purpose + '\'' +
////                ", collateralDetails='" + collateralDetails + '\'' +
////                '}';
////    }
////}
