package chapter07

/**
 * 普通wordcount
 */
object Test17_CommonWordCount {
  def main(args: Array[String]): Unit = {
    val stringList: List[String] = List(
      "hello",
      "hello world",
      "hello scala",
      "hello spark from scala",
      "hello flink from scala"
    )

    //1.对字符串进行切分，得到一个打散所有单词的列表。
    val wordList1: List[Array[String]] = stringList.map(_.split(" ")) //得到的是，每一个元素都是一个String类型的数组(嵌套列表)
    val wordList2: List[String] = wordList1.flatten //对wordList1进行扁平化打散操作
    println(wordList2)
    //map() & flatten 简化为-> flatMap()
    val wordList: List[String] = stringList.flatMap(_.split(" "))
    println(wordList) //List(hello, hello, world, hello, scala, hello, spark, from, scala, hello, flink, from, scala)

    //2.相同的单词进行分组
    println("************************")
    val groupMap: Map[String, List[String]] = wordList.groupBy(word => word)
    println(groupMap) //Map(world -> List(world), flink -> List(flink), spark -> List(spark), scala -> List(scala, scala, scala), from -> List(from, from), hello -> List(hello, hello, hello, hello, hello))

    //3.对分组之后的List取长度，得到每个单词的个数
    //对groupMap: Map[String, List[String]]进行map()映射转换后，得到的map类型是Map[String, Int]
    val countMap: Map[String, Int] = groupMap.map(kv => (kv._1, kv._2.length))

    //4.将map转换为list(有序)，并排序操作，取前三
    val sortList: List[(String, Int)] = countMap.toList
      .sortWith(_._2 > _._2) //表示按照list中每个元素的第二个元素作为逆序排序  (list.sortWith(_ > _) ---逆序)

    //最终结果
    println("************************")
    println(sortList)

  }
}
