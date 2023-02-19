package chess;
import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class ChessPiece extends Piece {
    private Color color;
    public ChessPiece(Board board, Color color) {
        super(board);
        this.color = color;
        

    }

    public Color getColor() {
        return color;
    }
    //Essa funcao passa um position pelo parametro,cria uma variavel recebendo uma peça do tipo ChessPiece na posicao passada pelo parametro, e depois
    //retorna true ou false se a peca for diferente de null e tiver uma cor dirente da cor da peça da variavel.
    protected boolean isthereOpponentPiece(Position position) {
    	ChessPiece p = (ChessPiece)getBoard().piece(position);
    	return p != null && p.getColor() != color;
    }
    
    

}
