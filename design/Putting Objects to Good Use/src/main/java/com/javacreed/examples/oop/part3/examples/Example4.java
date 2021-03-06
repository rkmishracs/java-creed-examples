/*
 * #%L
 * Putting Objects to Good Use
 * $Id:$
 * $HeadURL$
 * %%
 * Copyright (C) 2012 - 2014 Java Creed
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.javacreed.examples.oop.part3.examples;

import com.javacreed.examples.oop.part3.Item;
import com.javacreed.examples.oop.part3.tax.BasicTaxCalculator;
import com.javacreed.examples.oop.part3.tax.TaxCalculator;

public class Example4 {

  @SuppressWarnings("unused")
  private static final TaxCalculator SALES_TAX = new BasicTaxCalculator("0.1800");

  private static final TaxCalculator IMPORT_TAX = new BasicTaxCalculator("0.0300");

  @SuppressWarnings("unused")
  private static final TaxCalculator ECO_TAX = new BasicTaxCalculator("0.0500");

  public static void main(final String[] args) {
    final Item medicine = new Item("Imported Medicine", "8.40", Example4.IMPORT_TAX);
    System.out.println(medicine);
  }
}
