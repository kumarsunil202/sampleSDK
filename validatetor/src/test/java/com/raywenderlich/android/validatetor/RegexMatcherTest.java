/*
 * Modifications Copyright (c) 2018 Razeware LLC
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.raywenderlich.android.validatetor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RegexMatcherTest {

  private RegexMatcher regexMatcher;
  private String str;

  @Before
  public void setup() throws Exception {
    regexMatcher = new RegexMatcher();
  }

  @After
  public void tearDown() throws Exception {
    regexMatcher = null;
  }

  @Test
  public void validate_shouldThrowExeception_whenRegexStringIsNull() throws Exception {

    str = "abc";
    boolean threwException = false;

    try {
      regexMatcher.validate(str, (String) null);
    } catch (IllegalArgumentException expectedException) {
      threwException = true;
    }
    assertEquals(true, threwException);
  }

  @Test
  public void validate_shouldThrowExeception_whenRegexStringIsEmpty() throws Exception {

    str = "abc";
    boolean threwException = false;

    try {
      regexMatcher.validate(str, "");
    } catch (IllegalArgumentException expectedException) {
      threwException = true;
    }
    assertEquals(true, threwException);
  }

  @Test
  public void validate_shouldReturnFalse_whenStringIsEmpty() throws Exception {
    str = "";
    assertEquals(false, regexMatcher.validate(str, RegexPresetPattern.ALPHA));
  }

  @Test
  public void validate_shouldReturnFalse_whenStringIsNull() throws Exception {
    assertEquals(false, regexMatcher.validate(null, RegexPresetPattern.ALPHA));
  }


  @Test
  public void validate_shouldReturnTrue_whenStringIsValidAlpha() throws Exception {
    str = "abc";
    assertEquals(true, regexMatcher.validate(str, RegexPresetPattern.ALPHA));
  }

  @Test
  public void validate_shouldReturnTrue_whenRegexStringIsValidString() throws Exception {
    str = "abc";
    assertEquals(true, regexMatcher.validate(str, "[a-zA-Z]+"));
  }
}