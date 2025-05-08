'''
Created on 2025年4月17日

@author: 席酒
'''
# 被测代码（示例：计算阶乘）
def factorial(n):
    if n < 0:
        raise ValueError("输入必须为非负整数")
    return 1 if n <= 1 else n * factorial(n-1)

# 测试代码（unittest框架）
import unittest
class TestFactorial(unittest.TestCase):
    def test_positive_input(self):
        self.assertEqual(factorial(5), 120)
    def test_zero_input(self):
        self.assertEqual(factorial(0), 1)
    def test_negative_input(self):
        with self.assertRaises(ValueError):
            factorial(-1)