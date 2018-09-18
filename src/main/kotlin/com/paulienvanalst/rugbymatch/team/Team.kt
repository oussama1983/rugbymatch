package com.paulienvanalst.rugbymatch.team


data class Team (val players: List<Player>, val name: TeamName) {
    /**
     * A team has enough players when it has at least 15 players
     */
    val hasEnoughPlayers : Boolean
        get() = players.size >= 15

    /**
     * A team has substitutes when it has more than 15 players
     */
    val hasAnySubstitutes : Boolean
        get() = players.any { !it.isStarting }

    /**
     * A team has enough starting players when there are at least 15 players
     * wearing back numbers 1 until 15
     */
    val hasEnoughStartingPlayers : Boolean
        get() = players.all { it.isStarting }

    /**
     * The captain, when present, should always where back number 7
     */
    fun captainBackNumber(): Int? {
        val scrumhalf = scrumhalf()
        return scrumhalf!!.backNumber
    }

    /**
     * When no scrumhalf present (player with back number 7)
     * the captain is wearing the first back number we can find among the starting players.
     */
    fun replacingCaptainBackNumber(): Int? {
        val scrumhalf = scrumhalf()
        return scrumhalf?.backNumber ?: players.first { it.isStarting }.backNumber
    }

    /**
     * returns the scrum half.
     */
    fun scrumhalf(): Player? {
        return players.find { it.position == Position.SCRUM_HALF }
    }

}

