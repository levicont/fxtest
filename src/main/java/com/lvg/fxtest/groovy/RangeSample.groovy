package com.lvg.fxtest.groovy

class Weekday implements Comparable{
    static final DAYS = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat']
    private int idx = 0

    Weekday(index){
        idx = index
    }

    Weekday next(){
        new Weekday(idx+1)
    }

    Weekday previous(){
        new Weekday(idx-1)
    }

    @Override
    int compareTo(Object o) {
        return this.idx<=>o.idx
    }

    String toString(){
        def index = idx % DAYS.size()
        while (index < 0 ) index += DAYS.size()
        return DAYS[index]
    }
}

def mon = new Weekday(1)
def fri = new Weekday(5)

def report = ''

for (day in mon..fri){
    report += day.toString() + " "
}
7.times {mon++}

println(mon)

def diary = 'no work on '
for (day in ++fri ..< mon ){
    diary += day.toString() + ' '
}

println diary