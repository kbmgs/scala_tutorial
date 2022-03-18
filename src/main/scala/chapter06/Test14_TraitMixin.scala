package chapter06

/**
 * 特质的混入
 */

object Test14_TraitMixin {
  def main(args: Array[String]): Unit = {
    val student = new Student14
    student.study()
    student.increase()
    student.play()
    student.increase()
    student.dating()
    student.increase()

    println("***************************************")
    //【动态混入】---不直接在某一个类里混入trait，而是使用时，才单独将类额外添加某个trait
    //创建对象实例的时候才去实现特质里的具体属性和方法(报错因为要具体实现特质中的抽象方法，如下override)
    val studentWithTalent = new Student14 with Talent {
      override def dancing(): Unit = println("student is good at dancing")

      override def singing(): Unit = println("student is good at singing")
    }

    studentWithTalent.sayHello()
    studentWithTalent.play()
    studentWithTalent.study()
    studentWithTalent.dating()
    studentWithTalent.dancing()
    studentWithTalent.singing()

  }
}

//再定义一个特质(学生)
trait Knowledge {
  var amount: Int = 0

  //定义一个抽象方法
  def increase(): Unit
}

//定义特质：天赋
trait Talent {
  def singing(): Unit

  def dancing(): Unit
}

//定义一个类，混入Knowledge特征，需要在类中实现Knowledge中的抽象方法
class Student14 extends Person13 with Young with Knowledge {
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

  //定义特质中的increase()抽象方法
  override def increase(): Unit = {
    amount += 1
    println(s"学生 $name 奇怪的知识增加到了:$amount")
  }

}