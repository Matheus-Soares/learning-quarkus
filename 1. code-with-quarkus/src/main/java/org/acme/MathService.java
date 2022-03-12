package org.acme;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MathService {

    public Integer sum(Integer first, Integer second) {
        return first + second;
    }

    public Integer sub(Integer first, Integer second) {
        return first - second;
    }

    public Integer mult(Integer first, Integer second) {
        return first * second;
    }

    public Float div(Integer first, Integer second) {
        if (second != 0) return ((float) first / (float) second);
        else throw new NumberFormatException("Second number could not be zero!");
    }
}