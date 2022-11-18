package com.example.odev2;

public class Odev2 {

    //1. Kilometreyi mile çevirme.
    public double kilometreToMil(double kilometre){
        double mil = kilometre*0.621;
        return mil;
    }

    //2. Dikdörtgen alanı hesaplama.
    public void dikdortgenAlan(int kenar1, int kenar2){
        System.out.println("Kenarları " + kenar1 + " ve " + kenar2 + " metre olan dikdörtgenin Alanı: " + kenar1*kenar2 + " metrekaredir.");
    }

    //3. Faktöriyel hesaplama.
    public int faktoriyelHesapla(int sayi){
        int faktoriyel=1;
        for(int i=1; i <= sayi; i++){
            faktoriyel*=i;
        }
        return faktoriyel;
    }

    //4. Kelime içinde kaç adet "E" harfi var?
    public void kacAdetE(String kelime){
        int sayac = 0;
        for (int i=0; i < kelime.length(); i++){
            if (kelime.charAt(i) == 'e' || kelime.charAt(i) == 'E'){
                sayac++;
            }
        }
        System.out.println(kelime + " kelimesinde toplam " + sayac + " adet E harfi bulunmaktadır.");
    }

    //5. Kenar sayısına göre iç açı hesaplama.
    public int icAcilarToplami(int kenarSayisi){
        int toplam = ((kenarSayisi-2)*180);
        return toplam;
    }

    //6. Maaş hesabı yapma.
    public void maasHesaplama(int gunSayisi, int calismaSaati){
        int maas = 0;
        if((calismaSaati) > (gunSayisi*8)){
            System.out.println("Hata, günde 8 saat çalışabilirsiniz. Şu ana kadar en fazla " + gunSayisi*8 + " saat çalışmış olabilirsiniz.");
        }
        else if (calismaSaati < 150){
            maas = calismaSaati*40;
            System.out.println(gunSayisi + " günde " + calismaSaati + " saat çalışarak kazandığınız maaş: " + maas);
        }
        else{
            maas = (((calismaSaati-150)*80) + (150*40));
            System.out.println(gunSayisi + " günde " + calismaSaati + " saat çalışarak kazandığınız maaş: " + maas);
        }
    }

    //7. Otopark ücreti hesaplama.
    public int otoparkUcreti(int gecirilenSure){
        int ucret = 0;
        if (gecirilenSure <= 1){
            ucret = 50;
        }
        else{
            ucret = 50 + ((gecirilenSure-1)*10);
        }
        return ucret;
    }

}
