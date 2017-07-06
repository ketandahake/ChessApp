package com.pieces;

import java.util.ArrayList;

import com.chess.ChessBoard;
import com.chess.Piece;
import com.chess.Player;
import com.chess.Tile;

public class Pawn extends Piece{

	public Pawn(String s,Player p){
		this.pieceName=s;
		this.player=p;
	}
	@Override
	public ArrayList<Tile> getLegalMoves() {
		ArrayList<Tile> t=new ArrayList<Tile>();
		int x=this.onTile.row;
		int y=this.onTile.col;
		if(ChessBoard.chance%2==0){  //White player
			if(x==6){        //1 or 2 steps frm 1st position
				if(!ChessBoard.gameTiles[x-1][y].containPiece()){
					t.add(ChessBoard.gameTiles[x-1][y]);
					if(!ChessBoard.gameTiles[x-2][y].containPiece()){
						t.add(ChessBoard.gameTiles[x-2][y]);
					}
				}
				if((y-1)>=0 && ChessBoard.gameTiles[x-1][y-1].containPiece() && 
						ChessBoard.gameTiles[x-1][y-1].getPiece().getPlayerName()=="Black"){
					t.add(ChessBoard.gameTiles[x-1][y-1]);
				}
				if((y+1)<8 && ChessBoard.gameTiles[x-1][y+1].containPiece() && 
						ChessBoard.gameTiles[x-1][y+1].getPiece().getPlayerName()=="Black"){
					t.add(ChessBoard.gameTiles[x-1][y+1]);
				}
			}
			else{         //jst 1 step frm other positions
				if((x-1)>=0 && (!ChessBoard.gameTiles[x-1][y].containPiece())){
					t.add(ChessBoard.gameTiles[x-1][y]);
				}
				if((y-1)>=0 && ChessBoard.gameTiles[x-1][y-1].containPiece() && 
						ChessBoard.gameTiles[x-1][y-1].getPiece().getPlayerName()=="Black"){
					t.add(ChessBoard.gameTiles[x-1][y-1]);
				}
				if((y+1)<8 && ChessBoard.gameTiles[x-1][y+1].containPiece() && 
						ChessBoard.gameTiles[x-1][y+1].getPiece().getPlayerName()=="Black"){
					t.add(ChessBoard.gameTiles[x-1][y+1]);
				}
			}
		}
		else{
			if(x==1){        //1 or 2 steps frm 1st position
				if(!ChessBoard.gameTiles[x+1][y].containPiece()){
					t.add(ChessBoard.gameTiles[x+1][y]);
					if(!ChessBoard.gameTiles[x+2][y].containPiece()){
						t.add(ChessBoard.gameTiles[x+2][y]);
					}
				}
				if((y-1)>=0 && ChessBoard.gameTiles[x+1][y-1].containPiece() && 
						ChessBoard.gameTiles[x+1][y-1].getPiece().getPlayerName()=="White"){
					t.add(ChessBoard.gameTiles[x+1][y-1]);
				}
				if((y+1)<8 && ChessBoard.gameTiles[x+1][y+1].containPiece() && 
						ChessBoard.gameTiles[x+1][y+1].getPiece().getPlayerName()=="White"){
					t.add(ChessBoard.gameTiles[x+1][y+1]);
				}
			}
			else{         //jst 1 step frm other positions
				if((x+1)<8 && (!ChessBoard.gameTiles[x+1][y].containPiece())){
					t.add(ChessBoard.gameTiles[x+1][y]);
				}
				if((y-1)>=0 && ChessBoard.gameTiles[x+1][y-1].containPiece() && 
						ChessBoard.gameTiles[x+1][y-1].getPiece().getPlayerName()=="White"){
					t.add(ChessBoard.gameTiles[x+1][y-1]);
				}
				if((y+1)<8 && ChessBoard.gameTiles[x+1][y+1].containPiece() && 
						ChessBoard.gameTiles[x+1][y+1].getPiece().getPlayerName()=="White"){
					t.add(ChessBoard.gameTiles[x+1][y+1]);
				}
			}
		}
		return(t);
	}

}
