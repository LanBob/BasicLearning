package com.lusr.forwin.JVM;

import java.util.ArrayList;
import java.util.List;

public class OOM {
    static class OOMObject {

    }

    public static void main(String[] args) {

        List<OOMObject> list = new ArrayList<>();
        int i = 0;
        while (true) {
            ++i;
            //360146
            //205548
            System.out.println("======================================" + i);
            list.add(new OOMObject());
        }
    }

}
