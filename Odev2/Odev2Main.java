package com.example.odev2;

public class Odev2Main {
    public static void main(String[] args) {
        Odev2 o = new Odev2();
        //1. Kilometreyi mile çevirme.
        double cevrilenMil = o.kilometreToMil(51.2);
        System.out.println("Mil Değeri: " + cevrilenMil);

        //2. Dikdörtgen alanı hesaplama.
        o.dikdortgenAlan(5,20);

        //3. Faktöriyel hesaplama.
        int faktoriyelSonuc = o.faktoriyelHesapla(5);
        System.out.println("Faktöriyel Sonucu: " + faktoriyelSonuc);

        //4. Kelime içinde kaç adet "E" harfi var?
        o.kacAdetE("Eldiven");

        //5. Kenar sayısına göre iç açı hesaplama.
        int icAcilarToplami = o.icAcilarToplami(3);
        System.out.println("İç Açılar Toplamı: " + icAcilarToplami);

        //6. Maaş hesabı yapma.
        o.maasHesaplama(20,158);

        //7. Otopark ücreti hesaplama.
        int otoparkUcreti = o.otoparkUcreti(5);
        System.out.println("Ödenmesi Gereken Otopark Ücreti: " + otoparkUcreti);

    }
}
