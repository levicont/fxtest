package com.lvg.fxtest.groovy

import groovy.transform.Immutable

@Immutable
class FixedBook{
    String title
}

def gina = new FixedBook('Groovy in action')
def regina = new FixedBook(title: 'Groovy in action')

assert gina.title == 'Groovy in action'
assert gina == regina

try{
    gina.title = 'Ooops!'
    assert false, 'should not reach here'
}catch(ReadOnlyPropertyException ex){
    println(ex.message)
}
