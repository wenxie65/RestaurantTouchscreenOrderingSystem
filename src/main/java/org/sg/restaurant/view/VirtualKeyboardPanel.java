package org.sg.restaurant.view;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashMap;

public class VirtualKeyboardPanel extends JPanel{

    private final JPanel keyboardPanel;
    private JTextComponent currentSelectionTextComponent;
    private HashMap<JTextComponent, String> textComponentStringMap;
    private boolean isCap;
    private boolean isShift;
    final static Font font = new Font("Arial", Font.PLAIN, 25);

    public VirtualKeyboardPanel() {
        this.keyboardPanel = newVirtualKeyboardPanel();
        isCap = false;
        isShift = false;
    }

    public JPanel getKeyboardPanel() {
        return keyboardPanel;
    }

    public void setCurrentSelectionTextComponent(JTextComponent currentSelectionTextComponent) {
        this.currentSelectionTextComponent = currentSelectionTextComponent;
    }

    public void setTextComponentStringMap(HashMap<JTextComponent, String> textComponentStringMap) {
        this.textComponentStringMap = textComponentStringMap;
    }

    private JPanel newVirtualKeyboardPanel() {
        String[][] keys;
        if (isShift) {
            keys = new String[][]{
                    {"~", "!", "@", "#", "$", "%", "^", "&", "*", "(", ")", "_", "+", "←"},
                    {"Tab", "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P", "{", "}", "|"},
                    {"Caps", "A", "S", "D", "F", "G", "H", "J", "K", "L", ":", "\"", "Enter"},
                    {"Shift", "Z", "X", "C", "V", "B", "N", "M", "<", ">", "?", "Shift"},
                    {"Space"}
            };
        } else {
            keys = new String[][]{
                    {"`", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "-", "=", "←"},
                    {"Tab", "q", "w", "e", "r", "t", "y", "u", "i", "o", "p", "[", "]", "\\"},
                    {"Caps", "a", "s", "d", "f", "g", "h", "j", "k", "l", ";", "'", "Enter"},
                    {"Shift", "z", "x", "c", "v", "b", "n", "m", ",", ".", "/", "Shift"},
                    {"Space"}
            };
        }

        if (isCap) {
            for (int i = 0; i < keys.length; i++) {
                for (int j = 0; j < keys[i].length; j++) {
                    if (keys[i][j].length() == 1) {
                        keys[i][j] = keys[i][j].toUpperCase();
                    }
                }
            }
        }

        JPanel keyboardPanel = new JPanel(new GridLayout(5, 1));

        for (String[] line : keys) {
            JPanel temp = new JPanel(new GridLayout(1, line.length));
            for (String label : line) {
                JButton button = new JButton(label);
                button.setFont(font);
                button.addActionListener(new KeyButtonListener());
                temp.add(button);
            }
            keyboardPanel.add(temp);
        }

        return keyboardPanel;
    }

    private void updateKeyboard() {
        JPanel newKeyboardPanel = newVirtualKeyboardPanel();
        keyboardPanel.removeAll();

        for (Component comp : newKeyboardPanel.getComponents()) {
            JPanel linePanel = (JPanel) comp;
            JPanel temp = new JPanel(new GridLayout(1, linePanel.getWidth()));
            for (Component c : linePanel.getComponents()) {
                JButton keyButton = (JButton) c;
                String label = keyButton.getText();
                JButton newButton = new JButton(label);
                newButton.setFont(font);
                newButton.addActionListener(new KeyButtonListener());
                temp.add(newButton);
            }
            keyboardPanel.add(temp);
        }
        keyboardPanel.revalidate();
        keyboardPanel.repaint();
    }

    private class KeyButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentSelectionTextComponent != null) {
                JButton button = (JButton) e.getSource();
                String key = button.getText();
                String text = currentSelectionTextComponent.getText();

                if (isShift && !key.equals("Shift")) {
                    isShift = false;
                }

                switch (key) {
                    case "←":
                        if (!text.isEmpty()) {
                            text = text.substring(0, text.length() - 1);
                        }
                        break;
                    case "Tab":
                        text += "     ";
                        break;
                    case "Enter":
                        if (currentSelectionTextComponent.getClass() == JTextArea.class) {
                            text += "\n";
                        }
                        break;
                    case "Space":
                        text += " ";
                        break;
                    case "Caps":
                        isCap = !isCap;
                        break;
                    case "Shift":
                        isShift = !isShift;
                        break;
                    default:
                        text += key;
                        KeyEvent keyEvent = new KeyEvent(currentSelectionTextComponent, KeyEvent.KEY_TYPED, System.currentTimeMillis(), 0, KeyEvent.VK_UNDEFINED, key.charAt(0));
                        currentSelectionTextComponent.dispatchEvent(keyEvent);
                        break;
                }
                updateKeyboard();
                currentSelectionTextComponent.setText(text);
                currentSelectionTextComponent.requestFocusInWindow();
                if (textComponentStringMap.get(currentSelectionTextComponent).equals("phoneNumberTextField")) {
                    formatPhoneNumber();
                }
            }
        }

        public void formatPhoneNumber() {
            int MAX_LENGTH = 10;

            String phoneNumber = currentSelectionTextComponent.getText().replaceAll("\\D", "");
            StringBuilder formattedPhoneNumber = new StringBuilder();
            for (int i = 0; i < Math.min(phoneNumber.length(), MAX_LENGTH); i++) {
                if (i == 3 || i == 6) {
                    formattedPhoneNumber.append('-');
                }
                formattedPhoneNumber.append(phoneNumber.charAt(i));
            }
            currentSelectionTextComponent.setText(formattedPhoneNumber.toString());
        }
    }
}
