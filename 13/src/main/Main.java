package main;

import cart.Cart;
import fileOperations.ReadFile;
import tracks.AllTracks;
import tracks.ITrack;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        AllTracks allTracks = ReadFile.readAllTracks();
        boolean collision = false;
        int[] collisionCoordinates = new int[2];

        /*while (!collision) {
            allTracks.getCarts().sort(Comparator.comparingInt(Cart::getY));
            for (Cart cart : allTracks.getCarts()) {
                //System.out.println(cart.getX() + " " + cart.getY());
                Optional<ITrack> pom = allTracks.getTrack(cart.getX(), cart.getY());
                pom.ifPresent(iTrack -> iTrack.moveCart(cart));
                if (checkCollision(allTracks, cart)) {
                    collision = true;
                    collisionCoordinates[0] = cart.getX();
                    collisionCoordinates[1] = cart.getY();
                    break;
                }
            }
        }
        System.out.println("1: " + collisionCoordinates[1] + "," + collisionCoordinates[0]);*/

        allTracks = ReadFile.readAllTracks();

        while (allTracks.getCarts().size() > 1) {
            allTracks.getCarts().sort(Comparator.comparingInt(Cart::getY));
            List<Cart> toRemove = new ArrayList<>();
            for (Cart cart : allTracks.getCarts()) {
                Optional<ITrack> pom = allTracks.getTrack(cart.getX(), cart.getY());
                pom.ifPresent(iTrack -> iTrack.moveCart(cart));
                if (checkCollision(allTracks, cart)) {
                    toRemove.addAll(removeCarts(allTracks, cart));
                }
            }

            allTracks.getCarts().removeAll(toRemove);
        }
        System.out.println("2: " + allTracks.getCarts().get(0).getY() + "," + allTracks.getCarts().get(0).getX());
    }

    private static boolean checkCollision(AllTracks allTracks, Cart cart) {
        int count = 0;
        for (Cart c : allTracks.getCarts()) {
            if (cart.getY() == c.getY() && cart.getX() == c.getX()) {
                count++;
            }
        }
        return count > 1;
    }

    private static List<Cart> removeCarts(AllTracks allTracks, Cart cart) {
        List<Cart> toRemove = new ArrayList<>();
        for (Cart c : allTracks.getCarts()) {
            if (cart.getY() == c.getY() && cart.getX() == c.getX()) {
                toRemove.add(c);
            }
        }
        if (toRemove.size() > 1) {
            return toRemove;
        } else {
            return new ArrayList<>();
        }
    }
}
