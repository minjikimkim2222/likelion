package org.day24.실습코드.영화_평가_시스템;

import java.util.*;
class Movie implements Comparable<Movie>{ // Comparable 자료형 - Movie 클래스에 정의된 compareTo로 정렬됨!
    private String movieTitle; // 제목
    private int year; // 출시 연도
    private double rate; // 평점

    public Movie(String movieTitle, int year, double rate) {
        this.movieTitle = movieTitle;
        this.year = year;
        this.rate = rate;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getYear() {
        return year;
    }

    public double getRate() {
        return rate;
    }

    @Override
    public int compareTo(Movie o) {
        return this.movieTitle.compareTo(o.getMovieTitle());
    }

    @Override
    public String toString() {
        return "movie title : " + this.movieTitle + ", year : " + this.year + ", rate : " + rate;
    }
}

// Comparator 인터페이스 구현
class sortByRate implements Comparator<Movie>{
    @Override
    public int compare(Movie o1, Movie o2) { // double인 평점 기준 정렬
//        if (o1.getRate() > o2.getRate())
//            return 1;
//        else if (o1.getRate() < o2.getRate())
//            return -1;
//        else
//            return 0;
        return Double.compare(o1.getRate(), o2.getRate());
    }
}

class sortByYear implements Comparator<Movie>{
    public int compare(Movie o1, Movie o2) { // double인 평점 기준 정렬
        return o1.getYear() - o2.getYear();
    }
}

public class MovieManager {
    public static void main(String[] args) {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie("The Shawshank Redemption", 1994, 9.3));
        movies.add(new Movie("The Godfather", 1972, 9.2));
        movies.add(new Movie("The Dark Knight", 2008, 9.0));

        // 제목 기준 정렬 (Comparable)
        Collections.sort(movies);
        System.out.println("Sorted by title:");
        movies.forEach(System.out::println);

        // 평점 기준 정렬 (Comparator)
        Collections.sort(movies, new sortByRate());
        System.out.println("Sorted by rating:");
        movies.forEach(System.out::println);

        // 출시 연도 기준 정렬 (Comparator)
        Collections.sort(movies, new sortByYear());
        System.out.println("Sorted by release year:");
        movies.forEach(System.out::println);
    }
}
