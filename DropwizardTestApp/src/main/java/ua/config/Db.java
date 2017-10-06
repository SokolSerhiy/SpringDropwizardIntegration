package ua.config;

public class Db {

    private String url;

    private String pass;

    private String user;

    private String className;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "Db{" +
                "url='" + url + '\'' +
                ", pass='" + pass + '\'' +
                ", user='" + user + '\'' +
                ", className='" + className + '\'' +
                '}';
    }
}
