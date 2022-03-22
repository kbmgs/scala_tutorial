package chapter07

import scala.collection.immutable.Queue
import scala.collection.mutable

/**
 * 队列 遵循先进先出原则
 */
object Test19_Queue {
  def main(args: Array[String]): Unit = {
    //创建一个可变队列
    //导包 scala.collection.mutable
    val queue: mutable.Queue[String] = new mutable.Queue[String]()

    //入队
    queue.enqueue("a", "b", "c")

    println(queue) //Queue(a, b, c)

    //出队
    println(queue.dequeue()) //a
    println(queue) //Queue(b, c)
    println(queue.dequeue()) //b
    println(queue) //Queue(c)

    queue.enqueue("d", "e")
    println(queue)
    println(queue.dequeue())
    println(queue)

    //不可变队列
    //需要使用伴生对象创建实例
    println("***********************")
    val queue2: Queue[String] = Queue.apply("a", "b", "c") //等同于Queue("a", "b", "c")
    //入队操作需用一个新的队列来接收数据
    val queue3 = queue2.enqueue("d")
    println(queue3)

  }
}
