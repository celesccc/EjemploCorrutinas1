import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.random.Random

fun main() {
    print("Empezamos AQUÍ")

    for (i in 0..10) {
        GlobalScope.launch {
            //println("Soy una corrutina $i y estoy ejecutandome en 2º plano")
            //delay(2000)
            //println("Soy una corrutina $i y he acabado mi trabajo")
            funcionEnCorrutina(i)
        }
    }

    println("Entramos")
    runBlocking {
        funcionEnCorrutina(99)
    }
    println("Salimos")

    println("Esperamos un rato")
    Thread.sleep(2000000)
    println("Terminamos AQUÍ")
}

// HAY QUE INDICARLE QUE ESTAMOS DENTRO DE UNA CORRUTINA
suspend private fun funcionEnCorrutina(i : Int) {
    println("Soy una corrutina $i y estoy ejecutandome en 2º plano")
    delay(Random.nextLong(1000, 3000))
    println("Soy una corrutina $i y he acabado mi trabajo")
}