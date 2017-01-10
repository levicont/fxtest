package com.lvg.fxtest.groovy

def text = "http://azarask.in/services/rhyme/?q=movie".toURL().text
for(rhyme in evaluate('println 1') ) println rhyme
