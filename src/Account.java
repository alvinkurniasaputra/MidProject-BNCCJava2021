public class Account {
    private final String username;
    private final String fullName;
    private final String email;
    private final String password;
    private int money;
    private int structId;

    public Account(String username, String fullName, String email, String password, int money) {
        this.username = username;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.money = money;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money += money;
    }

    public int getStructId() {
        return structId;
    }

    public void setStructId() {
        this.structId++;
    }

}
