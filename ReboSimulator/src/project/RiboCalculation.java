package project;

import java.util.ArrayList;

class RiboCalculation {

	private int outstandingBalance;
	private double annualInterestRate;
	private int monthlyPayment;
	private int totalPayment;
	private int totalFees = 0;
	private ArrayList<Integer> monthlyBalances = new ArrayList<Integer>();
	private ArrayList<Integer> monthlyFees = new ArrayList<>();
	private ArrayList<Integer> actualmonthlypayment = new ArrayList<>();
	private ArrayList<Integer> principalPayment = new ArrayList<Integer>();
	private int monthlyPaymentY;
	private int monthlyPaymentM;

	RiboCalculation(int outstandingBalance, double annualInterestRate, int monthlyPayment) {
		this.outstandingBalance = outstandingBalance;
		this.annualInterestRate = annualInterestRate;
		this.monthlyPayment = monthlyPayment;
	}

	void riboCalc() {
		this.monthlyBalances.add(this.outstandingBalance);
		this.monthlyFees.add(0);
		this.actualmonthlypayment.add(0);

		double monthlyInterestRate = annualInterestRate / 12;
		while (this.outstandingBalance > 0) {

			//			手数料追加
			this.monthlyFees.add((int) Math.round(outstandingBalance * monthlyInterestRate));
			this.outstandingBalance += (int) Math.round(outstandingBalance * monthlyInterestRate);

			//			支払い
			if (this.outstandingBalance >= this.monthlyPayment) {
				this.outstandingBalance -= this.monthlyPayment;
				this.actualmonthlypayment.add(this.monthlyPayment);
			} else {
				this.actualmonthlypayment.add(this.outstandingBalance);
				this.outstandingBalance -= this.outstandingBalance;
			}

			if (this.outstandingBalance > 0) {
				this.monthlyBalances.add(this.outstandingBalance);
			} else {
				this.monthlyBalances.add(0);
			}
		}

		//		手数料合計
		for (double i : this.monthlyFees) {
			this.totalFees += i;
		}
		//		総支払額
		for (int i : this.actualmonthlypayment) {
			this.totalPayment += i;
		}
		//		元金返済額
		for (int i = 0; i < monthlyFees.size(); i++) {
			this.principalPayment.add(actualmonthlypayment.get(i) - monthlyFees.get(i));
		}
		//		支払い期間
		this.monthlyPaymentY = (monthlyBalances.size() - 1) / 12;
		this.monthlyPaymentM = (monthlyBalances.size() - 1) % 12;
	}

	ArrayList<Integer> getMonthlyPayment() {
		return this.monthlyBalances;
	}

	int getTotalPayment() {
		return this.totalPayment;
	}

	int getTotalFees() {
		return this.totalFees;
	}

	ArrayList<Integer> getMonthlyFees() {
		return this.monthlyFees;
	}

	ArrayList<Integer> getPrincipalPayment() {
		return this.principalPayment;
	}

	int getMonthlyPaymentY() {
		return this.monthlyPaymentY;
	}

	int getMonthlyPaymentM() {
		return this.monthlyPaymentM;
	}
}
