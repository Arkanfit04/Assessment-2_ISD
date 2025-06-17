public class Main {

    public static void main(String[] args) {
        GraphUk graph = new GraphUk();

        System.out.println("\nUrutan Kunjungan berdasarkan kota terdekat terlebih dahulu.");
        graph.kunjungiTerdekat("Paris");

        System.out.println("\nUrutan kujungan berdasarkan kota terjauh dari Paris.");
        graph.kunjungiMenjauh("Paris");
    }
}