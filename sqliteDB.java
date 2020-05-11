/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndgui;

import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.logging.*;

/**
 *
 * @author wilso
 */
public class sqliteDB
{
    static Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/DnD/db/dnd.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
  static void createDirectory(String location)
   {
       Path path = Paths.get(location);
       if (!Files.exists(path))
       {
           try
           {
               Files.createDirectories(path);
           } catch (IOException ex)
           {
               Logger.getLogger(sqliteDB.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
   }
   public static void createNewDatabase(String db) {

        //String url = "jdbc:sqlite:C:/DnD/db/" + db;

        //try (Connection conn = DriverManager.getConnection(url)) {
        try (Connection conn = sqliteDB.connect()) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   public static void writeMonstersImage(byte[] image, String selected)
   {
        String sql = "Update Monsters SET monsterCard = ? where name = ?";
        try (Connection conn = sqliteDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setBytes(1, image);
            pstmt.setString(2, selected);
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }  
   }
   public static void createNewMonsterTable(String table){
       String sql = "CREATE TABLE IF NOT EXISTS " +table+" (\n"
               + "	Name text NOT NULL,\n"
               + "      Health integer, \n"
               + "	Strength text,\n"
               + "	Dexterity text,\n"
               + "	Constitution text,\n"
               + "	Intelligence text,\n"
               + "	Wisdom text,\n"
               + "	Charisma text,\n"
               + "	monsterCard BLOB\n"
                + ");";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
  public static void createPlayerTable(String table){
       String sql = "CREATE TABLE IF NOT EXISTS " +table+" (\n"
               + "	Name text NOT NULL,\n"
               + "      Health integer, \n"
               + "	Strength text,\n"
               + "	Dexterity text,\n"
               + "	Constitution text,\n"
               + "	Intelligence text,\n"
               + "	Wisdom text,\n"
               + "	Charisma text,\n"
               + "	capacity real\n"
                + ");";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



 public static void createNewInitiativeTable(String table){
       String sql = "CREATE TABLE IF NOT EXISTS " +table+" (\n"
               + "	Name text NOT NULL);";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
  public static void createNewSpellTable(String table){
       String sql = "CREATE TABLE IF NOT EXISTS " +table+" (\n"
               + "	Name text);";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
  public static void createNewNotesTable(String table){
       String sql = "CREATE TABLE IF NOT EXISTS " +table+" (id integer PRIMARY KEY AUTOINCREMENT, notes text);";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.execute();
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void createNote(String table, String notes)
    {
       String sql = "INSERT or IGNORE INTO notes(id, notes) VALUES(1, null)";
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           pstmt.executeUpdate();

       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
   static void insertMonsters(String name, String health, String strength, String dex, String con, String intel, String wis, String charisma, String monsterCard)
   {
       String sql = "INSERT INTO Monsters (name, health, strength, dexterity, constitution, intelligence, wisdom, charisma, monsterCard) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
       
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           pstmt.setString(1, name);
           pstmt.setString(2, health);
           pstmt.setString(3, strength);
           pstmt.setString(4, dex);
           pstmt.setString(5, con);
           pstmt.setString(6, intel);
           pstmt.setString(7, wis);
           pstmt.setString(8, charisma);
           pstmt.setString(9, monsterCard);
           pstmt.executeUpdate();
       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
   }
   static void insertPlayer(String name, String health, String strength, String dex, String con, String intel, String wis, String charisma)
   {
       String sql = "INSERT INTO Players (name, health, strength, dexterity, constitution, intelligence, wisdom, charisma) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
       
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           pstmt.setString(1, name);
           pstmt.setString(2, health);
           pstmt.setString(3, strength);
           pstmt.setString(4, dex);
           pstmt.setString(5, con);
           pstmt.setString(6, intel);
           pstmt.setString(7, wis);
           pstmt.setString(8, charisma);
           pstmt.executeUpdate();
       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
   }

static void insertInit(String name)
   {
       String sql = "INSERT INTO Init (name) VALUES(?)";
       
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           pstmt.setString(1, name);
           pstmt.executeUpdate();
       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
   }
    static void updateMonsters(int health, String name) //int strength, int dex, int con, int intel, int wis, int charisma)
    {
        String sql = "Update Monsters SET Health = ? WHERE Name = ? ";
        
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           pstmt.setString(2, name);
           pstmt.setInt(1, health);
           pstmt.executeUpdate();

       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    static void updateNotes(String notes) //int strength, int dex, int con, int intel, int wis, int charisma)
    {
        String sql = "Update notes SET notes = ? WHERE id = 1";
        
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           pstmt.setString(1, notes);
           pstmt.executeUpdate();

       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

/*
    public static void main(String[] args) {
        createNewDatabase("dnd.db");
        createNewMonsterTable("Monsters");
        insert("test", 20);
*/
    }
