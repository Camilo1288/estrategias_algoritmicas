/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lasalle.estrategias_algoritmicas;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
/**
 *
 * @author Usuario
 */
public class Inversions {
    private static long count(int[] a, int[] aux, int left, int mid, int right) {
        long numberOfInversions = 0;

        for (int k = left; k <= right; k++) {
            aux[k] = a[k];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > right) {
                a[k] = aux[i++];
            } else if (aux[i] <= aux[j]) {
                a[k] = aux[i++];
            } else {
                a[k] = aux[j++];
                numberOfInversions += (mid - i + 1);
            }
        }
        return numberOfInversions;
    }

    private static long getNumberOfInversions(int[] a, int[] aux, int left, int right) {
        long numberOfInversions = 0;
        if (right <= left) {
            return numberOfInversions;
        }
        int mid = left + (right - left) / 2;
        numberOfInversions += getNumberOfInversions(a, aux, left, mid);
        numberOfInversions += getNumberOfInversions(a, aux, mid + 1, right);
        numberOfInversions += count(a, aux, left, mid, right);
        return numberOfInversions;
    }

    private static long getNumberOfInversions(int[] a) {
        int[] aux = new int[a.length];
        return getNumberOfInversions(a, aux, 0, a.length - 1);
    }

    // Versión ingenua O(n^2), la que usa el profe para comparar
    private static long getNumberOfInversionsNaive(int[] a) {
        long count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void stressTesting() {
        Random r = new Random();
        int[] a = new int[10];
        for (int it = 0; it < 1000; it++) {
            for (int i = 0; i < a.length; i++) {
                a[i] = r.nextInt(100);
            }
            long number1 = getNumberOfInversionsNaive(a);
            long number2 = getNumberOfInversions(a.clone());
            if (number1 != number2) {
                System.out.println("ERROR: " + number1 + " " + number2);
                for (int i = 0; i < a.length; i++) {
                    System.out.printf("%d ", a[i]);
                }
                break;
            }
        }
        System.out.println("Stress testing terminado: ambas versiones coinciden.");
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(String[] args) {
        int[] ejemplo = {2, 3, 9, 2, 9};
        System.out.println("Ejemplo: " + Arrays.toString(ejemplo));
        System.out.println("Ingenua: " + getNumberOfInversionsNaive(ejemplo));
        System.out.println("Divide y vencerás: " + getNumberOfInversions(ejemplo.clone()));

        stressTesting();

        System.out.println("Ingrese n y luego los n números:");
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        System.out.println("Ingenua: " + getNumberOfInversionsNaive(a));
        System.out.println("Divide y vencerás: " + getNumberOfInversions(a.clone()));
    }
}
