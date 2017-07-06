package com.pieces;

import java.util.ArrayList;

import com.chess.ChessBoard;
import com.chess.Piece;
import com.chess.Player;
import com.chess.Tile;

public class Knight extends Piece{

	public Knight(String s,Player p){
		this.pieceName=s;
		this.player=p;
	}
	@Override
	public ArrayList<Tile> getLegalMoves() {
		ArrayList<Tile> t=new ArrayList<Tile>();
		int x=this.onTile.row;
		int y=this.onTile.col;
		int posx[]={x+1,x+1,x+2,x+2,x-1,x-1,x-2,x-2};
		int posy[]={y-2,y+2,y-1,y+1,y-2,y+2,y-1,y+1};
		for(int i=0;i<8;i++){
			if(posx[i]>=0 && posx[i]<8 && posy[i]>=0 && posy[i]<8){
				if(!ChessBoard.gameTiles[posx[i]][posy[i]].containPiece()){
					t.add(ChessBoard.gameTiles[posx[i]][posy[i]]);
				}
				else{   //the contained piece should be of opposite player
					if((ChessBoard.gameTiles[posx[i]][posy[i]].getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==0)
							|| (ChessBoard.gameTiles[posx[i]][posy[i]].getPiece().getPlayerName()=="White" && ChessBoard.chance%2==1)) {
						t.add(ChessBoard.gameTiles[posx[i]][posy[i]]) ;
					} 
				}
			}
		}
		return(t);
	}
}
