package com.lvg.fxtest.groovy

assert 1234 =~ /\d+/
assert 'xxxx' == '1234'.replaceAll(/\d+/,'x')
