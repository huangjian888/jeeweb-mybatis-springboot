package com.company.business.goods.utils;

import java.math.BigDecimal;

public class BigDecimalUtils {

    /**
     * Add big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return the big decimal
     */
    public static BigDecimal add(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal addBig(BigDecimal b1, BigDecimal b2) {

        return b1.add(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Sub big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return the big decimal
     */
    public static BigDecimal sub(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.subtract(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal subBig(BigDecimal b1, BigDecimal b2) {

        return b1.subtract(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
    }


    /**
     * Mul big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return the big decimal
     */
    public static BigDecimal mul(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    public static BigDecimal mulBig(BigDecimal b1, BigDecimal b2) {

        return b1.multiply(b2).setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Div big decimal.
     *
     * @param v1 the v 1
     * @param v2 the v 2
     * @return the big decimal
     */
    public static BigDecimal div(double v1, double v2) {
        BigDecimal b1 = new BigDecimal(Double.toString(v1));
        BigDecimal b2 = new BigDecimal(Double.toString(v2));
        return b1.divide(b2).setScale(2, BigDecimal.ROUND_HALF_UP);//保留两位小数并进制
    }

    public static BigDecimal divBig(BigDecimal b1, BigDecimal b2) {

        return b1.divide(b2).setScale(2, BigDecimal.ROUND_HALF_UP);//保留两位小数并进制
    }

}


