package com.lvg.fxtest.groovy

assert [1, [2,3],4].flatten() == [1,2,3,4]
assert [1,2,3].intersect([4,3,1]) == [3,1]
assert [1,2,3].disjoint([4,5,6])

List list = [1,2]
list.push 3
assert list == [1,2,3]

popped = list.pop() //List as stack
assert popped == 3
assert list == [1,2]

assert [1,2].reverse() == [2,1]
assert [3,1,2].sort() == [1,2,3]

def kings = ['Dierk', 'Paul']
kings = kings.sort {item -> item.size()} //Sort by size
assert kings == ['Paul', 'Dierk']

kings.sort{a,b -> b[0] <=> a[0]} // Revers sort by firs char
assert kings == ['Paul', 'Dierk']


