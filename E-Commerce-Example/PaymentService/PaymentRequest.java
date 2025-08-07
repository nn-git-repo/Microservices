package com.example.PaymentService.entity;

public class PaymentRequest {
	  private String orderId;
	    private double amount;
	    private String paymentMethod;
		public PaymentRequest() {
			
		}
		public PaymentRequest(String orderId, double amount, String paymentMethod) {
			
			this.orderId = orderId;
			this.amount = amount;
			this.paymentMethod = paymentMethod;
		}
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		public String getPaymentMethod() {
			return paymentMethod;
		}
		public void setPaymentMethod(String paymentMethod) {
			this.paymentMethod = paymentMethod;
		}
		
}
