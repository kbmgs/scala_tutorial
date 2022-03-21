package chapter07

/**
 * 元组
 */
object Test10_Tuple {
  def main(args: Array[String]): Unit = {
    //1.创建元组
    val tuple: (String, Int, Char, Boolean) = ("hello", 100, 'a', true)

    //2.访问数据  注意加下划线
    println(tuple._1)
    println(tuple._2)
    println(tuple._3)
    println(tuple._4)

    println(tuple.productElement(1)) //从0开始的，指第2个位置上的元组数据

    //3.遍历元组数据
    println("*************************")
    for (elem <- tuple.productIterator)
      println(elem)

    //4.嵌套元组
    println("*************************")
    val mulTuple = (12,0.3,"hello",(23,"scala"),29)
    println(mulTuple._4._1)
    println(mulTuple._4._2)
  }
}
