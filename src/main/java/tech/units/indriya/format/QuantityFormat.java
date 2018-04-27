/*
 * Units of Measurement API
 * Copyright (c) 2014-2018, Jean-Marie Dautelle, Werner Keil, Otavio Santana.
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions
 *    and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *
 * 3. Neither the name of JSR-385 nor the names of its contributors may be used to endorse or promote products
 *    derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE,
 * EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package tech.units.indriya.format;

import java.io.IOException;
import java.text.ParsePosition;

import javax.measure.Quantity;
import javax.measure.format.ParserException;

/**
 * <p>
 * Formats instances of {@link Quantity}.
 * </p>
 *
 * <h1><a name="synchronization">Synchronization</a></h1>
 * <p>
 * Instances of this class are not required to be thread-safe. It is recommended to use separate format instances for each thread. If multiple threads
 * access a format concurrently, it must be synchronized externally.
 * <p>
 *
 * @author <a href="mailto:werner@uom.technology">Werner Keil</a>
 * @version 0.3, 26 January, 2018
 * @since 2.0
 *
 * @see Quantity
 */
public interface QuantityFormat {

  /**
   * Formats the specified quantity into an <code>Appendable</code>.
   *
   * @param quantity
   *          the quantity to format.
   * @param dest
   *          the appendable destination.
   * @return the specified <code>Appendable</code>.
   * @throws IOException
   *           if an I/O exception occurs.
   */
  public Appendable format(Quantity<?> quantity, Appendable dest) throws IOException;

  /**
   * Parses a portion of the specified <code>CharSequence</code> from the specified position to produce a {@link Quantity}. If parsing succeeds, then
   * the index of the <code>cursor</code> argument is updated to the index after the last character used.
   *
   * @param csq
   *          the <code>CharSequence</code> to parse.
   * @param cursor
   *          the cursor holding the current parsing index.
   * @return the quantity parsed from the specified character sub-sequence.
   * @throws IllegalArgumentException
   *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
   */
  public Quantity<?> parse(CharSequence csq, ParsePosition cursor) throws IllegalArgumentException, ParserException;

  /**
   * Parses a portion of the specified <code>CharSequence</code> from the specified position to produce a {@link Quantity}. If parsing succeeds, then
   * the index of the <code>cursor</code> argument is updated to the index after the last character used.
   *
   * @param csq
   *          the <code>CharSequence</code> to parse.
   * @param cursor
   *          the cursor holding the current parsing index.
   * @return the quantity parsed from the specified character sub-sequence.
   * @throws IllegalArgumentException
   *           if any problem occurs while parsing the specified character sequence (e.g. illegal syntax).
   */
  public Quantity<?> parse(CharSequence csq) throws ParserException;

  /**
   * Returns <code>true</code> if this {@link QuantityFormat} depends on a <code>Locale</code> to perform its tasks.
   * <p>
   * In environments that do not support a <code>Locale</code>, e.g. Java ME, this usually returns <code>false</code>.
   * </p>
   *
   * @return Whether this format depends on the locale.
   */
  default boolean isLocaleSensitive() {
      return false;
  }
}
