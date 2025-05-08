package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class TriangleTypeCheckerTest {
    @Test
    void testInvalidTriangles() {
        assertEquals("非三角形", TriangleTypeChecker.checkTriangleType(0, 1, 2));
        assertEquals("非三角形", TriangleTypeChecker.checkTriangleType(-1, 2, 3));
        assertEquals("非三角形", TriangleTypeChecker.checkTriangleType(1, 2, 3));
        assertEquals("非三角形", TriangleTypeChecker.checkTriangleType(1, 1, 2));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 3, '等边三角形'",
            "5, 5, 5, '等边三角形'",
            "10, 10, 10, '等边三角形'"
    })
    void testEquilateralTriangles(int a, int b, int c, String expected) {
        assertEquals(expected, TriangleTypeChecker.checkTriangleType(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 3, 4, '等腰三角形'",
            "5, 5, 8, '等腰三角形'",
            "7, 10, 10, '等腰三角形'",
            "6, 8, 6, '等腰三角形'"
    })
    void testIsoscelesTriangles(int a, int b, int c, String expected) {
        assertEquals(expected, TriangleTypeChecker.checkTriangleType(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "3, 4, 5, '直角三角形'",
            "5, 12, 13, '直角三角形'",
            "8, 15, 17, '直角三角形'",
            "7, 24, 25, '直角三角形'"
    })
    void testRightTriangles(int a, int b, int c, String expected) {
        assertEquals(expected, TriangleTypeChecker.checkTriangleType(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 4, '钝角三角形'",
            "5, 7, 9, '钝角三角形'",
            "6, 8, 11, '钝角三角形'"
    })
    void testObtuseTriangles(int a, int b, int c, String expected) {
        assertEquals(expected, TriangleTypeChecker.checkTriangleType(a, b, c));
    }

    @ParameterizedTest
    @CsvSource({
            "5, 6, 7, '锐角三角形'",
            "7, 8, 9, '锐角三角形'",
            "10, 11, 12, '锐角三角形'"
    })
    void testAcuteTriangles(int a, int b, int c, String expected) {
        assertEquals(expected, TriangleTypeChecker.checkTriangleType(a, b, c));
    }
}