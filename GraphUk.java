import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class GraphUk {
    Map<String, Kota> kotaMap = new HashMap<>();
    List<Kota> kotaList = new ArrayList<>();

    public GraphUk() {
        tambahKota("Paris", 0, 0);
        tambahKota("Brussels", 1, -1);
        tambahKota("Zurich", 0, -2);
        tambahKota("Amsterdam", 0,  -2);
        tambahKota("Vienna", -3, -4);
        tambahKota("Prague", -1, -5);
        tambahKota("Hamburg",-0, -4);
        tambahKota("Warsaw",2, -6);
        tambahKota("Budaapest", -2, -1);
    }

    private void tambahKota(String nama, double x, double y) {
        Kota k = new Kota(nama, x, y);
        kotaMap.put(nama, k);
        kotaList.add(k);
    }

    public void kunjungiTerdekat(String dari) {
        Set<Kota> dikunjungi = new HashSet<>();
        Kota sekarang = kotaMap.get(dari);
        dikunjungi.add(sekarang);
        System.out.println(sekarang.nama);

        while (dikunjungi.size() < kotaList.size()) {
            Kota berikutnya = null;
            double minJarak = Double.MAX_VALUE;
            for (Kota k : kotaList) {
                if (!dikunjungi.contains(k)) {
                    double jarak = sekarang.jarakKe(k);
                    if (jarak < minJarak) {
                        minJarak = jarak;
                        berikutnya = k;
                    }
                }
            }
            if (berikutnya != null) {
                System.out.println(berikutnya.nama);
                dikunjungi.add(berikutnya);
                sekarang = berikutnya;
            }
        }
    }

    public void kunjungiMenjauh(String dari) {
        Kota pusat = kotaMap.get(dari);
        kotaList.sort((a, b) -> Double.compare(b.jarakKe(pusat), a.jarakKe(pusat)));
        for (Kota k : kotaList) {
            System.out.println(k.nama);
        }
    }
}
