package chapter06

/**
 * java中属性静态绑定，根据变量的引用类型确定，方法是动态绑定。
 * 但scala中属性和方法都是动态绑定。
 */
//scala中的动态绑定
object Test08_DynamicBind {
  def main(args: Array[String]): Unit = {
    val student: Student8 = new Student8
    println(student.name)
    student.hello()
  }
}

//父类
class Person8 {
  val name: String = "person"

  def hello(): Unit = {
    println("hello person")
  }
}

//子类
class Student8 extends Person8 {
  //在子类中如果要重新定义父类中相同名称的属性，必须要加override关键字
  override val name: String = "student"

  override def hello(): Unit = {
    println("hello student")
  }
}