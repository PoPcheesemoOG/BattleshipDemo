
public class BoardSquare {
	public enum SquareState {Water, HiddenBoatPiece, ExposedBoatPiece};
	public static SquareState state;
	
	public int boatRow = Battleship.getRowSize();
	public int boatCol = Battleship.getColSize();

	public static void hideBoats(int boatRow, int boatCol) {
		for (int i = 0; i < boatRow; i++) {
			state = SquareState.HiddenBoatPiece;
		}
		for (int i = 0; i < boatCol; i++) {
			state = SquareState.HiddenBoatPiece;
		}
		
		
	}
}