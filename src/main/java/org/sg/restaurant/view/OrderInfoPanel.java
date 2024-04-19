package org.sg.restaurant.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class OrderInfoPanel extends JPanel{

    final static Font font = new Font("Arial", Font.PLAIN, 25);
    final static Border border = BorderFactory.createEmptyBorder(5,10,5,10);
    HashMap<JTextComponent, String> textComponentStringMap = new HashMap<>();
    VirtualKeyboardPanel virtualKeyboardPanel;

    public OrderInfoPanel() {
        setLayout(new BorderLayout());
        add(createOrderInfoPanel(), BorderLayout.CENTER);

        virtualKeyboardPanel = new VirtualKeyboardPanel();
        virtualKeyboardPanel.setTextComponentStringMap(textComponentStringMap);
        add(virtualKeyboardPanel.getKeyboardPanel(), BorderLayout.SOUTH);
    }

    private JPanel createOrderInfoPanel() {
        JPanel orderInfoPanel = new JPanel();
        orderInfoPanel.setLayout(new BorderLayout());

        orderInfoPanel.add(createPhoneNumberPanel(), BorderLayout.NORTH);
        orderInfoPanel.add(createOrderTypePanel(), BorderLayout.CENTER);
        orderInfoPanel.add(createCustomerInfoPanel(), BorderLayout.SOUTH);

        return orderInfoPanel;
    }

    private JPanel createCustomerInfoPanel() {
        JPanel customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new BorderLayout());

        customerInfoPanel.add(createAddressPanel(), BorderLayout.NORTH);
        customerInfoPanel.add(createNamePanel(), BorderLayout.CENTER);
        customerInfoPanel.add(createNotesPanel(), BorderLayout.SOUTH);


        return customerInfoPanel;
    }

    private JPanel createPhoneNumberPanel() {
        JPanel phoneNumberPanel = new JPanel();
        phoneNumberPanel.setLayout(new BorderLayout());
        phoneNumberPanel.setBorder(border);

        JLabel phoneNumberLabel = new JLabel("Phone Number: ");
        phoneNumberLabel.setFont(font);
        phoneNumberPanel.add(phoneNumberLabel, BorderLayout.WEST);

        JTextField phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(font);
        phoneNumberTextField.addFocusListener(new TextComponentFocusListener());
        phoneNumberPanel.add(phoneNumberTextField, BorderLayout.CENTER);

        textComponentStringMap.put(phoneNumberTextField, "phoneNumberTextField");

        return phoneNumberPanel;
    }

    private JPanel createOrderTypePanel() {
        JPanel orderTypePanel = new JPanel();
        orderTypePanel.setLayout(new BorderLayout());
        orderTypePanel.setBorder(border);

        JButton typeButton = new JButton("Pickup");
        typeButton.setFont(font);
        typeButton.addActionListener(new TypeButtonClickedListener());
        orderTypePanel.add(typeButton, BorderLayout.CENTER);

        return orderTypePanel;
    }

    private JPanel createAddressPanel() {
        JPanel addressPanel = new JPanel();
        addressPanel.setLayout(new BorderLayout());

        addressPanel.add(createHouseAptNumberPanel(), BorderLayout.NORTH);
        addressPanel.add(createStreetNamePanel(), BorderLayout.CENTER);
        addressPanel.add(createCityZipPanel(), BorderLayout.SOUTH);

        return addressPanel;
    }

    private JPanel createHouseAptNumberPanel() {
        JPanel houseAptNumberPanel = new JPanel();
        houseAptNumberPanel.setLayout(new GridLayout(1,2,10,10));

        houseAptNumberPanel.add(createHouseNumberPanel());
        houseAptNumberPanel.add(createAptNumberPanel());

        return houseAptNumberPanel;
    }

    private JPanel createHouseNumberPanel() {
        JPanel houseNumberPanel = new JPanel();
        houseNumberPanel.setLayout(new BorderLayout());
        houseNumberPanel.setBorder(border);

        JLabel houseNumberLabel = new JLabel("House Number: ");
        houseNumberLabel.setFont(font);
        houseNumberPanel.add(houseNumberLabel, BorderLayout.WEST);

        JTextField houseNumberTextField = new JTextField();
        houseNumberTextField.setFont(font);
        houseNumberTextField.addFocusListener(new TextComponentFocusListener());
        houseNumberPanel.add(houseNumberTextField, BorderLayout.CENTER);

        textComponentStringMap.put(houseNumberTextField, "houseNumberTextField");

        return houseNumberPanel;
    }

    private JPanel createAptNumberPanel() {
        JPanel aptNumberPanel = new JPanel();
        aptNumberPanel.setLayout(new BorderLayout());
        aptNumberPanel.setBorder(border);

        JLabel aptNumberLabel = new JLabel("Apt Number: ");
        aptNumberLabel.setFont(font);
        aptNumberPanel.add(aptNumberLabel, BorderLayout.WEST);

        JTextField aptNumberTextField = new JTextField();
        aptNumberTextField.setFont(font);
        aptNumberTextField.addFocusListener(new TextComponentFocusListener());
        aptNumberPanel.add(aptNumberTextField, BorderLayout.CENTER);

        textComponentStringMap.put(aptNumberTextField, "aptNumberTextField");

        return aptNumberPanel;
    }

    private JPanel createStreetNamePanel() {
        JPanel streetNamePanel = new JPanel();
        streetNamePanel.setLayout(new BorderLayout());
        streetNamePanel.setBorder(border);

        JLabel streetNameLabel = new JLabel("Street: ");
        streetNameLabel.setFont(font);
        streetNamePanel.add(streetNameLabel, BorderLayout.NORTH);

        JTextArea streetNameTextArea = new JTextArea(3,10);
        streetNameTextArea.setLineWrap(true);
        streetNameTextArea.setFont(font);
        streetNameTextArea.addFocusListener(new TextComponentFocusListener());

        JScrollPane scrollPane = new JScrollPane(streetNameTextArea);
        streetNamePanel.add(scrollPane, BorderLayout.CENTER);

        textComponentStringMap.put(streetNameTextArea, "streetNameTextArea");

        return streetNamePanel;
    }

    private JPanel createCityZipPanel() {
        JPanel cityZipPanel = new JPanel();
        cityZipPanel.setLayout(new GridLayout(1,2,10,10));

        cityZipPanel.add(createCityNamePanel());
        cityZipPanel.add(createZipcodePanel());

        return cityZipPanel;
    }

    private JPanel createCityNamePanel() {
        JPanel cityNamePanel = new JPanel();
        cityNamePanel.setLayout(new BorderLayout());
        cityNamePanel.setBorder(border);

        JLabel cityNameLabel = new JLabel("City: ");
        cityNameLabel.setFont(font);
        cityNamePanel.add(cityNameLabel, BorderLayout.WEST);

        JTextField cityNameTextField = new JTextField();
        cityNameTextField.setFont(font);
        cityNameTextField.addFocusListener(new TextComponentFocusListener());
        cityNamePanel.add(cityNameTextField, BorderLayout.CENTER);

        textComponentStringMap.put(cityNameTextField, "cityNameTextField");

        return cityNamePanel;
    }

    private JPanel createZipcodePanel() {
        JPanel zipcodePanel = new JPanel();
        zipcodePanel.setLayout(new BorderLayout());
        zipcodePanel.setBorder(border);

        JLabel zipcodeLabel = new JLabel("Zipcode: ");
        zipcodeLabel.setFont(font);
        zipcodePanel.add(zipcodeLabel, BorderLayout.WEST);

        JTextField zipcodeTextField = new JTextField();
        zipcodeTextField.setFont(font);
        zipcodeTextField.addFocusListener(new TextComponentFocusListener());
        zipcodePanel.add(zipcodeTextField, BorderLayout.CENTER);

        textComponentStringMap.put(zipcodeTextField, "zipcodeTextField");

        return zipcodePanel;
    }

    private JPanel createNamePanel() {
        JPanel namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        namePanel.setBorder(border);

        JLabel nameLabel = new JLabel("Name: ");
        nameLabel.setFont(font);
        namePanel.add(nameLabel, BorderLayout.WEST);

        JTextField nameTextField = new JTextField();
        nameTextField.setFont(font);
        nameTextField.addFocusListener(new TextComponentFocusListener());
        namePanel.add(nameTextField, BorderLayout.CENTER);

        textComponentStringMap.put(nameTextField, "nameTextField");

        return namePanel;
    }

    private JPanel createNotesPanel() {
        JPanel notesPanel = new JPanel();
        notesPanel.setLayout(new BorderLayout());
        notesPanel.setBorder(border);

        JLabel notesLabel = new JLabel("Notes: ");
        notesLabel.setFont(font);
        notesPanel.add(notesLabel, BorderLayout.WEST);

        JTextArea notesTextArea = new JTextArea(2,10);
        notesTextArea.setLineWrap(true);
        notesTextArea.setFont(font);
        notesTextArea.addFocusListener(new TextComponentFocusListener());

        JScrollPane scrollPane = new JScrollPane(notesTextArea);
        notesPanel.add(scrollPane, BorderLayout.CENTER);

        textComponentStringMap.put(notesTextArea, "notesTextArea");

        return notesPanel;
    }

    private static class TypeButtonClickedListener implements ActionListener {

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

    private class TextComponentFocusListener implements FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            virtualKeyboardPanel.setCurrentSelectionTextComponent((JTextComponent) e.getSource());
        }

        @Override
        public void focusLost(FocusEvent e) {
            // Don't need to handle focus lost
        }
    }
}
