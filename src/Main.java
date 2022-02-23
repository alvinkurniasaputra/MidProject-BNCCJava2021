import java.util.ArrayList;
import java.util.InputMismatchException;
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
            try {
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
            } catch (InputMismatchException e) {
                System.out.print("Input harus berupa angka!");
                scan.nextLine();
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
                        menu(acc);
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
        while (true) {
            System.out.print("Username: ");
            username = scan.nextLine();
            if (username.length() < 3 || username.length() > 16)
                System.out.println("(≥ 3 karakter dan ≤ 16 karakter)\n");
            else
                break;
        }
        while (true) {
            System.out.print("Nama panjang: ");
            fullname = scan.nextLine();
            if (fullname.length() < 3 || fullname.length() > 16 || fullname.matches(".*[^a-zA-Z].*"))
                System.out.println("(≥ 3 karakter dan ≤ 16 karakter, tidak boleh ada angka atau karakter spesial (cth:!?,.+-_))\n");
            else
                break;
        }
        while (true) {
            System.out.print("Email address: ");
            email = scan.nextLine();
            if (email.length() < 5 || email.length() > 30 || !email.contains("@") || !(email.endsWith(".com") || email.endsWith(".net")))
                System.out.println("(≥ 5 karakter dan ≤ 30 karakter, terdapat karakter '@', diakhiri dengan '.com' atau '.net')\n");
            else
                break;
        }
        while (true) {
            System.out.print("Password: ");
            password = scan.nextLine();
            if (password.length() < 8 || password.length() > 40 || !password.matches(".*[a-zA-Z].*") || !password.matches(".*[0-9].*"))
                System.out.println("(≥ 8 karakter dan ≤ 40, kombinasi huruf dan angka)\n");
            else
                break;
        }

        Account newAcc = new Account(username, fullname, email, password, 1000);
        accList.add(newAcc);
        clearConsole();
    }

    void menuAdmin() {
        while (true) {
            try {
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
            } catch (InputMismatchException E) {
                System.out.print("Input harus berupa angka!");
                scan.nextLine();
                scan.nextLine();
                clearConsole();
            }
        }
    }

    void addFood() {
        String nama;
        int harga;
        String tanggal;
        while (true) {
            System.out.print("Nama produk: ");
            nama = scan.nextLine();
            if (nama.length() > 16 || !nama.endsWith(" [F]"))
                System.out.println("(≥ 3 karakter dan ≤ 16 karakter, diakhiri dengan \" [F]\")\n");
            else
                break;
        }
        while (true) {
            System.out.print("Harga produk: ");
            harga = scan.nextInt();
            if (harga < 1000)
                System.out.println("(≥ Rp 1000)\n");
            else
                break;
        }
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
        while (true) {
            System.out.print("Nama produk: ");
            nama = scan.nextLine();
            if (nama.length() > 16 || !nama.endsWith(" [C]"))
                System.out.println("(≥ 3 karakter dan ≤ 16 karakter, diakhiri dengan \" [C]\")\n");
            else
                break;
        }
        while (true) {
            System.out.print("Harga produk: ");
            harga = scan.nextInt();
            if (harga < 1000)
                System.out.println("(≥ Rp 1000)\n");
            else
                break;
        }
        harga += harga / 4;
        scan.nextLine();
        while (true) {
            System.out.print("Size: ");
            size = scan.nextLine();
            if (!size.matches("[X][L]")  && !size.matches("[SML]"))
                System.out.println("(S / M / L / XL)\n");
            else
                break;
        }
        Cloth newCloth = new Cloth(nama, harga, size);
        List.add(newCloth);
        clearConsole();
    }

    void addTech() {
        String nama;
        int harga;
        String version;
        while (true) {
            System.out.print("Nama produk: ");
            nama = scan.nextLine();
            if (nama.length() > 16 || !nama.endsWith(" [T]"))
                System.out.println("(≥ 3 karakter dan ≤ 16 karakter, diakhiri dengan \" [T]\")\n");
            else
                break;
        }
        while (true) {
            System.out.print("Harga produk: ");
            harga = scan.nextInt();
            if (harga < 1000)
                System.out.println("(≥ Rp 1000)\n");
            else
                break;
        }
        harga += (harga * 3) / 10;
        scan.nextLine();
        System.out.print("Version: ");
        version = scan.nextLine();
        Technology newTech = new Technology(nama, harga, version);
        List.add(newTech);
        clearConsole();
    }

    void menu(Account acc) {
        while (true) {
            try {
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
                        buyProduct(acc);
                        clearConsole();
                        break;
                    case 2:
                        purchaseHistory(acc);
                        clearConsole();
                        break;
                    case 3:
                        addMoney(acc);
                        clearConsole();
                        break;
                    case 4:
                        checkMoney(acc);
                        clearConsole();
                        break;
                    case 5:
                        return;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Pilihan tidak tersedia!");
                }
            } catch (InputMismatchException E) {
                System.out.print("Input harus berupa angka!");
                scan.nextLine();
                scan.nextLine();
                clearConsole();
            }
        }
    }

    void buyProduct(Account acc) {
        History newHistory = new History();
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
                newHistory.setPayment(List.get(choice - 1));
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
                        checkout(acc, newHistory);
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

    void checkout(Account acc, History newHistory) {
        int i = 1;
        int total = 0;
        while (true) {
            System.out.println(">>> Checkout <<<");
            for (Product product : buyList) {
                System.out.print(i + ". " + product.name + " - Rp" + product.price + " - ");
                if (product instanceof Food) {
                    System.out.println("Expire date: " + ((Food) product).date);
                } else if (product instanceof Cloth) {
                    System.out.println("Size: " + ((Cloth) product).size);
                } else if (product instanceof Technology) {
                    System.out.println("Version: " + ((Technology) product).version);
                }
                i++;
                total += product.price;
            }
            System.out.println("Total: Rp" + total);
            System.out.println("Uang anda: Rp" + acc.getMoney());
            System.out.println("\n1. Bayar");
            System.out.println("2. Cancel");
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                if (acc.getMoney() >= total) {
                    acc.setHistory(newHistory);
                    acc.setStructId();
                    acc.setMoney(- total);
                    struct(acc,acc.getStructId());
                    System.out.print("\n(tekan enter untuk kembali ke menu)");
                    scan.nextLine();
                } else {
                    System.out.print("Uang yang anda miliki tidak mencukupi \n(tekan enter untuk kembali ke menu)");
                    scan.nextLine();
                }
                choice = 2;
            }
            if (choice == 2) {
                buyList.clear();
                break;
            } else {
                System.out.print("Pilihan tidak tersedia!");
                scan.nextLine();
                clearConsole();
            }
        }
    }

    void struct(Account acc, int n) {
        clearConsole();
        int i = 1;
        int total = 0;
        System.out.println("Padie Shop");
        System.out.println("------------------------------------------");
        System.out.println("ID: #" + n + "\n");
        for (Product product : acc.getHistory().get(n-1).getPayment()) {
            System.out.println(i + ". " + product.name + " - Rp" + product.price + " - ");
            if (product instanceof Food) {
                System.out.println("Expire date: " + ((Food) product).date);
            } else if (product instanceof Cloth) {
                System.out.println("Size: " + ((Cloth) product).size);
            } else if (product instanceof Technology) {
                System.out.println("Version: " + ((Technology) product).version);
            }
            i++;
            total += product.price;
        }
        System.out.println("------------------------------------------");
        System.out.println("Quantity    : " + (i - 1));
        System.out.println("Total Price : Rp" + total);
        System.out.println("------------------------------------------");
    }

    void purchaseHistory(Account acc) {
        while (true) {
            System.out.println("1. Lihat riwayat pembelian");
            System.out.println("2. Kembali");
            System.out.print(">> ");
            int choice = scan.nextInt();
            scan.nextLine();
            if (choice == 1) {
                System.out.print("Masukan struct ID: ");
                int n = scan.nextInt();
                scan.nextLine();
                if(n < 1 || n > acc.getStructId()){
                    System.out.println("Struct ID tidak ditemukan!");
                }
                else {
                    struct(acc, n);
                }
                System.out.print("\n(tekan enter untuk kembali)");
            } else if (choice == 2) {
                break;
            } else {
                System.out.print("Pilihan tidak tersedia!");
            }
            scan.nextLine();
            clearConsole();
        }
    }

    void addMoney(Account acc) {
        int total;
        System.out.print("Masukan nominal uang yang ingin ditambah: ");
        total = scan.nextInt();
        scan.nextLine();
        if (total < 0) {
            System.out.print("Nominal uang tidak valid. \n\n(tekan enter untuk kembali ke menu)");
        } else {
            acc.setMoney(total);
            System.out.print("Uang berhasil ditambahkan. \n\n(tekan enter untuk kembali ke menu)");
        }
        scan.nextLine();
    }

    void checkMoney(Account acc) {
        System.out.println("Jumlah uang anda: Rp" + acc.getMoney());
        System.out.print("\n(tekan enter untuk kembali ke menu)");
        scan.nextLine();
    }

    void clearConsole() {
        System.out.println(new String(new char[50]).replace("\0", "\r\n"));
    }

    public static void main(String[] args) {
        new Main();
    }
}
