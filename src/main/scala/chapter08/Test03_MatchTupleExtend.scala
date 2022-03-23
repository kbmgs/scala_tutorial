package chapter08

/**
 * 元组匹配拓展
 */
object Test03_MatchTupleExtend {
  def main(args: Array[String]): Unit = {
    //1.在变量声明时匹配
    val (x, y) = (10, "hello")
    println(s"x: $x, y: $y")

    val List(first, second, _*) = List(23, 15, 9, 78) //first:23,second:15,_*:(9,78)
    println(s"first: $first, second: $second") //此时无法对_*进行变量输出，因为List是四个元素，赋给两个接收参数的List

    //采用双冒号进行模式匹配的赋值
    val fir :: sec :: rest = List(23, 15, 9, 78)
    println(s"fir: $fir, sec: $sec, rest:$rest") //fir: 23, sec: 15, rest:List(9, 78)

    //2.for推导式中进行模式匹配
    println("***********************")

    val list: List[(String, Int)] = List(("a", 12), ("b", 35), ("c", 27), ("a", 13))

    //2.1原本的遍历方式
    for (elem <- list) {
      println(elem._1 + ": " + elem._2)
    }

    //2.2将List的元素直接定义为元组，对变量赋值
    println("***********************")
    for ((word, count) <- list) {
      println(word + ": " + count)
    }

    //2.3可以不考虑某个位置的变量，只遍历key或者value
    println("***********************")
    for ((word, _) <- list) {
      println(word)
    }

    //2.4可以指定某个位置的值必须是多少
    println("***********************")
    //此处指定元素的第一个位置的值必须为"a"
    for (("a", count) <- list) {
      println(count)
    }


  }
}
