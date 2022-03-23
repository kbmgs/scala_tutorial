package chapter08

/**
 * 模式匹配 常量
 */
object Test02_MatchTypes {
  def main(args: Array[String]): Unit = {
    //1.匹配常量
    def describeConst(x: Any): String = x match {
      case 1 => "Int one"
      case "hello" => "String hello"
      case true => "Boolean"
      case '+' => "Char +"
      case _ => "_"
    }

    println(describeConst("hello"))
    println(describeConst('+'))
    println(describeConst(0.3))

    //2.匹配类型
    println("***********************")

    def describeType(x: Any): String = x match {
      case i: Int => "Int " + i
      case s: String => "String " + s
      case list: List[String] => "List " + list
      case array: Array[Int] => "Array[Int] " + array.mkString(", ")
      case a => "Something else" + a //用a(或一个参数)代替_，可以将获取到的数据传进来，_则不可以

    }

    println(describeType(35))
    println(describeType("hello you"))
    println(describeType(List("hi", "hello")))
    println(describeType(List(2, 3))) //List List(2, 3)  这是因为JVM中List存在【泛型擦除】，在判断时，只会判断到List，而不判断到泛型中的内容
    println(describeType(Array("hi", "hello"))) //Something else[Ljava.lang.String;@35bbe5e8  Array不存在泛型擦除
    println(describeType(Array(2, 3)))

    //3.匹配数组
    println("***********************")

    //遍历List中的元素做匹配操作
    for (arr <- List(
      Array(0),
      Array(1, 0),
      Array(0, 1, 0),
      Array(1, 1, 0),
      Array(2, 3, 7, 15),
      Array("hello", 1, 30)
    )) {
      val result = arr match {
        case Array(0) => "0"
        case Array(1, 0) => "Array(1,0)"
        //对数组Array可以做模糊判断
        case Array(x, y) => "Array: " + x + ", " + y //匹配两元素数组
        case Array(0, _*) => "以0开头的数组，元素个数不限" //_表示通配符 ,*代表参数可变
        case Array(x, 1, z) => "中间为1的三元素数组"
        case _ => "something else"
      }
      //匹配顺序(优先级)从上到下
      println(result)

      //4.匹配列表 方式一
      println("***********************")

      for (list <- List(
        List(0),
        List(1, 0),
        List(0, 0, 0),
        List(1, 1, 0),
        List(88)
      )) {
        val result = list match {
          case List(0) => "0"
          case List(x, y) => "List(x, y):" + x + ", " + y
          case List(0, _*) => "List(0,...)"
          case List(a) => "List(a): " + a
          case _ => "something else"
        }
        println(result)
      }

      //4.匹配列表 方式二
      println("***********************")

      val list1 = List(1, 2, 5, 7, 24)
      val list = List(24)
      list1 match {
        //
        case first :: second :: rest2 => println(s"first:$first, second:$second, rest:$rest2")
        case _ => println("something else")

      }

      //5.匹配元组
      println("***********************")

      for (tuple <- List(
        (0, 1),
        (0, 0),
        (0, 1, 0),
        (0, 1, 1),
        (1, 23, 56),
        ("hello", true, 0.5)
      )) {
        val result = tuple match {
          case (a, b) => "" + a + ", " + b //二元组
          case (0, _) => "(0, _)" //第一个元素是0的二元组
          case (a, 1, _) => "(a, 1, _)" + a //三个元素，第二个元素是1
          case (x, y, z) => "(x, y, z)" + x + " " + y + " " + z + " " //三元素
          case _ => "something else" //默认case
        }
        println(result)
      }

    }
  }
}
