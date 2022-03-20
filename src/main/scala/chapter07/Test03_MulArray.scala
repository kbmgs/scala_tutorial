package chapter07

/**
 * 二维数组
 */
object Test03_MulArray {
  def main(args: Array[String]): Unit = {
    //1.创建二维数组
    val array: Array[Array[Int]] = Array.ofDim[Int](2, 3) //2行3列的二维数组，泛型指定为Int，数组元素为Int类型

    //2.访问元素
    array(0)(2) = 19 //赋值第一行的第三个元素
    array(1)(0) = 25

    println(array.mkString(", ")) //[I@34ce8af7, [I@3f3afe78  元素为数组，所以打印出来的是两个引用地址
    for (i <- 0 until array.length; j <- 0 until array(i).length) {
      println(array(i)(j))
    }

    //简化为
    println("*****************")
    for (i <- array.indices; j <- array(i).indices) {
      print(array(i)(j) + "\t")
      if (j == array(i).length - 1) println()
    }
    //foreach()
    println("*****************")
    array.foreach(line => line.foreach(println))

    //进一步简写
    println("*****************")
    array.foreach(_.foreach(println))

    //3.
  }

}
