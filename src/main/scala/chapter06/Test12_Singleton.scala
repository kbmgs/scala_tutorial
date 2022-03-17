package chapter06

/**
 * 单例设计模式
 */
object Test12_Singleton {
  def main(args: Array[String]): Unit = {
    val student1 = Student12.getInstance() //得到一个定义好的Student12的对象实例
    student1.printinfo()

    val student2 = Student12.getInstance()
    student2.printinfo()

    //看student1是否与student2相等
    println(student1)
    println(student2) //二者地址值相同，为同一个实例----单例设计模式
  }
}

class Student12 private(val name: String, val age: Int) {
  def printinfo(): Unit = {
    println(s"student:name=${name},age=${age},school=${Student11.school}")
  }
}

//伴生对象
//饿汉式单例设计模式
//object Student12 {
//  //定义一个private的属性，new出一个Student12的对象，赋给一个变量
//  private val student: Student12 = new Student12("alice", 18)
//
//  //定义一个public的方法，返回student
//  def getInstance(): Student12 = student
//}

//懒汉式单例设计模式
object Student12 {
  private var student: Student12 = _ //先将student设为变量var

  def getInstance(): Student12 = {
    if (student == null) {
      // 如果没有对象实例的话，就创建一个
      student = new Student12("Alice", 18)
    }
    student //如果已经存在对象实例，则返回student

  }

}
