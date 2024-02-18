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
    private final Pentamino F, I, L, N, P, T, U, V, W, X, Y, Z;

    // ***** CONSTRUCTOR *****

    public Model() {
        board = new Board(Color.BLACK, new Point(50, 50));
        pentaminos = new ArrayList<>();
        F = Pentamino.F(new Color(221, 189, 155), new Point(50, 350));
        pentaminos.add(F);
        I = Pentamino.I(new Color(238, 171, 172), new Point(250, 350));
        pentaminos.add(I);
        L = Pentamino.L(new Color(205, 205, 137), new Point(450, 350));
        pentaminos.add(L);
        N = Pentamino.N(new Color(172, 239, 172), new Point(550, 350));
        pentaminos.add(N);
        P = Pentamino.P(new Color(188, 222, 154), new Point(700, 350));
        pentaminos.add(P);
        T = Pentamino.T(new Color(154, 222, 189), new Point(900, 350));
        pentaminos.add(T);
        U = Pentamino.U(new Color(137, 205, 205), new Point(50, 650));
        pentaminos.add(U);
        V = Pentamino.V(new Color(154, 188, 222), new Point(250, 650));
        pentaminos.add(V);
        W = Pentamino.W(new Color(172, 172, 239), new Point(450, 650));
        pentaminos.add(W);
        X = Pentamino.X(new Color(188, 155, 221), new Point(650, 650));
        pentaminos.add(X);
        Y = Pentamino.Y(new Color(205, 137, 205), new Point(800, 600));
        pentaminos.add(Y);
        Z = Pentamino.Z(new Color(222, 154, 189), new Point(1000, 650));
        pentaminos.add(Z);
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

    public void flipPentamino() {
        getFrontPentamino().reverseColOrder();
        setChanged();
        notifyObservers();
    }

}