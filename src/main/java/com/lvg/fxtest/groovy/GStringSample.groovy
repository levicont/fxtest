package com.lvg.fxtest.groovy


def nick = 'Gina'
def book = 'Groovy in action'

assert "$nick in $book" == 'Gina in Groovy in action'
println("$nick in $book")