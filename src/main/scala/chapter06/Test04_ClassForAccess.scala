package chapter06

/**
 * @title: Test04_Access
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/3 17:19
 */
object Test04_ClassForAccess {

}


// 定义一个父类
class Person {
  private var idCard: String = "234120394"
  protected var name: String = "alice"
  var sex: String = "female"
  // 只在chapter06当前包下面
  private[chapter06] var age: Int = 18

  def printInfo(): Unit = {
    println(s"Person:$idCard $name $sex")
  }
}