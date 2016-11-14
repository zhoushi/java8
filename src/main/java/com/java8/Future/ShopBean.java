package com.java8.Future;

import java.util.Random;

import static com.java8.Future.Util.delay;
import static com.java8.Future.Util.format;

/**
 * Created by Administrator on 2016/11/14.
 */
public class ShopBean {

    private final String name;
    private final Random random;

    public ShopBean(String name){
        this.name = name;
        random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
    }

    public String getPrice(String product) {
        double price = calculatePrice(product);
        Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];
        return name + ":" + price + ":" + code;
    }

    public double calculatePrice(String product) {
        delay();
        return format(random.nextDouble() * product.charAt(0) + product.charAt(1));
    }



    public String getName() {
        return name;
    }
}
