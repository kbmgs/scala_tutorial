package chapter07

import scala.collection.mutable

/**
 * 可变集合
 *
 * 操作基于源集合做更改。
 * 为了与不可变集合区分，import scala.collection.mutable并用mutable.Set。
 * 不可变集合有的都有。
 * 添加元素到源上：set += elem add
 * 删除元素：set -= elem remove
 * 合并：set1 ++= set2
 * 都很简单很好理解，多看文档和源码就行。
 */
object Test07_MutableSet {
  def main(args: Array[String]): Unit = {
    //1.创建set
    //使用伴生对象创建
    //使用可变集合，导包scala.collection.mutable
    val set1: mutable.Set[Int] = mutable.Set.apply(13, 23, 52, 12, 13, 23, 78)
    println(set1)

    //2.添加元素
    println("********************")
    val set2 = set1 + 11
    println(set1) //set1没有进行更改，+不能改变当前集合内容
    println(set2)

    //在set1里直接做更改
    println("********************")
    set1 += 11
    println(set1)

    //对于不可变的集合，推荐使用符号的调用方法
    //对于可变的集合，推荐使用英文名称的调用方法
    println("********************")
    val flag1 = set1.add(10) //表示是否在set中添加上add()中的元素
    println(flag1) //true
    println(set1)
    println("********************")
    val flag2 = set1.add(10)
    println(flag2) //false  没有进行任何操作
    println(set1)

    //3.删除元素
    println("********************")
    set1 -= 11
    println(set1)
    val flag3 = set1.remove(10) //表示是否在set中删除掉remove()中的元素
    println(flag3) //true
    println(set1)
    println("********************")
    val flag4 = set1.remove(10)
    println(flag4) //false  没有进行任何操作
    println(set1)

    //4.合并两个set
    println("********************")
    val set3 = mutable.Set(13, 12, 13, 27, 98, 29)
    println(set1)
    println(set3)
    println("********************")
    set1 ++ set3
    println(set1) //set1不变
    println(set3) //set3不变
    println("********************")
    val set4 = set1 ++ set3
    println(set4)

  }
}
