package com.baoyi.utils;


import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Set;

public class NumberTools {
  /**
   * get Integer type
   * @param obj
   * @return
   */
  public static Integer toInteger(Object obj) {
    if (obj == null || obj.equals("")) {
      return null;
    }
    else {
      return new Integer(toNumber(obj).intValue());
    }
  }

  /**
   * get Float type
   * @param obj
   * @return
   */

  public static Float toFloat(Object obj) {
    if (obj == null || obj.equals("")) {
      return null;
    }
    else {
      return new Float(toNumber(obj).floatValue());
    }

  }

  /**
   * get Short type
   * @param obj
   * @return
   */

  public static Short toShort(Object obj) {
    if (obj == null || obj.equals("")) {
      return null;
    }
    else {
      return new Short(toNumber(obj).shortValue());
    }

  }

  /**
   * get Long type
   * @param obj
   * @return
   */

  public static Long toLong(Object obj) {
    if (obj == null || obj.equals("")) {
      return null;
    }
    else {
      return new Long(toNumber(obj).longValue());
    }

  }

  /**
   * get Double type
   * @param obj
   * @return
   */

  public static Double toDouble(Object obj) {
    if (obj == null || obj.equals("")) {
      return null;
    }
    else {
      return new Double(toNumber(obj).doubleValue());
    }

  }

  /**
   * structure Number Object
   * @param obj Number child object
   * @return
   */

  public static Number toNumber(Object obj) {
    if (obj == null) {
      return null;
    }
    if (obj instanceof Number) {
      return (Number) obj;
    }
    try {
      NumberFormat parser = getNumberFormat(Locale.getDefault());
      return parser.parse(String.valueOf(obj));
    }
    catch (Exception e) {
      return null;
    }
  }

  private static NumberFormat getNumberFormat(Locale locale)
  {
    return NumberFormat.getNumberInstance(locale);
  }
  
  public static double changeToDecimal2(double instance){
	BigDecimal   bd   =   new   BigDecimal(instance);   
    bd   =   bd.setScale(2,BigDecimal.ROUND_HALF_EVEN);   
    instance = bd.doubleValue();
    return instance;
	}
}
