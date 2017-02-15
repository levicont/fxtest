package com.lvg.fxtest.groovy.dynamic


println(String.metaClass)
assert String.metaClass =~ /MetaClassImpl/

String.metaClass.low = {k=10 -> def s = delegate.toLowerCase()
                        println("k = $k; delegate = $delegate")
                        return s }
assert String.metaClass =~ /ExpandoMetaClass/
println(String.metaClass)

assert "DIERK".low() == 'dierk'
println("DIERK".low(20))