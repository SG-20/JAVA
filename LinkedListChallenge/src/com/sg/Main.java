package com.sg;

import java.util.*;

public class Main {

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {
        Album album = new Album("Swimming", "Mac Miller");
        album.addSong("Come back to earth", 5);
        album.addSong("Hurt feelings", 6);
        album.addSong("What's the use?", 3);
        album.addSong("Perfecto", 4);
        album.addSong("Self care", 3.30);
        album.addSong("", 2);
        album.addSong("", 2.30);
        album.addSong("", 3);
        albums.add(album);

        album = new Album("Thank U, Next", "Ariana Grande");
        album.addSong("Imagine", 5);
        album.addSong("Neddy", 5.30);
        album.addSong("NASA", 3);
        album.addSong("Bloodline", 3);
        album.addSong("Fake smile", 2.40);
        album.addSong("Bad idea", 2.35);
        albums.add(album);

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("Perfecto", playList);
        albums.get(0).addToPlayList("Holy man", playList); //Does not exist
        albums.get(0).addToPlayList(3, playList);
        albums.get(1).addToPlayList(4, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24

        play(playList);
    }

    private static void play(LinkedList<Song> playList) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;

        ListIterator<Song> listIterator = playList.listIterator();
        if (playList.size() == 0) {
            System.out.println("No songs in playlist");
        } else {
            System.out.println("Now playing - " + listIterator.next().toString());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Playlist complete");
                    quit = true;
                    break;
                case 1:
                    if (!forward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        forward = true;
                    }

                    if (listIterator.hasNext()) {
                        System.out.println("Now playing - " + listIterator.next().toString());
                    } else {
                        System.out.println("We have reached the end of the playlist");
                        forward = false;
                    }
                    break;
                case 2:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        forward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now playing - " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        forward = true;
                    }
                    break;
                case 3:
                    if (forward) {
                        if (listIterator.hasPrevious()) {
                            System.out.println("Now replaying - " + listIterator.previous().toString());
                            forward = false;
                        } else {
                            System.out.println("We are at the start of the list");
                        }
                    } else {
                        if (listIterator.hasNext()) {
                            System.out.println("Now replaying - " + listIterator.next().toString());
                            forward = true;
                        } else {
                            System.out.println("We have reached the end of the list");
                        }
                    }
                    break;
                case 4:
                    printList(playList);
                    break;
                case 5:
                    printMenu();
                    break;
                case 6:
                    if (playList.size() > 0) {
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            System.out.println("Now playing - " + listIterator.next());
                        } else if (listIterator.hasPrevious()) {
                            System.out.println("Now playing - " + listIterator.previous());
                        }
                    }
                    break;
            }
        }
    }

    private static void printMenu() {
        System.out.println("Available actions:\npress");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - list songs in the playlist\n" +
                "5 - print available actions\n" +
                "6 - delete current song from the playlist\n");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("==========================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("===========================");
    }


}
