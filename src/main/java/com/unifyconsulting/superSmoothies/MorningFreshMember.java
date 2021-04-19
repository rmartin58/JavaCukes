package com.unifyconsulting.superSmoothies;

public class MorningFreshMember implements iCustomer {
    private String name;
    private int points;
    private SuperSmoothiesSchema schema;

    public MorningFreshMember(String name, SuperSmoothiesSchema schema) {
        this.name = name;
        this.schema = schema;
    }

    @Override
    public void orders(Integer quantity, String drink) {

        points += schema.getPointsFor(drink) * quantity;
    }

    @Override
    public int getEarnedPoints() {
        return points;
    }
}
