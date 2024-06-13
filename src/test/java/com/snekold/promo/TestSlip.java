package com.snekold.promo;

import org.junit.jupiter.api.Test;

public class TestSlip {

    @Test
    public void testMethodSlip(){
        String code = "gg45g42g,4h5h356ht,356h356h53)h356h356h3!h356h356h.345351111";
        String[] codes = code.split("[,!).]");

        for (int i = 0; i < codes.length; i++) {
            System.out.println(codes[i]);
        }

    }
}
