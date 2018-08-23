package com.ly.kotlin

class Runoob {
    //类名为Runoob
    //成员变量定义
    var age: Int = 1
    var score: Long = 2
    //不可变量
    val tag: String = "Runoob"

    //延迟初始化
    lateinit var myAddress: Address


    //定义成员函数
    fun foo() {
        println("foo fun.")
        //可以像使用普通函数那样使用构造函数创建类实例
        var address = Address()
        //要使用一个属性，只要用名称引用它即可
        address.id
        address.country
        address.province
        address.city
    }

    fun setup() {
        myAddress = Address()
    }


}