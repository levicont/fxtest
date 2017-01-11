package com.lvg.fxtest.groovy

class BookBean{
    String title
}

def groovyBook = new BookBean()

groovyBook.setTitle('Groovy book')
assert groovyBook.getTitle() == 'Groovy book'

groovyBook.title = 'Groovy in action'
assert groovyBook.title == 'Groovy in action'
