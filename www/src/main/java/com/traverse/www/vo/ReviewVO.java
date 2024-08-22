package com.traverse.www.vo;

public class ReviewVO {
    private int drep_idx;
    private int a_idx;
    private int p_idx;
    private String contents;
    private int rating;
    private String w_date;
    private String nick; // 닉네임 추가

    // Getters and Setters
    public int getDrep_idx() {
        return drep_idx;
    }

    public void setDrep_idx(int drep_idx) {
        this.drep_idx = drep_idx;
    }

    public int getA_idx() {
        return a_idx;
    }

    public void setA_idx(int a_idx) {
        this.a_idx = a_idx;
    }

    public int getP_idx() {
        return p_idx;
    }

    public void setP_idx(int p_idx) {
        this.p_idx = p_idx;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getW_date() {
        return w_date;
    }

    public void setW_date(String w_date) {
        this.w_date = w_date;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }
}
