package chapter05

/**
 * @title: Test01_FunctionAndMethod
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/1 23:23
 */
object Test01_FunctionAndMethod {
  def main(args: Array[String]): Unit = {
    // 在main方法中定义函数（java中不可以）
    def sayHi(name: String): Unit = {
      println("hi," + name)
    }

    // 函数调用
    sayHi("Alice")

    // 调用对象方法
    Test01_FunctionAndMethod.sayHi("Bob")

    // 获取方法返回值
    val result = Test01_FunctionAndMethod.sayHello("Cary")
    println(result)

  }

  // 定义在main方法外，定义对象的方法
  def sayHi(name: String): Unit = {
    println("Hi," + name)
  }

  // 定义返回值类型为String
  def sayHello(name: String): String = {
    println("Hi," + name)
    return "hello"
  }
}
