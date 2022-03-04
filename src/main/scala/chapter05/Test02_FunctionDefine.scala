package chapter05

/**
 * @title: Test02_FunctionDefine
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/1 23:41
 */
object Test02_FunctionDefine {
  def main(args: Array[String]): Unit = {

    // 1.无参无返回值
    def f1(): Unit = {
      println("1.无参无返回值")
    }

    f1()
    println(f1())

    println("======================")

    // 2.无参有返回值
    def f2(): Int = {
      println("2.无参有返回值")
      return 12
    }

    f2()
    println(f2())

    println("======================")

    // 3.有参无返回值
    def f3(name: String): Unit = {
      println("3.有参无返回值")
    }

    f3("Alice")
    println(f3("Alice"))

    println("======================")

    // 4.有参有返回值
    def f4(name: String): String = {
      println("4.有参有返回值" + name)
      return "Hi," + name
    }

    println(f4("Alice"))

    println("======================")

    // 5.多参无返回值
    def f5(name1: String, name2: String): Unit = {
      println("5.多参无返回值")
      println(s"${name1}和${name2}都是朋友")
    }

    f5("Alice", "Bob")

    println("======================")

    // 6.多参有返回值
    def f6(a: Int, b: Int): Int = {
      println("6.多参有返回值")
      return a + b
    }

    f6(3, 6)
    println(f6(3, 6))

  }

}
