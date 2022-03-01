package chapter01

// 定义一个Student类（伴生类）
// scala中，需要定义的属性被放在类名之后的括号中
class Student(name: String, var age: Int) {
  def printInfo(): Unit = {
    println(this.name + " " + this.age + " " + Student.School)
  }
}

// 引入 伴生对象（Student.school --- 静态变量）
object Student {
  val School:String = "atguigu"

  def main(args: Array[String]): Unit = {
    val alice = new Student("Alice", 20)
    val bob = new Student("Bob", 10)

    alice.printInfo()
    bob.printInfo()
  }
}