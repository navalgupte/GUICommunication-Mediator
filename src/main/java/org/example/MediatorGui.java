package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/*
    MediatorGui Class - Creates the main window and three panels for the application.
    It also creates the mediator and matches it with the three child panels.
 */
public class MediatorGui {
    private ContactMediator mediator;

    public void setContactMediator(ContactMediator newMediator) {
        mediator = newMediator;
    }

    public void createGui() {
        JFrame mainFrame = new JFrame("Mediator Example");
        Container content = mainFrame.getContentPane();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        ContactSelectorPanel select = new ContactSelectorPanel(mediator);
        ContactDisplayPanel display = new ContactDisplayPanel(mediator);
        ContactEditorPanel edit = new ContactEditorPanel(mediator);
        content.add(select);
        content.add(display);
        content.add(edit);
        mediator.setContactSelectorPanel(select);
        mediator.setContactDisplayPanel(display);
        mediator.setContactEditorPanel(edit);
        mainFrame.addWindowListener(new WindowCloseManager());
        mainFrame.pack();
        mainFrame.setVisible(true);
    }

    private class WindowCloseManager extends WindowAdapter {
        public void windowClosing(WindowEvent evt) {
            System.exit(0);
        }
    }
}
