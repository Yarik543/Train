import kotlin.math.min
import kotlin.random.Random

fun main() {
    while (true) {
        val direction = Direction.generate()//присваивание ф-ии (направление)
        println("Откуда: ${direction.from}")
        println("Куда: ${direction.to}")

        val train = Train(direction)
        val cashDesk = CashDesk()
        var passengersCount = cashDesk.sellTickets()//присваивание функции
        println("Продано билетов: $passengersCount")
        println()

        var error = false
        while (passengersCount > 0) {
            val capacity = Random.nextInt(5, 26)
            val carriage = Carriage.create(capacity, min(capacity, passengersCount))
            if (carriage == null) {
                error = true
                break
            }
            passengersCount -= capacity
            train.carriages.addLast(carriage)
            println("Добавлен вагон на $capacity человек")
        }
        println()

        if (!error) {
            train.send()
        }

        println("Хотите создать новый маршрут? (yes/no)")
        val choice = readln()
        if (choice.lowercase() != "yes") {//в нижний регистр
            break
        }
    }
}