package com.practice.ticketbooking;

import java.util.Random;

public class Payment {

    private String status; // should status be enum ??
    private double amount; // should amount be made final ??
    private int attempts;
    private String txnId;

    // difference b/w private and protected ??
    private final static int MAX_ATTEMPTS = 2;

    public Payment(double amount){
        this.status = "ATTEMPTING";
        this.amount = amount;
        this.attempts = 0;
        this.txnId = ""; // assign random Id
    }

    public Payment(String status, double amount, int attempts, String txnId) {
        this.status = status;
        this.amount = amount;
        this.attempts = attempts;
        this.txnId = txnId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getAttempts() {
        return attempts;
    }
    // increase not set
    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getTxnId() {
        return txnId;
    }

    public void setTxnId(String txnId) {
        this.txnId = txnId;
    }

    public boolean canRetry(){
        return attempts < MAX_ATTEMPTS;
    }

    public boolean pay(){
        if (attempts < MAX_ATTEMPTS){
            Random rnd = new Random();
            attempts++;
            Boolean  _call = rnd.nextBoolean();
            if(_call){
                status = "SUCCESS";
                System.out.println("Payment Successful");
            }
            else{
                status = "FAILED";
                System.out.println("Payment FAILED");
            }
            return _call;
        }
        else{
            System.out.println("Max attempts exhausted");
            return false;
        }
    }
    public boolean retryPayment(){
        if (canRetry()){
            return pay();
        }
        return false;
    }

}
