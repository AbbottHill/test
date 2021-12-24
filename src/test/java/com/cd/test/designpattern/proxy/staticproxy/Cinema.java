package com.cd.test.designpattern.proxy.staticproxy;

public class Cinema implements Movie {

    private Movie movie;

    public Cinema(Movie movie) {
        this.movie = movie;
    }

    @Override
    public void play() {
        advertise(true);
        movie.play();
        advertise(false);
    }

    private void advertise(boolean start) {
        if (start) {
            System.out.println("买爆米花，边吃边看");
        } else {
            System.out.println("买爆米花，带回家吃");
        }
    }

    public static void main(String[] args) {
        Cinema cinema = new Cinema(new RealMovie());
        cinema.play();
    }

}
