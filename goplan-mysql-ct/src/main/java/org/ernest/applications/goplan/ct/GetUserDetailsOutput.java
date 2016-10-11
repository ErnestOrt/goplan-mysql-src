package org.ernest.applications.goplan.ct;


public class GetUserDetailsOutput {

    private String description;
    private int eat;
    private int drink;
    private int party;
    private int sleep;
    private int work;
    private int mature;
    private int sport;
    private int movies;
    private int spirituality;
    private int travel;
    private int freak;
    private int animals;

    public GetUserDetailsOutput() {}

    public GetUserDetailsOutput(String description, int eat, int drink, int party, int sleep, int work, int mature, int sport, int movies, int spirituality, int travel, int freak, int animals) {
        this.description = description;
        this.eat = eat;
        this.drink = drink;
        this.party = party;
        this.sleep = sleep;
        this.work = work;
        this.mature = mature;
        this.sport = sport;
        this.movies = movies;
        this.spirituality = spirituality;
        this.travel = travel;
        this.freak = freak;
        this.animals = animals;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEat() {
        return eat;
    }

    public void setEat(int eat) {
        this.eat = eat;
    }

    public int getDrink() {
        return drink;
    }

    public void setDrink(int drink) {
        this.drink = drink;
    }

    public int getParty() {
        return party;
    }

    public void setParty(int party) {
        this.party = party;
    }

    public int getSleep() {
        return sleep;
    }

    public void setSleep(int sleep) {
        this.sleep = sleep;
    }

    public int getWork() {
        return work;
    }

    public void setWork(int work) {
        this.work = work;
    }

    public int getMature() {
        return mature;
    }

    public void setMature(int mature) {
        this.mature = mature;
    }

    public int getSport() {
        return sport;
    }

    public void setSport(int sport) {
        this.sport = sport;
    }

    public int getMovies() {
        return movies;
    }

    public void setMovies(int movies) {
        this.movies = movies;
    }

    public int getSpirituality() {
        return spirituality;
    }

    public void setSpirituality(int spirituality) {
        this.spirituality = spirituality;
    }

    public int getTravel() {
        return travel;
    }

    public void setTravel(int travel) {
        this.travel = travel;
    }

    public int getFreak() {
        return freak;
    }

    public void setFreak(int freak) {
        this.freak = freak;
    }

    public int getAnimals() {
        return animals;
    }

    public void setAnimals(int animals) {
        this.animals = animals;
    }
}