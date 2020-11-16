package com.lvg.fxtest.groovy.date

import java.time.LocalDate

/**
 * Created by Victor Levchenko LVG Corp. on 19.11.19.
 */
class DateTest {
    static void main(String[] args) {
        LocalDate date = LocalDate.now()

        println("date: ${date}")
    }

}
