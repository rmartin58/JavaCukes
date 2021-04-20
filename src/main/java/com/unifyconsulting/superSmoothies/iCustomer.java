package com.unifyconsulting.superSmoothies;

public interface iCustomer {
    public int getEarnedPoints();
    public void orders(Integer quantity, String drink);

    void enroll();

    void setPhoneNumber(String phoneNumber);

    void sendWelcomeText();

    boolean getWelcomeTextSent();

    void setEmailAddress(String emailAddress);

    boolean getWelcomeEmailSent();
}
