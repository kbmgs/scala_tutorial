package chapter06

object Test06_ConstructorParams {
  def main(args: Array[String]): Unit = {
    val student2 = new Student2
    student2.name = "alice"
    student2.age = 30
    println(s"student2:name = ${student2.name},age = ${student2.age}")

    val student3 = new Student3("bob", 35)
    println(s"student3:name = ${student3.name},age = ${student3.age}")

    val student4 = new Student4("carry", 25)
    //    println(s"student4:name = ${student4.name},age = ${student4.age}")
    student4.printinfo()

    val student6 = new Student6("harry",10,"No.9 MS")
    student6.printinfo()

  }

}

//定义类
//无参构造器
class Student2 {
  //单独定义属性
  var name: String = _ //初始值为空
  var age: Int = _ //初始值为0

}

//最为推荐的写法
//上面定价等价于
class Student3(var name: String, var age: Int)

//主构造器参数无修饰，此时只是Student4的两个形参，并不是类的属性
class Student4(name: String, age: Int) {
  //可以通过构造方法来调用参数
  def printinfo(): Unit = {
    println(s"student4:name = ${name},age = ${age}")
  }
}

// java写法，不推荐
//class Student44(_name: String, _age: Int) {
//  var name: String = _name
//  var age: Int = _age
//}

//val修饰属性，写法OK，但属性不可进行更改了
class Student5(val name: String, val age: Int)

class Student6(var name: String, var age: Int) {
  var school: String = _

  //辅助构造方法
  def this(name: String, age: Int, school: String) {
    this(name, age) //必须调用主构造器(主构造器带有name和age)
    this.school = school
  }

  //单独定义一个printinfo方法
  def printinfo(): Unit = {
    println(s"student6:name = ${name},age = ${age},school=${school}")
  }

}