package com.nguyen.dsa.linked_list

class LinkedListIterator<T>(
    private val list: LinkedList<T>
) : Iterator<T>{
    private var index: Int = 0
    private var lastNode: Node<T>? = null

    override fun hasNext(): Boolean {
        return index < list.size
    }

    override fun next(): T {
        if(index >= list.size) throw IndexOutOfBoundsException()

        lastNode = if(index == 0){
            list.nodeAt(0)
        } else {
            lastNode?.next
        }

        index ++

        return lastNode!!.value
    }

}


class LinkedList<T> : Iterable<T>{
    private var head: Node<T>? = null
    private var tail: Node<T>? = null
    var size = 0

    fun isEmpty(): Boolean {
        return size == 0
    }

    override fun toString(): String {
        return if (isEmpty()) {
            "Empty"
        } else {
            head.toString()
        }
    }

    fun push(value: T): LinkedList<T> {
        head = Node(value, next = head)
        if (tail == null) {
            tail = head
        }
        size++
        return this
    }

    fun append(value: T) {
        if (isEmpty()) {
            push(value)
            return
        }
        tail?.next = Node(value)
        tail = tail?.next
        size++
    }

    fun nodeAt(index: Int): Node<T>? {
        var current = head
        var currentIndex = 0
        while (current != null && currentIndex < index) {
            current = current.next
            currentIndex++
        }

        return current
    }

    fun insert(value: T, afterNode: Node<T>): Node<T> {
        if (tail == afterNode) {
            append(value)
            return tail!!
        }

        val newNode = Node(value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if (isEmpty()) {
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        //1
        val head = head ?: return null
        if (head.next == null) return pop()

        size--

        var prev = head
        var current = head

        var next = current.next
        while (next != null) {
            prev = current
            current = next
            next = current.next
        }

        prev.next = null
        tail = prev

        return current.value
    }

    fun removeAfter(node: Node<T>): T? {
        val next = node.next;
        if (next == null) {
            tail = next
        }

        if (next != null) {
            size--
        }

        node.next = next?.next

        return next?.value
    }

    override fun iterator(): Iterator<T> {
        TODO("Not yet implemented")
    }
}



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