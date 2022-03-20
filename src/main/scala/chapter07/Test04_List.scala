package chapter07

/**
 * 不可变列表List
 *
 * List，抽象类，不能直接new，使用伴生对象apply传入元素创建。
 * List本身也有apply能随机访问（做了优化），但是不能update更改。
 * foreach方法遍历。
 * 支持+: :+首尾添加元素。
 * Nil空列表，::添加元素到表头。
 * 常用Nil.::(elem)创建列表，换一种写法就是10 :: 20 :: 30 :: Nil得到结果List(10, 20, 30)，糖是真滴多！
 * 合并两个列表：list1 ::: list2 或者list1 ++ list2。
 */
object Test04_List {
  def main(args: Array[String]): Unit = {
    //1.创建一个List
    //List，抽象类，不能直接new，使用伴生对象apply传入元素创建。
    val list1 = List.apply(23, 65, 87) //可省略apply简写为List(23, 65, 87)
    println(list1)

    //2.访问和遍历元素
    println(list1(1))
    //    list1(1) = 12 //list里的值不能更改
    //foreach遍历所有元素
    list1.foreach(println)

    //3.向列表里添加元素
    println("****************************")
    val list2 = 10 +: list1 //在列表前面添加元素
    val list3 = list1 :+ 23 //在列表后面添加元素
    println(list1)
    println(list2)
    println(list3)

    println("****************************")
    //另一种添加元素的方法：双冒号
    //::添加元素到表头
    val list4 = list2.::(51)
    println(list4)

    //Nil空列表
    val list5 = Nil.::(13)
    println(list5)

    //简写，去掉.
    val list6 = 73 :: 32 :: Nil
    println(list6)
    val list7 = 17 :: 28 :: 59 :: 16 :: Nil //Nil -> 16添加在开头 ->59添加在开头 ->28添加在开头 ->17添加在开头
    println(list7)

    //4.合并列表
    val list8 = list6 :: list7 //在list7元素第一位加上list6列表。基于list7的列表，追加一个元素(list6列表)
    println(list8) //List(List(73, 32), 17, 28, 59, 16)

    //三冒号连接 --- 所有元素拆开重新拼接
    val list9 = list6 ::: list7
    println(list9) //List(73, 32, 17, 28, 59, 16)

    //++符号，等同于:::
    val list10 = list6 ++ list7
    println(list10) //List(73, 32, 17, 28, 59, 16)

  }
}
