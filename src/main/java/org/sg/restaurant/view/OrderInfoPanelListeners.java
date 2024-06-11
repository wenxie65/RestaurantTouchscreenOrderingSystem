package org.sg.restaurant.view;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class OrderInfoPanelListeners {

    public static void setKeyboardPanel(VirtualKeyboardPanel virtualKeyboardPanel) {
        TextComponentFocusListener.virtualKeyboardPanel = virtualKeyboardPanel;
    }

    public static class TypeButtonClickedListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton typeButton = (JButton) e.getSource();

            String[] options = { "Pickup", "Delivery" };
            UIManager.put("OptionPane.messageFont", font);
            UIManager.put("OptionPane.buttonFont", font);
            int choice = JOptionPane.showOptionDialog(null, "Choose an option:", "Options", JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
            if (choice == 0) {
                typeButton.setText("Pickup");
            } else if (choice == 1) {
                typeButton.setText("Delivery");
            }
        }
    }

    public static class TextComponentFocusListener implements FocusListener {

        public static VirtualKeyboardPanel virtualKeyboardPanel;

        @Override
        public void focusGained(FocusEvent e) {
            virtualKeyboardPanel.setCurrentSelectionTextComponent((JTextComponent) e.getSource());
        }

        @Override
        public void focusLost(FocusEvent e) {
            // Don't need to handle focus lost
        }
    }

    final static Font font = new Font("Arial", Font.PLAIN, 25);
}
