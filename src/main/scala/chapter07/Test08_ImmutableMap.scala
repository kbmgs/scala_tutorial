package chapter07

/**
 * 不可变的map
 */
object Test08_ImmutableMap {
  def main(args: Array[String]): Unit = {
    //1.创建map
    //伴生对象创建
    val map1: Map[String, Int] = Map.apply("a" -> 13, "b" -> 25, "hello" -> 3) //表示创建k-v键值对 "a"-13....
    println(map1)
    println(map1.getClass) //class scala.collection.immutable.Map$Map3   ---$Map3:保存了3个元素的一个具体的map

    //2.遍历元素
    println("*************************")
    map1.foreach(println)
    map1.foreach((kv: (String, Int)) => println(kv)) //lambda表达式

    //3.访问所有的key或所有的value
    println("*************************")
    for (key <- map1.keys) {
      println(s"$key ---> ${map1.get(key)}")
    }

    //4.访问某一个key的value
    println("*************************")
    println("a:" + map1.get("a").get) //获得value 13。此种写法不安全，只有运行是才知道有没有对应的key
    println("c:" + map1.get("c")) //返回None
    println("a:" + map1.getOrElse("a", 0)) //getOrElse()方法较安全，如果没有获取到key，则返回一个默认值
    println("c:" + map1.getOrElse("c", 0))

    //简单写法：
    print(map1("a"))

    //    map1.put  //不可使用put方法向里添加元素
  }
}
