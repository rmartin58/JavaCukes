package com.unifyconsulting.superSmoothies;

public class MorningFreshMember {
    private String name;
    private int points;
    private SuperSmoothiesSchema schema;

    public MorningFreshMember(String name, SuperSmoothiesSchema schema) {
        this.name = name;
        this.schema = schema;
    }

    public void orders(Integer quantity, String drink) {

        points += schema.getPointsFor(drink) * quantity;
    }


    public int getEarnedPoints() {
        return points;
    }
}
