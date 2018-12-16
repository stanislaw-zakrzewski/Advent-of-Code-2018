package fileOperations;

import board.Board;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class ReadFile {
    public static Board readBoard() {
        Board board = null;

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("input.txt")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return board;
    }
}
