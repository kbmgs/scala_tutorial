package chapter06

/**
 * 类型的检测和转换
 */
object Test17_Extends {
  def main(args: Array[String]): Unit = {
    //1.类型的检测和转换
    val student: Student17 = new Student17("alice", 18)
    student.study()
    student.sayHi() //此时调用的是Student17的sayHi方法
    //将子类的对象赋值给一个父类
    println("****************************")
    val person: Person17 = new Student17("bob", 20)
    person.sayHi() //多态，调用的还是子类的sayHi方法

    //查看student和person实例的类
    println("****************************")
    println("student is Student17:" + student.isInstanceOf[Student17])
    println("student is Person17:" + student.isInstanceOf[Person17])
    println("person is Student17:" + person.isInstanceOf[Student17])
    println("person is Person17:" + person.isInstanceOf[Person17])

    val person2: Person17 = new Person17("cary", 35)
    println("person2 is Student17:" + person2.isInstanceOf[Student17])

    //类型转换
    println("****************************")
    if (person.isInstanceOf[Person17]) {
      //将当前的person对象实例直接转换成Student17类型赋给新实例
      val newStudent = person.asInstanceOf[Student17]
      newStudent.study()
    }

    //查看类的类型
    println("****************************")
    println(classOf[Student17])
    println(classOf[Person17])

    //2.测试枚举类
    println("****************************")
    println(WorkDay.MONDAY)
    println(WorkDay.TUESDAY)
  }
}

class Person17(val name: String, val age: Int) {
  def sayHi(): Unit = {
    println("hi from Person " + name) //父类的sayHi方法
  }
}

//子类对父类有继承关系，所以不需要单独定义它的属性val了
class Student17(name: String, age: Int) extends Person17(name, age) {
  //重写父类的方法，必须加上override关键字
  override def sayHi(): Unit = {
    println("hi from Student " + name)
  }

  def study(): Unit = {
    println("student study")
  }
}

//枚举类对象的定义
object WorkDay extends Enumeration {
  val MONDAY = Value(1, "Monday") //参数必须是两个，类似键值对
  val TUESDAY = Value(2, "Tuesday")
}

//应用类对象的定义
//只要继承App，object前就会出现可执行的标志(App自带main方法)
object TestApp extends App {
  println("app start")

  //定义一个新的类型MyString
  type MyString = String
  val a: MyString = "abc"
  print(a)
}