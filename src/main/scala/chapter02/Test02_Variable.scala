package chapter02

import chapter01.Student

object Test02_Variable {
  def main(args: Array[String]): Unit = {
    // 声明一个变量的通用语法
    var a: Int = 10

    // 1.声明变量时类型可以省略，编译器自动推导
    var a1 = 10
    val b1 = 23

    // 2.类型确定就不能修改，scala是强数据类型语言
    var a2 = 15
    //    a2 = "hello"

    // 3.变量声明需要有初始值
    //    var a3: Int

    // 4.var修饰的变量可改变，val修饰的变量不可改
    a1 = 12
    //    b1 = 25

    // var修饰的引用类型，是可以修改的
    var alice = new Student("alice", 20)
    alice = new Student("Alice",20)
    alice = null

    // val修饰的引用类型不可修改，但属性可能修改
    val bob = new Student("bob",23)
    bob.age = 24 // Student类中age已用var修饰

  }

}
