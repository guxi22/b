package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class LeapYearCheckerTest {

    // 普通测试用例
    @Test
    void testNormalLeapYears() {
        assertTrue(LeapYearChecker.isLeapYear(2000));
        assertTrue(LeapYearChecker.isLeapYear(2020));
        assertTrue(LeapYearChecker.isLeapYear(2400));
    }

    @Test
    void testNormalNonLeapYears() {
        assertFalse(LeapYearChecker.isLeapYear(1900));
        assertFalse(LeapYearChecker.isLeapYear(2021));
        assertFalse(LeapYearChecker.isLeapYear(2100));
    }

    // 边界值测试
    @Test
    void testBoundaryValues() {
        assertTrue(LeapYearChecker.isLeapYear(4)); // 第一个闰年
        assertFalse(LeapYearChecker.isLeapYear(1)); // 第一个非闰年
    }

    // 异常测试
    @Test
    void testInvalidYear() {
        assertThrows(IllegalArgumentException.class, () -> LeapYearChecker.isLeapYear(0));
        assertThrows(IllegalArgumentException.class, () -> LeapYearChecker.isLeapYear(-1));
        assertThrows(IllegalArgumentException.class, () -> LeapYearChecker.isLeapYear(-100));
    }

    // 参数化测试 - 使用CsvSource
    @ParameterizedTest(name = "年份 {0} 是闰年: {1}")
    @CsvSource({
            "2000, true",   // 能被400整除
            "2004, true",   // 能被4整除但不能被100整除
            "1900, false",  // 能被100整除但不能被400整除
            "2001, false",  // 普通非闰年
            "2400, true",   // 能被400整除
            "2100, false"   // 能被100整除但不能被400整除
    })
    void parameterizedTestWithCsvSource(int year, boolean expected) {
        assertEquals(expected, LeapYearChecker.isLeapYear(year));
    }

    // 参数化测试 - 使用ValueSource测试异常情况
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -4, -100, -400})
    void parameterizedTestInvalidYears(int year) {
        assertThrows(IllegalArgumentException.class, () -> LeapYearChecker.isLeapYear(year));
    }
}
