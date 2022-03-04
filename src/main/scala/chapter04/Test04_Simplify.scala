package chapter04

object Test04_Simplify {
  def main(args: Array[String]): Unit = {

    def f0(name: String): String = {
      return name //Return keyword is redundant
    }

    println(f0("atguigu"))

    println("1.return可以省略，Scala会用函数体最后一行代码作为返回值")

    def f1(name: String): String = {
      name
    }

    println(f1("atguigu"))

    println("2.如果函数体只有一行代码，可以省略花括号")

    def f2(name: String): String = name

    println(f2("atguigu"))

    println("3.返回值类型如果能推断出来，可以省略")

    def f3(name: String) = name //f3(x) = x ，函数式编程，关注数据的映射关系

    println(f3("atguigu"))

    println("4.如果有return，则不能省略返回值类型，必须指定")

    def f4(name: String): String = {
      return name
    }

    println(f4("atguigu"))

    println("5.函数明确声明unit，那么即使函数体中使用return关键字也不起作用")

    def f5(name: String): Unit = {
      return name
    }

    println(f5("atguigu")) //打印为()

    println("6.Scala如果期望是无返回类型，可以省略等号")

    def f6(name: String) { //相当于定义了一个过程
      println(name)
    }

    f6("atguigu")

    println("7.如果函数无参，但是声明了参数列表，那么调用时小括号可加可不加")

    def f7(): Unit = {
      println("atguigu")
    }

    f7()
    f7 //此时也可执行

    println("8.如果函数没有参数列表，那么小括号可以省略，调用时小括号必须省略")

    def f8: Unit = {
      println("atguigu")
    }

    f8

    println("9.如果不关心名称，只关心逻辑处理，那么函数名和def可以省略")

    def f9(name: String): Unit = {
      println(name)
    }
        //匿名函数，lambda表达式
    (name: String) => {println(name)}

  }


}
