def a  = 1
def log  = ''
switch (a) {
        case 0 : log += '0'
        case 1 : log += '1'
        case 2 : log += '2'; break
        default: log += 'default'
}

println log

def mac(){
    switch (osname = System.properties.'os.name'){
        case 'Mac OS X': "We're on Mac."; break
        default: "Oh! we have ${osname} system"
    }
}
println mac()
println '---------------------'

a = 10
switch (a){
    case 0 : println("a = ${a} equals 0 "); break
    case 0..9 : println("a = ${a} in range 0..9 "); break
    case [8,9,11] : println("a = ${a} in list [8,9,11] "); break
    case Float : println("a = ${a} is Float "); break
    case {it % 3 == 0} : println("a = ${a} % 3 == 0 "); break
    case ~/../ : println("a = ${a} match /../ "); break
    default: println("a = ${a} has no match"); break
}

class A {
    int x



    @Override
    String toString() {
        return "A = x:${x}"
    }


}

def x = new A(x: 10)
def y = new A(x: 10)

assert x.is(x)

println '-----------------------'

println x.dump()



