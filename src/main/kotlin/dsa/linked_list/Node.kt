package com.nguyen.dsa.linked_list


data class Node<T>(
    var value: T,
    var next: Node<T>? = null
) {
    override fun toString(): String {
        return if (next == null) {
            return "$value";
        } else {
            return "$value -> $next";
        }
    }
}