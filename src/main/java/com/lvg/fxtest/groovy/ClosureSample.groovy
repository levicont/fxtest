package com.lvg.fxtest.groovy

def totalClink = 0
def totalPeople = 100

1.upto(totalPeople){guestNumber ->
    clinkWithGuest = guestNumber - 1
    totalClink += clinkWithGuest
}

assert totalClink == (totalPeople * (totalPeople - 1)/2)

def code = '1 +'
def expr = '49.0'
code += expr
println(code)
println(evaluate(code))