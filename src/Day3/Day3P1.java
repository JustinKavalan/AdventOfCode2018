package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day3P1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Day3.in"));
        List<Claim> claims = parseInput(input);

        Map<Coordinate, Integer> fabric = new HashMap<>();
        int sum = 0;
        for (Claim claim: claims) {
            for (int i = claim.Start.CoorX; i < claim.Start.CoorX + claim.SizeX; i++) {
                for (int j = claim.Start.CoorY; j < claim.Start.CoorY + claim.SizeY; j++) {
                    Coordinate cur = new Coordinate(i, j);
                    if (fabric.containsKey(cur)) {
                        int curValue = fabric.get(cur);
                        fabric.put(cur, curValue + 1);

                        if (curValue == 0) {
                            sum++;
                        }
                    } else {
                        fabric.put(cur, 0);
                    }
                }
            }
        }

        System.out.println(sum);

    }

    private static List<Claim> parseInput(Scanner input) {
        List<Claim> claims = new ArrayList<>();

        while (input.hasNext()) {
            String line = input.nextLine();
            String[] tokens = line.split("\\s+");
            // The third token should be our coordinate, in C1,C2: form

            String[] coordinates = tokens[2].replace(":", "").split(",");
            String[] size = tokens[3].split("x");

            claims.add(new Claim(Integer.parseInt(coordinates[0]),
                    Integer.parseInt(coordinates[1]),
                    Integer.parseInt(size[0]),
                    Integer.parseInt(size[1])));

        }

        return claims;
    }
}

class Coordinate {
    public int CoorX;
    public int CoorY;

    public Coordinate(int coorX, int coorY) {
        CoorX = coorX;
        CoorY = coorY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Coordinate)) return false;
        Coordinate other = (Coordinate) obj;
       return (this.CoorX == other.CoorX
                && this.CoorY == other.CoorY);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + CoorX;
        hash = 31 * hash + CoorY;
        return hash;
    }
}

class Claim {
    public Coordinate Start;
    public int SizeX;
    public int SizeY;

    public Claim(int coorX, int coorY, int sizeX, int sizeY) {
        Start = new Coordinate(coorX, coorY);
        SizeX = sizeX;
        SizeY = sizeY;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Claim)) return false;
        Claim other = (Claim) obj;
        if (this.Start == other.Start
                && this.SizeX == other.SizeX
                && this.SizeY == other.SizeY) {

            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Start.hashCode();
        hash = 31 * hash + SizeX;
        hash = 31 * hash + SizeY;
        return hash;
    }
}