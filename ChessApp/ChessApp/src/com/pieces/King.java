package com.pieces;

import java.util.ArrayList;

import com.chess.ChessBoard;
import com.chess.Piece;
import com.chess.Player;
import com.chess.Tile;

public class King extends Piece{

	public King(String s,Player p){
		this.pieceName=s;
		this.player=p;
	}

	@Override
	public ArrayList<Tile> getLegalMoves() {
		ArrayList<Tile> t=new ArrayList<Tile>();
		int x=this.onTile.row;
		int y=this.onTile.col;
		int posx[]={x-1,x-1,x-1,x,x,x+1,x+1,x+1};
		int posy[]={y-1,y,y+1,y-1,y+1,y-1,y,y+1};
		for(int i=0;i<posx.length;i++){
			if(posx[i]>=0 && posx[i]<8 && posy[i]>=0 && posy[i]<8){
				if(!ChessBoard.gameTiles[posx[i]][posy[i]].containPiece()){
					t.add(ChessBoard.gameTiles[posx[i]][posy[i]]);
				}
				else{
					if((ChessBoard.gameTiles[posx[i]][posy[i]].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
								|| (ChessBoard.gameTiles[posx[i]][posy[i]].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)){
						t.add(ChessBoard.gameTiles[posx[i]][posy[i]]);
					}
				}
			}
		}
		return(t);
	}
	
	public boolean isKingInDanger(){
		int x=this.onTile.row;
		int y=this.onTile.col;
		//danger from Knight of opposite player
		int posx[]={x+1,x+1,x+2,x+2,x-1,x-1,x-2,x-2};
		int posy[]={y-2,y+2,y-1,y+1,y-2,y+2,y-1,y+1};
		for(int i=0;i<8;i++){
			if(posx[i]>=0 && posx[i]<8 && posy[i]>=0 && posy[i]<8){
				if(ChessBoard.gameTiles[posx[i]][posy[i]].containPiece() && ChessBoard.gameTiles[posx[i]][posy[i]].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& ChessBoard.gameTiles[posx[i]][posy[i]].getPiece().getPieceName()=="Knight"){
					return(true);
				}
			}
		}
		//danger from rook or Queen
		int i=x-1;
		int j=y;
		while(i>=0){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Rook"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			i--;
		}
		i=x+1;
		j=y;
		while(i<8){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Rook"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			i++;
		}
		i=x;
		j=y-1;
		while(j>=0){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Rook"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			j--;
		}
		i=x;
		j=y+1;
		while(j<8){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Rook"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			j++;
		}
		//danger from bishop or queen
		x=this.onTile.row;
		y=this.onTile.col;
		i=x+1;
		j=y+1;
		while(i<8 && j<8){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Bishop"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			i++;
			j++;
		}
		i=x+1;
		j=y-1;
		while(i<8 && j>=0){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Bishop"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			i++;
			j--;
		}
		i=x-1;
		j=y-1;
		while(i>=0 && j>=0){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Bishop"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			i--;
			j--;
		}
		i=x-1;
		j=y+1;
		while(i>=0 && j<8){
			if(ChessBoard.gameTiles[i][j].containPiece()){
				if(ChessBoard.gameTiles[i][j].getPiece().getPlayerName()!=this.player.getPlayerClass()
						&& (ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Bishop"
							|| ChessBoard.gameTiles[i][j].getPiece().getPieceName()=="Queen")){
					return(true);
				}
				else{
					break;
				}
			}
			i--;
			j++;
		}
		//danger from king
		int posxx[]={x-1,x-1,x-1,x,x,x+1,x+1,x+1};
		int posyy[]={y-1,y,y+1,y-1,y+1,y-1,y,y+1};
		for(i=0;i<8;i++){
			if(posxx[i]>=0 && posxx[i]<8 && posyy[i]>=0 && posyy[i]<8){
				if(ChessBoard.gameTiles[posxx[i]][posyy[i]].containPiece()){
					if(ChessBoard.gameTiles[posxx[i]][posyy[i]].getPiece().getPlayerName()!=this.player.getPlayerClass()
							&& ChessBoard.gameTiles[posxx[i]][posyy[i]].getPiece().getPieceName()=="King"){
						return(true);
					}
				}
			}
		}
		//danger from a pawn
		if(ChessBoard.gameTiles[x][y].getPiece().getPlayerName()=="White"){
			if(x-1>=0 && y-1>=0){
				if(ChessBoard.gameTiles[x-1][y-1].containPiece()){
					if(ChessBoard.gameTiles[x-1][y-1].getPiece().getPlayerName()=="Black"
							&& ChessBoard.gameTiles[x-1][y-1].getPiece().getPieceName()=="Pawn"){
						return(true);
					}
				}
			}
			if(x-1>=0 && y+1<8){
				if(ChessBoard.gameTiles[x-1][y+1].containPiece()){
					if(ChessBoard.gameTiles[x-1][y+1].getPiece().getPlayerName()=="Black"
							&& ChessBoard.gameTiles[x-1][y+1].getPiece().getPieceName()=="Pawn"){
						return(true);
					}
				}
			}
		}
		else{
			if(x+1<8 && y-1>=0){
				if(ChessBoard.gameTiles[x+1][y-1].containPiece()){
					if(ChessBoard.gameTiles[x+1][y-1].getPiece().getPlayerName()=="White"
							&& ChessBoard.gameTiles[x+1][y-1].getPiece().getPieceName()=="Pawn"){
						return(true);
					}
				}
			}
			if(x+1<8 && y+1<8){
				if(ChessBoard.gameTiles[x+1][y+1].containPiece()){
					if(ChessBoard.gameTiles[x+1][y+1].getPiece().getPlayerName()=="White"
							&& ChessBoard.gameTiles[x+1][y+1].getPiece().getPieceName()=="Pawn"){
						return(true);
					}
				}
			}
		}
		return(false);
	}
}

