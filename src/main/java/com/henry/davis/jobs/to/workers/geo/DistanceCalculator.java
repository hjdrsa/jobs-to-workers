package com.henry.davis.jobs.to.workers.geo;

import java.math.BigDecimal;
import java.math.MathContext;

public class DistanceCalculator {
    private static final BigDecimal EARTH_RADIUS = BigDecimal.valueOf(6371); // Approx Earth radius in KM

    public static BigDecimal distance(BigDecimal startLat, BigDecimal startLong,
                                      BigDecimal endLat, BigDecimal endLong) {

        MathContext mc = MathContext.DECIMAL64;

        BigDecimal dLat  = endLat.subtract(startLat).multiply(BigDecimal.valueOf(Math.PI/180));
        BigDecimal dLong = endLong.subtract(startLong).multiply(BigDecimal.valueOf(Math.PI/180));

        startLat = startLat.multiply(BigDecimal.valueOf(Math.PI/180));
        endLat   = endLat.multiply(BigDecimal.valueOf(Math.PI/180));

        BigDecimal a = haversin(dLat).add(
                (cos(startLat).multiply(cos(endLat)).multiply(haversin(dLong)))
        );
        BigDecimal c = BigDecimal.valueOf(2).multiply(
                atan2(sqrt(a, mc), sqrt(BigDecimal.ONE.subtract(a), mc))
        );

        return EARTH_RADIUS.multiply(c); // <-- d
    }

    private static BigDecimal haversin(BigDecimal val) {
        BigDecimal a = val.divide(BigDecimal.valueOf(2), MathContext.DECIMAL64);
        return BigDecimal.valueOf(Math.sin(a.doubleValue())).pow(2);
    }

    private static BigDecimal cos(BigDecimal val) {
        return BigDecimal.valueOf(Math.cos(val.doubleValue()));
    }

    private static BigDecimal atan2(BigDecimal a, BigDecimal b) {
        return BigDecimal.valueOf(Math.atan2(a.doubleValue(), b.doubleValue()));
    }

    private static BigDecimal sqrt(BigDecimal a, MathContext mc) {
        return new BigDecimal(Math.sqrt(a.doubleValue()), mc);
    }
}
