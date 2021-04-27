package org.springframework.guru.domain;

import org.springframework.stereotype.Component;

@Component
public class BookPublisher {

    private int publisherId;
    private String firstName;
    private String lastName;

    public BookPublisher() {
    }

    public BookPublisher(int publisherId, String firstName, String lastName) {
        this.publisherId = publisherId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "BookPublisher{" +
                "publisherId=" + publisherId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
