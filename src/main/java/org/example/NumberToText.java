package org.example;

import org.example.utils.Utils;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class NumberToText {
  public static void main(String[] args) {

    int number = 871_225_931;
    System.out.println("Number To Text:");
    System.out.println("\tNumber: " + number);
    System.out.println("\tNumberToText: " + Utils.numberToText(number));
  }

}
