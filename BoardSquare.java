public class BoardSquare {

	public enum SquareState {Water, Hidden_Boat_Piece, Exposed_Boat_Piece};
	public SquareState state = SquareState.Water;

	static int height = GameBoard.height;
	static int width = GameBoard.width;
	
	public int boatRow;
	public int boatCol;
	
	public BoardSquare(SquareState newstate, int boatRow, int boatCol) {
		state = newstate;
		// boatRow = Battleship.rowsize;
		// boatCol = Battleship.colsize;
	}
	
	public SquareState setState(SquareState newstate) {
		state = newstate;
		return state;
	}
}
