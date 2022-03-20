package chapter07

import scala.collection.mutable.ListBuffer

/**
 * 可变列表ListBuffer
 *
 * 可变列表ListBuffer，和ArrayBuffer很像。
 * final的，可以直接new，也可以伴生对象apply传入元素创建（总体来说scala中更推荐这种方式）。
 * 方法：append prepend insert remove
 * 添加元素到头或尾：+=: +=
 * 合并：++得到新的列表，++=合并到源上。
 * 删除元素也可以用-=运算符。
 * 具体操作很多，使用时阅读文档即可。
 */
object Test05_ListBuffer {
  def main(args: Array[String]): Unit = {
    //1.创建可变列表
    //导包scala.collection.mutable.ListBuffer
    val list1: ListBuffer[Int] = new ListBuffer[Int]() //指定泛型Int
    val list2 = ListBuffer.apply(12, 53, 75) //使用伴生对象创建可变列表，并传入元素，可省略apply ListBuffer(12, 53, 75)

    println(list1)
    println(list2)

    println("*************************")

    //2.添加元素
    list1.append(15, 62)
    list2.prepend(20)

    list1.insert(1, 19, 22)

    println(list1) //ListBuffer(15, 19, 22, 62)
    println(list2) //ListBuffer(20, 12, 53, 75)

    println("*************************")

    list1 += 25 += 11
    31 +=: 96 +=: list1 //可以结合成为 31 +=: 96 +=: list1 += 25 += 11
    println(list1)

    //3.合并list
    println("*************************")
    //++得到新的列表
    val list3 = list1 ++ list2 //list1 和 list2在合并后并不做更改
    println(list1)
    println(list2)
    println(list3)

    println("*************************")
    //++=合并到源上
    list1 ++=: list2
    println(list1)
    println(list2)

    //4.修改元素
    list2(3) = 30 //将第四个元素改成30
    println(list2)

    //5.删除元素
    list2.remove(2) //删除第三个数
    list2 -= 25 //删除值为25的元素
    println(list2)

  }
}
