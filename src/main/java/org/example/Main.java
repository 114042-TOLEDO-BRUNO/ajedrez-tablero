package org.example;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        LinkedList<Piece>pieceLinkedList=new LinkedList<>();
        BufferedImage all= ImageIO.read(new File("D:\\Documentos\\vruno\\TECNICATURA EN PROGRAMACION UTN\\TERCER CUATRIMESTRE_2023\\LCIII\\REPOS\\ajedrez_tablero\\Ajedrez_Tablero\\docs\\image\\pieces.png"));
        Image imgs[]=new Image[12];
        int ind=0;
        for(int y=0;y<400;y+=200){
            for(int x=0;x<1200;x+=200){
                imgs[ind]=all.getSubimage(x,y,200,200).getScaledInstance(64,64,BufferedImage.SCALE_SMOOTH);
                ind++;
            }
        }
        Piece blackLeftRook=new Piece(0,7,true,"rook",pieceLinkedList);
        Piece blackLeftKnight=new Piece(1,7,true,"knight",pieceLinkedList);
        Piece blackLeftBishop=new Piece(2,7,true,"bishop",pieceLinkedList);
        Piece blackQueen=new Piece(3,7,true,"queen",pieceLinkedList);
        Piece blackKing=new Piece(4,7,true,"king",pieceLinkedList);
        Piece blackRightBishop=new Piece(5,7,true,"bishop",pieceLinkedList);
        Piece blackRightKnight=new Piece(6,7,true,"knight",pieceLinkedList);
        Piece blackRightRook=new Piece(7,7,true,"rook",pieceLinkedList);
        for(int p=0;p<8;p++){
            Piece blackPawn=new Piece(p,6,true,"pawn",pieceLinkedList);
        }


        Piece whiteLeftRook=new Piece(0,0,false,"rook",pieceLinkedList);
        Piece whiteLeftKnight=new Piece(1,0,false,"knight",pieceLinkedList);
        Piece whiteLeftBishop=new Piece(2,0,false,"bishop",pieceLinkedList);
        Piece whiteQueen=new Piece(3,0,false,"queen",pieceLinkedList);
        Piece whiteKing=new Piece(4,0,false,"king",pieceLinkedList);
        Piece whiteRightBishop=new Piece(5,0,false,"bishop",pieceLinkedList);
        Piece whiteRightKnight=new Piece(6,0,false,"knight",pieceLinkedList);
        Piece whiteRightRook=new Piece(7,0,false,"rook",pieceLinkedList);
        for(int p=0;p<8;p++){
            Piece blackPawn=new Piece(p,1,false,"pawn",pieceLinkedList);
        }






        JFrame frame=new JFrame();
        frame.setBounds(10,10,512,512);
        frame.setUndecorated(true);//saca el borde a la ventana
        JPanel panel=new JPanel(){
            @Override
            public void paint(Graphics g){
                boolean white=true;
                for(int y=0;y<8;y++){
                    for(int x=0;x<8;x++){
                        if(white){
                            g.setColor(new Color(235,235,208));
                        }else{
                            g.setColor(new Color(119,148,148));
                        }
                        g.fillRect(x*64,y*64,64,64);
                        white=!white;
                    }
                    white=!white;
                }
                for(Piece p:pieceLinkedList){
                    int index=0;
                    if(p.name.equalsIgnoreCase("king")){
                        index=0;
                    }
                    if(p.name.equalsIgnoreCase("queen")){
                        index=1;
                    }
                    if(p.name.equalsIgnoreCase("bishop")){
                        index=2;
                    }
                    if(p.name.equalsIgnoreCase("knight")){
                        index=3;
                    }
                    if(p.name.equalsIgnoreCase("rook")){
                        index=4;
                    }
                    if(p.name.equalsIgnoreCase("pawn")){
                        index=5;
                    }
                    if(!p.isWhite){
                        index+=6;
                    }
                    g.drawImage(imgs[index],p.xp*64,p.yp*64,this);

                }
            }
        };
        frame.add(panel);
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);


    }
}