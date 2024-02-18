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
        board = new Board(Color.BLACK, new Point(50, 50));
        pentaminos = new ArrayList<>();
        Pentamino f = Pentamino.F(new Color(221, 189, 155), new Point(50, 400));
        pentaminos.add(f);
        Pentamino i = Pentamino.I(new Color(238, 171, 172), new Point(250, 400));
        pentaminos.add(i);
        Pentamino l = Pentamino.L(new Color(205, 205, 137), new Point(400, 400));
        pentaminos.add(l);
        Pentamino n = Pentamino.N(new Color(172, 239, 172), new Point(550, 400));
        pentaminos.add(n);
        Pentamino p = Pentamino.P(new Color(188, 222, 154), new Point(700, 400));
        pentaminos.add(p);
        Pentamino t = Pentamino.T(new Color(154, 222, 189), new Point(900, 400));
        pentaminos.add(t);
        Pentamino u = Pentamino.U(new Color(137, 205, 205), new Point(50, 700));
        pentaminos.add(u);
        Pentamino v = Pentamino.V(new Color(154, 188, 222), new Point(250, 700));
        pentaminos.add(v);
        Pentamino w = Pentamino.W(new Color(172, 172, 239), new Point(450, 700));
        pentaminos.add(w);
        Pentamino x = Pentamino.X(new Color(188, 155, 221), new Point(650, 700));
        pentaminos.add(x);
        Pentamino y = Pentamino.Y(new Color(205, 137, 205), new Point(800, 650));
        pentaminos.add(y);
        Pentamino z = Pentamino.Z(new Color(222, 154, 189), new Point(1000, 700));
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