package com.unifyconsulting.superSmoothies;

public class MorningFreshCustomer implements iCustomer {
    private String name;
    private int points = 0;
    private boolean isRewardsMemeber;
    private SuperSmoothiesSchema schema;
    private String phoneNumber;
    private boolean welcomeTextSent;
    private String emailAddress;

    public MorningFreshCustomer(String name, SuperSmoothiesSchema schema, boolean isRewardsMemeber) {
        this.name = name;
        this.schema = schema;
        this.isRewardsMemeber = isRewardsMemeber;
        welcomeTextSent = false;
    }

    @Override
    public void orders(Integer quantity, String drink) {
        points += schema.getPointsFor(drink) * quantity;
        System.out.println(String.format("### %s just earned %d points",
                name,
                points));
    }

    @Override
    public void enroll() {
        isRewardsMemeber = true;
        points += 10;
    }

    @Override
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;

    }

    @Override
    public void sendWelcomeText() {
        welcomeTextSent = true;
    }

    @Override
    public boolean getWelcomeTextSent() {
        return welcomeTextSent;
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;

    }

    @Override
    public boolean getWelcomeEmailSent() {
        return false;
    }

    @Override
    public int getEarnedPoints() {
        return isRewardsMemeber ? points : 0;
    }
}
