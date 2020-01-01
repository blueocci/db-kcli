package mysql

import me.liuwj.ktorm.database.Database
import me.liuwj.ktorm.dsl.select
import sso.Users

fun main() {
    Database.connect("jdbc:mysql://localhost:3306/ktorm", driver = "com.mysql.jdbc.Driver")
}

class UserCommand {
    fun showUsers() {
        for (row in Users.select()) {
            println(row[Users.name])
        }
    }
}