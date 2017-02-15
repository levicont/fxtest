package com.lvg.fxtest.groovy.dynamic

class MyClass2 {}


def myClass2 = new MyClass2()

myClass2.metaClass.myProp = "MyClass2 prop"
myClass2.metaClass.test = { -> myProp}

try{
    new MyClass2().test()
    assert false, "should throw MME"
}catch (mme){}

assert myClass2.test() == "MyClass2 prop"