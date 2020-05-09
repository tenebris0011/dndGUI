package dndgui;

import java.util.Random;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author wilso
 */
public class Dice
{
    public Random random;
    public Dice()
    {
        this.random = new Random();
    }
    public int roll4()
    {
        int rand = random.nextInt(4) +1 ;
        return rand;
    }
    public int roll6()
    {
        int rand = random.nextInt(6) +1 ;
        return rand;
    }    
    public int roll8()
    {
        int rand = random.nextInt(8) +1 ;
        return rand;
    }
    public int roll10()
    {
        int rand = random.nextInt(10) +1 ;
        return rand;
    }
    public int roll12()
    {
        int rand = random.nextInt(12) +1 ;
        return rand;
    }
    public int roll20()
    {
        int rand = random.nextInt(20) +1 ;
        return rand;
    }
}
