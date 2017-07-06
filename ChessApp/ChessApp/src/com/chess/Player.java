package com.chess;
import com.pieces.*;
public class Player {
	String PlayerClass;
	King k;
	Queen q;
	Bishop b1,b2;
	Rook r1,r2;
	Knight k1,k2;
	Pawn p[];
	public Player(String name){
		this.PlayerClass=name;
		this.k=new King("King",this);
		this.q=new Queen("Queen",this);
		this.b1=new Bishop("Bishop",this);
		this.b2=new Bishop("Bishop",this);
		this.r1=new Rook("Rook",this);
		this.r2=new Rook("Rook",this);
		this.k1=new Knight("Knight",this);
		this.k2=new Knight("Knight",this);
		p=new Pawn[8];
		for(int i=0;i<8;i++){
			this.p[i]=new Pawn("Pawn",this);
		}
	}
	public String getPlayerClass(){
		return(this.PlayerClass);
	}
}
