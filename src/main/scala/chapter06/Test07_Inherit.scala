package chapter06

object Test07_Inherit {
  def main(args: Array[String]): Unit = {
    //测试
    val student1 = new Student7("alice", 18)
    println("***************")
    val student2 = new Student7("bob", 20, "std001")

    student1.printinfo()
    student2.printinfo()
    println("***************")
    val teacher = new Teacher
    teacher.printinfo()

    //测试多态
    //personInfo()中，使用父类的类型(Person7)来作为参数person的接收
    //在运行是判断对象的属性，使用动态绑定
    def personInfo(person: Person7): Unit = {
      person.printinfo()
    }

    println("***************")
    val person = new Person7()
    personInfo(student1)
    personInfo(teacher)
    personInfo(person)

  }
}

//首先定义一个父类
class Person7() { //空括号，代表主构造器是无参的
  // 生命属性
  var name: String = _
  var age: Int = _

  println("1.父类的主构造器被调用")

  //定义一个辅助构造器修改属性
  def this(name: String, age: Int) {
    this()
    println("2.父类的辅助构造器被调用")
    this.age = age
    this.name = name
  }

  def printinfo(): Unit = {
    println(s"Person:$name $age")
  }
}

//定义子类
class Student7(name: String, age: Int) extends Person7(name, age) {
  var stdNo: String = _
  //辅助构造器对于当前两个属性进行赋值
  println("3.子类的主构造器被调用")

  def this(name: String, age: Int, stdNo: String) {
    this(name, age)
    println("4.子类的辅助构造器被调用")
    this.stdNo = stdNo
  }

  override def printinfo(): Unit = {
    println(s"Student:$name $age $stdNo")
  }
}

//增加子类Teacher
class Teacher extends Person7 {
  override def printinfo(): Unit = {
    println(s"Teacher")
  }
}