/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndgui;

import java.awt.Image;
import java.io.*;
import java.sql.*;
import java.util.logging.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author wilso
 */
public final class dndGUI extends javax.swing.JFrame
{
    String fileName = "dnd.db";
    String mTable = "Monsters"; 
    String initTable = "Init";
    String sTable = "Spells";
    String nTable = "Notes";
    String pTable = "Players";
    String location = "C:\\DnD\\db";
    String notes;
    int health;
    private ImageIcon format =null;
    String imageName=null;
    int s =0;
    byte[] characterImage=null;
    //test
    /**
     * Creates new form dndGUI
     */
    public dndGUI()
    {
        initComponents();
        sqliteDB.createDirectory(location);
        sqliteDB.createNewDatabase(fileName);
        sqliteDB.createNewMonsterTable(mTable);
        sqliteDB.createNewInitiativeTable(initTable);
        sqliteDB.createNewSpellTable(sTable);
        sqliteDB.createNewNotesTable(nTable);
        sqliteDB.createNote(nTable, notes);
        sqliteDB.createPlayerTable(pTable);
        comboBox();
        updateInitTable();
        updateMonsterTable();
        loadNotes();
        updatePlayerTable();
    }

private void updateInitTable()
 {
     String sql = "select * from "+initTable+"";
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           ResultSet rs = pstmt.executeQuery();
           initJTable.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     
 }
private void updateMonsterTable()
 {
     String sql = "select * from "+mTable+"";
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           ResultSet rs = pstmt.executeQuery();
           monsterTable.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     
 }
private void updatePlayerTable()
 {
     String sql = "select * from "+pTable+"";
       try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
       {
           ResultSet rs = pstmt.executeQuery();
           playerTable.setModel(DbUtils.resultSetToTableModel(rs));
       }
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }
     
 }
    public void comboBox()
    {
        String sql = "select name from " +mTable+"";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            monsterInit.removeAllItems();
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                monsterInit.addItem(rs.getString("name"));
            }
        }
            
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
        sql = "select name from " +pTable+"";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            playerInit.removeAllItems();
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                playerInit.addItem(rs.getString("name"));
            }
        }
            
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
    }
    public void loadNotes()
    {
        String sql = "select Notes from " +nTable+"";
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            ResultSet rs = pstmt.executeQuery();
            while(rs.next())
            {
                notesArea.setText(rs.getString(1));
            }
        }
            
       catch (SQLException e) {
            System.out.println(e.getMessage());
        } 
    }
        public void updateMonsterHealth()
    {
        String sql = "Update Monsters SET Health = ? WHERE Name = ? ";
        int row = monsterTable.getSelectedRow();
        String selected = monsterTable.getModel().getValueAt(row, 0).toString();
        if (monsterTable.isEditing())
            monsterTable.getCellEditor().stopCellEditing();
        health = Integer.parseInt(monsterTable.getModel().getValueAt(row, 1).toString());
        System.out.println(selected);
        System.out.println(health);
        
        try (Connection conn = sqliteDB.connect();
               PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setInt(1, health);
            pstmt.setString(2, selected);
            pstmt.executeUpdate();
        }
            
       catch (SQLException e) {
            System.out.println(e.getMessage());
        }    
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        monsterName1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        monsterStrength1 = new javax.swing.JTextField();
        monsterDexterity1 = new javax.swing.JTextField();
        monsterConstituion1 = new javax.swing.JTextField();
        monsterIntelligence1 = new javax.swing.JTextField();
        monsterWisdom1 = new javax.swing.JTextField();
        monsterCharisma1 = new javax.swing.JTextField();
        insertButton1 = new javax.swing.JButton();
        monsterHealth1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        addTab = new javax.swing.JTabbedPane();
        monsterPanel = new javax.swing.JPanel();
        updateMonsters = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        monsterTable = new javax.swing.JTable();
        imageAdd = new javax.swing.JButton();
        filePath = new javax.swing.JTextField();
        selectImage = new javax.swing.JButton();
        clearImage = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        imageLabel = new javax.swing.JLabel();
        playerPanel = new javax.swing.JPanel();
        removePlayer = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        playerTable = new javax.swing.JTable();
        addPanel = new javax.swing.JPanel();
        characterName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        characterStrength = new javax.swing.JTextField();
        characterDexterity = new javax.swing.JTextField();
        characterConstituion = new javax.swing.JTextField();
        characterIntelligence = new javax.swing.JTextField();
        characterWisdom = new javax.swing.JTextField();
        characterCharisma = new javax.swing.JTextField();
        insertMonster = new javax.swing.JButton();
        characterHealth = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        insertPlayer = new javax.swing.JButton();
        initPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        initJTable = new javax.swing.JTable();
        monsterInit = new javax.swing.JComboBox<>();
        clearInit = new javax.swing.JButton();
        addMonsterInit = new javax.swing.JButton();
        playerInit = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        addPlayerInit = new javax.swing.JButton();
        diceType = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        diceCount = new javax.swing.JSpinner();
        jLabel20 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        diceResults = new javax.swing.JTextArea();
        rollDice = new javax.swing.JButton();
        notesPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        notesArea = new javax.swing.JTextArea();
        updateNotes = new javax.swing.JButton();
        loadNotes = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel9.setText("Monster Name");

        jLabel10.setText("Strength");

        jLabel11.setText("Dexterity");

        jLabel12.setText("Charisma");

        jLabel13.setText("Wisdom");

        jLabel14.setText("Intelligence");

        jLabel15.setText("Constitution");

        insertButton1.setText("Insert");
        insertButton1.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                insertButton1ActionPerformed(evt);
            }
        });

        jLabel16.setText("Health");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(insertButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel16))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(monsterHealth1, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(monsterConstituion1)
                            .addComponent(monsterStrength1)
                            .addComponent(monsterName1)
                            .addComponent(monsterDexterity1)
                            .addComponent(monsterIntelligence1)
                            .addComponent(monsterWisdom1)
                            .addComponent(monsterCharisma1))
                        .addContainerGap(305, Short.MAX_VALUE))))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monsterName1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(monsterHealth1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(monsterStrength1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(monsterDexterity1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(monsterConstituion1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(monsterIntelligence1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(monsterWisdom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(monsterCharisma1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(insertButton1)
                .addContainerGap(285, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        updateMonsters.setText("Update Health");
        updateMonsters.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                updateMonstersActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removeButtonActionPerformed(evt);
            }
        });

        monsterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        monsterTable.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                monsterTableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(monsterTable);

        imageAdd.setText("Add Image");
        imageAdd.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                imageAddActionPerformed(evt);
            }
        });

        selectImage.setText("Select Image");
        selectImage.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                selectImageActionPerformed(evt);
            }
        });

        clearImage.setText("Clear");
        clearImage.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearImageActionPerformed(evt);
            }
        });

        imageLabel.setAutoscrolls(true);
        jScrollPane6.setViewportView(imageLabel);

        javax.swing.GroupLayout monsterPanelLayout = new javax.swing.GroupLayout(monsterPanel);
        monsterPanel.setLayout(monsterPanelLayout);
        monsterPanelLayout.setHorizontalGroup(
            monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(monsterPanelLayout.createSequentialGroup()
                .addGroup(monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(monsterPanelLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(updateMonsters)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(removeButton))
                        .addGroup(monsterPanelLayout.createSequentialGroup()
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 538, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(monsterPanelLayout.createSequentialGroup()
                                    .addComponent(selectImage)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(imageAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(clearImage, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        monsterPanelLayout.setVerticalGroup(
            monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, monsterPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(monsterPanelLayout.createSequentialGroup()
                        .addComponent(filePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectImage)
                            .addComponent(imageAdd)
                            .addComponent(clearImage))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(monsterPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 547, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(monsterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateMonsters)
                            .addComponent(removeButton))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        addTab.addTab("Monsters", monsterPanel);

        removePlayer.setText("Remove");
        removePlayer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                removePlayerActionPerformed(evt);
            }
        });

        playerTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][]
            {
                {},
                {},
                {},
                {}
            },
            new String []
            {

            }
        ));
        jScrollPane5.setViewportView(playerTable);

        javax.swing.GroupLayout playerPanelLayout = new javax.swing.GroupLayout(playerPanel);
        playerPanel.setLayout(playerPanelLayout);
        playerPanelLayout.setHorizontalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(playerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(removePlayer)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        playerPanelLayout.setVerticalGroup(
            playerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 256, Short.MAX_VALUE)
                .addComponent(removePlayer)
                .addContainerGap())
        );

        addTab.addTab("Players", playerPanel);

        jLabel1.setText("Name");

        jLabel2.setText("Strength");

        jLabel3.setText("Dexterity");

        jLabel4.setText("Charisma");

        jLabel5.setText("Wisdom");

        jLabel6.setText("Intelligence");

        jLabel7.setText("Constitution");

        insertMonster.setText("Add Monster");
        insertMonster.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                insertMonsterActionPerformed(evt);
            }
        });

        jLabel8.setText("Health");

        insertPlayer.setText("Add Player");
        insertPlayer.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                insertPlayerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(insertPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel8))
                        .addGap(41, 41, 41)
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(characterHealth, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(characterStrength, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(characterDexterity, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(characterConstituion, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(characterIntelligence, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(characterWisdom, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(characterCharisma, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(characterName)))
                    .addComponent(insertMonster))
                .addContainerGap(576, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(characterName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(characterHealth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(8, 8, 8)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(characterStrength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(characterDexterity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(characterConstituion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(characterIntelligence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(characterWisdom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(characterCharisma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertMonster)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(insertPlayer)
                .addContainerGap(451, Short.MAX_VALUE))
        );

        addTab.addTab("Add Monster/Player", addPanel);

        jScrollPane2.setViewportView(initJTable);

        clearInit.setText("Clear");
        clearInit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                clearInitActionPerformed(evt);
            }
        });

        addMonsterInit.setText("Add Monster");
        addMonsterInit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addMonsterInitActionPerformed(evt);
            }
        });

        jLabel17.setText("Monsters");

        jLabel18.setText("Players");

        addPlayerInit.setText("Add Player");
        addPlayerInit.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                addPlayerInitActionPerformed(evt);
            }
        });

        diceType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "D4", "D6", "D8", "D10", "D12", "D20" }));

        jLabel19.setText("Dice Type");

        jLabel20.setText("Dice Count");

        diceResults.setEditable(false);
        diceResults.setColumns(20);
        diceResults.setRows(5);
        jScrollPane4.setViewportView(diceResults);

        rollDice.setText("Roll Dice");
        rollDice.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                rollDiceActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout initPanelLayout = new javax.swing.GroupLayout(initPanel);
        initPanel.setLayout(initPanelLayout);
        initPanelLayout.setHorizontalGroup(
            initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 835, Short.MAX_VALUE)
            .addGroup(initPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(initPanelLayout.createSequentialGroup()
                        .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(monsterInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playerInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18)))
                    .addComponent(addMonsterInit)
                    .addComponent(addPlayerInit)
                    .addComponent(clearInit))
                .addGap(82, 82, 82)
                .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(initPanelLayout.createSequentialGroup()
                        .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel19)
                            .addComponent(diceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(initPanelLayout.createSequentialGroup()
                                .addComponent(diceCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rollDice))
                            .addComponent(jLabel20)))
                    .addComponent(jScrollPane4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        initPanelLayout.setVerticalGroup(
            initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel17)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(2, 2, 2)
                .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(playerInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(monsterInit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diceType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diceCount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rollDice))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(initPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(initPanelLayout.createSequentialGroup()
                        .addComponent(addMonsterInit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addPlayerInit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearInit))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );

        addTab.addTab("Initiative", initPanel);

        notesArea.setColumns(20);
        notesArea.setRows(5);
        jScrollPane1.setViewportView(notesArea);

        updateNotes.setText("Update");
        updateNotes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                updateNotesActionPerformed(evt);
            }
        });

        loadNotes.setText("Load");
        loadNotes.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                loadNotesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout notesPanelLayout = new javax.swing.GroupLayout(notesPanel);
        notesPanel.setLayout(notesPanelLayout);
        notesPanelLayout.setHorizontalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(notesPanelLayout.createSequentialGroup()
                        .addComponent(updateNotes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loadNotes)
                        .addGap(0, 687, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE))
                .addContainerGap())
        );
        notesPanelLayout.setVerticalGroup(
            notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(notesPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 684, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(notesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(updateNotes)
                    .addComponent(loadNotes))
                .addContainerGap())
        );

        addTab.addTab("Notes", notesPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addTab)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addTab, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void insertButton1ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_insertButton1ActionPerformed
    {//GEN-HEADEREND:event_insertButton1ActionPerformed

    }//GEN-LAST:event_insertButton1ActionPerformed

    private void insertPlayerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_insertPlayerActionPerformed
    {//GEN-HEADEREND:event_insertPlayerActionPerformed
        //On click add player to player db
        String name = characterName.getText();
        String health = characterHealth.getText();
        String strength = characterStrength.getText();
        String dex = characterDexterity.getText();
        String con = characterConstituion.getText();
        String intel = characterIntelligence.getText();
        String wis = characterWisdom.getText();
        String charisma = characterCharisma.getText();
        sqliteDB.insertPlayer(name, health, strength, dex, con, intel, wis, charisma);
        comboBox();
        updatePlayerTable();
    }//GEN-LAST:event_insertPlayerActionPerformed

    private void insertMonsterActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_insertMonsterActionPerformed
    {//GEN-HEADEREND:event_insertMonsterActionPerformed
        String name = characterName.getText();
        String health = characterHealth.getText();
        String strength = characterStrength.getText();
        String dex = characterDexterity.getText();
        String con = characterConstituion.getText();
        String intel = characterIntelligence.getText();
        String wis = characterWisdom.getText();
        String charisma = characterCharisma.getText();
        String monsterCard = null;
        sqliteDB.insertMonsters(name, health, strength, dex, con, intel, wis, charisma, monsterCard);
        comboBox();
        updateMonsterTable();
    }//GEN-LAST:event_insertMonsterActionPerformed

    private void loadNotesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_loadNotesActionPerformed
    {//GEN-HEADEREND:event_loadNotesActionPerformed
        loadNotes();
    }//GEN-LAST:event_loadNotesActionPerformed

    private void updateNotesActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateNotesActionPerformed
    {//GEN-HEADEREND:event_updateNotesActionPerformed
        //On click update notes
        String notes = notesArea.getText();
        sqliteDB.updateNotes(notes);
        loadNotes();
    }//GEN-LAST:event_updateNotesActionPerformed

    @SuppressWarnings("empty-statement")
    private void rollDiceActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_rollDiceActionPerformed
    {//GEN-HEADEREND:event_rollDiceActionPerformed
        // On click roll dice
        Dice d = new Dice();
        if (diceType.getSelectedItem() == "D4")
        {
            int total = 0;
            int i = 0;
            int c = (int) diceCount.getValue();
            while (i < c)
            {
                total += d.roll4();
                i++;
            }
            diceResults.setText("You rolled "+ c + " D4 dice. Totaling to "+total+".");
        }
        if (diceType.getSelectedItem() == "D4")
        {
            int total = 0;
            int i = 0;
            int c = (int) diceCount.getValue();
            while (i < c)
            {
                total += d.roll4();
                i++;
            }
            diceResults.setText("You rolled "+ c + " D4 dice. Totaling to "+total+".");
        }
        if (diceType.getSelectedItem() == "D6")
        {
            int total = 0;
            int i = 0;
            int c = (int) diceCount.getValue();
            while (i < c)
            {
                total += d.roll6();
                i++;
            }
            diceResults.setText("You rolled "+ c + " D6 dice. Totaling to "+total+".");
        }
        if (diceType.getSelectedItem() == "D8")
        {
            int total = 0;
            int i = 0;
            int c = (int) diceCount.getValue();
            while (i < c)
            {
                total += d.roll8();
                i++;
            }
            diceResults.setText("You rolled "+ c + " D8 dice. Totaling to "+total+".");
        }
        if (diceType.getSelectedItem() == "D10")
        {
            int total = 0;
            int i = 0;
            int c = (int) diceCount.getValue();
            while (i < c)
            {
                total += d.roll10();
                i++;
            }
            diceResults.setText("You rolled "+ c + " D10 dice. Totaling to "+total+".");
        }
        if (diceType.getSelectedItem() == "D12")
        {
            int total = 0;
            int i = 0;
            int c = (int) diceCount.getValue();
            while (i < c)
            {
                total += d.roll12();
                i++;
            }
            diceResults.setText("You rolled "+ c + " D12 dice. Totaling to "+total+".");
        }
        if (diceType.getSelectedItem() == "D20")
        {
            int total = 0;
            int i = 0;
            int c = (int) diceCount.getValue();
            while (i < c)
            {
                total += d.roll20();
                i++;
            }
            diceResults.setText("You rolled "+ c + " 204 dice. Totaling to "+total+".");
        }
    }//GEN-LAST:event_rollDiceActionPerformed

    private void addPlayerInitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addPlayerInitActionPerformed
    {//GEN-HEADEREND:event_addPlayerInitActionPerformed
        if (playerInit.getSelectedIndex() != -1)
        {
            String name2 = playerInit.getSelectedItem().toString();
            sqliteDB.insertInit(name2);
            updateInitTable();
        }
    }//GEN-LAST:event_addPlayerInitActionPerformed

    private void addMonsterInitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_addMonsterInitActionPerformed
    {//GEN-HEADEREND:event_addMonsterInitActionPerformed
        if (monsterInit.getSelectedIndex() != -1)
        {
            String name = monsterInit.getSelectedItem().toString();
            sqliteDB.insertInit(name);
            updateInitTable();
        }
    }//GEN-LAST:event_addMonsterInitActionPerformed

    private void clearInitActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearInitActionPerformed
    {//GEN-HEADEREND:event_clearInitActionPerformed
        //Clear database on click
        String sql = "DELETE FROM Init;";
        try (Connection conn = sqliteDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        updateInitTable();
    }//GEN-LAST:event_clearInitActionPerformed

    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removeButtonActionPerformed
    {//GEN-HEADEREND:event_removeButtonActionPerformed
        int row = monsterTable.getSelectedRow();
        String selected = monsterTable.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM monsters WHERE name = ?";
        //String sql2 = "DBCC CHECKIDENT ('Passwords', RESEED, 0)";
        try (Connection conn = sqliteDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, selected);
            pstmt.executeUpdate();
            updateMonsterTable();
            comboBox();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        
    }//GEN-LAST:event_removeButtonActionPerformed

    private void updateMonstersActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_updateMonstersActionPerformed
    {//GEN-HEADEREND:event_updateMonstersActionPerformed
        updateMonsterHealth();
        updateMonsterTable();
    }//GEN-LAST:event_updateMonstersActionPerformed

    private void removePlayerActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_removePlayerActionPerformed
    {//GEN-HEADEREND:event_removePlayerActionPerformed
        int row = playerTable.getSelectedRow();
        String selected = playerTable.getModel().getValueAt(row, 0).toString();
        String sql = "DELETE FROM players WHERE name = ?";
        //String sql2 = "DBCC CHECKIDENT ('Passwords', RESEED, 0)";
        try (Connection conn = sqliteDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            pstmt.setString(1, selected);
            pstmt.executeUpdate();
            comboBox();
            updatePlayerTable();
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_removePlayerActionPerformed

    private void imageAddActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_imageAddActionPerformed
    {//GEN-HEADEREND:event_imageAddActionPerformed
        int row = monsterTable.getSelectedRow();
        String selected = monsterTable.getModel().getValueAt(row, 0).toString();
        String sql = "Update "+mTable+" SET monsterCard = ? where name = ?";
        String image = filePath.getText();
        try
        {
            File f = new File (image);
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for(int readNum; (readNum = fis.read(buf)) != -1;)
            {
                bos.write(buf,0,readNum);
            }
            characterImage=bos.toByteArray();
        }
        catch(FileNotFoundException e)
                {
                    JOptionPane.showMessageDialog(null, e);
                } catch (IOException ex)
        {
            Logger.getLogger(dndGUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        sqliteDB.writeMonstersImage(characterImage, selected);
        
    }//GEN-LAST:event_imageAddActionPerformed

    private void monsterTableMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_monsterTableMouseClicked
    {//GEN-HEADEREND:event_monsterTableMouseClicked
        int row = monsterTable.getSelectedRow();
        String selected = monsterTable.getModel().getValueAt(row, 0).toString();
        String sql = "select monsterCard from "+mTable+" where name ='"+selected+"'";

        try (Connection conn = sqliteDB.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql))
        {
            //pstmt.setString(1, selected);
            ResultSet rs;
            rs = pstmt.executeQuery();
            if(rs.next())
            {
                byte[]imagedata = rs.getBytes("monsterCard");
                format = new ImageIcon(imagedata);
                imageLabel.setIcon(format);
            }
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }  
    }//GEN-LAST:event_monsterTableMouseClicked

    private void selectImageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_selectImageActionPerformed
    {//GEN-HEADEREND:event_selectImageActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        String imageName=f.getAbsolutePath();
        filePath.setText(imageName);
    }//GEN-LAST:event_selectImageActionPerformed

    private void clearImageActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_clearImageActionPerformed
    {//GEN-HEADEREND:event_clearImageActionPerformed
        filePath.setText("");
        imageLabel.setIcon(null);
    }//GEN-LAST:event_clearImageActionPerformed

    /*
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(dndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(dndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(dndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(dndGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new dndGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addMonsterInit;
    private javax.swing.JPanel addPanel;
    private javax.swing.JButton addPlayerInit;
    private javax.swing.JTabbedPane addTab;
    private javax.swing.JTextField characterCharisma;
    private javax.swing.JTextField characterConstituion;
    private javax.swing.JTextField characterDexterity;
    private javax.swing.JTextField characterHealth;
    private javax.swing.JTextField characterIntelligence;
    private javax.swing.JTextField characterName;
    private javax.swing.JTextField characterStrength;
    private javax.swing.JTextField characterWisdom;
    private javax.swing.JButton clearImage;
    private javax.swing.JButton clearInit;
    private javax.swing.JSpinner diceCount;
    private javax.swing.JTextArea diceResults;
    private javax.swing.JComboBox<String> diceType;
    private javax.swing.JTextField filePath;
    private javax.swing.JButton imageAdd;
    private javax.swing.JLabel imageLabel;
    private javax.swing.JTable initJTable;
    private javax.swing.JPanel initPanel;
    private javax.swing.JButton insertButton1;
    private javax.swing.JButton insertMonster;
    private javax.swing.JButton insertPlayer;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton loadNotes;
    private javax.swing.JTextField monsterCharisma1;
    private javax.swing.JTextField monsterConstituion1;
    private javax.swing.JTextField monsterDexterity1;
    private javax.swing.JTextField monsterHealth1;
    private javax.swing.JComboBox<String> monsterInit;
    private javax.swing.JTextField monsterIntelligence1;
    private javax.swing.JTextField monsterName1;
    private javax.swing.JPanel monsterPanel;
    private javax.swing.JTextField monsterStrength1;
    private javax.swing.JTable monsterTable;
    private javax.swing.JTextField monsterWisdom1;
    private javax.swing.JTextArea notesArea;
    private javax.swing.JPanel notesPanel;
    private javax.swing.JComboBox<String> playerInit;
    private javax.swing.JPanel playerPanel;
    private javax.swing.JTable playerTable;
    private javax.swing.JButton removeButton;
    private javax.swing.JButton removePlayer;
    private javax.swing.JButton rollDice;
    private javax.swing.JButton selectImage;
    private javax.swing.JButton updateMonsters;
    private javax.swing.JButton updateNotes;
    // End of variables declaration//GEN-END:variables

}
