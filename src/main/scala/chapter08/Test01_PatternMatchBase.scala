package chapter08

/**
 * 模式匹配基本  scala中的case操作
 */
object Test01_PatternMatchBase {
  def main(args: Array[String]): Unit = {
    //1.基本定义语法
    val x: Int = 1001
    val y: String = x match {
      case 1 => "one"
      case 2 => "two"
      case 3 => "three"
      case _ => "other" //case _类似于 java中case的default分支，必须要有
    }
    println(y)

    //2.实例：用模式匹配实现简单的二元运算
    val a = 25
    val b = 13

    def matchDualOp(op: Char) = op match {
      case '+' => a + b
      case '-' => a - b
      case '*' => a * b
      case '/' => a / b
      case '%' => a % b
      case _ => -1
    }

    println(matchDualOp('+'))
    println(matchDualOp('/'))
    println(matchDualOp('\\'))

    //3.模式守卫 做范围内的匹配
    println("***********************")

    //求一个整数的绝对值
    def abs(num: Int): Int = {
      num match {
        case i if i >= 0 => i //利用if条件判断，给定一个范围
        case j if j < 0 => -j
      }
    }

    println(abs(67))
    println(abs(-34))

  }
}
