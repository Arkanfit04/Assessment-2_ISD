class Kota {
    String nama;
    double x, y;

    public Kota(String nama, double x, double y) {
        this.nama = nama;
        this.x = x;
        this.y = y;
    }

    public double jarakKe(Kota k) {
        return Math.sqrt(Math.pow(x - k.x, 2) + Math.pow(y - k.y, 2));
    }

}