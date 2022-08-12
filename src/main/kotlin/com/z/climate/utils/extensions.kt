package com.z.product.utils

fun <E> MutableSet<E>.update(element:E):Boolean{
    println(element)
    println("iiiiiiiiiiiiiiii")
    return this.remove(element) && this.add(element)
}