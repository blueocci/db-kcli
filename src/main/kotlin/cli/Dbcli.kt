package cli

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.default
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.prompt
import com.github.ajalt.clikt.parameters.types.int

class MysqlLint : CliktCommand() {
    val port: Int by option(help = "tcp port").int().default(3306)
    val server: String by option(help = "ip or name of database server").prompt("servername or ip")

    override fun run() {
        echo("mysql: server $server, port $port!")
    }
}

fun main(args: Array<String>) = MysqlLint().main(args)