package com.ly.kotlin

open class Base {
    open fun f() {

    }
}

//抽象类
abstract class Derived : Base() {
    override abstract fun f()
    abstract fun buy()
}



