package com.nguyen.dsa.linked_list

fun main() {
    val list = LinkedList<Int>()
    list.push(1).push(2).push(3)
    println(list)


    println("remove last")
//    val list2 = LinkedList<Int>()
//    list2.push(1).push(2).push(3)
//    println('bef')


    "removing a node after a particular node"
    val list2 =
        LinkedList<Int>()
    list2.push(3)
    list2.push(2)
    list2.push(1)
    println("Before removing at particular index: $list2")
    val index = 2
    val node = list2.nodeAt(index - 1)!!
    val removedValue =
        list2.removeAfter(node)
    println("After removing at index $index: $list2")
    println("Removed value: $removedValue")

}