package chapter07

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

/**
 * 可变数组
 */
object Test02_ArrayBuffer {
  def main(args: Array[String]): Unit = {
    //1.创建可变数组
    //ArrayBuffer()注意导包 scala.collection.mutable.ArrayBuffer
    val arr1: ArrayBuffer[Int] = new ArrayBuffer[Int]()
    val arr2 = ArrayBuffer(23, 57, 92)

    println(arr1.mkString(", "))
    println(arr2)
    //直接写数组名时，重写了toString()方法，所以等同于
    println(arr2.toString())

    //2.访问元素
    //    println(arr1(0)) //error数组越界，未定义数组元素
    println(arr2(1))
    arr2(1) = 39
    println(arr2(1))

    //3.添加元素
    println("*******************************")
    //:+ 用于不可变数组，直接对可变数组使用，原数组不会添加新元素
    arr1 :+ 15
    println(arr1) //arr1数组仍然为空
    val newArr1 = arr1 :+ 15
    println(newArr1) //添加元素new一个新数组时，可以成功添加进来
    println(arr1 == newArr1) //false

    //+= 用于可变数组
    arr1 += 19
    println(arr1)
    val newArr2 = arr1 += 19 //对于可变数组，不推荐将操作之后的数组赋给一个新的数组
    println(newArr2)
    println(arr1 == newArr2) //true
    newArr2 += 13 //对newArr2进行添加元素
    println(arr1) //此时arr1也会添加13，arr1/newArr2 二者地址值其实相等

    //在开头追加元素  +=:
    77 +=: arr1
    println(arr1)
    println(newArr2)

    //推荐：不可变集合用运算符+: :+，可变集合直接调用对应方法。运算符容易迷惑。
    arr1.append(36) //在后面添加
    arr1.prepend(11, 76) //在前面添加
    arr1.insert(1, 13, 59) //在任意位置添加
    println(arr1)

    arr1.insertAll(2, newArr1) //在索引位置2，添加进newArr1的所有元素
    arr1.prependAll(newArr2)

    println(arr1)

    //4.删除元素
    println("******************************")
    arr1.remove(3) //删掉索引位置为3的59
    println(arr1)
    arr1.remove(0, 10) //从索引位置0开始删掉10个元素
    println(arr1)

    arr1 -= 13 //指定删除值为13的元素
    println(arr1)

    arr1 -= 14 //未找到值为14的话，不做任何操作
    println(arr1)

    //5.可变数组转换为不可变数组
    println("******************************")
    val arr: ArrayBuffer[Int] = ArrayBuffer(23, 56, 98)
    val newArr: Array[Int] = arr.toArray
    println(newArr.mkString(", "))
    println(arr) //ArrayBuffer(23, 56, 98)

    //6.不可变数组转换为可变数组
    println("******************************")
    val buffer: mutable.Buffer[Int] = newArr.toBuffer
    println(buffer)
    println(newArr)

  }
}
