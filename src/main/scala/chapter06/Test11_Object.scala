package chapter06

/**
 * 伴生对象
 */

object Test11_Object {
  def main(args: Array[String]): Unit = {
    //    val student = new Student11("alice", 18) //只需要传两个参数进来，school相当于静态定义了
    //    student.printinfo()

    //
    val student1 = Student11.newStudent("alice", 18)
    student1.printinfo()

    val student2 = Student11("bob", 19) //等同于 Student11.apply("bob", 19)创建实例对象----语法糖
    student2.printinfo()
  }
}

//定义类
//将构造方法私有化：private关键字。同时通过伴生对象来定义属性
class Student11 private(val name: String, val age: Int) {
  def printinfo(): Unit = {
    println(s"student:name=${name},age=${age}," +
      //调用伴生对象中的school
      s"school=${Student11.school}")
  }
}

//伴生对象 名字必须和上面的伴生类一模一样(类似java中的静态属性)
object Student11 {
  val school: String = "atguigu"

  //定义一个类的对象实例的创建方法(工厂方法)
  //伴生对象中可以直接访问伴生类中的私有成员和方法
  def newStudent(name: String, age: Int): Student11 = new Student11(name, age)

  //当用伴生对象的【apply】方法私有化构造方法时，在main中调用时，可以直接省略掉apply
  def apply(name: String, age: Int): Student11 = new Student11(name, age)
}