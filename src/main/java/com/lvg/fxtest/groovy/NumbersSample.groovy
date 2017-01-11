package com.lvg.fxtest.groovy

//All numbers is object

def x = 12
def y = 18

assert x + y == 30
assert x.plus(y) == 30
assert x instanceof Integer