package com.lvg.fxtest.groovy.dynamic

def move(string, distance){
    string.collect { (it as char) + distance as char}.join()
}

String.metaClass {
    shift = -1
    encode { -> move delegate, shift}
    decode { -> move delegate, -shift}
    getCode { -> encode() }
    getOrig { -> decode() }
}

assert "IBM".encode() == "HAL"
println("IBM".encode())
