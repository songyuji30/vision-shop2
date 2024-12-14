package com.vision.shoppingmall.common.util;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

@Component("priceRenderUtil")
public class PriceRenderUtil {
    public static String renderPrice(int price) {
        return NumberFormat.getNumberInstance(Locale.KOREA).format(price);
    }
}
