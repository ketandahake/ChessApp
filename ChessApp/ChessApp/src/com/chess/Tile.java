package com.chess;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.chess.ChessBoard;

public class Tile extends JPanel implements MouseListener {
	private static final long serialVersionUID = 1L;
	public int row,col;
	public Piece piece;
	private boolean hasPiece;
	private JLabel content;
	private static boolean selected=false;
	private static Tile selectedCell;
	public boolean possibleDestination;
	
	Tile(int x,int y){
		this.row=x;
		this.col=y;
		addMouseListener(this);
	}
	
	public static boolean isSelected(){
		return(selected);
	}
	public static void selectCell(Tile t){
		selected=true;
		t.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		setSelectedCell(t);
	}
	public static void unselectCell(){
		selected=false;
	}
	public static Tile getSelectedCell() {
		return selectedCell;
	}

	public static void setSelectedCell(Tile selectedCell) {
		Tile.selectedCell = selectedCell;
	}
	public void setPiece(Piece p) throws IOException{
		this.hasPiece=true;
		this.piece=p;
		int x=this.row;
		int y=this.col;
		String name=p.getPlayerName()+"_"+p.getPieceName();
		name=name+'.'+"png";
		BufferedImage img = ImageIO.read(this.getClass().getResource(name));
		JLabel icon = new JLabel(new ImageIcon(img));
		this.content=icon;
		add(icon);
		ChessBoard.gameTiles[x][y]=this;
	}
	public Piece getPiece(){
		return(this.piece);
	}
	public boolean containPiece(){
		return(this.hasPiece);
	}
	public void removePiece(){
		this.hasPiece=false;
		remove(this.content);
		int x=this.row;
		int y=this.col;
		ChessBoard.gameTiles[x][y]=this;
	}
	public void setBlackColor() {
		this.setBackground(Color.gray);
	}
	public void setWhiteColor() {
		this.setBackground(Color.WHITE);
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(!Tile.isSelected()){       //no tile is selected previously
			if(this.containPiece() && ((this.getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==1)
					|| (this.getPiece().getPlayerName()=="White" && ChessBoard.chance%2==0))){
				   //click on a tile containing a piece of a player whose chance it is
				Tile.selectCell(this);
				setLegalMoves(this.piece);
			}
		}
		else{       //some tile is selected previously
			//either have to select some other tile or move a piece to a destination tile
			if(this.possibleDestination){
				selectedCell.removePossibleDestinations();
				Tile.selectedCell.setBorder(BorderFactory.createEmptyBorder());
				if(this.containPiece()){
					try {
						selectedCell.getPiece().makeAttackMove(this);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				else{
					try {
						selectedCell.getPiece().makeMove(this);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				ChessBoard.chance=(ChessBoard.chance+1)%2;
				Tile.unselectCell();
			}
			else if(this.containPiece() && ((this.getPiece().getPlayerName()=="Black" && ChessBoard.chance%2==1)
					|| (this.getPiece().getPlayerName()=="White" && ChessBoard.chance%2==0))){
				Tile.selectedCell.setBorder(BorderFactory.createEmptyBorder()); 
				selectedCell.removePossibleDestinations();
				Tile.selectCell(this);
				this.setBorder(BorderFactory.createLineBorder(Color.blue,3));
				setLegalMoves(this.piece);
			}
		}
	}

	private void removePossibleDestinations() {
		ArrayList<Tile> destinations=new ArrayList<Tile>();
		destinations=this.getPiece().getLegalMoves();
		for(Tile destination : destinations){
			destination.possibleDestination=false;
			destination.setBorder(BorderFactory.createEmptyBorder());
		}
	}

	private void setLegalMoves(Piece p) {
		ArrayList<Tile> destinations=new ArrayList<Tile>();
		destinations=p.getLegalMoves();
		//System.out.println(destinations.size());
		for(Tile destination : destinations){
			destination.possibleDestination=true;
			destination.setBorder(BorderFactory.createLineBorder(Color.green,3));
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
}
