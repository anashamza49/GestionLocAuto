package rentCar;


public abstract class User {
	
    protected int id_user;
    protected String login;
    protected String password;

    public User(int id_user, String login, String password) {
    	
        this.id_user = id_user;
        this.login = login;
        this.password = password;
    
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_user() {
        return id_user;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getLogin() {
        return login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void seConnecter() {

    }

    public void seDeconnecter() {
    }
}
