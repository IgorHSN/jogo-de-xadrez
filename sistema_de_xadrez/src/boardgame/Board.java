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
    
    //esse metodo retorna uma peca na posicao do row/column
    public Piece piece (int row, int column) {
    	if (!positionExists(row, column)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    	}
        return pieces[row][column];
    }
    //esse metodo retorna uma peca na posicao do position.getRow/position.getColumn
    public  Piece piece (Position position){
    	if (!positionExists(position)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    	}
        return  pieces[position.getRow()][position.getColumm()];
    }
    
    // funcao insere uma peca na matriz passando como posicao a position.getRow/position.getColumn. Apos isso insere o position
    //do parametro no atributo position na peca
    public void placePiece (Piece piece, Position position) {
    	if (thereIsAPiece(position)) {
    		throw new BoardException("Ja existe uma peca nessa posicao " + position);
    	}
    	pieces[position.getRow()][position.getColumm()] = piece;
    	piece.position = position;
    }
    
    //esse metodo remove uma peca na matrizes de peca passando um objeto position no parametro. Criando uma variavel com a peca da posicao
    //inserindo null no objeto position da peca e inserindo null na matriz de peca de acordo com a posicao do position do parametro apois
    //retorna a peca
    public Piece removePiece(Position position) {
    	if (!positionExists(position)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    		
    	}
    	if(piece(position) == null) {
    		return null;
    	}
    	Piece p = piece(position);
    	p.position = null;
    	pieces[position.getRow()][position.getColumm()] = null;
    	return p;
    }
    
    
    //funcao para testar se uma position existe
    private boolean positionExists(int row, int column) {
    	return row >= 0 && row < rows && column >= 0 && column < columns;
    	
    }
    //funcao para testar se uma position existe
    public boolean positionExists(Position position) {
    	return positionExists(position.getRow(), position.getColumm());
    	
    	
    }
    
    // testa se uma peca existe na posicao
    public boolean thereIsAPiece(Position position) {
    	if (!positionExists(position)) {
    		throw new BoardException("A posicao nao esta no tabuleiro");
    	}
    	return piece(position) != null;
    }
    
    




}
