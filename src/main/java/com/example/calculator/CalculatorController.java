package com.example.calculator;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


public class CalculatorController {

    String str, first, second;
    int func = 0;
    boolean flagFirstOperation = true, flagOfNewOperation = false; //Первый флаг для ввода 1-го значения, второй для обнуления результата при нажатии на цифры

    private void reset() {
        calculatorText.setText("");
        str = null;
        first = null;
        second = null;
        func = 0;
        flagFirstOperation = true;
    }

    private void equally() {
        str = calculatorText.getText();
        int ind;
        switch (func) {
            case 1 -> {
                second = str;
                System.out.println(first + "+" + second + " = " + (Double.parseDouble(first) + Double.parseDouble(second)));
                first = String.valueOf(Double.parseDouble(first) + Double.parseDouble(second));
                calculatorText.setText(first);
                flagOfNewOperation = true;
                break;
            }
            case 2 -> {
                second = str;
                System.out.println(first + "-" + second + " = " + (Double.parseDouble(first) - Double.parseDouble(second)));
                first = String.valueOf(Double.parseDouble(first) - Double.parseDouble(second));
                calculatorText.setText(first);
                flagOfNewOperation = true;
                break;
            }
            case 3 -> {
                second = str;
                System.out.println(first + "*" + second + " = " + (Double.parseDouble(first) * Double.parseDouble(second)));
                first = String.valueOf(Double.parseDouble(first) * Double.parseDouble(second));
                calculatorText.setText(first);
                flagOfNewOperation = true;
                break;
            }
            case 4 -> {
                second = str;
                if (str.equals("0")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Нельзя делить на 0");
                    alert.showAndWait();
                    reset();
                } else {
                    System.out.println(first + "/" + second + " = " + (Double.parseDouble(first) / Double.parseDouble(second)));
                    first = String.valueOf(Double.parseDouble(first) / Double.parseDouble(second));
                    calculatorText.setText(first);
                    flagOfNewOperation = true;
                }
                break;
            }
            case 5 -> {
                second = str;
                System.out.println(first + "^" + second + " = " + (Math.pow(Double.parseDouble(first), Double.parseDouble(second))));
                first = String.valueOf(Math.pow(Double.parseDouble(first), Double.parseDouble(second)));
                calculatorText.setText(first);
                flagOfNewOperation = true;
                break;
            }
            case 6 -> {
                System.out.println(Math.sqrt(Double.parseDouble(str)));
                if (flagFirstOperation) {
                    flagFirstOperation = false;
                }
                first = String.valueOf(Math.sqrt(Double.parseDouble(str)));
                calculatorText.setText(first);
                flagOfNewOperation = true;
                break;
            }
            default -> {
                first = str;
                System.out.println(first);
                calculatorText.clear();
                break;
            }
        }
        func = 0;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField calculatorText;

    @FXML
    private Button degreeButton;

    @FXML
    private Button divButton;

    @FXML
    private Button eightButton;

    @FXML
    private Button equallyButton;

    @FXML
    private Button fiveButton;

    @FXML
    private Button fourButton;

    @FXML
    private Button minusButton;

    @FXML
    private Button multButton;

    @FXML
    private Button nineButton;

    @FXML
    private Button oneButton;

    @FXML
    private Button sevenButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button sqrtButton;

    @FXML
    private Button sumButton;

    @FXML
    private Button threeButton;

    @FXML
    private Button twoButton;

    @FXML
    private Button resetButton;

    @FXML
    private Button pointButton;

    @FXML
    private Button zeroButton;

    @FXML
    void pointFunc() {
        calculatorText.setText(calculatorText.getText()+".");
    }

    @FXML
    void degreeFunc() {
        if (isDouble(calculatorText.getText())) {
            equally();
            func = 5;
        }
    }

    @FXML
    void divFunc() {
        if (isDouble(calculatorText.getText())) {
            equally();
            func = 4;
        }
    }

    @FXML
    void eightFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("8");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "8");
        }
    }

    @FXML
    void equallyFunc() {
        equally();
    }

    @FXML
    void fiveFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("5");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "5");
        }
    }

    @FXML
    void fourFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("4");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "4");
        }
    }

    @FXML
    void sumFunc() {
        if (isDouble(calculatorText.getText())) {
            equally();
            func = 1;
        }
    }

    @FXML
    void minusFunc() {
        if (isDouble(calculatorText.getText())) {
            equally();
            func = 2;
        }
    }

    @FXML
    void multFunc() {
        if (isDouble(calculatorText.getText())) {
            equally();
            func = 3;
        }
    }

    @FXML
    void nineFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("9");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "9");
        }
    }

    @FXML
    void oneFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("1");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "1");
        }
    }

    @FXML
    void sevenFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("7");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "7");
        }
    }

    @FXML
    void sixFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("6");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "6");
        }
    }

    @FXML
    void sqrtFunc() {
        if (isDouble(calculatorText.getText())) {
            if (func != 0) {
                equally();
            }
            func = 6;
            equally();
        }
    }

    @FXML
    void threeFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("3");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "3");
        }
    }

    @FXML
    void twoFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("2");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "2");
        }
    }

    @FXML
    void resetFunc() {
        reset();
    }

    @FXML
    void zeroFunc() {
        if (flagOfNewOperation) {
            calculatorText.setText("0");
            flagOfNewOperation = false;
        } else {
            str = calculatorText.getText();
            calculatorText.setText(str + "0");
        }
    }

    @FXML
    void calculatorFunc() {
        isDouble(calculatorText.getText());
    }

    private boolean isDouble(String message) {
        try {
            double number = Double.parseDouble(message);
            System.out.println(number);
            return true;
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Неправильно введено число");
            alert.showAndWait();
            reset();
            return false;
        }
    }

    @FXML
    void initialize() {
        assert calculatorText != null : "fx:id=\"calculatorText\" was not injected: check your FXML file 'calculator.fxml'.";
        assert pointButton != null : "fx:id=\"commaButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert degreeButton != null : "fx:id=\"degreeButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert divButton != null : "fx:id=\"divButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert eightButton != null : "fx:id=\"eightButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert equallyButton != null : "fx:id=\"equallyButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert fiveButton != null : "fx:id=\"fiveButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert fourButton != null : "fx:id=\"fourButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert minusButton != null : "fx:id=\"minusButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert multButton != null : "fx:id=\"multButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert nineButton != null : "fx:id=\"nineButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert oneButton != null : "fx:id=\"oneButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert resetButton != null : "fx:id=\"resetButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert sevenButton != null : "fx:id=\"sevenButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert sixButton != null : "fx:id=\"sixButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert sqrtButton != null : "fx:id=\"sqrtButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert sumButton != null : "fx:id=\"sumButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert threeButton != null : "fx:id=\"threeButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert twoButton != null : "fx:id=\"twoButton\" was not injected: check your FXML file 'calculator.fxml'.";
        assert zeroButton != null : "fx:id=\"zeroButton\" was not injected: check your FXML file 'calculator.fxml'.";
    }
}
