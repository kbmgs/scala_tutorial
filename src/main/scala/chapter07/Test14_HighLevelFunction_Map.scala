package chapter07

/**
 * 集合转换操作(map)
 */
object Test14_HighLevelFunction_Map {
  def main(args: Array[String]): Unit = {
    val list = List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    //1.过滤操作 过滤：自定义过滤条件，filter(Elem => Boolean)
    //选取偶数
    val evenList = list.filter((elem: Int) => {
      elem % 2 == 0
    })
    println(evenList)

    //化简
    println(list.filter(elem => elem % 2 == 0)) //elem只出现了一次，可以用_简化
    //最终化简
    println(list.filter(_ % 2 == 0))

    //选取奇数
    println(list.filter(_ % 2 == 1))

    //2.映射map 转化/映射（狭义上的map）：自定义映射函数，map(Elem => NewElem)
    println("************************")
    //把集合中每个数乘以2 .map()方法
    println(list.map(elem => elem * 2)) //elem只出现了一次，可以用_简化
    //化简
    println(list.map(_ * 2))
    //每个数平方
    println(list.map(x => x * x))

    //3.扁平化 （flatten）：将集合中集合元素拆开，去掉里层集合，放到外层中来。flatten
    println("************************")
    val nestedList: List[List[Int]] = List(List(1, 2, 3), List(4, 5), List(6, 7, 8, 9)) //list中有list

    val flatList = nestedList(0) ::: nestedList(1) ::: nestedList(2) //复习：合并两个列表：list1 ::: list2 或者list1 ++ list2。
    println(flatList)

    val flatList2 = nestedList.flatten
    println(flatList2) //List(1, 2, 3, 4, 5, 6, 7, 8, 9)

    //4.扁平映射
    //举例：将一组字符串进行分词，并保存成单词的列表
    println("************************")
    val strings: List[String] = List("hello world", "hello scala", "hello java", "we study")
    val splitList: List[Array[String]] = strings.map(string => string.split(" ")) //以集合作为元素的列表
    println(splitList.flatten) //扁平化

    //扁平映射，包含了先map再flatten的操作
    val flatmapList = strings.flatMap(_.split(" "))
    println(flatmapList)

    //5.分组group
    println("************************")
    //将list分成奇偶两组的map
    val groupMap: Map[Int, List[Int]] = list.groupBy(_ % 2) //map-key:key%2的结果(取余结果，1或0)
    val groupMap2: Map[String, List[Int]] = list.groupBy(data => if (data % 2 == 0) "偶数" else "奇数") //map-key:if返回的字符串(奇数偶数)
    println(groupMap) //Map(1 -> List(1, 3, 5, 7, 9), 0 -> List(2, 4, 6, 8))
    println(groupMap2) //Map(奇数 -> List(1, 3, 5, 7, 9), 偶数 -> List(2, 4, 6, 8))

    //案例：给定一组词汇，按照单词的首字母进行分组
    val wordList = List("China", "America", "Alice", "Canada", "bob", "Japan")
    println(wordList.groupBy(_.charAt(0))) //.charAt()表示取第几位字母

  }
}
