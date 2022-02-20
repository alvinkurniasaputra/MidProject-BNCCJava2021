import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    Scanner scan = new Scanner(System.in);
    ArrayList<Account> accList = new ArrayList<>();
    ArrayList<Product> List = new ArrayList<>();
    ArrayList<Product> buyList = new ArrayList<>();

    public Main() {
        Account admin = new Account("admin", "", "", "admin123", 0);
        accList.add(admin);
        Food newFood = new Food("Susu milo [F]", 8800, "22 Desember 2022");
        List.add(newFood);
        Cloth newCloth = new Cloth("Jaket anime [C]", 187500, "XL");
        List.add(newCloth);
        Technology newTech = new Technology("Headset Logitech [T]", 780000, "G231 Prodigy");
        List.add(newTech);
        while (true) {
            System.out.println("1. Login ");
            System.out.println("2. Register ");
            System.out.println("3. Exit ");
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 3) {
                break;
            }
            switch (choice) {
                case 1:
                    clearConsole();
                    login();
                    break;
                case 2:
                    clearConsole();
                    register();
                    break;
                default:
                    System.out.print("Pilihan tidak tersedia!");
                    scan.nextLine();
                    clearConsole();
            }
        }
    }

    void login() {
        while (true) {
            int test = 0;
            System.out.println(">>> Login <<<");
            System.out.print("Username: ");
            String username = scan.nextLine();
            System.out.print("Password: ");
            String password = scan.nextLine();

            for (Account acc : accList) {
                if (username.equals(acc.getUsername())) {
                    test = 1;
                    if (password.equals(acc.getPassword())) {
                        clearConsole();
                        System.out.println("Login successful!");
                        if (username.equals("admin") && password.equals("admin123")) {
                            menuAdmin();
                            return;
                        }
                        menu();
                        return;
                    }
                }
            }
            if (test == 0) {
                System.out.println("Username not found!");
            } else {
                System.out.println("Incorrect password!");
            }
            while (true) {
                System.out.println("1. Try again");
                System.out.println("2. Back");
                System.out.print(">> ");
                test = scan.nextInt();
                if (test < 1 || test > 2) {
                    clearConsole();
                    System.out.println("Pilihan tidak tersedia!");
                } else {
                    break;
                }
            }
            if (test == 2) {
                clearConsole();
                break;
            }
            scan.nextLine();
            clearConsole();
        }
    }

    void register() {
        String username;
        String fullname;
        String email;
        String password;
        System.out.println(">>> Register <<<");
        do {
            System.out.print("Username: ");
            username = scan.nextLine();
        } while (username.length() < 3 || username.length() > 16);
        do {
            System.out.print("Nama panjang: ");
            fullname = scan.nextLine();
        } while (fullname.length() < 3 || fullname.length() > 16 || !fullname.matches(".*[a-zA-Z0-9].*"));
        do {
            System.out.print("Email address: ");
            email = scan.nextLine();
        } while (email.length() < 5 || email.length() > 30 || !email.contains("@") || !(email.endsWith(".com") || email.endsWith(".net")));
        do {
            System.out.print("Password: ");
            password = scan.nextLine();
        } while (password.length() < 8 || password.length() > 40 || !password.matches(".*[a-zA-Z].*") || !password.matches(".*[0-9].*"));

        Account newAcc = new Account(username, fullname, email, password, 1000);
        accList.add(newAcc);
        clearConsole();
    }

    void menuAdmin() {
        while (true) {
            System.out.println(">>> Tambah Produk <<<");
            System.out.println("1. Makanan");
            System.out.println("2. Pakaian");
            System.out.println("3. Teknologi");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();
            clearConsole();
            switch (choice) {
                case 1:
                    addFood();
                    break;
                case 2:
                    addCloth();
                    break;
                case 3:
                    addTech();
                    break;
                case 4:
                    return;
                case 5:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        }
    }

    void addFood() {
        String nama;
        int harga;
        String tanggal;
        do {
            System.out.print("Nama produk: ");
            nama = scan.nextLine();
        } while (nama.length() > 16 || !nama.endsWith(" [F]"));
        do {
            System.out.print("Harga produk: ");
            harga = scan.nextInt();
        } while (harga < 1000);
        harga += harga / 10;
        scan.nextLine();
        System.out.print("Tanggal kadaluarsa: ");
        tanggal = scan.nextLine();
        Food newFood = new Food(nama, harga, tanggal);
        List.add(newFood);
        clearConsole();
    }

    void addCloth() {
        String nama;
        int harga;
        String size;
        do {
            System.out.print("Nama produk: ");
            nama = scan.nextLine();
        } while (nama.length() > 16 || !nama.endsWith(" [C]"));
        do {
            System.out.print("Harga produk: ");
            harga = scan.nextInt();
        } while (harga < 1000);
        harga += harga / 4;
        scan.nextLine();
        do {
            System.out.print("Size: ");
            size = scan.nextLine();
        } while (size.contains("S") || size.contains("M") || size.contains("L") || size.contains("XL"));
        Cloth newCloth = new Cloth(nama, harga, size);
        List.add(newCloth);
        clearConsole();
    }

    void addTech() {
        String nama;
        int harga;
        String version;
        do {
            System.out.print("Nama produk: ");
            nama = scan.nextLine();
        } while (nama.length() > 16 || !nama.endsWith(" [C]"));
        do {
            System.out.print("Harga produk: ");
            harga = scan.nextInt();
        } while (harga < 1000);
        harga += (harga * 3) / 10;
        scan.nextLine();
        System.out.print("Version: ");
        version = scan.nextLine();
        Technology newTech = new Technology(nama, harga, version);
        List.add(newTech);
        clearConsole();
    }

    void menu() {
        while (true) {
            System.out.println(">>> Menu <<<");
            System.out.println("1. Beli produk");
            System.out.println("2. History pembelian");
            System.out.println("3. Tambah uang");
            System.out.println("4. Cek uang");
            System.out.println("5. Logout");
            System.out.println("6. Exit");
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();
            clearConsole();
            switch (choice) {
                case 1:
                    buyProduct();
                    clearConsole();
                    break;
                case 2:
                    //purchaseHistory();
                    break;
                case 3:
                    //addMoney();
                    break;
                case 4:
                    //checkMoney();
                    break;
                case 5:
                    return;
                case 6:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        }
    }

    void buyProduct() {
        while (true) {
            int i = 1;
            System.out.println(">>> Product <<<");
            for (Product product : List) {
                System.out.print(i + ". " + product.name + " - Rp" + product.price + " - ");
                if (product instanceof Food) {
                    System.out.println("Expire date: " + ((Food) product).date);
                } else if (product instanceof Cloth) {
                    System.out.println("Size: " + ((Cloth) product).size);
                } else if (product instanceof Technology) {
                    System.out.println("Version: " + ((Technology) product).version);
                }
                i++;
            }
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice < 1 || choice >= i) {
                System.out.print("Pilihan tidak tersedia!");
                scan.nextLine();
            } else {
                buyList.add(List.get(choice - 1));
                while(true) {
                    System.out.println("1. Buy more ?");
                    System.out.println("2. Checkout");
                    System.out.print(">> ");
                    choice = scan.nextInt();
                    scan.nextLine();
                    if (choice == 1) {
                        break;
                    } else if (choice == 2) {
                        clearConsole();
                        //checkout();
                        return;
                    } else {
                        System.out.print("Pilihan tidak tersedia!");
                        scan.nextLine();
                        clearConsole();
                    }
                }
            }
            clearConsole();
        }
    }

    void clearConsole() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    public static void main(String[] args) {
        new Main();
    }
}
