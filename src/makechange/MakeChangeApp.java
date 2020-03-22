package makechange;

import java.util.Scanner;

public class MakeChangeApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int twenties = 0, tens = 0, fives = 0, singles = 0;
		double ¢25 = 0.0, ¢10 = 0.0, ¢5 = 0.0, ¢1 = 0.0;

		System.out.print("How much does the item cost? $");
		double price = sc.nextDouble();

		System.out.print("How much $ is tendered? $");
		double offer = sc.nextDouble();

		if (offer < price) {
			System.out.println("Not enough $$ provided. \nGoodbye");
		} else if (offer == price) {
			System.out.println("Exact amount. Pleasure having business with you.");
		}

		else {
			double change = offer - price;
			System.out.println(" Your change is $" + Math.round(change * 100.0) / 100.0);

			if (change > 20) {
				twenties = calculateBills(change, 20);

				if (twenties > 1)
					System.out.print(" " + twenties + " twenty dollar bills");
				else if (twenties == 1)
					System.out.print(" " + twenties + " twenty dollar bill");
				change = change - 20 * twenties;
			}
			if (change >= 10 && change < 20) {
				tens = calculateBills(change, 10);
				System.out.print(" " + tens + " ten dollar bill");
				change = change - 10 * tens;
			}
			if (change >= 5 && change < 10) {
				fives = calculateBills(change, 5);
				System.out.print(" " + fives + " five dollar bill");
				change = change - 5 * fives;

			}
			if (change >= 1 && change < 5) {
				singles = calculateBills(change, 1);
				if (singles > 1)
					System.out.print(" " + singles + " one dollar bills");
				else if (singles == 1)
					System.out.print(" " + singles + " one dollar bill");
				change = Math.round((change - singles) * 100.0) / 100.0;

			}
			if (change >= 0.25 && change < 1) {
				¢25 = calculateCoins(change, 0.25);
				¢25 = (int) ¢25;
				if (¢25 > 1)
					System.out.print(" " + (int) ¢25 + " quarters");
				else if (¢25 == 1)
					System.out.print(" " + (int) ¢25 + " quarter");
				change = change - (0.25 * ¢25);
			}

			if (change >= 0.1 && change < 0.25) {
				¢10 = calculateCoins(change, 0.1);
				¢10 = (int) ¢10;
				if (¢10 > 1)
					System.out.print(" " + (int) ¢10 + " dimes");
				else if (¢10 == 1)
					System.out.print(" " + (int) ¢10 + " dime");
				change = change - (0.1 * ¢10);
			}

			if (change >= 0.05 && change < 0.1) {
				¢5 = calculateCoins(change, 0.05);
				¢5 = (int) ¢5;
				System.out.print(" " + (int) ¢5 + " nickel");
				change = change - (0.05 * ¢5);
			}
			change = Math.round(change * 100.0) / 100.0;

			if (change >= 0.01 && change < 0.05) {
				¢1 = calculateCoins(change, 0.01);
				change = Math.round((change - ¢1) * 100.0) / 100.0;
				if (¢1 > 1)
					System.out.print(" " + (int) ¢1 + " pennies");
				else if (¢1 == 1)
					System.out.print(" " + (int) ¢1 + " penny");

			}
		}

		sc.close();
	}

	public static int calculateBills(double change, int bill) {
		double leftOver;

		leftOver = change % bill;
		if (leftOver >= 0 && leftOver != change) {
			bill = (int) (change / bill);
		}
		return bill;

	}

	public static double calculateCoins(double change, double coins) {
		double leftOver;

		leftOver = change % coins;
		if (leftOver >= 0 && leftOver != change) {
			coins = change / coins;
		}
		return coins;
	}

}