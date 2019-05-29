package com.tsmid.kelvinht.fotballleague2.db

data class FootballFavorite (val id : String, val idEvent : String, val name : String, val nameFile : String,
          val nameTeam1 : String, val nameTeam2 : String, val scoreTeam1 : String, val scoreTeam2 : String) {

    companion object {
        const val TABLE_FOOTBALL_FAVORITE : String = "TABLE_FOOTBALL_FAVORITE"
        const val ID : String = "ID_"
        const val ID_EVENT : String = "ID_EVENT"
        const val TEAM_NAME : String = "TEAM_NAME"
        const val TEAM_NAME_FILE : String = "TEAM_NAME_FILE"
        const val NAME_TEAM1 : String = "NAME_TEAM1"
        const val NAME_TEAM2 : String = "NAME_TEAM2"
        const val SCORE_TEAM1 : String = "SCORE_TEAM1"
        const val SCORE_TEAM2 : String = "SCORE_TEAM2"
    }
}