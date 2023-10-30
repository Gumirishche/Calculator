package com.example.calculator;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

    String str, first, second, result;
    int func = 0;
    boolean flag = true, pointF = true, opFlag = false;

    String[] funcs = {"+", "^", "/", "*", "sqrt"};

    private void reset() {
        calculatorText.setText("");
        str = null;
        first = null;
        second = null;
        func = 0;
        flag = true;
        pointF = true;
    }

    private void equally() {
        str = calculatorText.getText();
        int ind;
        switch (func) {
            case 1 -> {
                ind = calculatorText.getText().indexOf("+");
                second = str.substring(ind + 1);
                first = str.substring(0, ind);
                System.out.println(first + "+" + second);
                result = String.valueOf(Double.parseDouble(first) + Double.parseDouble(second));
                calculatorText.setText(result);
            }
            case 2 -> {
                ind = calculatorText.getText().indexOf("^");
                second = str.substring(ind + 1);
                first = str.substring(0, ind);
                System.out.println(first + "^" + second);
                result = String.valueOf(Math.pow(Double.parseDouble(first), Double.parseDouble(second)));
                calculatorText.setText(result);
            }
            case 3 -> {
                ind = calculatorText.getText().indexOf("/");
                second = str.substring(ind + 1);
                first = str.substring(0, ind);
                System.out.println(first + "/" + second);
                if (Objects.equals(second, "0")) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Нельзя делить на 0");
                    alert.showAndWait();
                    reset();
                } else {
                    result = String.valueOf(Double.parseDouble(first) / Double.parseDouble(second));
                    calculatorText.setText(result);
                }
            }
            case 4 -> {
                ind = calculatorText.getText().indexOf("*");
                second = str.substring(ind + 1);
                first = str.substring(0, ind);
                System.out.println(first + "*" + second);
                result = String.valueOf(Double.parseDouble(first) * Double.parseDouble(second));
                calculatorText.setText(result);
            }
            case 5 -> {
                ind = calculatorText.getText().indexOf("sqrt");
                second = str.substring(ind + 4);
                System.out.println("sqrt" + second);
                if (Double.parseDouble(second) < 0) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("Под корнем не может быть отрцательного числа");
                    alert.showAndWait();
                    reset();
                } else {
                    result = String.valueOf(Math.sqrt(Double.parseDouble(second)));
                    calculatorText.setText(result);
                }
            }
            case 6 -> {
                ind = calculatorText.getText().indexOf("-");
                second = str.substring(ind + 1);
                first = str.substring(0, ind);
                System.out.println(first + "-" + second);
                result = String.valueOf(Double.parseDouble(first) - Double.parseDouble(second));
                calculatorText.setText(result);
            }
        }
        func = 0;
        opFlag = false;
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
        if (pointF) {
            str = calculatorText.getText();
            calculatorText.setText(str + ".");
            pointF = false;
        }
    }

    @FXML
    void degreeFunc() {
        if (!calculatorText.getText().substring(calculatorText.getText().length() - 1).equals("^")) {
            if (opFlag) {
                first = calculatorText.getText();
                calculatorText.setText(first.substring(0, first.length() - 1) + "^");
                flag = false;
            } else {
                if (flag) {
                    first = calculatorText.getText();
                    calculatorText.setText(first + "^");
                    flag = false;
                } else {
                    equally();
                    str = calculatorText.getText();
                    calculatorText.setText(str + "^");
                }
            }
            opFlag = true;
            pointF = true;
            func = 2;
        }
    }

    @FXML
    void divFunc() {
        if (!calculatorText.getText().substring(calculatorText.getText().length() - 1).equals("/")) {
            if (opFlag) {
                first = calculatorText.getText();
                calculatorText.setText(first.substring(0, first.length() - 1) + "/");
                flag = false;
            } else {
                if (flag) {
                    first = calculatorText.getText();
                    calculatorText.setText(first + "/");
                    flag = false;
                } else {
                    equally();
                    str = calculatorText.getText();
                    calculatorText.setText(str + "/");
                }
            }
            pointF = true;
            opFlag = true;
            func = 3;
        }
    }

    @FXML
    void eightFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "8");
        opFlag = false;
    }

    @FXML
    void equallyFunc() {
        equally();
    }

    @FXML
    void fiveFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "5");
        opFlag = false;
    }

    @FXML
    void fourFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "4");
        opFlag = false;
    }

    @FXML
    void sumFunc() {
        if (!calculatorText.getText().substring(calculatorText.getText().length() - 1).equals("+")) {
            if (opFlag) {
                first = calculatorText.getText();
                calculatorText.setText(first.substring(0, first.length() - 1) + "+");
                flag = false;
            } else {
                if (flag) {
                    first = calculatorText.getText();
                    calculatorText.setText(first + "+");
                    flag = false;
                } else {
                    equally();
                    str = calculatorText.getText();
                    calculatorText.setText(str + "+");
                }
            }
            pointF = true;
            opFlag = true;
            func = 1;
        }
    }

    @FXML
    void minusFunc() {
        if (!calculatorText.getText().substring(calculatorText.getText().length() - 1).equals("-")) {
            if (opFlag) {
                first = calculatorText.getText();
                calculatorText.setText(first + "-");
                flag = false;
                opFlag = false;
            } else {
                if (flag) {
                    first = calculatorText.getText();
                    calculatorText.setText(first + "-");
                    if (!first.isEmpty()) {
                        flag = false;
                    }
                } else {
                    equally();
                    str = calculatorText.getText();
                    calculatorText.setText(str + "-");
                }
                opFlag = true;
                func = 6;
            }
            pointF = true;
        }
    }

    @FXML
    void multFunc() {
        if (!calculatorText.getText().substring(calculatorText.getText().length() - 1).equals("*")) {
            if (opFlag) {
                first = calculatorText.getText();
                calculatorText.setText(first.substring(0, first.length() - 1) + "*");
                flag = false;
            } else {
                if (flag) {
                    first = calculatorText.getText();
                    calculatorText.setText(first + "*");
                    flag = false;
                } else {
                    equally();
                    str = calculatorText.getText();
                    calculatorText.setText(str + "*");
                }
            }
            opFlag = true;
            pointF = true;
            func = 4;
        }
    }

    @FXML
    void nineFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "9");
        opFlag = false;
    }

    @FXML
    void oneFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "1");
        opFlag = false;
    }

    @FXML
    void sevenFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "7");
        opFlag = false;
    }

    @FXML
    void sixFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "6");
        opFlag = false;
    }

    @FXML
    void sqrtFunc() {
        if (calculatorText.getText().charAt(0) != 's') {
            if (opFlag) {
                first = calculatorText.getText();
                System.out.println(first);
                calculatorText.setText("sqrt" + first.substring(0, first.length() - 1));
            } else {
                equally();
                str = calculatorText.getText();
                calculatorText.setText("sqrt" + str);
            }
            flag = false;
            opFlag = false;
            func = 5;
        }
    }

    @FXML
    void threeFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "3");
        opFlag = false;
    }

    @FXML
    void twoFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "2");
        opFlag = false;
    }

    @FXML
    void resetFunc() {
        reset();
    }

    @FXML
    void zeroFunc() {
        str = calculatorText.getText();
        calculatorText.setText(str + "0");
        opFlag = false;
    }

    @FXML
    void calculatorFunc() {
        boolean sqrtFlag = false;
        int ind = 0;
        str = calculatorText.getText();
        if (!str.replace("sqrt","").matches("[a-zA-Z]+")) {
            for (int i = 0; i < 5; i++) {
                if (str.contains(funcs[i])) {
                    if (i == 4) {
                        sqrtFlag = true;
                    }
                    func = i + 1;
                    ind = str.indexOf(funcs[i]);
                    break;
                }
            }
            if (str.contains("-") && func == 0) {
                func = 6;
                ind = str.indexOf("-");
            }
            if (func == 0) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Error");
                alert.setHeaderText("Введите данные формата: число(операция)число");
                alert.showAndWait();
                reset();
            } else {
                String f = str.substring(0, ind), s;
                if (sqrtFlag)
                    s = str.substring(ind + 4);
                else
                    s = str.substring(ind + 1);
                if (f.chars().filter(c -> c == '.').count() > 1 || s.chars().filter(c -> c == '.').count() > 1) {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Error");
                    alert.setHeaderText("В одном числе не может быть больше 1 точки");
                    alert.showAndWait();
                    reset();
                } else
                    equally();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Error");
            alert.setHeaderText("Должны бить только цифры и операции");
            alert.showAndWait();
            reset();
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
