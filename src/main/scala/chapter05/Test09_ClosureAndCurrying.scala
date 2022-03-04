package chapter05

/**
 * @title: Test05_ClosureAndCurrying
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/2 20:16
 */
object Test09_ClosureAndCurrying {
  def main(args: Array[String]): Unit = {
    def add(a: Int, b: Int): Int = {
      a + b
    }

    //当前传入的是两个参数，那如果2w个加数要传入呢？(大数据的场景下，等)需要增强适用性。

    // 1.考虑固定一个加数4，只改变另一个加数的场景
    def addByFour(b: Int): Int = {
      4 + b
    }

    // 2.考虑扩展固定加数(4)改变(4->5)的情况
    def addByFive(b: Int): Int = {
      5 + b
    }

    // 3.将固定加数作为另一个参数传入，但是作为"第一层参数"传入，分层传入
    // add()()
    def addByFour1(): Int => Int = {
      val a = 4

      def addB(b: Int): Int = {
        a + b
      }

      addB
    }

    // 以一个函数作为返回值，定义外层的函数
    def addByA(a: Int): Int => Int = {
      def addB(b: Int): Int = {
        a + b
      }

      addB
    }

    println(addByA(35)(24))

    // 解耦,通用性与适用性的结合
    val addByFour2 = addByA(4)
    val addByFive2 = addByA(5)

    println(addByFour2(3))
    println(addByFive2(11))

    // 4.lambda表达式简写
    def addByA1(a: Int): Int => Int = {
      (b: Int) => {
        a + b
      }
    }

    // 进一步简化
    def addByA2(a: Int): Int => Int = {
      b => a + b
    }

    // 更进一步简化
    def addByA3(a: Int): Int => Int = a + _

    println(addByA3(3)(4))

    val addByFour3 = addByA3(4)
    val addByFive3 = addByA3(5)
    println(addByFour3(13))
    println(addByFive3(25))

    // 5.柯里化
    // 柯里化底层一定是闭包
    def addCurrying(a: Int)(b: Int): Int = {
      a + b
    }

    println(addCurrying(35)(24))

  }
}