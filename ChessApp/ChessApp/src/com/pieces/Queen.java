package com.pieces;

import java.util.ArrayList;

import com.chess.ChessBoard;
import com.chess.Piece;
import com.chess.Player;
import com.chess.Tile;

public class Queen extends Piece{

	public Queen(String s,Player p){
		this.pieceName=s;
		this.player=p;
	}
	@Override
	public ArrayList<Tile> getLegalMoves() {
		ArrayList<Tile> t=new ArrayList<Tile>();
		int x=this.onTile.row;
		int y=this.onTile.col;
		int i=x+1;
		int j=y+1;
		while(i<8 && j<8){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			i++;
			j++;
		}
		i=x+1;
		j=y-1;
		while(i<8 && j>=0){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			i++;
			j--;
		}
		i=x-1;
		j=y-1;
		while(i>=0 && j>=0){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			i--;
			j--;
		}
		i=x-1;
		j=y+1;
		while(i>=0 && j<8){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			i--;
			j++;
		}
		i=x-1;
		j=y;
		while(i>=0){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			i--;
		}
		i=x+1;
		j=y;
		while(i<8){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			i++;
		}
		i=x;
		j=y-1;
		while(j>=0){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			j--;
		}
		i=x;
		j=y+1;
		while(j<8){
			if(!ChessBoard.gameTiles[i][j].containPiece()){
				t.add(ChessBoard.gameTiles[i][j]);
			}
			else{
				if((ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
						|| (ChessBoard.gameTiles[i][j].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
					t.add(ChessBoard.gameTiles[i][j]);
				}
				break;
			}
			j++;
		}
		return(t);
	}

}
