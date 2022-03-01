package chapter02

object Test04_String {
  def main(args: Array[String]): Unit = {
    val name: String = "bob"
    val age: Int = 18
    // 字符串模板，通过$获取变量值。s""表示模板字符串。通过$获取变量值
    println(s"${age}岁")
    val num: Double = 3.1415
    println(s"The num is ${num}")

    // 格式化模板字符串
    println(f"The num is ${num}%2.2f")
    // 除参数外其余原样输出
    println(raw"The num is ${num}%2.2f")

    // 三引号表示字符串，保持多行字符串的原格式输出
    val sql =
      s"""
         |select *
         |from
         |  student
         |where
         |  name = ${name}
         |and
         |  age > ${age}
         |""".stripMargin

    println(sql)

  }

}
