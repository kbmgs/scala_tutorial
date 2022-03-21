package chapter07

/**
 * 简单计算函数
 */
object Test13_SimpleFunction {
  def main(args: Array[String]): Unit = {
    val list = List(5, 1, 8, 2, -3, 4)
    val list2 = List(("a", 5), ("b", 1), ("c", 8), ("d", 2), ("e", -3), ("f", 4))
    //1.求和
    //使用for循环
    var sum = 0
    for (elem <- list) {
      sum += elem
    }
    println(sum)
    //使用包装好的方法 .sum
    println(list.sum)
    //2.求乘积
    println(list.product)
    //3.最大值
    println(list.max)
    list2.maxBy((tuple: (String, Int)) => tuple._2)
    println(list2.maxBy(_._2)) //简写成
    //4.最小值
    println(list.min)
    //5.排序  返回的是集合类型
    println("************************")
    //5.1 sorted
    val sortedList = list.sorted
    println(sortedList)
    println(list.sorted.reverse) //排序后reverse翻转实现逆序，效率不高
    //传入隐式参数(可有可无的参数)
    println("************************")
    println(list.sorted(Ordering[Int]))
    println(list.sorted(Ordering[Int].reverse))

    //5.2 sortBy
    //对list2排序(按照key的大小进行排序)
    println("************************")
    println(list2.sortBy(_._2))
    println(list2.sortBy(_._2)(Ordering[Int].reverse)) //柯里化表达

    //5.3 sortWith
    println("************************")
    println(list.sortWith((a: Int, b: Int) => {
      a < b
    }))
    //简化
    println(list.sortWith((a, b) => a < b))
    println(list.sortWith(_ < _))
    println(list.sortWith(_ > _)) //逆序

  }
}
