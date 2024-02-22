package com.example.cricketscore;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    private static final String dbname = "cricket_score.db";
    public Database(@Nullable Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTeamsTable = "CREATE TABLE teams(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT)";
        String createPlayersTable = "CREATE TABLE players(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "matches INTEGER DEFAULT 0 NOT NULL, " +
                "runs INTEGER DEFAULT 0 NOT NULL," +
                "sixes INTEGER DEFAULT 0 NOT NULL," +
                "fours INTEGER DEFAULT 0 NOT NULL," +
                "fifties INTEGER DEFAULT 0 NOT NULL," +
                "hundreds INTEGER DEFAULT 0 NOT NULL," +
                "balls INTEGER DEFAULT 0 NOT NULL," +
                "wickets INTEGER DEFAULT 0 NOT NULL, " +
                "FOREIGN KEY(team_id) REFERENCES teams(_id))";
        String createMatchHistoryTable = "CREATE TABLE match_history(_id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "host_team_runs INTEGER DEFAULT 0 NOT NULL," +
                "host_team_wickets INTEGER DEFAULT 0 NOT NULL, " +
                "visitor_team_runs INTEGER DEFAULT 0 NOT NULL, " +
                "visitor_team_runs INTEGER DEFAULT 0 NOT NULL, " +
                "FOREIGN KEY(host_team_id) REFERENCES teams(_id), " +
                "FOREIGN KEY(visitor_team_id) REFERENCES teams(_id), " +
                "FOREIGN KEY(won_team_id) REFERENCES teams(_id))";
        sqLiteDatabase.execSQL(createTeamsTable);
        sqLiteDatabase.execSQL(createPlayersTable);
        sqLiteDatabase.execSQL(createMatchHistoryTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists teams");
        sqLiteDatabase.execSQL("drop table if exists players");
        sqLiteDatabase.execSQL("drop table if exists match_history");
        onCreate(sqLiteDatabase);
    }

    public boolean insertTeam(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        long r = db.insert("teams", null, contentValues);
        return r != -1;
    }

    public boolean insertPlayer(String name, int team_id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("team_id", team_id);
        long r = db.insert("players", null, contentValues);
        return r != -1;
    }

    public boolean updateRuns(String playerName, String teamName, int runs, int sixes, int fours)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("runs", runs);
        contentValues.put("sixes", sixes);
        contentValues.put("fours", fours);
        Cursor cursor = db.rawQuery("select * from players where name=? and team_id = (select _id from teams where name = ?)", new String[]{playerName, teamName});
        Cursor playerId = db.rawQuery("select _id from players where name=? and team_id = (select _id from teams where teams.name = ?)", new String[]{playerName, teamName});
        if(cursor.getCount() > 0)
        {
            long r =  db.update("players", contentValues, "_id = ?",  new String[]{String.valueOf(playerId)});
            return r != -1;
        }
        return false;
    }

    public boolean updateBalls(String playerName, String teamName, int balls, int wickets)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("balls", balls);
        contentValues.put("wickets", wickets);
        Cursor cursor = db.rawQuery("select * from players where name=? and team_id = (select _id from teams where teams.name = ?)", new String[]{playerName, teamName});
        Cursor playerId = db.rawQuery("select _id from players where name=? and team_id = (select _id from teams where teams.name = ?)", new String[]{playerName, teamName});
        if(cursor.getCount() > 0)
        {
            long r =  db.update("players", contentValues, "_id = ?",  new String[]{String.valueOf(playerId)});
            return r != -1;
        }
        return false;
    }

    public boolean insertMatchHistory(String hostTeam, String visitorTeam, String wonTeam, int host_team_runs, int host_team_wickets, int visitor_team_runs, int visitor_team_wickets)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        Cursor cursor = db.rawQuery("select team_id from teams where name = ?", new String[]{hostTeam});
        int hostTeamId = Integer.parseInt(cursor.getString(1));
        cursor = db.rawQuery("select team_id from teams where name = ?", new String[]{visitorTeam});
        int visitorTeamId = Integer.parseInt(cursor.getString(1));
        cursor = db.rawQuery("select team_id from teams where name = ?", new String[]{wonTeam});
        int wonTeamId = Integer.parseInt(cursor.getString(1));
        contentValues.put("host_team_id", hostTeamId);
        contentValues.put("visitor_team_id", visitorTeamId);
        contentValues.put("won_team_id", wonTeamId);
        contentValues.put("host_team_runs", host_team_runs);
        contentValues.put("host_team_wickets", host_team_wickets);
        contentValues.put("visitor_team_runs", visitor_team_runs);
        contentValues.put("visitor_team_wickets", visitor_team_wickets);
        long r = db.insert("match_history", null, contentValues);
        return r != -1;
    }

    public Cursor getTeams() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT name FROM teams", null);
        return cursor;
    }

    public Cursor getPlayers(String team) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT name FROM players WHERE _id = (SELECT team_id FROM teams WHERE teams.name = ?)", new String[]{team});
        return cursor;
    }

    public Cursor getPlayerInfo(String player, String team) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT matches, fours, sixes, runs, fifties, hundreds, balls, wickets FROM players where _id = (SELECT _id FROM players WHERE name = ?) AND team_id = (SELECT _id FROM teams where name = ?)", new String[]{player, team});
        return cursor;
    }

   /* public Cursor getMatchHistory() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
    }*/
}
