public class tugas1 {
    public static void main(String[] args) {

        int[] nilai = {1,2,3,4,5,6,7,8,9,10};

        double total = 0;

        for (int i = 0; i < nilai.length; i++) {
            total += nilai[i];
        }

        double rataRata = total / nilai.length;

        System.out.println("Total Penjumlahan : " + total);
        System.out.println("RATA-RATA: " + rataRata);
    }
}
