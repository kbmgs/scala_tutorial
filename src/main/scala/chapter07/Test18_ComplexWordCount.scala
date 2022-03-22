package chapter07

/**
 * 复杂wordcount
 */
object Test18_ComplexWordCount {
  def main(args: Array[String]): Unit = {
    //考虑list的元素是一个kv元组，value已经对词组进行了预统计
    val tupleList: List[(String, Int)] = List(
      ("hello", 1),
      ("hello world", 2),
      ("hello scala", 3),
      ("hello spark from scala", 1),
      ("hello flink from scala", 2)
    )

    //思路一：直接展开为普通版本
    val newStringList: List[String] = tupleList.map(
      kv => {
        (kv._1.trim + " ") * kv._2 //严谨：先对key做trim出去前后空格，再对key拼接" "，再乘以value的数量
      }
    )
    println(newStringList)

    //接下来操作与普通版本完全一致
    val wordCountList: List[(String, Int)] = newStringList
      .flatMap(_.split(" ")) //空格分词  ->List[String]
      .groupBy(word => word) //按单词分组 -->Map[String, List[String]]
      .map(kv => (kv._1, kv._2.length)) //统计出每个单词的个数  -->Map[String, Int]
      .toList //转换成List格式  -->List[(String, Int)]
      .sortBy(_._2)(Ordering[Int].reverse) //排序  -->List[(String, Int)]
      .take(3) //取list前三个

    println(wordCountList)


    //思路二：直接基于预统计的结果进行转换
    //1.将字符串打散为单词，并结合对应的个数包装成二元组
    println("***********")
    val preCountList: List[(String, Int)] = tupleList.flatMap(
      tuple => {
        val strings: Array[String] = tuple._1.split(" ") //List(hello, hello, world, hello, scala, hello, spark, from, scala, hello, flink, from, scala)
        strings.map(word => (word, tuple._2)) //做map映射，返回二元组的列表 List((hello,1), (hello,2), (world,2), (hello,3), (scala,3), (hello,1), (spark,1), (from,1), (scala,1), (hello,2), (flink,2), (from,2), (scala,2))
      }
    )
    println(preCountList) //List((hello,1), (hello,2), (world,2), (hello,3), (scala,3), (hello,1), (spark,1), (from,1), (scala,1), (hello,2), (flink,2), (from,2), (scala,2))

    //2.对二元组按照单词进行分组
    println("***********")
    val preCountMap: Map[String, List[(String, Int)]] = preCountList.groupBy((tuple: (String, Int)) => tuple._1)
    println(preCountMap)
    //Map(world -> List((world,2)), flink -> List((flink,2)), spark -> List((spark,1)), scala -> List((scala,3), (scala,1), (scala,2)), from -> List((from,1), (from,2)), hello -> List((hello,1), (hello,2), (hello,3), (hello,1), (hello,2)))

    //3.叠加每个单词预统计的个数值
    //mapValues() 把当前的value全部更新，要操作的对象是Map:preCountMap中的每一个value，也就是List，需要将List的部分转换为sum(List中每个元素的第二项)
    println("***********")
    val countMap: Map[String, Int] = preCountMap.mapValues(
      mapList => (mapList.map(preCountMap => preCountMap._2).sum)
    )

    println(countMap)

    //4.转换成list排序取前三
    println("***********")
    println(countMap.toList.sortWith(_._2 > _._2).take(3))

  }
}
