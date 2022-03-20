package chapter07

/**
 * Set集合
 *
 * 不可变set
 * 数据无序，不可重复。
 * 可变和不可变都叫Set，需要做区分。默认Set定义为immutable.Set别名。
 * 创建时重复数据会被去除，可用来去重。
 * 添加元素：set + elem
 * 合并：set1 ++ set2
 * 移除元素：set - elem
 * 不改变源集合。
 */
object Test06_ImmutableSet {
  def main(args: Array[String]): Unit = {
    //1.创建set
    //使用伴生对象创建
    val set1 = Set.apply(13, 23, 52, 12, 13, 23, 78) //等同于Set(xx,xx,...)
    println(set1)

    //2.添加元素
    println("********************")
    //    val set2 = set1.+(20)  //等同于下面
    val set2 = set1 + 20
    println(set1)
    println(set2) //set没有顺序，元素会出现在任意位置

    //3.合并set
    println("********************")
    val set3 = Set(19, 13, 23, 53, 67, 99)
    //    val set4 = set2 + set3 //error 集合不能加集合
    val set4 = set2 ++ set3
    println(set2)
    println(set3)
    println(set4)

    //4.删除元素
    println("********************")
    val set5 = set3 - 13
    println(set3)
    println(set5)
  }
}
