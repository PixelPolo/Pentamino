package mvc;

import geometry.Point;
import geometry.Vector;
import shapes.pentamino.Board;
import shapes.pentamino.Pentamino;

import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable {

    // ***** FIELDS *****

    private final Board board;
    private final ArrayList<Pentamino> pentaminos;

    // ***** CONSTRUCTOR *****

    public Model() {
        int tile = View.TILE_WIDTH;
        board = new Board(Color.BLACK, new Point(2 * tile, 2 * tile));
        pentaminos = new ArrayList<>();
        Pentamino f = Pentamino.F(new Color(221, 189, 155), new Point(tile, 9 * tile));
        pentaminos.add(f);
        Pentamino i = Pentamino.I(new Color(238, 171, 172), new Point(5 * tile, 9 * tile));
        pentaminos.add(i);
        Pentamino l = Pentamino.L(new Color(205, 205, 137), new Point(8 * tile, 9 * tile));
        pentaminos.add(l);
        Pentamino n = Pentamino.N(new Color(172, 239, 172), new Point(11 * tile, 9 * tile));
        pentaminos.add(n);
        Pentamino p = Pentamino.P(new Color(188, 222, 154), new Point(14 * tile, 9 * tile));
        pentaminos.add(p);
        Pentamino t = Pentamino.T(new Color(154, 222, 189), new Point(18 * tile, 9 * tile));
        pentaminos.add(t);
        Pentamino u = Pentamino.U(new Color(137, 205, 205), new Point(tile, 15 * tile));
        pentaminos.add(u);
        Pentamino v = Pentamino.V(new Color(154, 188, 222), new Point(5 * tile, 15 * tile));
        pentaminos.add(v);
        Pentamino w = Pentamino.W(new Color(172, 172, 239), new Point(9 * tile, 15 * tile));
        pentaminos.add(w);
        Pentamino x = Pentamino.X(new Color(188, 155, 221), new Point(13 * tile, 15 * tile));
        pentaminos.add(x);
        Pentamino y = Pentamino.Y(new Color(205, 137, 205), new Point(16 * tile, 14 * tile));
        pentaminos.add(y);
        Pentamino z = Pentamino.Z(new Color(222, 154, 189), new Point(20 * tile, 15 * tile));
        pentaminos.add(z);
    }

    // ***** GETTERS *****

    public Board getBoard() {
        return board;
    }

    public ArrayList<Pentamino> getPentaminos() {
        return pentaminos;
    }

    public Pentamino getFrontPentamino() {
        return pentaminos.get(0);
    }

    // ***** METHODS *****

    public void putPentaminoAtFront(Pentamino pentamino) {
        pentaminos.remove(pentamino);
        pentaminos.add(0, pentamino);
        setChanged();
        notifyObservers();
    }

    public void translatePentamino(Vector vector) {
        getFrontPentamino().translate(vector);
        setChanged();
        notifyObservers();
    }

    public void rotateRightPentamino() {
        getFrontPentamino().rotateMatrixRight();
        setChanged();
        notifyObservers();
    }

    public void rotateLeftPentamino() {
        getFrontPentamino().rotateMatrixLeft();
        setChanged();
        notifyObservers();
    }

    public void flipPentaminoHorizontally() {
        getFrontPentamino().reverseColOrder();
        setChanged();
        notifyObservers();
    }

    public void flipPentaminoVertically() {
        getFrontPentamino().reverseRowOrder();
        setChanged();
        notifyObservers();
    }

    public void modifyBoard(int rows, int cols) {
        getBoard().setRows(rows);
        getBoard().setCols(cols);
        getBoard().resetBoard();
        setChanged();
        notifyObservers();
    }

}