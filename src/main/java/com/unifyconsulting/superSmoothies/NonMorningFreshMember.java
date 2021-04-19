package com.unifyconsulting.superSmoothies;

public class NonMorningFreshMember implements iCustomer {

    private String name;
    private SuperSmoothiesSchema schema;

    public NonMorningFreshMember(String name, SuperSmoothiesSchema schema) {
        this.name = name;
        this.schema = schema;
    }
    @Override
    public int getEarnedPoints() {
        return 0;
    }

    @Override
    public void orders(Integer quantity, String drink) {
        System.out.println(String.format("#### Inform the customer they are missing out on %d points", schema.getPointsFor(drink)*quantity));
    }
}
