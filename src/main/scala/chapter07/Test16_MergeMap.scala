package chapter07

import scala.collection.mutable

/**
 * 合并map
 */
object Test16_MergeMap {
  def main(args: Array[String]): Unit = {
    val map1 = Map("a" -> 1, "b" -> 3, "c" -> 6, "e" -> 100)
    val map2 = mutable.Map("a" -> 6, "b" -> 2, "c" -> 9, "d" -> 3) //map1 map2中相同的key，value不尽相同

    //map1 map2使用++，其实是覆盖操作
    println(map1 ++ map2) //Map(a -> 6, b -> 2, c -> 9, d -> 3)  结果以map2为准，因为是map2覆盖map1的元素，而非key值相加

    //现需要统计value的合并值，相同的key进行value相加，没有的key直接将元素添加进map中
    //如果要对map2作为基准，对其进行更新，则需要将map2设为mutable(map1不需要可变)


    map1.foldLeft(map2)(
      //***理解此lambda表达式
      op = (mergedMap: mutable.Map[String, Int], kv: (String, Int)) => {
        val key = kv._1
        val value = kv._2
        mergedMap(key) = mergedMap.getOrElse(key, 0) + value //如果没有get到对应key，value以0做计算
        mergedMap //返回mergedMap
      }
    )
 
    println(map2)
  }
}
