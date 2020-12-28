import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MatrixAndWordTest {
    private static MatrixAndWord matrixAndWord;

    @BeforeAll
    public static void beforeAll() {
        matrixAndWord = new MatrixAndWord();
    }

    @Test
    public void checkMatrix_notOk() {
        assertThrows(RuntimeException.class, () ->
                matrixAndWord.getCoordinate("HEDYHRWF", "RED"));
        assertThrows(RuntimeException.class, () ->
                matrixAndWord.getCoordinate("HEDHYHRWF", "RED"));
        assertThrows(RuntimeException.class, () ->
                matrixAndWord.getCoordinate("HEgjYtRjF", ""));
        assertThrows(RuntimeException.class, () ->
                matrixAndWord.getCoordinate("EQBNEeASg", "ANANAS"));
    }

    @Test
    public void checkWords_Ok() {
        assertEquals("[0,2]", matrixAndWord.getCoordinate("QGDREGVDG", "D"));
        assertEquals("[0,2]->[1,2]", matrixAndWord.getCoordinate("EQBGEeABg", "BE"));
        assertEquals("[1,0]->[1,1]->[2,1]", matrixAndWord.getCoordinate("QGDREGVDG", "RED"));
        assertEquals("[1,2]->[1,3]->[0,3]->[0,2]",
                matrixAndWord.getCoordinate("QLGNAEKIRLRNGEAE", "KING"));
        assertEquals("[0,0]->[1,0]->[1,1]->[2,1]->[2,2]",
                matrixAndWord.getCoordinate("GYNOERENIGHEDjtGURNWLDJVI", "GReED"));
        assertEquals("[2,2]->[2,1]->[3,1]->[4,1]->[4,2]",
                matrixAndWord.getCoordinate("NFRKFNNAFKARFRNKAKAKNNKKF", "Frank"));
        assertEquals("[1,1]->[1,2]->[2,2]->[2,1]->[2,0]",
                matrixAndWord.getCoordinate("UKJVXNAPBXELPLHVNLDKBVVNM", "APPLE"));
        assertEquals("[0,2]->[1,2]->[2,2]->[2,3]->[2,4]->[3,4]->[4,4]->"
                        + "[5,4]->[5,3]->[5,2]->[5,1]->[4,1]->[4,0]->[5,0]",
                matrixAndWord.getCoordinate("FBDHBAAGNITISTDASABIDDBITILBNILALASGTATIGIYGNTGND",
                        "DISABILITATING"));
    }

    @Test
    public void checkForRepeat_Ok() {
        assertEquals("[2,3]->[2,2]->[2,1]->[1,1]->[0,1]->[0,0]",
                matrixAndWord.getCoordinate("SATURYNFLKGANADEYJNJJLLAD", "ANANAS"));
    }

    @Test
    public void checkPalindrome_Ok() {
        assertEquals("[0,2]->[0,3]->[1,3]->[2,3]->[2,2]->[2,1]->[3,1]",
                matrixAndWord.getCoordinate("HXROZBDZTZNOTAGhRuhBNDJMM", "ROTATOR"));
    }
}
