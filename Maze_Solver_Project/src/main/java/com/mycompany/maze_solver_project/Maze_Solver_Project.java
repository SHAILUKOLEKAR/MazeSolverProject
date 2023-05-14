/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.maze_solver_project;

import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author SHAILU KOLEKAR
 */
public class Maze_Solver_Project extends JFrame{
    
    private int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,1},
        {1,0,0,0,0,0,1,0,1,1,0,1},
        {1,1,1,1,1,0,1,0,0,1,0,1},
        {1,0,0,1,1,0,0,0,0,0,0,1},
        {1,0,0,0,1,1,1,0,1,1,0,1},
        {1,0,1,0,0,0,0,0,0,9,0,1},
        {1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    public List<Integer> path = new ArrayList<>();
    
    public Maze_Solver_Project(){
        setTitle("Maze Solver Project");
        setSize(620,420);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        DepthFirst.searchPath(maze, 1, 1, path);
        //System.out.println(path);
    }
    
    @Override
    public void paint(Graphics g)
    {
        g.translate(120, 100);
        for(int i=0;i<maze.length;i++)
        {
            for(int j=0;j<maze[0].length;j++)
            {
                Color color;
                switch(maze[i][j]){
                    case 1:color=Color.BLACK;break;
                    case 9:color=Color.RED;break;
                    default: color = Color.WHITE;break;
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(Color.RED);
                g.drawRect(30*j, 30*i, 30, 30);
            }
        }
        
        for(int i=0;i<path.size();i+=2)
        {
            int pathX = path.get(i);
            int pathY = path.get(i+1);
            
            g.setColor(Color.GREEN);
            g.fillRect(30*pathX, 30*pathY, 20, 20);
            
        }
    }
    

    public static void main(String[] args) {
        Maze_Solver_Project view = new Maze_Solver_Project();
        view.setVisible(true);
    }
}
