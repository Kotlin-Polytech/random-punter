package ru.spbstu.competition.game

import ru.spbstu.competition.protocol.Protocol
import java.util.concurrent.ThreadLocalRandom

class Intellect(val state: State, val protocol: Protocol) {

    fun <T> List<T>.randomElement() = this[ThreadLocalRandom.current().nextInt(0, size)]

    fun makeMove() {

        val choice =
                state
                        .rivers
                        .asSequence()
                        .filter { it.value == RiverState.Neutral }
                        .map { it.key }
                        .toList()
                        .randomElement()

        protocol.claimMove(choice.source, choice.target)
    }

}
