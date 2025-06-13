# RIFT: Escape ⚔️

Bu proje, Java öğrenme sürecinin bir parçası olarak geliştirilmiş, konsol tabanlı bir Rol Yapma Oyunu'dur (RPG).

![RIFT Portalı](./game/rift-portal.png)

## 📖 Oyunun Hikayesi

Gizemli bir diyar olan **RIFT**'te mahsur kaldınız. Normal hayata dönebilmenizin tek yolu, bu diyarın dört farklı tehlikeli bölgesinde saklı olan özel eşyaları toplamak ve evinizdeki portalı yeniden çalıştırmaktır. Karakterinizi seçin, canavarlarla savaşın, kendinizi güçlendirin ve bu esaretten kurtulun!

---

## ✨ Özellikler

* **3 Farklı Karakter Sınıfı:** Savaşçı, Okçu veya Büyücü olarak oyuna başlayın. Her sınıfın kendine özgü başlangıç değerleri vardır.
* **Keşfedilebilir Bölgeler:** Ev, Mağaza, Orman, Mağara, Bataklık ve Kule dahil olmak üzere farklı mekanları keşfedin.
* **Sıra Tabanlı Savaş Sistemi:** Bölgelerdeki canavarlarla stratejik, sıra tabanlı savaşlara girin.
* **Eşya ve Geliştirme:** Mağazadan daha güçlü silahlar ve zırhlar satın alarak karakterinizi geliştirin.
* **Görev ve Amaç:** Dört özel eşyayı toplayıp portalı açarak oyunu kazanın ve ilerlemenizi takip edin.

---

## 🗺️ Oyun Dünyası

* **Ev (Home):** Güvenli sığınağınız. Topladığınız özel eşyaları ve portalın durumunu burada kontrol edebilirsiniz.
* **Mağaza (Store):** Savaşlarda kazandığınız paralarla yeni silahlar ve zırhlar alabileceğiniz yer.
* **Savaş Bölgeleri (Battle Zones):**
    * **Işık Ormanı (Forest):** Kurtların kol gezdiği, ilk özel eşyanın bulunduğu bölge.
    * **Yankı Mağaraları (Cave):** Golemlerin koruduğu, değerli bir eşyayı barındıran mağaralar.
    * **Suskun Bataklık (Swamp):** Sülüklerin yaşadığı, zorlu bir bataklık.
    * **Zamanın Kulesi (Tower):** En güçlü koruyucuların beklediği, son eşyanın bulunduğu kule.

---

## 🚀 Nasıl Çalıştırılır?

Bu projeyi yerel makinenizde çalıştırmak için aşağıdaki adımları izleyin.

### Gereksinimler
* Java Geliştirme Kiti (JDK) 11 veya üstü.

### Kurulum ve Çalıştırma

1.  **Repoyu klonlayın:**
    ```sh
    git clone [https://github.com/emrecanesenn/RiftGame.git](https://github.com/emrecanesenn/RiftGame.git)
    ```

2.  **Proje dizinine gidin:**
    ```sh
    cd RiftGame
    ```

3.  **Kaynak dosyalarının olduğu dizine gidin:**
    ```sh
    cd src
    ```

4.  **Java dosyalarını derleyin:**
    * `Main.java` dosyanızın `game` paketi içinde olduğunu varsayarsak:
    ```sh
    javac game/Main.java
    ```
    * Bu komut, `Main.java`'nın ihtiyaç duyduğu diğer tüm sınıfları da otomatik olarak derleyecektir.

5.  **Oyunu çalıştırın:**
    ```sh
    java game.Main
    ```

---

## 📸 Oyun İçi Görüntüler

### Karakter Seçimi
```
----------------------------
1- Warrior (Savaşçı) / Sağlık : 120 - Güç : 15 - Silah : El - Başlangıç Parası : 50
2- Archer (Okçu) / Sağlık : 100 - Güç : 18 - Silah : Basit Yay - Başlangıç Parası : 60
3- Wizard (Büyücü) / Sağlık : 80 - Güç : 12 - Silah : Basit Asa - Başlangıç Parası : 80
Bir karakter seçmelisin:
```

### Ana Menü
```
----- Yönlendirici -----

Bölgeler;
0 - Ev (Buradasınız)
1 - Işık Ormanı
2 - Yankı Mağaraları
3 - Suskun Bataklık
4 - Zamanın Kulesi

Bilgiler;
5 - Kişisel Durum
6 - Özel Eşyalar ve Portal Durumu
7 - Mağaza

911 - Oyunu Bitir

------------------------
```

### Mağaza Ekranı
```
----> Mağaza

1- Silahlar (Güç Artışı)
2- Zırhlar (Ekstra Sağlık)

3- Mağazadan çık
Gitmek istediğiniz menüyü giriniz : 1
Mağaza -> Silahlar

1- Tahta Kılıç (+5 Güç) - 50$
2- Demir Kılıç (+10 Güç) - 120$
3- Çelik Kılıç (+15 Güç) - 220$
4- Mithril Kılıç (+20 Güç) - 380$
5- Kadim Silah (+25 Güç) - 550$
6- Önceki menüye dön ->

Mevcut paranız : 150
Yapmak istediğiniz işlemi seçiniz :
```

### Savaş Ekranı
```
Golem sayısı : 3
Golem canavarının gücü : 7
Kalan canınız : 120
Devam etmek için bir tuşa basınız..

Savaş sırası sende!!
+15 hasar verdin! Golem canavarının kalan canı: 25


Savaş sırası Golem canavarında!
+7 hasar aldın! Kalan canın: 113
```

---

## ✍️ Yazar

Bu proje, **Emrecan Esen** ([@emrecanesenn](https://github.com/emrecanesenn)) tarafından Java öğrenme serüveninin bir parçası olarak geliştirilmiştir.
