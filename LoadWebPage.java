/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dndgui;


import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javax.swing.*;

/**
 *
 * @author wilso
 */
public class LoadWebPage
{
public static void main(String args[])
{
final JFrame frame=new JFrame();
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setSize(620,440);
final JFXPanel fxpanel=new JFXPanel();
frame.add(fxpanel);

Platform.runLater(new Runnable() {
@Override
public void run()
    {
    WebEngine engine;
    WebView wv=new WebView();
    engine=wv.getEngine();
    fxpanel.setScene(new Scene(wv));
    engine.load("https://beta.open5e.com/monsters/monster-list");
    }
    });
frame.setVisible(true);
}
}

