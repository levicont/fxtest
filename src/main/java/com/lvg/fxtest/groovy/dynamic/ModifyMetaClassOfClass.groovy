package com.lvg.fxtest.groovy.dynamic

class MyClass{}

def before = new MyClass()

MyClass.metaClass.myProp = "MyClass prop"
MyClass.metaClass.test = { -> myProp}

try{
    before.test()
    assert false, "should throw MME"
}catch (mme){}

assert new MyClass().test() == "MyClass prop"
