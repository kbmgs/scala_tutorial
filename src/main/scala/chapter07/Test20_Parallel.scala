package chapter07

import scala.collection.immutable
import scala.collection.parallel.immutable.ParSeq

/**
 * 并行处理
 */
object Test20_Parallel {
  def main(args: Array[String]): Unit = {
    val result: immutable.IndexedSeq[Long] = (1 to 100).map(
      x => Thread.currentThread.getId //获取当前的线程ID
    )
    println(result) //Vector(1,1,1,1...)  相当于都是主程序中进行一次一次的操作。串行计算

    val result2: ParSeq[Long] = (1 to 100).par.map(
      x => Thread.currentThread.getId //获取当前的线程ID
    )
    println(result2) //ParVector(20, 20, 20, 20, 20, 20, 30, 30, 30, 30, 30, 30, 25, 25, 25, 25, 25, 25, 32, 32, 32...)
    //代表有很多不同的并行线程在参与计算
  }
}
