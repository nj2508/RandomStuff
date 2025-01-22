import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Main class. Whole file generates a map similar to dungeons using an algorithm that fills in
 * zones with randomly selected rooms.
 */
public class MapGen {
    Unit[][] map = new Unit[5][5]; // 5 chunks x 5 chunks
    ArrayList<Room> rooms = new ArrayList<>();

    /**
     * Create a bunch of rooms and then generate a map
     * @param args passed by java i think??
     */
    public static void main(String[] args) {

    }
}

/**
 * References a zone of a designated size with entrances and exits at defined points.
 * For example, a 1x1 room with doors at the left and right. Gets rotated in one of four ways
 * to match the need of the map when generating.
 */
class Room {
    public final Unit[][] map;
    /*
     * Starts at top left, so 1x1 is:
     * T
     * L is:
     * TF
     * TT
     */
    public final String name;

    /**
     * Constructor for a Room
     * @param map Size of room (i.e. 2x2, 4x1). Can have an empty slot in top-right, indicating L room.
     * @param name Name of room (one letter, one number)
     */
    public Room(Unit[][] map, String name) {
        this.map = map;
        this.name = name;
    }
    public List<Integer> getDimensions() {
        return Arrays.asList(map.length, map[0].length);
    }
    public Unit[][] getMap() {
        return map;
    }
}
/**
 * Generate a dungeon map by taking a 2d array and pathing from start to midpoint to end with randomly
 * selected rooms. Once the initial path is made, expand outwards from there via the doors on each
 * randomly selected room.
 */
class Generator {
    /*
     * Get spawn, blood, fairy, generate random path from spawn to fairy and then from fairy to blood.
     * Get doors of each room and then expand from there
     */
    Unit[][] map;
    Pair spawn;
    Pair blood;
    Pair fairy;
    List<Room> rooms;
    public Generator(Unit[][] map, Pair spawn, Pair blood, Pair fairy, List<Room> rooms) {
        this.map = map;
        this.spawn = spawn;
        this.blood = blood;
        this.fairy = fairy;
        this.rooms = rooms;
    }
    public void genMainLine() {
        map[spawn.a][spawn.b] = rooms.get(0).map[0][0];
    }
//    public Room getRandomRoom() {
//
//    }

    /**
     * Gets the dimensions between in a square
     * @param startPos position to start at
     * @param endPos position to end at
     * @return map with available spaces
     */
//    public Unit[][] getDistance(Pair startPos, Pair endPos) {
//
//    }
}

/**
 * Represents the dimensions of a room.
 */
enum RoomSize {
    TWO_TWO(2, 2),
    FOUR_ONE(4, 1),
    THREE_ONE(3, 1),
    TWO_ONE(2, 1),
    ONE_ONE(1, 1),
    L(2, 2);
    public final int x;
    public final int y;
    private RoomSize(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Pair {
    int a;
    int b;
    public Pair(int a, int b) {
        a = a;
        b = b;
    }
}

/**
 * One unit = one slot on a map. Derived from a parent room.
 */
class Unit {
    Room parent;
}