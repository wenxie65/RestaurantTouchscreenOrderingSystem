package org.sg.restaurant.view;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.util.HashMap;

public class OrderInfoPanelUI extends JPanel{

    public OrderInfoPanelUI() {
        setLayout(new BorderLayout(5,5));

        add(createMainPanel(), BorderLayout.CENTER);

        add(createKeyboardContainerPanel(), BorderLayout.SOUTH);
    }

    private JPanel createKeyboardContainerPanel() {
        keyboardContainerPanel = new JPanel();
        keyboardContainerPanel.setLayout(new BorderLayout());
        keyboardContainerPanel.setPreferredSize(new Dimension(400, 250));

        virtualKeyboardPanel = new VirtualKeyboardPanel();
        virtualKeyboardPanel.setTextComponentMap(textComponentMap);
        OrderInfoPanelListeners.setKeyboardPanel(virtualKeyboardPanel);
        keyboardContainerPanel.add(virtualKeyboardPanel.getKeyboardPanel(), BorderLayout.CENTER);

        return keyboardContainerPanel;
    }

    private JPanel createMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(1,3,10, 10));

        mainPanel.add(createOrderInfoPanel());
        mainPanel.add(createAddressRecommendPanel());
        mainPanel.add(createOrderHistoryAndButtonPanel());

        return mainPanel;
    }

    private JPanel createOrderHistoryAndButtonPanel() {
        orderHistoryAndButtonPanel = new JPanel();
        orderHistoryAndButtonPanel.setLayout(new BorderLayout());

        orderHistoryAndButtonPanel.add(createOrderHistoryPanel(), BorderLayout.CENTER);

        orderHistoryAndButtonPanel.add(createOrderButtonPanel(), BorderLayout.SOUTH);

        return orderHistoryAndButtonPanel;
    }

    private JPanel createOrderButtonPanel() {
        orderButtonPanel = new JPanel();
        orderButtonPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        orderButton = new JButton("Order");
        orderButton.setFont(font);
        orderButtonPanel.add(orderButton);

        return orderButtonPanel;
    }

    private JPanel createOrderHistoryPanel() {
        orderHistoryPanel = new JPanel();
        orderHistoryPanel.setLayout(new GridLayout(4, 1));

        orderHistoryButton1.setFont(font);
        orderHistoryPanel.add(orderHistoryButton1);

        orderHistoryButton2.setFont(font);
        orderHistoryPanel.add(orderHistoryButton2);

        orderHistoryButton3.setFont(font);
        orderHistoryPanel.add(orderHistoryButton3);

        orderHistoryButton4.setFont(font);
        orderHistoryPanel.add(orderHistoryButton4);

        return orderHistoryPanel;
    }

    private JPanel createAddressRecommendPanel() {
        addressRecommendPanel = new JPanel();
        addressRecommendPanel.setLayout(new GridLayout(4, 2));

        addressRecommendButton1.setFont(font);
        addressRecommendPanel.add(addressRecommendButton1);

        addressRecommendButton2.setFont(font);
        addressRecommendPanel.add(addressRecommendButton2);

        addressRecommendButton3.setFont(font);
        addressRecommendPanel.add(addressRecommendButton3);

        addressRecommendButton4.setFont(font);
        addressRecommendPanel.add(addressRecommendButton4);

        addressRecommendButton5.setFont(font);
        addressRecommendPanel.add(addressRecommendButton5);

        addressRecommendButton6.setFont(font);
        addressRecommendPanel.add(addressRecommendButton6);

        addressRecommendButton7.setFont(font);
        addressRecommendPanel.add(addressRecommendButton7);

        addressRecommendButton8.setFont(font);
        addressRecommendPanel.add(addressRecommendButton8);

        return addressRecommendPanel;
    }

    private JPanel createOrderInfoPanel() {
        orderInfoPanel = new JPanel();
        orderInfoPanel.setLayout(new BorderLayout());

        orderInfoPanel.add(createPhoneNumberPanel(), BorderLayout.NORTH);
        orderInfoPanel.add(createOrderTypePanel(), BorderLayout.CENTER);
        orderInfoPanel.add(createCustomerInfoPanel(), BorderLayout.SOUTH);

        return orderInfoPanel;
    }

    private JPanel createCustomerInfoPanel() {
        customerInfoPanel = new JPanel();
        customerInfoPanel.setLayout(new BorderLayout());

        customerInfoPanel.add(createAddressPanel(), BorderLayout.NORTH);
        customerInfoPanel.add(createNamePanel(), BorderLayout.CENTER);
        customerInfoPanel.add(createNotesPanel(), BorderLayout.SOUTH);

        customerInfoPanel.setBorder(border);

        return customerInfoPanel;
    }

    private JPanel createPhoneNumberPanel() {
        phoneNumberPanel = new JPanel();
        phoneNumberPanel.setLayout(new BorderLayout());
        phoneNumberPanel.setBorder(border);

        phoneNumberLabel = new JLabel("Phone #: ");
        phoneNumberLabel.setFont(font);
        phoneNumberPanel.add(phoneNumberLabel, BorderLayout.WEST);

        phoneNumberTextField = new JTextField();
        phoneNumberTextField.setFont(font);
        phoneNumberTextField.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());
        phoneNumberTextField.setPreferredSize(new Dimension(300, phoneNumberTextField.getPreferredSize().height));
        phoneNumberPanel.add(phoneNumberTextField, BorderLayout.CENTER);

        textComponentMap.put(1, phoneNumberTextField);

        return phoneNumberPanel;
    }

    private JPanel createOrderTypePanel() {
        orderTypePanel = new JPanel();
        orderTypePanel.setLayout(new BorderLayout());
        orderTypePanel.setBorder(border);

        typeButton = new JButton("Pickup");
        typeButton.setFont(font);
        typeButton.addActionListener(new OrderInfoPanelListeners.TypeButtonClickedListener());
        orderTypePanel.add(typeButton, BorderLayout.CENTER);

        return orderTypePanel;
    }

    private JPanel createAddressPanel() {
        addressPanel = new JPanel();
        addressPanel.setLayout(new BorderLayout());

        addressPanel.add(createHouseAptNumberPanel(), BorderLayout.NORTH);
        addressPanel.add(createStreetNamePanel(), BorderLayout.CENTER);
        addressPanel.add(createCityZipPanel(), BorderLayout.SOUTH);

        return addressPanel;
    }

    private JPanel createHouseAptNumberPanel() {
        houseAptNumberPanel = new JPanel();
        houseAptNumberPanel.setLayout(new GridLayout(2,1));

        houseAptNumberPanel.add(createHouseNumberPanel());
        houseAptNumberPanel.add(createAptNumberPanel());

        return houseAptNumberPanel;
    }

    private JPanel createHouseNumberPanel() {
        houseNumberPanel = new JPanel();
        houseNumberPanel.setLayout(new BorderLayout());
        houseNumberPanel.setBorder(border);

        houseNumberLabel = new JLabel("House #: ");
        houseNumberLabel.setFont(font);
        houseNumberPanel.add(houseNumberLabel, BorderLayout.WEST);

        houseNumberTextField = new JTextField();
        houseNumberTextField.setFont(font);
        houseNumberTextField.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());
        houseNumberTextField.setPreferredSize(new Dimension(300, houseNumberTextField.getPreferredSize().height));
        houseNumberPanel.add(houseNumberTextField, BorderLayout.CENTER);

        textComponentMap.put(2, houseNumberTextField);

        return houseNumberPanel;
    }

    private JPanel createAptNumberPanel() {
        aptNumberPanel = new JPanel();
        aptNumberPanel.setLayout(new BorderLayout());
        aptNumberPanel.setBorder(border);

        aptNumberLabel = new JLabel("Apt #:      ");
        aptNumberLabel.setFont(font);
        aptNumberPanel.add(aptNumberLabel, BorderLayout.WEST);

        aptNumberTextField = new JTextField();
        aptNumberTextField.setFont(font);
        aptNumberTextField.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());
        aptNumberTextField.setPreferredSize(new Dimension(300, aptNumberTextField.getPreferredSize().height));
        aptNumberPanel.add(aptNumberTextField, BorderLayout.CENTER);

        textComponentMap.put(3, aptNumberTextField);

        return aptNumberPanel;
    }

    private JPanel createStreetNamePanel() {
        streetNamePanel = new JPanel();
        streetNamePanel.setLayout(new BorderLayout());
        streetNamePanel.setBorder(border);

        streetNameLabel = new JLabel("Street:     ");
        streetNameLabel.setFont(font);
        streetNamePanel.add(streetNameLabel, BorderLayout.WEST);

        streetNameTextArea = new JTextArea(3,10);
        streetNameTextArea.setLineWrap(true);
        streetNameTextArea.setFont(font);
        streetNameTextArea.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());

        streetNameScrollPane = new JScrollPane(streetNameTextArea);
        streetNamePanel.add(streetNameScrollPane, BorderLayout.CENTER);

        textComponentMap.put(4, streetNameTextArea);

        return streetNamePanel;
    }

    private JPanel createCityZipPanel() {
        cityZipPanel = new JPanel();
        cityZipPanel.setLayout(new GridLayout(2,1,10,10));

        cityZipPanel.add(createCityNamePanel());
        cityZipPanel.add(createZipcodePanel());

        return cityZipPanel;
    }

    private JPanel createCityNamePanel() {
        cityNamePanel = new JPanel();
        cityNamePanel.setLayout(new BorderLayout());
        cityNamePanel.setBorder(border);

        cityNameLabel = new JLabel("City:        ");
        cityNameLabel.setFont(font);
        cityNamePanel.add(cityNameLabel, BorderLayout.WEST);

        cityNameTextField = new JTextField();
        cityNameTextField.setFont(font);
        cityNameTextField.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());
        cityNamePanel.add(cityNameTextField, BorderLayout.CENTER);

        textComponentMap.put(5, cityNameTextField);

        return cityNamePanel;
    }

    private JPanel createZipcodePanel() {
        zipcodePanel = new JPanel();
        zipcodePanel.setLayout(new BorderLayout());
        zipcodePanel.setBorder(border);

        zipcodeLabel = new JLabel("Zipcode:  ");
        zipcodeLabel.setFont(font);
        zipcodePanel.add(zipcodeLabel, BorderLayout.WEST);

        zipcodeTextField = new JTextField();
        zipcodeTextField.setFont(font);

        zipcodeTextField.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());
        zipcodePanel.add(zipcodeTextField, BorderLayout.CENTER);

        textComponentMap.put(6, zipcodeTextField);

        return zipcodePanel;
    }

    private JPanel createNamePanel() {
        namePanel = new JPanel();
        namePanel.setLayout(new BorderLayout());
        namePanel.setBorder(border);

        nameLabel = new JLabel("Name:     ");
        nameLabel.setFont(font);
        namePanel.add(nameLabel, BorderLayout.WEST);

        nameTextField = new JTextField();
        nameTextField.setFont(font);
        nameTextField.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());
        namePanel.add(nameTextField, BorderLayout.CENTER);

        textComponentMap.put(7, nameTextField);

        return namePanel;
    }

    private JPanel createNotesPanel() {
        notesPanel = new JPanel();
        notesPanel.setLayout(new BorderLayout());
        notesPanel.setBorder(border);

        notesLabel = new JLabel("Notes:     ");
        notesLabel.setFont(font);
        notesPanel.add(notesLabel, BorderLayout.WEST);

        notesTextArea = new JTextArea(2,10);
        notesTextArea.setLineWrap(true);
        notesTextArea.setFont(font);
        notesTextArea.addFocusListener(new OrderInfoPanelListeners.TextComponentFocusListener());

        notesScrollPane = new JScrollPane(notesTextArea);
        notesPanel.add(notesScrollPane, BorderLayout.CENTER);

        textComponentMap.put(8, notesTextArea);

        return notesPanel;
    }


    final static Font font = new Font("Arial", Font.PLAIN, 25);
    final static Border border = BorderFactory.createEmptyBorder(2,2,2,2);
    HashMap<Integer, JTextComponent> textComponentMap = new HashMap<>();

    VirtualKeyboardPanel virtualKeyboardPanel = new VirtualKeyboardPanel();

    JPanel mainPanel = new JPanel();
    JPanel keyboardContainerPanel = new JPanel();
    JPanel addressRecommendPanel = new JPanel();
    JPanel orderInfoPanel = new JPanel();
    JPanel customerInfoPanel = new JPanel();
    JPanel phoneNumberPanel = new JPanel();
    JPanel orderTypePanel = new JPanel();
    JPanel addressPanel = new JPanel();
    JPanel houseAptNumberPanel = new JPanel();
    JPanel houseNumberPanel = new JPanel();
    JPanel aptNumberPanel = new JPanel();
    JPanel streetNamePanel = new JPanel();
    JPanel cityZipPanel = new JPanel();
    JPanel cityNamePanel = new JPanel();
    JPanel zipcodePanel = new JPanel();
    JPanel namePanel = new JPanel();
    JPanel notesPanel = new JPanel();
    JPanel orderHistoryPanel = new JPanel();
    JPanel orderHistoryAndButtonPanel = new JPanel();
    JPanel orderButtonPanel = new JPanel();

    JLabel phoneNumberLabel = new JLabel();
    JLabel houseNumberLabel = new JLabel();
    JLabel aptNumberLabel = new JLabel();
    JLabel streetNameLabel = new JLabel();
    JLabel cityNameLabel = new JLabel();
    JLabel zipcodeLabel = new JLabel();
    JLabel nameLabel = new JLabel();
    JLabel notesLabel = new JLabel();

    JTextField phoneNumberTextField = new JTextField();
    JTextField houseNumberTextField = new JTextField();
    JTextField aptNumberTextField = new JTextField();
    JTextField cityNameTextField = new JTextField();
    JTextField zipcodeTextField = new JTextField();
    JTextField nameTextField = new JTextField();

    JButton typeButton = new JButton();
    JButton addressRecommendButton1  = new JButton();
    JButton addressRecommendButton2  = new JButton();
    JButton addressRecommendButton3  = new JButton();
    JButton addressRecommendButton4  = new JButton();
    JButton addressRecommendButton5  = new JButton();
    JButton addressRecommendButton6  = new JButton();
    JButton addressRecommendButton7  = new JButton();
    JButton addressRecommendButton8  = new JButton();
    JButton orderHistoryButton1 = new JButton();
    JButton orderHistoryButton2 = new JButton();
    JButton orderHistoryButton3 = new JButton();
    JButton orderHistoryButton4 = new JButton();
    JButton orderButton = new JButton();

    JTextArea streetNameTextArea = new JTextArea();
    JTextArea notesTextArea = new JTextArea();

    JScrollPane streetNameScrollPane = new JScrollPane();
    JScrollPane notesScrollPane = new JScrollPane();
}
