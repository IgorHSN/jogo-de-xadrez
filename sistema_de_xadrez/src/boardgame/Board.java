package boardgame;

import java.util.Arrays;

public class Board {
    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
    	if (rows < 1 || columns < 1 ) {
    		throw new BoardException("Erro na criacao do tabuleiro é necessario que aja pelo menos uma linha e uma coluna");
    	}
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece (int row, int column) {
    	if (!positionExists(row, column)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    	}
        return pieces[row][column];
    }

    public  Piece piece (Position position){
    	if (!positionExists(position)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    	}
        return  pieces[position.getRow()][position.getColumm()];
    }
    
    public void placePiece (Piece piece, Position position) {
    	if (thereIsAPiece(position)) {
    		throw new BoardException("Ja existe uma peca nessa posicao " + position);
    	}
    	pieces[position.getRow()][position.getColumm()] = piece;
    	piece.position = position;
    }
    
    public Piece removePiece(Position position) {
    	if (!positionExists(position)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    		
    	}
    	if(piece(position) == null) {
    		return null;
    	}
    	Piece aux = piece(position);
    	aux.position = null;
    	pieces[position.getRow()][position.getColumm()] = null;
    	return aux;
    }
    
    private boolean positionExists(int row, int column) {
    	return row >= 0 && row < rows && column >= 0 && column < columns;
    	
    }
    
    public boolean positionExists(Position position) {
    	return positionExists(position.getRow(), position.getColumm());
    	
    	
    }
    
    public boolean thereIsAPiece(Position position) {
    	if (!positionExists(position)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    	}
    	return piece(position) != null;
    }
    
    




}