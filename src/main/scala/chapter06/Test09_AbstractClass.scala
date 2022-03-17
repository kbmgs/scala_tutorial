package chapter06

/**
 * 抽象类 抽象属性和方法
 */
object Test09_AbstractClass {
  def main(args: Array[String]): Unit = {
    val student = new Student9
    student.eat()
    student.sleep()
  }
}

//定义一个抽象类的父类
abstract class Person9 {
  //非抽象属性
  val name: String = "person"

  //抽象属性
  var age: Int

  //非抽象方法
  def eat(): Unit = {
    println("person eat")
  }

  //抽象方法
  def sleep(): Unit
}

//定义具体的实现子类
//需要将Student9里所有抽象属性和方法都具体实现，才不会报错
class Student9 extends Person9 {
  var age: Int = 18 //抽象属性的实现

  override def sleep(): Unit = {
    println("student sleep") //抽象方法的实现
  }

  //重写非抽象属性和方法，需要加上override关键字
  //variable name cannot override a mutable variable
  //如果name是var类型，重写var会报错。不可以直接override一个可变的变量(var)
  //如果name是var，则直接name = "Student"
  override val name: String = "Student"

  override def eat(): Unit = {
    super.eat()  //子类的方法中也可直接调用父类的方法，使用super
    println("student eat")
  }
}