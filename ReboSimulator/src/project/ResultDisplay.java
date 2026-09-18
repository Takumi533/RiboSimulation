package project;

import java.util.ArrayList;

public class ResultDisplay {

	private ArrayList<Integer> monthlyPayment;
	private int totalPayment;
	private int totalFees;
	private ArrayList<Integer> monthlyFees;
	private ArrayList<Integer> principalPayment;
	private int monthlyPaymentY;
	private int monthlyPaymentM;

	ResultDisplay(ArrayList<Integer> monthlyPayment, int totalPayment, int totalFees,
			ArrayList<Integer> monthlyFees, ArrayList<Integer> principalPayment, int monthlyPaymentY,
			int monthlyPaymentM) {
		this.monthlyPayment = monthlyPayment;
		this.totalPayment = totalPayment;
		this.totalFees = totalFees;
		this.monthlyFees = monthlyFees;
		this.principalPayment = principalPayment;
		this.monthlyPaymentY = monthlyPaymentY;
		this.monthlyPaymentM = monthlyPaymentM;

	}

	void showResult() {
		System.out.println();
		System.out.println("===月ごとの借入残高===");
		System.out.println();
		System.out.println("シミュレーション開始時 残高 " + this.monthlyPayment.get(0) + " 円");
		System.out.println(
				"+------------+-------------------------+--------------------+--------------------------+-------------------------+");
		for (int i = 1; i < this.monthlyPayment.size(); i++) {
			System.out.printf("| %4d ヶ月目 | 返済前残高：%,10d 円 | 手数料： %,8d 円 | 元金返済額： %,10d 円 | 返済後残高： %,10d 円 |%n", i,
					this.monthlyPayment.get(i - 1),
					this.monthlyFees.get(i), principalPayment.get(i), this.monthlyPayment.get(i));
		}
		System.out.println(
				"+------------+-------------------------+--------------------+--------------------------+-------------------------+");

	}

	void showResult2() {
		System.out.println();
		System.out.println(" " + (this.monthlyPayment.size() - 1) + " 回の返済で完済します。");
		System.out.print("返済期間は 約 ");
		if (monthlyPaymentY > 0) {
			System.out.print(monthlyPaymentY + " 年 ");
		}
		System.out.println(+monthlyPaymentM + " ヶ月です");
		System.out.println("総支払金額は " + this.totalPayment + " 円です。");
		System.out.println("総手数料は " + this.totalFees + " 円です。");
	}
}
