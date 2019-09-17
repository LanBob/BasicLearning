package com.lusr.forwin.HuaWeiIWantIt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.nextLine();
            String[] strings = str.split("},");
            String A = strings[0];
            String As = A.substring(3, A.length());
            String[] aNum = As.split(",");

            String B = strings[1];
            String Bs = B.substring(3, B.length());
            String[] bNum = Bs.split(",");

            String Rs = strings[2];
            String rNum = Rs.substring(2, Rs.length());

            int[] a = new int[aNum.length];
            int[] b = new int[bNum.length];
            for (int i = 0; i < aNum.length; i++) {
                a[i] = Integer.valueOf(aNum[i]);
            }

            for (int i = 0; i < bNum.length; i++) {
                b[i] = Integer.valueOf(bNum[i]);
            }


            int r = Integer.valueOf(rNum);


            for (int i = 0; i < a.length; i++) {

                boolean has = false;
                for (int j = 0; j < b.length; j++) {
                    if (a[i] <= b[j] && b[j] - a[i] <= r) {
                        System.out.print("(" + a[i] + "," + b[j] + ")");
                        has = true;
                    }
                }

                if (!has) {
                    for (int j = 0; j < b.length; j++) {
                        if(a[i] <= b[j]){
                            System.out.print("(" + a[i] + "," + b[j] + ")");
                            break;
                        }
                    }
                }
            }
            System.out.println();
        }
    }
}
