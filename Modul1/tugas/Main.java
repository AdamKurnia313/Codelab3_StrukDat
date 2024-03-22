package StrukturData.Modul1.tugas;

import java.util.Scanner;

//---m d k
class Barang<V>{
    private V Value;

    public void setValue(V value) {
        this.Value = value;
    }

    public V getValue() {
        return Value;
    }

    //---J d
    public enum Jenis {
        Sandang, Pangan, Papan
    }
    public static class EnumType {
        Jenis jenis;
        
        public EnumType(Jenis jenis){
            this.jenis = jenis;
        }

        public void JenisKebutuhan(){
            switch (jenis){
                case Sandang :
                    System.out.println("Jenis : Kebutuhan Sandang");
                     break;
                case Pangan  :
                    System.out.println("Jenis : Kebutuhan Pangan");
                     break;
                case Papan:
                    System.out.println("Jenis : Kebutuhan Papan");
                    break;
                default:
                    System.out.println("Pilih Jenis kebutuhan dengan benar");
                    break;

            }
        }
    }

    public static class Main {
    
        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            //---G 1
            Barang<String> striBarang = new Barang<>();
            System.out.println("Nama Baramg : ");
            String namaBarang = scanner.nextLine();
            striBarang.setValue(namaBarang);

            //---G 2
            Barang<String> harga = new Barang<>();
            System.out.println("Harga : " );
            String hargaBarang = scanner.nextLine();
            harga.setValue(hargaBarang);

            //---P E
            System.out.println("Pilih Jenis Kebutuhan :");
            System.out.println("1.Sandang");
            System.out.println("2.Pangan");
            System.out.println("3.Pakan");

            System.out.println("Masukkan Kode Kebutuhan : " );
            int kodeKebutuhan = Integer.parseInt(scanner.nextLine());

            //---P 
            EnumType jenisBarang;
            switch (kodeKebutuhan) {
            case 1:
                jenisBarang = new EnumType(Jenis.Sandang);
                break;
            case 2:
                jenisBarang = new EnumType(Jenis.Pangan);
                break;
            case 3:
                jenisBarang = new EnumType(Jenis.Papan);
                break;
            default:
                System.out.println("Input tidak valid.");
                return;
        }
        
            System.out.println("Informasi Barang : ");
            System.out.println("Nama  : " + striBarang.getValue());
            System.out.println("Harga : " + harga.getValue());
            jenisBarang.JenisKebutuhan();
        }
    }
}

