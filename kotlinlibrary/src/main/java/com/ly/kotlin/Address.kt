package com.ly.kotlin

class Address constructor(address: String) {
    var id: Long = 0
    var country: String = ""
    var province: String = ""
    var city: String = ""

    init {
        println("主构造器中初始化代码：" + address)
    }
}