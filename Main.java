package com;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;
//import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.*;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    //private String fileName, fileContent;

    public static void main(String[] args) {

       /*  String namaFile = "output.txt";
        File file = new File(namaFile);
        FileWriter fileWriter = new FileWriter(file, true);*/


        /*Program*/
        //panggil metode
        mainMenu();
    }

    private static void mainMenu(){

        //pilihan menu
        System.out.println("=========================================");
        System.out.println("| Hitung Luas dan Keliling Bangun Datar |");
        System.out.println("=========================================");
        System.out.println("1. Persegi");
        System.out.println("2. Persegi Panjang");
        System.out.println("3. Segitiga Siku-Siku");
        System.out.println("4. Jajar Genjang");
        System.out.println("5. Trapesium");
        System.out.println("6. Layang-Layang");
        System.out.println("7. Belah Ketupat");
        System.out.println("8. Lingkaran");
        System.out.println("9. Keluar\n");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(isr);

        try {
            System.out.print("Masukan Pilihan Menu : ");
            String input = bufferedReader.readLine();

            //kondisional untuk pilihan menu yang dimasukan
            if (input.isEmpty()) {
                System.out.println("\nAnda tidak memasukkan inputan, silahkan coba lagi.\n");
                mainMenu();
            } else {
                int numberOfString = Integer.parseInt(input);

                if (numberOfString == 1) {
                    bdp();
                } else if (numberOfString == 2) {
                    persegiPanjang();
                } else if (numberOfString == 3) {
                    segitigaSiku();
                } else if (numberOfString == 4){
                    jajarGenjang();
                } else if (numberOfString == 5){
                    trapesium();
                } else if (numberOfString == 6){
                    layangLayang();
                } else if (numberOfString == 7){
                    belahKetupat();
                } else if (numberOfString == 8) {
                    lingkaran();
                } else if (numberOfString == 9) {
                    System.out.println("\nTerima Kasih Sudah Menggunakan Aplikasi ini.\n");
                } else {
                    System.out.println("\nTidak ada pilihan, silahkan coba lagi.\n");
                    mainMenu();
                }
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("\nTidak ada pilihan, silahkan Masukkan Angka 1-9.\n");
           mainMenu();
        }
    }

     private static void bdp() {
     String fileName, fileContent;
     double hasil;
            /*Kamus*/
            Persegi opsg = new Persegi();
            double s;
            char coba;
    
            do {
                System.out.print("\nMasukan sisi persegi: ");
                s = scanner.nextDouble();
                System.out.println("Luas persegi: " + roundingMode(opsg.luas(s)));
                System.out.println("Keliling persegi: " + roundingMode(opsg.keliling(s)));
                
                
                hasil = opsg.luas(s);
                String str = String.valueOf(hasil);
                
                try{
                    File myObj = new File("Persegi.txt");
                    if(myObj.createNewFile()){
                        System.out.print("File Create" + myObj.getName());
                    }else{
                        System.out.println("Data sudah Ada");
                    }
                }catch (IOException e){
                    System.out.println("Error");
                    e.printStackTrace();
                }
                fileName = "Persegi.txt";
                fileContent = "Luas Persegi"+ str;

                try{
                    FileWriter fileWriter = new FileWriter(fileName,true);
                    fileWriter.write("\n" + fileContent);
                    fileWriter.close();
                    System.out.print ("Data Sudah dimasukkan");

                }catch (IOException e){
                    System.out.println("terjadi kesalahan");
                }

                System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
                coba = scanner.next().charAt(0);
                System.out.print("\n");
            } while (coba == 'Y' || coba == 'y');
            System.out.print("\n");
    
            mainMenu();
        }
    
        private static void persegiPanjang() {
            String fileName, fileContent;
            double hasil;
            PersegiPanjang opsgpjg;
            double s1, s2;
            char coba;
    
            opsgpjg = new PersegiPanjang();
    
            do {
                System.out.print("\nMasukan panjang persegi panjang: ");
                s1 = scanner.nextDouble();
                System.out.print("Masukan lebar persegi panjang: ");
                s2 = scanner.nextDouble();
                System.out.println("Luas persegi panjang: " + roundingMode(opsgpjg.luas(s1, s2)));
                System.out.println("Keliling persegi panjang: " + roundingMode(opsgpjg.keliling(s1, s2)));
               

                hasil = opsgpjg.luas(s1,s2);
                String str = String.valueOf(hasil);
                
                try{
                    File myObj = new File("LPersegiPanjang.txt");
                    if(myObj.createNewFile()){
                        System.out.print("File Create" + myObj.getName());
                    }else{
                        System.out.println("Data sudah Ada");
                    }
                }catch (IOException e){
                    System.out.println("Error");
                    e.printStackTrace();
                }
                fileName = "LPersegiPanjang.txt";
                fileContent = "Luas Persegi Panjang"+ str;

                try{
                    FileWriter fileWriter = new FileWriter(fileName,true);
                    fileWriter.write("\n" + fileContent);
                    fileWriter.close();
                    System.out.print ("Data Sudah dimasukkan");

                }catch (IOException e){
                    System.out.println("terjadi kesalahan");
                }
                System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
                coba = scanner.next().charAt(0);
                System.out.print("\n");
            } while (coba == 'Y' || coba == 'y');
            System.out.print("\n");
    
            mainMenu();
        }
    
        private static void segitigaSiku() {
            String fileName, fileContent;
            double hasil;
            SegitigaSiku ostgsiku;
            double s1, s2;
            char coba;
    
            ostgsiku = new SegitigaSiku();
    
            do {
                System.out.print("\nMasukan alas segitiga siku-siku: ");
                s1 = scanner.nextDouble();
                System.out.print("Masukan tinggi segitiga siku-siku: ");
                s2 = scanner.nextDouble();
                System.out.println("Sisi miring (hipotenusa): " + roundingMode(ostgsiku.sisiMiring(s1, s2)));
                System.out.println("Luas segitiga: " + roundingMode(ostgsiku.luas(s1, s2)));
                System.out.println("Keliling segitiga: " + roundingMode(ostgsiku.keliling(s1, s2)));
    
               
            hasil = ostgsiku.luas(s1,s2);
                String str = String.valueOf(hasil);
                
                try{
                    File myObj = new File("LSegitiga.txt");
                    if(myObj.createNewFile()){
                        System.out.print("File Create" + myObj.getName());
                    }else{
                        System.out.println("Data sudah Ada");
                    }
                }catch (IOException e){
                    System.out.println("Error");
                    e.printStackTrace();
                }
                fileName = "LPSegitiga.txt";
                fileContent = "Luas Segitiga"+ str;

                try{
                    FileWriter fileWriter = new FileWriter(fileName,true);
                    fileWriter.write(fileContent);
                    fileWriter.close();
                    System.out.print ("Data Sudah dimasukkan");

                }catch (IOException e){
                    System.out.println("terjadi kesalahan");
                }
                System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
                coba = scanner.next().charAt(0);
                System.out.print("\n");
            } while (coba == 'Y' || coba == 'y');
            System.out.print("\n");
    
            mainMenu();
        }
    
        private static void lingkaran() {
            String fileName, fileContent;
            double hasil;
            Lingkaran olingkaran;
            double r;
            char coba;
    
            olingkaran = new Lingkaran();
    
            do {
                System.out.print("\nMasukan jari-jari lingkaran: ");
                r = scanner.nextDouble();
                System.out.println("Luas lingkaran: " + roundingMode(olingkaran.luas(r)));
                System.out.println("Keliling lingkaran: " + roundingMode(olingkaran.keliling(r)));
    
            

            hasil = olingkaran.luas(r);
            String str = String.valueOf(hasil);
            
            try{
                File myObj = new File("LLingkaran.txt");
                if(myObj.createNewFile()){
                    System.out.print("File Create" + myObj.getName());
                }else{
                    System.out.println("Data sudah Ada");
                }
            }catch (IOException e){
                System.out.println("Error");
                e.printStackTrace();
            }
            fileName = "LLingkaran.txt";
            fileContent = "Luas Lingkaran"+ str;

            try{
                FileWriter fileWriter = new FileWriter(fileName,true);
                fileWriter.write(fileContent);
                fileWriter.close();
                System.out.print ("Data Sudah dimasukkan");

            }catch (IOException e){
                System.out.println("terjadi kesalahan");
            }
            System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
            coba = scanner.next().charAt(0);
            System.out.print("\n");
        } while (coba == 'Y' || coba == 'y');
            System.out.print("\n");
    
            mainMenu();
        }
    
        private static void jajarGenjang() {
            String fileName, fileContent;
            double hasilL, hasilK;
            JajarGenjang ojjrgjg;
            double a, t, b;
            char coba;
    
            ojjrgjg = new JajarGenjang();
    
            do {
                System.out.print("\nMasukan alas jajar genjang: ");
                a = scanner.nextDouble();
                System.out.print("Masukan tinggi jajar genjang: ");
                t = scanner.nextDouble();
                System.out.print("Masukan sisi miring jajar genjang: ");
                b = scanner.nextDouble();
                System.out.println("\nLuas jajar genjang: " + roundingMode(ojjrgjg.luas(a, t)));
                System.out.println("Keliling jajar genjang: " + roundingMode(ojjrgjg.keliling(a, b)));
    
                
            hasilL = ojjrgjg.luas(a,t);
            String strL = String.valueOf(hasilL);
            hasilK = ojjrgjg.keliling(a,b);
            String strK = String.valueOf(hasilK);
            
            try{
                File myObj = new File("JajarGenjang.txt");
                if(myObj.createNewFile()){
                    System.out.print("\nFile Create " + myObj.getName());
                }else{}
            }catch (IOException e){
                System.out.println("Error");
                e.printStackTrace();
            }
            fileName = "JajarGenjang.txt";
            fileContent = "Luas Jajajr Genjang Dari A: "+a +",T: " + t + "Sisi Miring"+b + strL+"\nLuas Jajajr Genjang Dari A: "+a +",T: " + t + "Sisi Miring"+b + strK;

            try{
                FileWriter fileWriter = new FileWriter(fileName,true);
                fileWriter.write("\n"+fileContent);
                fileWriter.close();
                System.out.print ("\nData Sudah dimasukkan\n");

            }catch (IOException e){
                System.out.println("terjadi kesalahan");
            }
            System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
                coba = scanner.next().charAt(0);
                System.out.print("\n");
            } while (coba == 'Y' || coba == 'y');
            System.out.print("\n");
            mainMenu();
        }
    
        private static void trapesium() {
            String fileName, fileContent;
            double hasilL, hasilK;
            Trapesium otrps;
            double a, b, s;
            char coba;
    
            otrps = new Trapesium();
    
            do {
                System.out.print("\nMasukan sisi sejajar a trapesium: ");
                a = scanner.nextDouble();
                System.out.print("Masukan sisi sejajar b trapesium: ");
                b = scanner.nextDouble();
                System.out.print("Masukan sisi miring trapesium: ");
                s = scanner.nextDouble();
                System.out.println("Tinggi trapesium: " + roundingMode(otrps.tinggi(a, b, s)));
                System.out.println("\nLuas trapesium: " + roundingMode(otrps.luas(a, b, s)));
                System.out.println("Keliling trapesium: " + roundingMode(otrps.keliling(a, b, s)));

                hasilL = otrps.luas(a,b,s);
                String strL = String.valueOf(hasilL);
                hasilK = otrps.keliling(a,b,s);
                String strK = String.valueOf(hasilK);
                
                try{
                    File myObj = new File("Trapesium.txt");
                    if(myObj.createNewFile()){
                        System.out.print("\nFile Create " + myObj.getName());
                    }else{}
                }catch (IOException e){
                    System.out.println("Error");
                    e.printStackTrace();
                }
                fileName = "Trapesium.txt";
                fileContent = "Luas Trapesium  Dari Sisi A: "+a +", Sisi B: "+b+ "Sisi Miring: "+s+" = "+ strL+"\nKeliling Trapesium  Dari Sisi A: "+a +", Sisi B: "+b+ "Sisi Miring: "+s+" = "+ strK;
                try{
                    FileWriter fileWriter = new FileWriter(fileName,true);
                    fileWriter.write("\n"+fileContent);
                    fileWriter.close();
                    System.out.print ("\nData Sudah dimasukkan\n");

                }catch (IOException e){
                    System.out.println("terjadi kesalahan");
                }
                System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
                coba = scanner.next().charAt(0);
                System.out.print("\n");
            } while (coba == 'Y' || coba == 'y');    
            System.out.print("\n");
            mainMenu();
        }
    
        private static void layangLayang() {
            String fileName, fileContent;
            double hasilL, hasilK;
            LayangLayang olyglyg;
            double d1, d2, ab, bc;
            char coba;
    
            olyglyg = new LayangLayang();
    
            do {
                System.out.print("\nMasukan diagonal1/AC layang-layang: ");
                d1 = scanner.nextDouble();
                System.out.print("Masukan diagonal2/BD layang-layang: ");
                d2 = scanner.nextDouble();
                System.out.print("Masukan sisi miring1/AB layang-layang: ");
                ab = scanner.nextDouble();
                System.out.print("Masukan sisi miring2/BC layang-layang: ");
                bc = scanner.nextDouble();
                System.out.println("\nLuas layang-layang: " + roundingMode(olyglyg.luas(d1, d2)));
                System.out.println("Keliling layang-layang: " + roundingMode(olyglyg.keliling(ab, bc)));
                    
                hasilL = olyglyg.luas(d1,d2);
                String strL = String.valueOf(hasilL);
                hasilK = olyglyg.keliling(ab, bc);
                String strK = String.valueOf(hasilK);
                try{
                    File myObj = new File("LayangLayang.txt");
                    if(myObj.createNewFile()){
                        System.out.print("File Create " + myObj.getName());
                    }else{}
                }catch (IOException e){
                    System.out.println("Error");
                    e.printStackTrace();
                }
                fileName = "LayangLayang.txt";
                fileContent = "Luas Layang-Layang  Dari D1: "+ d1+",D2: "+d2+ " = " + strL + "\nKeliling Layang-Layang  Dari D1: "+ d1+",D2: "+d2+" = "+ strK;

                try{
                    FileWriter fileWriter = new FileWriter(fileName,true);
                    fileWriter.write("\n" + fileContent);
                    fileWriter.close();
                    System.out.print ("\nData Sudah dimasukkan\n");

                }catch (IOException e){
                    System.out.println("terjadi kesalahan");
                }
                System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
                coba = scanner.next().charAt(0);
                System.out.print("\n");
            } while (coba == 'Y' || coba == 'y');
                System.out.print("\n");
                mainMenu();
            }
    
        private static void belahKetupat() {
            String fileName, fileContent;
            double hasilL, hasilK;
            BelahKetupat oblhktpt;
            double d1, d2;
            char coba;
    
            oblhktpt = new BelahKetupat();
    
            do {
                System.out.print("\nMasukan diagonal1/AC belah ketupat: ");
                d1 = scanner.nextDouble();
                System.out.print("Masukan diagonal2/BD belah ketupat: ");
                d2 = scanner.nextDouble();
                System.out.println("Sisi miring belah ketupat: " + roundingMode(oblhktpt.sisiMiring(d1, d2)));
                System.out.println("\nLuas belah ketupat: " + roundingMode(oblhktpt.luas(d1, d2)));
                System.out.println("Keliling belah ketupat: " + roundingMode(oblhktpt.keliling(d1, d2)));
    
                hasilL = oblhktpt.luas(d1,d2);
                String strL = String.valueOf(hasilL);
                hasilK = oblhktpt.keliling(d1,d2);
                String strK = String.valueOf(hasilK);
                try{
                    File myObj = new File("BelahKetupat.txt");
                    if(myObj.createNewFile()){
                        System.out.print("File Create" + myObj.getName());
                    }else{}
                }catch (IOException e){
                    System.out.println("Error");
                    e.printStackTrace();
                }
                fileName = "BelahKetupat.txt";
                fileContent = "Luas Belah Ketupat Dari D1: "+ d1 + ", D2: "+ d2 + " = " + strL + "\nKeliling Belah Ketupat Dari D1: "+ d1 + ", D2: "+ d2 + " = " + strK;
                try{
                    FileWriter fileWriter = new FileWriter(fileName,true);
                    fileWriter.write( "\n" + fileContent);
                    fileWriter.close();
                    System.out.print ("Data Sudah dimasukkan\n");

                }catch (IOException e){
                    System.out.println("terjadi kesalahan");
                }
            
            System.out.print("\nMasih Ingin Menghitung? (y/t) : ");
                coba = scanner.next().charAt(0);
                System.out.print("\n");
            } while (coba == 'Y' || coba == 'y');
            System.out.print("\n");
            mainMenu();
        }

    private static String roundingMode(double number) {
        DecimalFormat df = new DecimalFormat("#.#####");
        df.setRoundingMode(RoundingMode.CEILING);
        return df.format(number);
    }
}
