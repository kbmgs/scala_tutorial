//package chapter06

/**
 * @title: Test02_PackageObject
 * @projectName scala_tutorial
 * @description: TODO
 * @author kbmgs
 * @date 2022/3/3 16:27
 */
//object Test02_PackageObject {
//  def main(args: Array[String]): Unit = {
//    commonMethod
//    println(commonValue)
//  }
//}

// 包嵌套的写法
package chapter06 {
  object Test02_PackageObject {
    def main(args: Array[String]): Unit = {
      commonMethod
      println(commonValue)
    }
  }
}

package ccc {
  package ddd {
    object Test02_PackageObject{
      def main(args: Array[String]): Unit = {
        println(school)
        println(school2)
      }
    }

  }
  package object ddd {
    val school2: String = "atguigu"
  }

}

// 定义一个包对象，要想在包内访问school，必须包与包对象在同一层级
package object ccc {
  val school: String = "atguigu"
}
