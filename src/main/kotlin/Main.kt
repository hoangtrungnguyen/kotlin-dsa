package com.nguyen

import com.nguyen.dsa.linked_list.Node

fun main() {

    println("creating and linking nodes")

    val node1 = Node(value = 1)
    val node2 = Node(value = 2)
    val node3 = Node(value = 3)
    node1.next = node2
    node2.next = node3
    println(node1)
}

