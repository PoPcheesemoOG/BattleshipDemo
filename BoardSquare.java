/* Name: Paul Helske
 * Date: 06/20/23
 */
public class BoardSquare {

	public enum SquareState {Water, Hidden_Boat_Piece, Exposed_Boat_Piece};
	public SquareState state = SquareState.Water;

	static int height = GameBoard.height;
	static int width = GameBoard.width;

	public int boatRow;
	public int boatCol;

	public BoardSquare(SquareState newstate, int boatRow, int boatCol) {
		state = newstate;
	}

	public SquareState setState(SquareState newstate) {
		state = newstate;
		return state;
	}
}
