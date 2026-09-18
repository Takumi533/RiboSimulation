package project;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		int outstandnigBalance = inputInt(scanner, "借りる金額を入力してください。(円)");
		double annualInterestRate = inputInt(scanner, "年利を入力してください。(%)") * 0.01;
		int monthlyPayment = inputInt(scanner, "月ごとに支払う金額を入力してください。(円)");

		RiboCalculation riboCalc = new RiboCalculation(outstandnigBalance, annualInterestRate, monthlyPayment);
		riboCalc.riboCalc();
		ArrayList<Integer> monthlyPaymentDisplay = riboCalc.getMonthlyPayment();
		int totalPayment = riboCalc.getTotalPayment();
		int totalFees = riboCalc.getTotalFees();
		ArrayList<Integer> monthlyFees = riboCalc.getMonthlyFees();
		ArrayList<Integer> principalPayment = riboCalc.getPrincipalPayment();
		int monthlyPaymentY = riboCalc.getMonthlyPaymentY();
		int monthlyPaymentM = riboCalc.getMonthlyPaymentM();

		ResultDisplay resultDisplay = new ResultDisplay(monthlyPaymentDisplay, totalPayment, totalFees, monthlyFees,
				principalPayment, monthlyPaymentY, monthlyPaymentM);
		resultDisplay.showResult();
		resultDisplay.showResult2();

		scanner.close();
	}

	public static int inputInt(Scanner scanner, String message) {
		System.out.println(message);
		while (true) {

			if (scanner.hasNextInt()) {
				int value = scanner.nextInt();

				if (value > 0) {
					return value;
				}
			} else {
				scanner.next();
			}
			System.out.println("正しい整数を入力してください。");

		}
	}
}
