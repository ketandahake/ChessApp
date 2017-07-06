package com.chess;

import java.io.IOException;
import com.chess.ChessBoard;
import java.util.ArrayList;

public abstract class Piece {
	protected Tile onTile;
	protected Player player;
	protected String pieceName;
	public abstract ArrayList<Tile> getLegalMoves();
	public void makeMove(Tile t) throws IOException{
		this.onTile.removePiece();
		t.setPiece(this);
		this.onTile=t;
	}
	public void makeAttackMove(Tile t) throws IOException{
		if(t.getPiece().getPieceName()=="King"){
			ChessBoard.endGame();
		}
		else{
			t.removePiece();
			this.onTile.removePiece();
			t.setPiece(this);
			this.onTile=t;
		}
	}
	public String getPlayerName(){
		return(this.player.getPlayerClass());
	}
	public String getPieceName(){
		return(this.pieceName);
	}
}
