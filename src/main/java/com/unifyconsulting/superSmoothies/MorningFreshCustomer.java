package com.unifyconsulting.superSmoothies;

public class MorningFreshCustomer {
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


    public void orders(Integer quantity, String drink) {
        if (isRewardsMemeber) {
            points += schema.getPointsFor(drink) * quantity;
        }

        System.out.println(String.format("### %s just earned %d points",
                name,
                points));
    }


    public void enroll() {
        isRewardsMemeber = true;
        points += 10;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public void sendWelcomeText() {
        welcomeTextSent = true;
    }


    public boolean getWelcomeTextSent() {
        return welcomeTextSent;
    }


    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }


    public boolean getWelcomeEmailSent() {
        return false;
    }


    public int getEarnedPoints() {
        return points;
    }
}
