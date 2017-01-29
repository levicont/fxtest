package com.lvg.fxtest.groovy.control

assert(true)
assert 1 == 1

def x = 1
assert x == 1

def a = 5
def b = 6
assert a + b == 11

assert ('text'*3 << 'super').size() == 4*3 + 5
println'-----------------'
try{
    input = new File('no such file')
    assert input.exists(), "cannot find: $input.absolutePath"
    assert input.canRead()
    println input.text

}catch (AssertionError error){
//    assert "n" + error.message == '''
// assert input.exists()
//           |    |
//           |    false
//           no such file '''
}

println '------------------'

def host = /\/\/([a-zA-Z0-9-]+(.[a-zA-Z0-9-])*?)(:|\/)/
assertHost 'http://a.b.c:8080/bla', host, 'a.b.c'

def assertHost(candidate, regex, expected){
    candidate.eachMatch(regex){assert  it[1] == expected }
}



