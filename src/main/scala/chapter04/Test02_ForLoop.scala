package chapter04

/**
 * @title: Test02_ForLoop
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/1 21:06
 */
object Test02_ForLoop {
  def main(args: Array[String]): Unit = {
    // 1.范围遍历
    for (i <- 1 to 10) {
      println(i + ". hello world") //范围1~10
    }
    println("==========================================")
    //等同于
    for (i <- 1.to(10)) {
      println(i + ". hello world") //范围1~10
    }
    println("==========================================")
    for (i <- Range(1, 10)) {
      println(i + ". hello world") //范围1~9
    }
    println("==========================================")
    //一般用下面的方法
    for (i <- 1 until 10) { //until
      println(i + ". hello world") //范围1~9
    }

    println("==========================================")
    // 2.集合遍历
    for (i <- Array(12, 34, 53)) {
      println(i)
    }
    for (i <- List(12, 34, 53)) {
      println(i)
    }
    for (i <- Set(12, 34, 53)) {
      println(i)
    }
    println("==========================================")
    // 3.循环守卫
    for (i <- 1 to 10 if i != 5) {
      println(i)
    }
    println("==========================================")
    // 4.循环步长
    for (i <- 1 to 10 by 2) {
      println(i)
    }
    println("==========================================")
    for (i <- 13 to 30 by 3) {
      println(i)
    }
    println("==========================================")
    // 倒序输出
    for (i <- 30 to 13 by -2) {
      println(i)
    }
    println("==========================================")
    // 倒序输出
    for (i <- 1 to 10 by 2 reverse) {
      println(i)
    }
    println("==========================================")
    // 5.嵌套循环
    for (i <- 1 to 4; j <- 1 to 5) {
      println("i = " + i + " ,j = " + j)
    }
    println("==========================================")
    // 6.引入变量
    for (i <- 1 to 10; j = 10 - i) {
      println("i = " + i + " ,j = " + j)
    }
    //第二种写法
    for {i <- 1 to 10
         j = 10 - i} {
      println("i = " + i + " ,j = " + j)
    }

  }

}
