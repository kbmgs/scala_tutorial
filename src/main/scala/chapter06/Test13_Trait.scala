package chapter06

/**
 * 特质
 */
object Test13_Trait {
  def main(args: Array[String]): Unit = {
    val student: Student13 = new Student13
    student.sayHello()
    student.study()
    student.dating()
    student.play()
  }
}

//定义一个父类
class Person13 {
  val name: String = "Person"
  var age: Int = 18

  def sayHello(): Unit = {
    println("hello from:" + name)
  }
}

//定义一个特质 --- 年轻 young
trait Young {
  // 可以定义抽象和非抽象的属性和方法
  var age: Int
  val name: String = "young"

  //声明抽象和非抽象的方法 --- 玩 play , 约会 dating
  def play(): Unit = {
    println("young man is playing")
  }

  def dating(): Unit
}

//with 继承特质Young，此时需要将Young中的所有抽象方法和属性实现
class Student13 extends Person13 with Young {
  //重写冲突的属性：name
  override val name: String = "alice"

  //实现抽象方法
  override def dating(): Unit = println(s"student $name is dating")

  //定义学生特有的方法
  def study(): Unit = println(s"student $name is studying")

  //重写父类方法
  override def sayHello(): Unit = {
    super.sayHello()
    println(s"hello from:student $name")
  }

}