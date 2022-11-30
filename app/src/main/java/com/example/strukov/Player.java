package com.example.strukov;

class Player {
    private String login;
    private int id;

    public Player(String login, int id, String node_id, String type, Boolean site_admin) {
        this.login = login;
        this.id = id;
        this.node_id = node_id;
        this.type = type;
        this.site_admin = site_admin;
    }

    private String node_id;
    private String type;
    private Boolean site_admin;

    public Boolean getSite_admin() {
        return site_admin;
    }

    public void setSite_admin(Boolean site_admin) {
        this.site_admin = site_admin;
    }

    public Player(String login, int id, String node_id, String type, boolean site_admin) {
        this.login = login;
        this.id = id;
        this.node_id = node_id;
        this.type = type;
        this.site_admin = site_admin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNode_id() {
        return node_id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
