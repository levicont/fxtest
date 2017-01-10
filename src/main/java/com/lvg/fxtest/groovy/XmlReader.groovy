package com.lvg.fxtest.groovy

def fileUrl = getClass().classLoader.getResource('META-INF/groovy/xml/customers.xml').file
def customers = new XmlSlurper().parse(new File(fileUrl))
for (customer in customers.corporate.customer)
    println "${customer.@name} works for ${customer.@company}"


