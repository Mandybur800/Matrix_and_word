import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class MatrixAndWordTest {
    @Test
    public void checkMatrix_notOk() {
        assertThrows(RuntimeException.class, () ->
                MatrixAndWord.getCoordinate("HEDYHRWF", "RED"));
        assertThrows(RuntimeException.class, () ->
                MatrixAndWord.getCoordinate("HEDHYHRWF", "RED"));
        assertThrows(RuntimeException.class, () ->
                MatrixAndWord.getCoordinate("HEgjYtRjF", ""));
        assertThrows(RuntimeException.class, () ->
                MatrixAndWord.getCoordinate("EQBNEeASg", "ANANAS"));
    }

    @Test
    public void checkWords_Ok() {
        assertEquals("[0,2]", MatrixAndWord.getCoordinate("QGDREGVDG", "D"));
        assertEquals("[0,2]->[1,2]", MatrixAndWord.getCoordinate("EQBGEeABg", "BE"));
        assertEquals("[1,0]->[1,1]->[2,1]", MatrixAndWord.getCoordinate("QGDREGVDG", "RED"));
        assertEquals("[1,2]->[1,3]->[0,3]->[0,2]",
                MatrixAndWord.getCoordinate("QLGNAEKIRLRNGEAE", "KING"));
        assertEquals("[0,0]->[1,0]->[1,1]->[2,1]->[2,2]",
                MatrixAndWord.getCoordinate("GYNOERENIGHEDjtGURNWLDJVI", "GReED"));
        assertEquals("[2,2]->[2,1]->[3,1]->[4,1]->[4,2]",
                MatrixAndWord.getCoordinate("NFRKFNNAFKARFRNKAKAKNNKKF", "Frank"));
        assertEquals("[1,1]->[1,2]->[2,2]->[2,1]->[2,0]",
                MatrixAndWord.getCoordinate("UKJVXNAPBXELPLHVNLDKBVVNM", "APPLE"));
        assertEquals("[0,2]->[1,2]->[2,2]->[2,3]->[2,4]->[3,4]->[4,4]->"
                        + "[5,4]->[5,3]->[5,2]->[5,1]->[4,1]->[4,0]->[5,0]",
                MatrixAndWord.getCoordinate("FBDHBAAGNITISTDASABIDDBITILBNILALASGTATIGIYGNTGND",
                        "DISABILITATING"));
    }

    @Test
    public void checkForRepeat_Ok() {
        assertEquals("[2,3]->[2,2]->[2,1]->[1,1]->[0,1]->[0,0]",
                MatrixAndWord.getCoordinate("SATURYNFLKGANADEYJNJJLLAD", "ANANAS"));
    }

    @Test
    public void checkPalindrome_Ok() {
        assertEquals("[0,2]->[0,3]->[1,3]->[2,3]->[2,2]->[2,1]->[3,1]",
                MatrixAndWord.getCoordinate("HXROZBDZTZNOTAGhRuhBNDJMM", "ROTATOR"));
    }
}
