package com.gtalent.jdbc_mysql.model;

public class Tutorial { // 靠這個class把物件轉換成MYSQL欄位

    private long id; //id 這個變數淺規則類型都用long
    private String title;
    private String description;
    private boolean published;

    public Tutorial(){
        //Java會自動做
    }
    // MYSQL 指令:
    // CREATE TABLE tutorials (
    //      id BIGINT AUTO_INCREMENT PRIMARY KEY,
    //      title VARCHAR(255) NOT NULL,
    //      description TEXT,
    //      published BOOLEAN NOT NULL
    // )
    public Tutorial(long id, String title, String description, boolean published){
        this.id = id;
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public Tutorial(String title, String description, boolean published) {
        this.title = title;
        this.description = description;
        this.published = published;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    @Override
    public String toString() {
        return "Tutorial{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", published=" + published +
                '}';
    }
}
