package assignment;

import java.util.HashMap;
import java.util.Map;

public class MapController extends GameMap {
    private Map<String, Node> nodeMap;

    public MapController(String filePath) {
        super(filePath);
        this.nodeMap = new HashMap<>();
    }

    public Boolean isRock(String point) {
        return "0".equalsIgnoreCase(point);
    }

    public Boolean isStart(String point) {
        return "S".equalsIgnoreCase(point);
    }

    public Boolean isFinish(String point) {
        return "F".equalsIgnoreCase(point);
    }

    public Boolean checkPleyerPointFree(String playerPoint) {
        return ".".equalsIgnoreCase(playerPoint);
    }

    public void printmap() {
        System.out.println("\t------------------Map----------------\n\n");
        String[][] array = super.mapArray;
        for (String[] strings : array) {
            for (String string : strings) {
                System.out.print("\t" + string);
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    public Map<String, Node> createMapNodeList() {
        super.readMap();
        int colCount = super.map.size();
        int rowCount = 0;
        if (colCount > 0) {
            rowCount = super.map.get(0).size();
        }

        createMapArray(rowCount,colCount);

        for (int y = 0; y < colCount; y++) {
            for (int x = 0; x < rowCount; x++) {
                String point = mapArray[y][x];
                //
                if ((y == 0 || y == colCount - 1) && checkPleyerPointFree(point)) {

                    nodeMap.put(x + "," + y, new Node(x, y));
                } else if ((x == 0 || x == rowCount - 1) && checkPleyerPointFree(point)) {

                    nodeMap.put(x + "," + y, new Node(x, y));
                }


                if (isStart(point)) {
                    nodeMap.put("Start", new Node(x, y, "Start"));

                } else if (isFinish(point)) {
                    nodeMap.put("Finish", new Node(x, y, "Finish"));

                } else if (isRock(point)) {


                    //up
                    if (y - 1 >= 0 && checkPleyerPointFree(mapArray[y - 1][x])) {
                        nodeMap.put(x + "," + (y - 1), new Node(x, y - 1));
                    }
                    //down
                    if (y + 1 < colCount && checkPleyerPointFree(mapArray[y + 1][x])) {
                        nodeMap.put(x + "," + (y + 1), new Node(x, y + 1));
                    }
                    //left
                    if (x - 1 >= 0 && checkPleyerPointFree(mapArray[y][x - 1])) {
                        nodeMap.put((x - 1) + "," + y, new Node(x - 1, y));
                    }
                    //right
                    if (x + 1 < rowCount && checkPleyerPointFree(mapArray[y][x + 1])) {
                        nodeMap.put((x + 1) + "," + y, new Node(x + 1, y));
                    }
                }
            }
        }

        for (String key : nodeMap.keySet()) {
            Node node = nodeMap.get(key);
            //up
            if (node.getY() > 0) {
                int y = node.getY();
                int len = 0;
                while (y > 0) {
                    y--;
                    if (isStart(mapArray[y][node.getX()])) {
                        break;
                    } else if (checkPleyerPointFree(mapArray[y][node.getX()])) {
                        len++;
                        if (y == 0) {
                            node.setUpKey(node.getX() + "," + y);
                            node.setUpLen(len);
                            nodeMap.put(key, node);
                            break;
                        }
                    } else if (isFinish(mapArray[y][node.getX()])) {
                        len++;
                        node.setUpKey("Finish");
                        node.setUpLen(len);
                        nodeMap.put(key, node);
                        break;
                    } else {
                        if (y + 1 != node.getY()) {
                            node.setUpKey(node.getX() + "," + (y + 1));
                            node.setUpLen(len);
                            nodeMap.put(key, node);
                        }
                        break;
                    }
                }
            }
            //down
            if (node.getY() < colCount - 1) {
                int y = node.getY();
                int len = 0;
                while (y < colCount - 1) {
                    y++;

                    if (isStart(mapArray[y][node.getX()])) {
                        break;
                    } else if (checkPleyerPointFree(mapArray[y][node.getX()])) {
                        len++;
                        if (y == colCount - 1) {
                            node.setDownKey(node.getX() + "," + y);
                            node.setDownLen(len);
                            nodeMap.put(key, node);
                            break;
                        }
                    } else if (isFinish(mapArray[y][node.getX()])) {
                        len++;
                        node.setDownKey("Finish");
                        node.setDownLen(len);
                        nodeMap.put(key, node);
                        break;
                    } else {

                        if (y - 1 != node.getY()) {
                            node.setDownKey(node.getX() + "," + (y - 1));
                            node.setDownLen(len);
                            nodeMap.put(key, node);
                        }
                        break;
                    }
                }
            }

            //left
            if (node.getX() > 0) {
                int x = node.getX();
                int len = 0;
                while (x > 0) {
                    x--;
                    if (isStart(mapArray[node.getY()][x])) {
                        break;
                    }
                    if (checkPleyerPointFree(mapArray[node.getY()][x])) {
                        len++;
                        if (x == 0) {
                            node.setLeftKey(x + "," + node.getY());
                            node.setLeftLen(len);
                            nodeMap.put(key, node);
                            break;
                        }
                    } else if (isFinish(mapArray[node.getY()][x])) {
                        len++;
                        node.setLeftKey("Finish");
                        node.setLeftLen(len);
                        nodeMap.put(key, node);
                        break;
                    } else {
                        if (x + 1 != node.getX()) {
                            node.setLeftKey((x + 1) + "," + node.getY());
                            node.setLeftLen(len);
                            nodeMap.put(key, node);
                        }
                        break;
                    }
                }
            }

            //right
            if (node.getX() < rowCount - 1) {
                int x = node.getX();
                int len = 0;

                while (x < rowCount - 1) {
                    x++;

                    if (isStart(mapArray[node.getY()][x])) {
                        break;
                    }
                    if (checkPleyerPointFree(mapArray[node.getY()][x])) {
                        len++;

                        if (x == rowCount - 1) {

                            node.setRightKey(x + "," + node.getY());
                            node.setRightLen(len);
                            nodeMap.put(key, node);
                            break;
                        }
                    } else if (isFinish(mapArray[node.getY()][x])) {
                        len++;
                        node.setRightKey("Finish");
                        node.setRightLen(len);
                        nodeMap.put(key, node);
                        break;
                    } else {
                        if (x - 1 != node.getX()) {
                            node.setRightKey((x - 1) + "," + node.getY());
                            node.setRightLen(len);
                            nodeMap.put(key, node);
                        }
                        break;
                    }
                }
            }
        }
        return nodeMap;
    }
}
