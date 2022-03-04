package chapter06

/**
 * @title: Test04_Access
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/3 17:25
 */
object Test04_Access {
  def main(args: Array[String]): Unit = {
    // 创建对象
    val person: Person = new Person()
    //    person.idcard //error，private属性
    //    person.name  //protected的属性，只能在当前类以及子类能访问到
    println(person.age)
    println(person.sex)

    person.printInfo()

    val worker: Worker = new Worker()
    worker.age = 23
    worker.printInfo()
  }
}

// 定义一个子类继承Student
class Worker extends Person {
  // 重写
  override def printInfo(): Unit = {
    println(s"Worker:$name $sex $age")
    //    println(idcard) //error,私有属性，子类不能访问
    name = "bob"
    age = 25
    sex = "male"
  }
}

