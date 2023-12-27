package org.daffodile.utils;

import java.util.HashMap;
import java.util.Map;

public final class Utils {
  private static final Map<Integer, String> defs = new HashMap<>() {
    {
      put(1, "One");
      put(2, "Two");
      put(3, "Three");
      put(4, "Four");
      put(5, "Five");
      put(6, "Six");
      put(7, "Seven");
      put(8, "Eight");
      put(9, "Nine");
      put(10, "Ten");

      put(11, "Eleven");
      put(12, "Twelve");
      put(13, "Thirteen");
      put(14, "Fourteen");
      put(15, "Fifteen");
      put(16, "Sixteen");
      put(17, "Seventeen");
      put(18, "Eighteen");
      put(19, "Ninteen");

      put(20, "Twenty");
      put(30, "Thirty");
      put(40, "Fourty");
      put(50, "Fifty");
      put(60, "Sixty");
      put(70, "Seventy");
      put(80, "Eighty");
      put(90, "Ninty");

      put(100, "Hundred");
      put(1000, "Thousand");
      put(1_000_000, "Million");
      put(1_000_000_000, "Billion");
    }
  };

  public static String numberToText(Integer number) {
    if(number == null){
      throw new RuntimeException("Null number value.");
    }else if(number < 1){
      return "Invalid number.";
    }

    return numberToTextHelper(number)
      .replaceAll(String.format("(\\s%s)(\\s+\\w+)", defs.get(1_000_000_000)), "$1,$2")
        .replaceAll(String.format("(\\s%s)(\\s+\\w+)",defs.get(1_000_000)), "$1,$2")
        .replaceAll(String.format("(\\s%s)(\\s+\\w+)", defs.get(1_000)), "$1,$2");
  }

  private static String numberToTextHelper(Integer number)
      throws RuntimeException {

    // Integer.MAX_VALUE 2_147_483_647

    if(number == 0){
      return "";
    }

    int pwr = Double.valueOf(Math.log10(number)).intValue();
    pwr = pwr > 3 ? ((pwr / 3) * 3) : pwr;

    StringBuilder builder = new StringBuilder();

    if (number <= 20) {
      return defs.get(number);
    } else if (number < 100) {
      int ones = number % 10;
      int tens = number - ones;

      builder.append(defs.get(tens));
      if (ones == 0) {
        return builder.toString();
      }
      builder.append(" ");
      builder.append(defs.get(ones));
      return builder.toString();
    }

    int dividend = Double.valueOf(Math.pow(10, pwr)).intValue();
    int cof = number / dividend;

    builder.append(numberToTextHelper(cof));
    builder.append(" ");
    builder.append(defs.get(dividend));

    int remainder = number % dividend;

    String r = numberToTextHelper(remainder);

    if (!r.isBlank()) {
      builder.append(" ");
      builder.append(r);
    }

    return builder.toString();
  }
}
