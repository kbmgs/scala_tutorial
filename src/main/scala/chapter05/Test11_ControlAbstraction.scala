package chapter05

/**
 * @title: Test11_ControlAbstraction
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/3 13:34
 */
object Test11_ControlAbstraction {
  def main(args: Array[String]): Unit = {

    // 1.传值参数
    def f0(a: Int): Unit = {
      println("a:" + a)
      println("a:" + a)
    }

    f0(23)

    def f1(): Int = {
      println("f1调用")
      12
    }

    f0(f1())

    println("========================")
    // 2.传名参数
    // 注意参数类型的写法(代表返回到参数中函数，的返回值类型)
    // 此时传递进函数的是代码块
    def f2(a: => Int): Unit = {
      println("a:" + a)
      println("a:" + a)
    }

    f2(23)
    f2(f1()) // f1()在f2()中被调用了两次，因为f1()被传入了a，a被调用了两次

    f2({
      println("这是一个代码块")
      29  // 29作为返回值返回到a
    })

  }

}
