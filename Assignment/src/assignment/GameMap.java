package assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GameMap {

    private String filePath;
    protected  String [][]mapArray;
    protected List <List<String>> map;

    public GameMap(String filePath) {
        this.filePath= filePath;
        this.map= new ArrayList<>();
    }

    public void readMap(){
        try {
            File myObj = new File(filePath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                List<String> strings = new ArrayList<>();
                for(int i=0;i<data.length();i++){
                    strings.add(String.valueOf(data.charAt(i)));
                }
                this.map.add(strings);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }


    }

    public void createMapArray(int rowCount,int colCount){
        mapArray = new String[colCount][rowCount];
        for (int i = 0; i < colCount; i++) {
            mapArray[i] = map.get(i).toArray(String[]::new);
        }
    }
}
