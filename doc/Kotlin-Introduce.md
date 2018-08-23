
Kotlin 是一种在 Java 虚拟机上运行的静态类型编程语言，被称之为 Android 世界的Swift，由 JetBrains 设计开发并开源。
Kotlin 可以编译成Java字节码，也可以编译成 JavaScript，方便在没有 JVM 的设备上运行。

1、Kotlin 程序文件以 .kt 结尾

2、kotlin源文件不需要相匹配的目录和包，源文件可以放在任何文件目录。如果没有指定包，默认为 default 包。

3、函数定义

  函数定义使用关键字 fun，参数格式为：参数 : 类型
  
  
  类的修饰符
  类的修饰符包括 classModifier 和_accessModifier_:
  
  classModifier: 类属性修饰符，标示类本身特性。
  abstract    // 抽象类  
  final       // 类不可继承，默认属性
  enum        // 枚举类
  open        // 类可继承，类默认是final的
  annotation  // 注解类
  
  accessModifier: 访问权限修饰符
  private    // 仅在同一个文件中可见
  protected  // 同一个文件中或子类可见
  public     // 所有调用的地方都可见
  internal   // 同一个模块中可见
  
  
  Kotlin 中所有类都继承该 Any 类，它是所有类的超类，对于没有超类型声明的类是默认超类
  
  注意：Any 不是 java.lang.Object。
  如果一个类要被继承，可以使用 open 关键字进行修饰
  
  如果子类有主构造函数， 则基类必须在主构造函数中立即初始化。
  如果子类没有主构造函数，则必须在每一个二级构造函数中用 super 关键字初始化基类，或者在代理另一个构造函数。初始化基类时，可以调用基类的不同构造方法。
  
  在基类中，使用fun声明函数时，此函数默认为final修饰，不能被子类重写。如果允许子类重写该函数，那么就要手动添加 open 修饰它, 子类重写方法使用 override 关键词：
  
  属性重写使用 override 关键字，属性必须具有兼容类型，每一个声明的属性都可以通过初始化程序或者getter方法被重写：
可以用一个var属性重写一个val属性，但是反过来不行。因为val属性本身定义了getter方法，重写为var属性会在衍生类中额外声明一个setter方法

Kotlin 接口与 Java 8 类似，使用 interface 关键字定义接口，允许方法有默认实现：

一个类或者对象可以实现一个或多个接口。


为了保证生成代码的一致性以及有意义，数据类需要满足以下条件：
主构造函数至少包含一个参数。
所有的主构造函数的参数必须标识为val 或者 var ;
数据类不可以声明为 abstract, open, sealed 或者 inner;
数据类不能继承其他类 (但是可以实现接口)。