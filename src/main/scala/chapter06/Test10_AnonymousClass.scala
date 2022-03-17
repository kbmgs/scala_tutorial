package chapter06

/**
 * 匿名子类
 */
object Test10_AnonymousClass {
  def main(args: Array[String]): Unit = {
    //直接在代码里创建具体的对象实例（不定义具体的子类去实现）
    //创建了一个匿名子类
    val person:Person10 = new Person10 {
      //以下为IDEA自动补全
      override var name: String = "alice"

      override def eat(): Unit = println("person eat")
    }
    println(person.name)
    person.eat()
  }

}

//定义一个抽象类
abstract class Person10 {
  var name: String

  def eat(): Unit

}