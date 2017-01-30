package com.lvg.fxtest.groovy.control

def breakes = {println '-'*20}

def store  = ''
for (String i in 'a'..'c'){
    store += i
}
assert store == 'abc'
println "store = $store"
breakes()

store = ''
for (i in [1,2,3]){
    store += i
}
assert store == '123'
println "store = $store"
breakes()

def myString = 'Equivalent to Java'
store = ''
for (i in 0 ..< myString.size()){
    store += myString[i]
}
assert store == myString
println("store = $store")
breakes()

store = ''
for (i in myString){
    store += i
}
assert store == myString
println("store = $store")
breakes()

def matcher = '12xy3' =~ /\d/
for (match in matcher) println(match)
breakes()

for(x in new Object()) println("Printed once for object $x")
print breakes
