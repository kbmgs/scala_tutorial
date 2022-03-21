package chapter07

import scala.collection.mutable

/**
 * 可变map
 */
object Test09_MutableMap {
  def main(args: Array[String]): Unit = {
    //1.创建可变map
    //导包 scala.collection.mutable
    val map1: mutable.Map[String, Int] = mutable.Map.apply("a" -> 13, "b" -> 25, "hello" -> 3)
    println(map1)
    println(map1.getClass) //class scala.collection.mutable.HashMap

    //2.添加元素
    println("*************************")
    //可变map，可以使用put()方法新增元素
    map1.put("c", 5)
    map1.put("d", 9)
    println(map1) //map无序

    //符号方法
    println("*************************")
    map1 += (("e", 7))
    println(map1)

    //3.删除元素
    println("*************************")
    println(map1("c"))
    map1.remove("c")
    println(map1.getOrElse("c", 0))
    map1 -= "d"
    println(map1)

    //4.修改元素
    println("*************************")
    map1.update("c", 5)
    map1.update("e", 10)
    println(map1)

    //5.合并两个map
    println("*************************")
    val map2: Map[String, Int] = Map.apply("aaa" -> 13, "b" -> 29, "hello" -> 5) //b和hello的value和map1不一样
    //将map2中的所有元素添加到map1中
    map1 ++= map2
    println(map1) //此时map1中原有的 b和hello 的value也更新为map2中的value
    println(map2)

    println("*************************")
    val map3: Map[String, Int] = map2 ++ map1 //map2为不可变，不可++=map1。但可以++，合并map1后赋给新的map
    println(map3.getClass)  //生成的是不可变map
    println(map1)
    println(map2)
    println(map3)
  }
}
