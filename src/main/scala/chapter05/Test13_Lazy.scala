package chapter05

/**
 * @title: Test13_Lazy
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/3 15:18
 */
object Test13_Lazy {
  def main(args: Array[String]): Unit = {
    //lazy---当前的sum()函数求值过程变成了懒加载的过程
    //sum()函数，在使用的过程中，才去做执行
    //lazy 行先不执行
    lazy val result: Int = sum(13, 47)

    println("1.函数调用")
    println("2.result = " + result)
    println("4.result = " + result) //sum只在2中调用一次

    def sum(a: Int, b: Int): Int = {
      println("3.sum调用")
      a + b
    }

  }

}
