class Carriage private constructor(val capacity /*вместимость*/: Int, val passengersCount: Int) {//перевозка

    companion object {
        fun create(capacity: Int, passengersCount: Int): Carriage? {
            if (capacity !in 5..25) {//проверка диапозона
                println("Неверное значение. Вместимость должна быть между 5 и 25 включительно.")
                return null
            }

            if (passengersCount > capacity) {//проверка если пассажиров оказалось больше чем ожидалось
                println("Неверное значение. Количество пассажиров не может превышать вместимость вагона.")
                return null
            }

            return Carriage(capacity, passengersCount)
        }
    }
}