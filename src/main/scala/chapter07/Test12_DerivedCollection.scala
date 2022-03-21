package chapter07

/**
 * 衍生集合
 */
object Test12_DerivedCollection {
  def main(args: Array[String]): Unit = {
    val list1 = List(1, 3, 5, 7, 2, 89)
    val list2 = List(3, 7, 2, 45, 7, 4, 8, 19)

    //1.获取集合的头 (有序的集合里才会考虑头和尾，所以在列表中比较常见)
    println(list1.head)
    //2.获取集合的尾(出去头，剩下的都是尾)
    println(list1.tail)
    //3.集合的最后一个数据
    println(list2.last)
    //4.集合初始数据(不包含最后一个，其余的都是初始数据)
    println(list2.init)
    //5.反转
    println(list1.reverse)
    //6.取前(后)n个元素
    println(list1.take(3))
    println(list1.takeRight(4))
    //7.去掉前(后)n个元素
    println(list1.drop(3))
    println(list1.dropRight(4))
    //8.并集
    println("*******************************")
    val union = list1.union(list2)
    println("union: " + union)
    println(list1 ::: list2) //等同于

    //如果是set做并集，会去重
    println("*******************************")
    val set1 = Set(1, 3, 5, 7, 2, 89)
    val set2 = Set(3, 7, 2, 45, 7, 4, 8, 19)
    val union2 = set1.union(set2)
    println("union: " + union2)
    println(set1 ++ set2) //等同于

    //9.交集
    println("*******************************")
    val intersection = list1.intersect(list2)
    println("intersection: " + intersection)

    //10.差集
    val diff1 = list1.diff(list2) //属于list1但不属于list2
    println("diff1: " + diff1)

    //11.拉链 (捉对)
    println("*******************************")
    println("zip:" + list1.zip(list2))

    //12.滑窗
    println("*******************************")
    for (elem <- list1.sliding(3)) println(elem) //每组为按顺序的三个元素的滑窗list，向后滑动生成所有可能生成的list
    println("**************")
    for (elem <- list1.sliding(3, 2)) println(elem) //可设置滑动的步长
    println("**************")
    for (elem <- list1.sliding(3, 3)) println(elem) //当窗口长度与滑动步长一样，相当于按窗口长度切分list，每个窗口list没有重复数据---滚动窗口


  }
}
