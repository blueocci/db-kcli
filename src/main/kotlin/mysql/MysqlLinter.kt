package mysql

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.iterable
import me.liuwj.ktorm.dsl.select
import sso.Users

fun startlint(server:String,port:Int,dbname:String) {
    val db = Database.connect("jdbc:mysql://$server:$port/$dbname", driver = "com.mysql.jdbc.Driver")

    val names = db.useConnection { conn ->
        val sql = """
        select name from t_employee
        where department_id = ?
        order by id
    """

        conn.prepareStatement(sql).use { statement ->
            statement.setInt(1, 1)
            statement.executeQuery().iterable().map {
                it.getString(1)
            }
        }
    }

    names.forEach {
        println(it)
    }
}

class UserCommand {
    fun showUsers() {
        for (row in Users.select()) {
            println(row[Users.name])
        }
    }
}