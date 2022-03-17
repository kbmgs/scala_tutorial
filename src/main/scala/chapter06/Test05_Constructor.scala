package chapter06

/**
 * @title: Test05_Constructor
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/3 17:44
 */
object Test05_Constructor {
  def main(args: Array[String]): Unit = {
    //创建对象
    val student1 = new Student1
    // 调用一般方法
    student1.Student1()
    println("*********************")
    val student2 = new Student1("alice")
    println("*********************")
    val student3 = new Student1("bob",30)
  }
}

// 定义一个类
class Student1() {
  // 定义属性
  var name: String = _ // 给_作为默认属性空值
  var age: Int = _

  println("1.主构造方法被调用")

  // 声明辅助构造方法
  def this(name: String) {
    this() //直接调用主构造器
    println("2.辅助构造方法1被调用")
    this.name = name
    println(s"name:$name age:$age")
  }

  // 继续定义辅助构造方法
  def this(name: String, age: Int) {
    // 调用之前的辅助构造器
    this(name)
    println("3.辅助构造方法2被调用")
    this.age = age
    println(s"name:$name age:$age")
  }

  //创建Student1类中的同名方法(一般的方法)
  def Student1(): Unit = {
    println("一般方法被调用")
  }

}