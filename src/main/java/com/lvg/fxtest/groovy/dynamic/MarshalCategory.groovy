package com.lvg.fxtest.groovy.dynamic

class Marshal {
    static String marshal(Integer self){
        self.toString()
    }

    static Integer unMarshal(String self){
        self.toInteger()
    }
}

use Marshal, {
    a = 5
    assert  1.marshal() == "1"
    assert "1".unMarshal() == 1
    [Integer.MIN_VALUE, -1, 0, Integer.MAX_VALUE].each{
        assert it.marshal().unMarshal() == it
    }

    println a.marshal().class
}