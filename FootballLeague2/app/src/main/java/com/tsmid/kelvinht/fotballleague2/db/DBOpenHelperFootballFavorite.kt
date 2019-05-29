package com.tsmid.kelvinht.fotballleague2.db

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import org.jetbrains.anko.db.*

class DBOpenHelperFootballFavorite(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "FootballFavorite.db", null, 1) {
    companion object {
        private var instance: DBOpenHelperFootballFavorite? = null

        @Synchronized
        fun getInstance(ctx: Context): DBOpenHelperFootballFavorite {
            if (instance == null) {
                instance = DBOpenHelperFootballFavorite(ctx.applicationContext)
            }
            return instance as DBOpenHelperFootballFavorite
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        // Here you create tables
        db.createTable(FootballFavorite.TABLE_FOOTBALL_FAVORITE, true,
            FootballFavorite.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
            FootballFavorite.ID_EVENT to TEXT + UNIQUE,
            FootballFavorite.TEAM_NAME to TEXT,
            FootballFavorite.TEAM_NAME_FILE to TEXT,
            FootballFavorite.NAME_TEAM1 to TEXT,
            FootballFavorite.NAME_TEAM2 to TEXT,
            FootballFavorite.SCORE_TEAM1 to TEXT,
            FootballFavorite.SCORE_TEAM2 to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Here you can upgrade tables, as usual
        db.dropTable(FootballFavorite.TABLE_FOOTBALL_FAVORITE, true)
    }
}

    // Access property for Context
    val Context.database : DBOpenHelperFootballFavorite
        get() = DBOpenHelperFootballFavorite.getInstance(applicationContext)