package chapter06

/**
 * trait自身类型
 */
object Test16_TraitSelfType {
  def main(args: Array[String]): Unit = {
    val user = new RegisterUser("alice", "123456")
    user.insert() //可以直接调insert()
  }
}

//用户类
class User(val name: String, val password: String)

trait UserDao {
  //定义一个自身类型(把当前的UserDao定义成了User，在操作时认为自身内部有一个User)
  _: User => // _ 通配符为别名，用其他字符也可

  //向数据库插入数据
  def insert(): Unit = {
    println(s"insert into db:${this.name}")
  }
}

//定义一个子类：注册用户类
//UserDao想使用User里面的一些属性，但不想有继承的关系。指定一个自身类型，则在UserDao中拥有了一个User类型。类似直接插入了一个User对象:依赖注入
class RegisterUser(name: String, password: String) extends User(name, password) with UserDao
