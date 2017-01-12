package com.lvg.fxtest.groovy

assert 1234 =~ /\d+/
assert 'xxxx' == '1234'.replaceAll(/\d/,'x')

def matcher = '2:3 4:5 6:78' =~ /(\S+):(\S+)/
matcher.each { item -> println item}

def twister = 'she sells sea shells at the sea shore of seychelles'

def regex = /b(w)w*1b/
def many  = 100 * 1000
start = System.nanoTime()
many.times{
    twister =~ regex  // #1 Find operator with implicit pattern const
}
timeImplicit = System.nanoTime() - start
println(timeImplicit)
start = System.nanoTime()
pattern = ~regex  // #2 Explicit pattern construction
many.times{
    pattern.matcher(twister)  // #3 Apply pattern on a string
}
timePredef = System.nanoTime() - start
println(timePredef)
assert timeImplicit > timePredef * 2  // #4 up to factor 5