package chapter01

// scala中object为关键字，表示声明一个 单例对象(伴生对象，与对应的类相伴相生)，全局只有一份
object HelloWorld {
  /*
  main方法：从外部可以直接调用执行的
  格式：
  def 方法名称(参数名称:参数类型):返回值类型 = {方法体}

  此处的Array[String]中括号表示泛型，表示String类型的Array数组
  Unit为scala里特殊的类型，表示当前的方法返回值为空
  与java相比，区别是删去了修饰符，每一句不需要加分号
   */
  def main(args: Array[String]): Unit = {
    println("hello world")

    // 支持直接调用java类,语法灵活
    System.out.println("hello scala from java")
  }
}
