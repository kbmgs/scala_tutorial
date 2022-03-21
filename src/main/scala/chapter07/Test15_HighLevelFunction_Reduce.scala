package chapter07

/**
 * 集合转换操作(reduce) 归约操作
 */
object Test15_HighLevelFunction_Reduce {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4)

    //1.reduce
    println(list.reduce((a: Int, b: Int) => a + b)) //1+2+3+4
    println(list.reduceLeft(_ + _)) //从左往右一个一个加
    println(list.reduceRight(_ + _)) //从右往左一个一个加


    println("************************")
    val list2 = List(3, 4, 5, 8, 10)
    //减法操作
    println(list2.reduce((_ - _))) //-24 从左往右一个一个减
    println(list2.reduceLeft((_ - _))) //-24 从左往右一个一个减
    println(list2.reduceRight((_ - _))) //6 = 3-(4-(5-(8-10)) = 3-4+5-8+10 ，具体逻辑看源码---op(head, tail.reduceRight(op))

  }
}
