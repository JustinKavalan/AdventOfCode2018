package Day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static Day3.Day3P1.parseInput;

public class Day3P2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner input = new Scanner(new File("Day3.in"));
        List<Claim> claims = parseInput(input);


        Map<Coordinate, Integer> fabric = new HashMap<>();
        for (Claim claim: claims) {
            for (int i = claim.Start.CoorX; i < claim.Start.CoorX + claim.SizeX; i++) {
                for (int j = claim.Start.CoorY; j < claim.Start.CoorY + claim.SizeY; j++) {
                    Coordinate cur = new Coordinate(i, j);
                    if (fabric.containsKey(cur)) {
                        int curValue = fabric.get(cur);
                        fabric.put(cur, curValue + 1);
                    } else {
                        fabric.put(cur, 1);
                    }
                }
            }
        }

        for (Claim claim: claims) {
            if (determineUnbroken(claim, fabric)) {
                System.out.println(claim.id);
            }
        }
    }

    public static boolean determineUnbroken(Claim claim, Map<Coordinate, Integer> fabric) {
        for (int i = claim.Start.CoorX; i < claim.Start.CoorX + claim.SizeX; i++) {
            for (int j = claim.Start.CoorY; j < claim.Start.CoorY + claim.SizeY; j++) {
                Coordinate cur = new Coordinate(i, j);
                if (fabric.get(cur) > 1) {
                    return false;
                }
                if (fabric.get(cur) == 0) {
//                    System.out.println("The hell happened at " + i + ", " + j);
                }
            }
        }

        return true;
    }
}
