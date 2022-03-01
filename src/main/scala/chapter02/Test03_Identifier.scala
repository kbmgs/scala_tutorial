package chapter02

/**
 * 标识符
 */

object Test03_Identifier {
  def main(args: Array[String]): Unit = {
    // 1.以字母或者下划线开头，后接字母数字下划线
    val hello: String = ""
    var hello123 = ""
    val _abc = 123

//    val h-b = ""
//    val 123abc = 234

    // 2.以操作符开头，且只包括操作符
    val -+/% = "hello" // 合法
    println(-+/%)

    // 3.用反引号包括的任意字符串，包括scala的39个关键字也可以
    val `if` = "if"
    println(`if`)

  }
}
