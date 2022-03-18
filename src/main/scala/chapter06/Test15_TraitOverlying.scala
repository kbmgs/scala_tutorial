package chapter06

/**
 * 特质的叠加
 */
object Test15_TraitOverlying {
  def main(args: Array[String]): Unit = {
    val student = new Student15
    student.increase()

    //钻石问题特质叠加的测试
    println("****************************")
    val myFootBall = new MyFootBall
    println(myFootBall.describe()) //"my ball is a red-foot-ball"

  }
}

////钻石问题的特质叠加
//定义球类特征
trait Ball {
  def describe(): String = "ball"
}

//定义颜色特征
trait ColorBall extends Ball {
  val color: String = "red"

  override def describe(): String = color + "+" + super.describe()
}

//定义种类特征
trait CategoryBall extends Ball {
  var category: String = "foot"

  override def describe(): String = category + "-" + super.describe()
}

//定义一个自定义球的类
//叠加顺序：MyFootBall->(super.)->ColorBall->(super.)->CategoryBall->(super.)->Ball
class MyFootBall extends CategoryBall with ColorBall {
  override def describe(): String = "my ball is a " + super.describe()
  //可指定super的具体trait
//  override def describe(): String = "my ball is a " + super[CategoryBall].describe()
}

//再定义一个特质(学生)
trait Knowledge15 {
  var amount: Int = 0

  //与Talent15特质中定义同名方法
  def increase(): Unit = {
    println("knowledge increased")
  }
}

//定义特质：天赋
trait Talent15 {
  def singing(): Unit

  def dancing(): Unit

  //与Knowledge15特质中定义同名方法
  def increase(): Unit = {
    println("talent increased")
  }
}

class Student15 extends Person13 with Talent15 with Knowledge15 {
  override def dancing(): Unit = println("dancing")

  override def singing(): Unit = println("singing")

  //此时直接运行会出现，因为特质Talent15与Knowledge15中有同名方法，需要对其override
  override def increase(): Unit = {
    super.increase() //问题：此时super.调的是谁的increase()? --- Knowledge15.increase()，调用的是最后一个trait的同名increase()方法
    //特征的叠加顺序：从右到左叠加
    //不论是继承的父类的increase()方法，还是其他trait的increase()方法，直接把继承顺序中最后一个特征的方法拿来调用

    super[Person13].increase()  //此写法直接调用父类Person13中的increase()
  }
}