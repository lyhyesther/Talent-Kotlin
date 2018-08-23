#Kotlin Guide

下面提供了一些使用Kotlin来构建Android应用的的原则。

##Style Guide
1、源文件
所有的源文件必须使用UTF-8编码。
1.1命名
如果一个源文件只包含一个顶级类，该文件的名称应该是大小敏感的，并且以.kt为后缀。相反，如果源文件包含多个顶级类声明，那么选择一个能
构反映文件内容的文件名，使用"驼峰命名"，并以.kt扩展。
1.2结构
一个.kt文件由下面的几部分组成：
1）Copyright或者license header
2)文件级的注释
3）package语句
4）import语句
5）top-level声明