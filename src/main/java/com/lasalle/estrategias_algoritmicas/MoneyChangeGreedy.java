/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.estrategias_algoritmicas;
import java.util.Scanner;
/**
 *
 * @author Usuario
 */
public class MoneyChangeGreedy {
    
    
    private static int getChange(int m) {
        int count = m / 10;
        m = m % 10;
        count += m / 5;
        m = m % 5;
        count += m / 1;
        return count;
    }

    
    private static int getChangeGreedy(int m) {
        int changes = 0, count = 0;
        int[] denominations = {1, 5, 10};
        int max = denominations.length - 1;

        while (changes < m) {
            while (changes <= m && (m - changes) >= denominations[max]) {
                changes += denominations[max];
                count++;
            }
            max = max - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println("Sample 1: m = 2  -> " + getChange(2) + " / " + getChangeGreedy(2) + " (esperado 2)");
        System.out.println("Sample 2: m = 28 -> " + getChange(28) + " / " + getChangeGreedy(28) + " (esperado 6)");

        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese la cantidad m (1 a 1000): ");
        int m = sc.nextInt();
        System.out.println("Aritmética básica: " + getChange(m));
        System.out.println("Voraz: " + getChangeGreedy(m));
    }
}
