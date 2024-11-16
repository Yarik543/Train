class Train(var direction: Direction) {
    val carriages: MutableList<Carriage> = mutableListOf()//изменяемый список с класса Carriage

    fun send() {
        println("Поезд поехал")
    }
}