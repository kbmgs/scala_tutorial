package chapter04

object Test07_Practice_CollectionOperation {
  def main(args: Array[String]): Unit = {

    // 定义一组数组
    val arr: Array[Int] = Array(12, 45, 75, 98)


    // 对数组进行处理，将操作抽象出来，处理完毕之后的结果，返回一个新的数组
    // 输入数组，以及对数组进行的操作函数op(输入Int,返回Int)
    def arrayOperation(array: Array[Int], op: Int => Int): Array[Int] = {
      // 循环中的 yield 会把当前的元素(op操作elem之后的数据)记下来，保存在集合中，循环结束后将返回该集合
      for (elem <- array) yield op(elem) // 该集合作为返回值
    }

    // 定义一个+1操作
    def addOne(elem: Int): Int = {
      elem + 1
    }

    // 开始调用函数
    val newArray: Array[Int] = arrayOperation(arr, addOne) //传入的+1函数不要加()，目的是传入函数本身而不是返回值

    // 打印输出经过arrayOperation()之后的新数组
    // 大数据处理中的map运算
    println(newArray.mkString(","))  //mkString输出集合，用","分割

    // 直接传入匿名函数，实现元素翻倍
    val newArray2 = arrayOperation(arr, _ * 2)
    println(newArray2.mkString(","))


  }
}
