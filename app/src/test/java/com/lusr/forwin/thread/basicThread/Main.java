package com.lusr.forwin.thread.basicThread;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        prime();
    }

    static void prime() {
        Scanner scanner = new Scanner(System.in);
        int a, b;
        while (scanner.hasNext()) {
            int min = getValue(scanner.nextInt());
            int max = getValue(scanner.nextInt());
            if (min == max && min == 41) {
                break;
            }
            boolean isAll = true;
            for (int i = min; i <= max; i++) {
                if(!isPrime(i)){
                    isAll = false;
                    break;
                }
            }
            if(isAll){
                System.out.println("OK");
            }else {
                System.out.println("Sorry");
            }
        }
    }

    static int getValue(int a) {
        return a * a + a + 41;
    }

    static boolean isPrime(int a) {
        int aSqrt = (int) Math.sqrt(a);
        for (int i = 3; i <= aSqrt; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    static void a12() {
        float[] result = new float[1005];
        result[1] = 1;
        for (int i = 1; i < 1005; ++i) {
            if ((i & 1) == 1) {
                result[i] = 1.0f / i + result[i - 1];
            } else {
                result[i] = result[i - 1] - 1.0f / i;
            }
        }

        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                System.out.println(String.format("%.2f", result[scanner.nextInt()]));
            }
        }
    }

    static void a11() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            boolean hasFlower = false;
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            List<Integer> integers = new ArrayList<>();
            for (int i = a; i <= b; i++) {
                if (isFlower(i)) {
                    hasFlower = true;
                    integers.add(i);
                }
            }
            for (int i = 0; i < integers.size(); i++) {
                if (i == 0) {
                    System.out.print(integers.get(i));
                } else {
                    System.out.print(" " + integers.get(i));
                }
            }
            if (!hasFlower) {
                System.out.println("no");
            } else {
                System.out.println();
            }
        }

    }

    static boolean isFlower(int a) {
        int ge = a % 10;
        int shi = a / 10 % 10;
        int bai = a / 100;
        if (a == (int) (Math.pow(ge, 3) + Math.pow(shi, 3) + Math.pow(bai, 3))) {
            return true;
        }
        return false;
    }


    static void a10() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            double[] re = new double[b];
            re[0] = (float) a;
            double result = 0;
            for (int i = 1; i <= b; i++) {
                result += re[i - 1];
                if (i != b)
                    re[i] = Math.sqrt(re[i - 1]);
            }
            System.out.println(String.format("%.2f", result));
        }
    }

    static void a09() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (scanner.hasNext()) {
            int a = 0, b = 0, c = 0;
            n = scanner.nextInt();
            if (n == 0) {
                break;
            }
            float t;
            for (int i = 0; i < n; ++i) {
                t = scanner.nextFloat();
                if (t < 0) {
                    a++;
                } else if (t > 0) {
                    b++;
                } else {
                    c++;
                }
            }
            System.out.println(a + " " + c + " " + b);
        }
    }

    static void a08() {
        Scanner scanner = new Scanner(System.in);
        int a = 1, b = 1;
        int oddResult = 0, outResult = 0;
        while (scanner.hasNext()) {
            a = scanner.nextInt();
            b = scanner.nextInt();
            oddResult = 0;
            outResult = 0;
            if (a > b) {
                int t = a;
                a = b;
                b = t;
            }
            for (int i = a; i <= b; i++) {
                if ((i & 1) == 1) {
                    oddResult += Math.pow(i, 3);
                } else {
                    outResult += Math.pow(i, 2);
                }
            }
            System.out.println(outResult + " " + oddResult);
        }
    }

    static void a07() {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        List<Integer> integers = new ArrayList<>();
        while (scanner.hasNext()) {
            n = scanner.nextInt();
            int[] a = new int[n];
            int i = 0;
            while (n != 0) {
                a[i++] = scanner.nextInt();
                n--;
            }
            long result = 1;
            for (int j = 0; j < a.length; j++) {
                if ((a[j] & 1) == 1) {
                    result *= a[j];
                }
            }
            System.out.println(result);
        }
    }

    static void a06() {
        Scanner scanner = new Scanner(System.in);
        int[] month = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int[] count = new int[13];
        int flag = 0;
        for (int i = 0; i < month.length; ++i) {
            flag += month[i];
            count[i + 1] = flag;
        }

        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split("/");
            int year = Integer.valueOf(strings[0]);
            int months = Integer.valueOf(strings[1]);
            int day = Integer.valueOf(strings[2]);
            int re = 0;
            re += count[months - 1];
            re += day;

            if (months > 2) {
                re += isAddRun(year) ? 1 : 0;
            }

            System.out.println(re);
        }
    }

    static boolean isAddRun(int year) {
        return year % 400 == 0 || (year % 100 != 0 && year % 4 == 0);
    }

    static void a05() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt();
            if (a < 0 || a > 100) {
                System.out.println("Score is error!");
            } else if (a < 60) {
                System.out.println("E");
            } else if (a < 70) {
                System.out.println("D");
            } else if (a < 80) {
                System.out.println("C");
            } else if (a < 90) {
                System.out.println("B");
            } else if (a <= 100) {
                System.out.println("A");
            }
        }
    }

    static void a04() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            double s = scanner.nextDouble();
            s = s > 0 ? s : -s;
            System.out.println(String.format("%.2f", s));
        }
    }

    static void a03() {
        Scanner scanner = new Scanner(System.in);
        double x, y, xx, yy;
        while (scanner.hasNext()) {
            double Pi = 3.1415927;
            double rate = 4.0 / 3.0;//不要使用4.0f
            System.out.println(String.format("%.3f", Pi * rate * Math.pow(scanner.nextDouble(), 3)));
        }

    }

    static void a031() {
        Scanner scanner = new Scanner(System.in);
        double x, y, xx, yy;
        while (scanner.hasNext()) {
            x = scanner.nextDouble();
            y = scanner.nextDouble();
            xx = scanner.nextDouble();
            yy = scanner.nextDouble();
            double result = Math.pow(x - xx, 2);
            result += Math.pow(y - yy, 2);
            DecimalFormat decimalFormat = new DecimalFormat(".00");
            System.out.println(decimalFormat.format(Math.sqrt(result)));
        }
    }


    static void a01() {
        Scanner scanner = new Scanner(System.in);
        char x, y, z, xx, yy, zz;
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            xx = str.charAt(0);
            yy = str.charAt(1);
            zz = str.charAt(2);
            x = xx < yy ? xx : yy;
            x = x < zz ? x : zz;
            y = xx > yy ? xx : yy;
            y = y > zz ? y : zz;
            System.out.println(x + " " + (char) (xx + yy + zz - x - y) + " " + y);
        }
    }
}
