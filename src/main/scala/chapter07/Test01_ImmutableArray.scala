package chapter07

/**
 * 不可变数组
 */
object Test01_ImmutableArray {
  def main(args: Array[String]): Unit = {
    //1.创建数组
    val arr: Array[Int] = new Array[Int](5) //[]是泛型，指定数组的元素类型
    //另一种创建的方式：伴生对象
    val arr2 = Array(12, 37, 42, 58, 97)
    //    val arr3 = Array.apply(12, 37, 42, 58, 97) //以上等同于使用Array.apply方法，省略apply

    //2.访问元素
    println(arr(0))
    println(arr(1))
    println(arr(2))
    println(arr(3))
    println(arr(4))

    //赋值
    arr(0) = 12
    arr(4) = 57
    arr(4) = 58
    println(arr(0))
    println(arr(1))
    println(arr(4))

    //3.用循环做数组的遍历
    //1)普通for循环
    println("*************************")
    //idea标黄，表示有更简洁写法
    for (i <- 0 until arr.length) { //until 不包含结尾。until arr.length 等同于 to arr.length - 1
      println(arr(i))
    }

    //以上可改成
    for (i <- arr.indices) println(arr(i))

    //2)增强for循环。直接遍历所有元素，不考虑索引操作
    println("*************************")
    for (elem <- arr2) println(elem)

    //3)利用迭代器作为集合元素的遍历方法
    println("*************************")
    val iter = arr2.iterator
    while (iter.hasNext)
      println(iter.next())

    //4)调用foreach方法
    println("*************************")
    arr2.foreach((elem: Int) => println(elem))

    //函数至简原则，自动推断，只需要传递println方法
    arr.foreach(println)

    //打印 所有元素按照"--"连接，的一个字符串。相当于scala底层自动帮助实现的遍历过程
    println(arr2.mkString("--"))

    //4.添加元素（此时为不可变数组，指的是添加元素后，变成一个新的数组返回。scala中推荐使用不可变数组）
    //:+ (面向符号编程。。)将新增的数据添加到末尾
    println("*************************")
    val newArr = arr2.:+(73)
    println(arr2.mkString("--")) //原先数组不变 12--37--42--58--97
    println(newArr.mkString("--")) //新数组结尾增加了一个元素 12--37--42--58--97--73

    println("*************************")
    //+: 将新增的数据添加到开头
    val newArr2 = newArr.+:(30)
    println(newArr2.mkString("--"))

    //将.省略，用空格代替的方法
    //可以看到自定义运算符可以非常灵活，规定如果运算符首尾有:那么:一定要指向对象。
    val newArr3 = newArr2 :+ 15 //15添加在末尾，可以连续添加
    val newArr4 = 19 +: 29 +: newArr3 :+ 26 :+ 73 //29添加在开头，可以连续添加
    println(newArr3.mkString(","))
    println(newArr4.mkString(","))

  }
}
