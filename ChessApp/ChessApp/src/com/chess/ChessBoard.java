package com.chess;

import java.awt.GridLayout;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
//////unimplemented - castling,en passant,promotion
					//highlighting when the king is in danger
					//time constraints
					//Draw a game
public class ChessBoard{
	public static JFrame gameframe;
	public static Tile[][] gameTiles;
	private Player p1;
	private Player p2;
	public static int chance=0;   //even number is for the white player
	
	public ChessBoard() throws IOException {
		ChessBoard.gameframe=new JFrame("Chess");
		ChessBoard.gameframe.setSize(600,600);
		ChessBoard.gameframe.setLayout(new GridLayout(8,8));
		ChessBoard.gameTiles=new Tile[8][8];
		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				Tile tile=new Tile(i, j);
				if((i+j)%2==0){
					tile.setBlackColor();
				}
				else{
					tile.setWhiteColor();
				}
				tile.row=i;
				tile.col=j;
				tile.possibleDestination=false;
				gameTiles[i][j]=tile;
				ChessBoard.gameframe.add(gameTiles[i][j]);
			}
		}
		this.p1=new Player("Black");
		//set pieces on the board for white player
		gameTiles[0][0].setPiece((Piece)p1.r1);
		p1.r1.onTile=gameTiles[0][0];
		gameTiles[0][1].setPiece((Piece)p1.k1);
		p1.k1.onTile=gameTiles[0][1];
		gameTiles[0][2].setPiece((Piece)p1.b1);
		p1.b1.onTile=gameTiles[0][2];
		gameTiles[0][3].setPiece((Piece)p1.q);
		p1.q.onTile=gameTiles[0][3];
		gameTiles[0][4].setPiece((Piece)p1.k);
		p1.k.onTile=gameTiles[0][4];
		gameTiles[0][5].setPiece((Piece)p1.b2);
		p1.b2.onTile=gameTiles[0][5];
		gameTiles[0][6].setPiece((Piece)p1.k2);
		p1.k2.onTile=gameTiles[0][6];
		gameTiles[0][7].setPiece((Piece)p1.r2);
		p1.r2.onTile=gameTiles[0][7];
		for(int i=0;i<8;i++){
			gameTiles[1][i].setPiece((Piece)p1.p[i]);
			p1.p[i].onTile=gameTiles[1][i];
		}
		this.p2=new Player("White");
		//set pieces on the board for white player
		gameTiles[7][0].setPiece((Piece)p2.r1);
		p2.r1.onTile=gameTiles[7][0];
		gameTiles[7][1].setPiece((Piece)p2.k1);
		p2.k1.onTile=gameTiles[7][1];
		gameTiles[7][2].setPiece((Piece)p2.b1);
		p2.b1.onTile=gameTiles[7][2];
		gameTiles[7][3].setPiece((Piece)p2.q);
		p2.q.onTile=gameTiles[7][3];
		gameTiles[7][4].setPiece((Piece)p2.k);
		p2.k.onTile=gameTiles[7][4];
		gameTiles[7][5].setPiece((Piece)p2.b2);
		p2.b2.onTile=gameTiles[7][5];
		gameTiles[7][6].setPiece((Piece)p2.k2);
		p2.k2.onTile=gameTiles[7][6];
		gameTiles[7][7].setPiece((Piece)p2.r2);
		p2.r2.onTile=gameTiles[7][7];
		for(int i=0;i<8;i++){
			gameTiles[6][i].setPiece((Piece)p2.p[i]);
			p2.p[i].onTile=gameTiles[6][i];
		}
		ChessBoard.gameframe.setVisible(true);
	}
	public static void endGame(){
		String winner;
		if(ChessBoard.chance%2==0){
			winner="White";
		}
		else{
			winner="Black";
		}
		JOptionPane.showMessageDialog(gameframe,winner+" "+"player won the game");
		gameframe.dispose();
		try {
			Main.c=new ChessBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
