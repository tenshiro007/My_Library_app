package com.example.p003_mylibraly;

public class Book {
    private int id;
    private String name;
    private String author;
    private String imageUrl;
    private String shortDes;
    private String longDes;
    private boolean isExpand;

    public Book(int id, String name, String author, String imageUrl, String shortDes, String longDes, boolean isExpand) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.shortDes = shortDes;
        this.longDes = longDes;
        this.isExpand = isExpand;
    }

    public Book(int id, String name, String author, String imageUrl, String shortDes, String longDes) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.imageUrl = imageUrl;
        this.shortDes = shortDes;
        this.longDes = longDes;
    }

    public boolean isExpand() {
        return isExpand;
    }

    public void setExpand(boolean expand) {
        isExpand = expand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getShortDes() {
        return shortDes;
    }

    public void setShortDes(String shortDes) {
        this.shortDes = shortDes;
    }

    public String getLongDes() {
        return longDes;
    }

    public void setLongDes(String longDes) {
        this.longDes = longDes;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", shortDes='" + shortDes + '\'' +
                ", longDes='" + longDes + '\'' +
                '}';
    }
}
