/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment;


import java.util.List;

/**
 * @author Sachin Kumara
 */
public class Assignment {

    public static void run(String file){
        MapController mapController = new MapController(file);
        GraphController graphController = new GraphController();
        List<String> step = graphController.getShortestPath(mapController.createMapNodeList());
        mapController.printmap();

        for (String s : step) {
            System.out.println(s);
        }
    }


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       String []files={"maze10_1.txt","maze10_2.txt","maze10_3.txt","maze10_4.txt","maze10_5.txt","maze15_1.txt",
               "maze15_2.txt","maze15_3.txt","maze15_4.txt","maze15_5.txt","maze20_1.txt","maze20_2.txt","maze20_3.txt","maze20_4.txt","maze20_5.txt",
               "maze25_1.txt","maze25_2.txt","maze25_3.txt","maze25_4.txt","maze25_5.txt","maze30_1.txt","maze30_2.txt","maze30_3.txt","maze30_4.txt",
               "maze30_5.txt","puzzle_160.txt","puzzle_20.txt","puzzle_320.txt","puzzle_40.txt","puzzle_640.txt","puzzle_80.txt"};
        for (String file: files) {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+file+"@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
            try{
                Assignment.run("examples/"+file);
            }catch (Exception e){
                e.printStackTrace();
            }
            ;
        }
//        Assignment.run("examples/maze10_1.txt");



    }


}
    
