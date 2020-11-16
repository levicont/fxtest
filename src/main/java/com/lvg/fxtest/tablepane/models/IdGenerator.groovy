package com.lvg.fxtest.tablepane.models

class IdGenerator {
    private static Long id = 0l

    static Long getId(){
        return ++id
    }
}
