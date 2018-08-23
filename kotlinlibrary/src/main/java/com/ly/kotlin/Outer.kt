package com.ly.kotlin

class Outer {


    class Person {
        //嵌套类
        var name: String? = ""
    }

    inner class Children {
        //内部类，由inner关键字修饰
        var name: String = ""
    }
}