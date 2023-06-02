package com.example.mongodb.model;


import java.util.ArrayList;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Document(collection="Seva")
public class Book {
	
	private double sure;;
	private String kelime1;
	private String kelime2;
   // private String son;
	private String birlesmisSon;
/*	
public String Total()
{
	birlesmisSon=kelime1+kelime2;
	return birlesmisSon;
}
*/
	
	
	public String Total() {

      

       long beginTime = 0, endTime = 0;

        beginTime = System.nanoTime();
        kelime1=kelime1.trim().replaceAll(",", "").replaceAll(";", "").replaceAll("-", "");
        kelime2=kelime2.trim().replaceAll(",", "").replaceAll(";", "").replaceAll("-", "");
        
        String[] cumle1Kelimeler = kelime1.split(" ");
        String[] cumle2Kelimeler = kelime2.split(" ");
        ArrayList<String> kelime3 = new ArrayList<String>();

        if ((kelime1.equals("")) || (kelime2.equals(""))) {
            birlesmisSon = "KELİME GİRİSİ YAPMADİNİZ.";
            System.out.println("KELİME GİRİSİ YAPMADİNİZ.");
        } else if ((cumle1Kelimeler.length == 1) && (cumle2Kelimeler.length == 1)) {
            //KELİMELERİ KARAKTER KARAKTER KARSILASTIRMA YAPIYOR
            //-------------------------------------------METİNLERİ DİZİYE ATIYOR
            String[] dizi1 = new String[kelime1.length()];
            for (int i = 0; i < kelime1.length(); i++) {
                String harf1 = kelime1.substring(i, i + 1);
                dizi1[i] = harf1;
            }

            String[] dizi2 = new String[kelime2.length()];
            for (int l = 0; l < kelime2.length(); l++) {
                String harf2 = kelime2.substring(l, l + 1);
                dizi2[l] = harf2;
            }
            //------------------------------------------ESİT OLAN KISMI DİZİ3 E ATIYOR
            ArrayList<String> dizi3 = new ArrayList<String>();
            for (int i = 0; i < dizi1.length; i++) {
                for (int j = 0; j < dizi2.length; j++) {
                    if (dizi1[i].equals(dizi2[j])) {
                        dizi3.add(dizi2[j]);
                    }
                }
            }
//                    for (int i = 0; i < dizi3.size(); i++) {
//                        System.out.println(dizi3.get(i)); 
//                    }
             //------------------
            StringBuilder sb = new StringBuilder();//DİZİ 3 UN ELEMANLARINI STRİNG OLARAK  DEGİSKENDE SAKLA
            for (int i = 0; i < dizi3.size(); i++) {
                sb.append(dizi3.get(i));
            }
            String son = sb.toString();
//            System.out.println(son);

//------------------
            //ORTAK OLMAYANLARI DEGİSKENLERE ATIP BİRLESİMİ VERİYOR.
            ArrayList<Character> silinecekHarfler = new ArrayList<Character>();//dizi3 ü character arraylistine aktardım.
            char[] charArray = son.toCharArray();
            for (int i = 0; i < son.length(); i++) {
                silinecekHarfler.add(charArray[i]);
            }

            StringBuilder sbs = new StringBuilder();//kelime1 de ortak karakterleri sildim.
            for (int i = 0; i < kelime1.length(); i++) {
                char c = kelime1.charAt(i);
                if (!silinecekHarfler.contains(c)) {
                    sbs.append(c);
                }
            }
            String kelime1son = (sbs.toString());
//               System.out.println(kelime1son);

            StringBuilder sbs2 = new StringBuilder();//kelime2 de ortak karakterleri sildim.
            for (int i = 0; i < kelime2.length(); i++) {
                char c = kelime2.charAt(i);
                if (!silinecekHarfler.contains(c)) {
                    sbs2.append(c);
                }
            }
            String kelime2son = (sbs2.toString());
//               System.out.println(kelime2son);

            if (dizi3.size() == 0) {
                birlesmisSon = "ORTAK YOK" + " -> " + (kelime1 + " " + kelime2);
                System.out.println("ORTAK YOK" + " -> " + (kelime1 + " " + kelime2));
            }else{
               birlesmisSon =  son + kelime1son +kelime2son;
                System.out.println(birlesmisSon); 
            }

        } else {
            //STRİNGLERDE ORTAK KELİMELERİ BULUP AARAY LİST E ATIYOR.
            for (int i = 0; i < cumle1Kelimeler.length; i++) {
                for (int j = 0; j < cumle2Kelimeler.length; j++) {
                    if (cumle1Kelimeler[i].equals(cumle2Kelimeler[j])) {  //ortakları arrayliste ata
                        kelime3.add(cumle1Kelimeler[i]);
                    }
                }
            }
            //        for (int i = 0; i < kelime3.size(); i++) {
            //            System.out.println(kelime3.get(i));  
            //        }
            //---------------
            if (kelime3.size() == 0) {//ORTAK KELİME YOKSA EKRANA BİLDİRİ MESAJI GONDERİYOR IF-ELSE İLE
                birlesmisSon = "ORTAK YOK" + " -> " + (kelime1 + " " + kelime2);
                System.out.println("ORTAK YOK" + " -> " + (kelime1 + " " + kelime2));
            } 
            else {
                //CÜMLELERİ KELİME KELİME KARSILASTIRIYOR
                ArrayList<String> kelime1parcala = new ArrayList<String>();// İLK CUMLEYİ PARCALIYOR.
                for (int i = 0; i < cumle1Kelimeler.length; i++) {//İLK CUMLEDE ORTAK OLAN KELİMELERİ SİLEREK ARRAYLİSTE ATIYOR. SON ELEMANI DOGRU.
                    for (int j = 0; j < kelime3.size(); j++) {
                        if (kelime1.contains(kelime3.get(j))) {
                            kelime1 = kelime1.replace(kelime3.get(j), "");
                            kelime1parcala.add(kelime1);
                        }
                    }
                }
                //        for (int i = 0; i < kelime1parcala.size(); i++) {
                //            System.out.println(kelime1parcala.get(i));
                //        }
                //          System.out.println(kelime1parcala.get(kelime1parcala.size()-1));
                String kelime1ortakolmayanlar = kelime1parcala.get(kelime1parcala.size() - 1);
                kelime1ortakolmayanlar=kelime1ortakolmayanlar.trim();
                //+++++++++++++++++++++
                ArrayList<String> kelime2parcala = new ArrayList<String>();// İKİNCİ CUMLEYİ PARCALIYOR.
                for (int i = 0; i < cumle2Kelimeler.length; i++) {//İKİNCİ CUMLEDE ORTAK OLAN KELİMELERİ SİLEREK ARRAYLİSTE ATIYOR. SON ELEMANI DOGRU.
                    for (int j = 0; j < kelime3.size(); j++) {
                        if (kelime2.contains(kelime3.get(j))) {
                            kelime2 = kelime2.replace(kelime3.get(j), "");
                            kelime2parcala.add(kelime2);
                        }
                    }
                }
                //        for (int i = 0; i < kelime2parcala.size(); i++) {
                //            System.out.println(kelime2parcala.get(i));
                //        }
                //        System.out.println(kelime2parcala.get(kelime2parcala.size()-1));
                String kelime2ortakolmayanlar = kelime2parcala.get(kelime2parcala.size() - 1);
                kelime2ortakolmayanlar=kelime2ortakolmayanlar.trim();
                //+++++++++++++++++++++
                //ORTAK OLANLARIN OLDUGU KELİME3 ARRAYLİST İNİN ELEMANLARINI BOSLUK EKLEYEREK STRİNGE  AKTARIR.
                StringBuilder cumle = new StringBuilder();
                for (String kelime : kelime3) {
                    cumle.append(kelime).append(" ");
                }
                String cumleString = cumle.toString();
                cumleString=cumleString.trim();
                //        System.out.println(cumleString);
                //---------------------------------

                birlesmisSon = kelime1ortakolmayanlar + " "+cumleString + " "+kelime2ortakolmayanlar;
                System.out.println(birlesmisSon);
                
            }

        }

        endTime = System.nanoTime();
        // long sures= (endTime - beginTime)/1000;
        // sure = Long.toString(sures);
        sure = ((double) (endTime - beginTime) / 1000000000);
        System.out.println("Çalışma Süresi : " + ((double) (endTime - beginTime)));
        //return birlesmisSon;
 	return birlesmisSon;

    }
	
	
	


}