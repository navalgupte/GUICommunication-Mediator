package org.example;

public class RunPattern {
    public static void main(String[] args) {
        System.out.println("Example showing use of Mediator Pattern");
        System.out.println("---- ---- ---- ---- ----");
        Contact contact1 = new ContactImpl("", "", "", "");
        Contact contact2 = new ContactImpl("Steven", "Handel", "Java Advocate", "The Patterns Guild");

        ContactMediatorImpl mediator = new ContactMediatorImpl();
        mediator.addContact(contact1);
        mediator.addContact(contact2);

        MediatorGui gui = new MediatorGui();
        gui.setContactMediator(mediator);
        gui.createGui();

        System.out.println("---- ---- ---- ---- ----");
    }
}