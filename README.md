## Nerdle Game
###### 03.06.2022, Friday
Tanım: Bu projede Nerdle Oyunu’na benzer şekilde çalışan bir oyun yapmanız ve projenizin bir 
arayüzünün (GUI’sinin) olması beklenmektedir. Ödevinizde olması istenilen özellikler aşağıda maddeler halinde verilmiştir:
* Oyun açıldığında kullanıcının karşısına ilk çıkan daha önceki oynadığı oyunlara dair istatistikler 
(istatistiklerin neler olacağına daha sonra değinilecektir) olmalıdır. Bu istatistiklere ek olarak sayfanın 
herhangi bir yerinde kullanıcıyı yönlendiren “Yeni Oyun”, “Devam Et” (Özel Şartı Var) ve “Test” 
butonları olmalıdır. Bu iki buton projenin akışını farklı yöne çevirmelidir.
  - “Yeni Oyun” butonu tıklandığında “generateEquation” metodu çalışmakta (bu metodun 
nasıl çalıştığı aşağıda detaylı olarak anlatılmıştır) ve bir denklem rastgele üretilmektedir.
  - Bu akışta üretilen denklem herhangi bir şekilde kullanıcıya gösterilmemelidir ve kullanıcının 
denklemi tahmin etmesi istenmelidir. Üretilen denklem uzunluğu X 6 satır kadar kare alan 
ekranda gösterilmelidir (Örneğin denklem uzunluğu 8 ise; her satırı 8 kareden oluşan 6 satır
kullanıcıya gösterilmelidir.
  - Kullanıcı tahmin satırlarına ait hücreleri gördüğü anda bir süre başlatılması ve saniyelik olarak 
bu sürenin akışı ekranın herhangi bir yerinde kullanıcıya gösterilmelidir.
  - Yani kullanıcının denklemi tahmin için 6 hakkı bulunmaktadır. Bu hakları ilk satırdan 
başlayacak şekilde kullanmalıdır. Rastgele bir satırdan başlamasına izin verilmemelidir.
  - Ancak ilk satırı seçtikten sonra satırın istediği konumuna değer girmeye müsaade edilmelidir. 
Örneğin öncelikle = (eşittir) sembolünün nerede olmasını istediğine karar vermek istiyorsa
önce onu girebilmesine izin verilmelidir.
  - Bu ekranda tahmin karelerine ek olarak, 0’dan 9’a kadar rakamlar, 4 işlem sembolleri (+, -, *, 
/) ve eşittir (=) ifadesinin yanında “Tahmin Et”, “Sil” ve “Sonra Bitir” butonları 
bulunmalıdır. Yani toplamda 18 adet buton bulunmalıdır.
  - Kullanıcı tahmin gerçekleştireceği satırda bir hücre seçer ve 10 adet rakamdan veya 5 adet 
sembolden birisini tıklar/seçer. Böylece bu hücrenin değeri kullanıcının seçtiği değer olur.
    - Kullanıcı dilerse hücrenin içerisine tekrar gelir ve yeni değer ile o hücreyi değiştirebilir.
  - Tüm hücreler için girilen değerler tamamlandığında kullanıcı denklemi tahmin etmek için
“Tahmin Et” butonuna basar.
  - Eğer girilen ifadede eşittirin (=) solunda bulunan işlem sonucunda eşittirin (=) sağında 
bulunan sonuç oluşuyorsa bu tahmin geçerli bir tahmindir ve tahmin edilen satırda bu ifade 
sabitlenir (artık değiştirilemez hale getirilir) ve yeni satıra geçilir.
  - Tahmin sonucunda yeri başarılı bir şekilde tahmin edilmiş değerlerin arka planı yeşil olarak 
boyanır. Tahmin neticesinde denklemde bulunan bir ifade kullanılmış ama yeri yanlış bir 
şekilde belirlenmişse sarı olarak boyanır ve tahminde denklemin içerisinde olmayan bir değer 
girilmişse kırmızı olarak boyanır. Bu renklendirme sistemi kullanıcıya bir sonraki tahmininde 
kolaylık sağlamak içindir.
  - Önemli not: tahmin ile rastgele üretilen denklem kontrol edilirken toplamanın ve çarpmanın 
değişme özelliğinden faydalanmanız zorunlu değildir. Örneğin üretilen denklem 7*8-16=40 
ise kullanıcı 8*7-16=40 girdiğinde de illa doğru olarak kabul etmeniz beklenmemektedir. 
Değerlerin tam olarak üretildiği yerleri ile tahmin edilmesini beklemenizde herhangi bir 
sakınca yoktur. Dileyen gruplar değişme özelliğini de kullanabilirler.
  - İlgili satırda tahmin gerçekleştirildikten sonra yeni satıra geçilir ve tekrar tahmin girilmesi
beklenir. Tüm satırlar için durum bu şekilde döngüsel olarak ilerler.
  - 6 satırda kullanıcı doğru tahmini bilemezse kullanıcıya kaybettiği bilgisi verilir ve denklemin
istenilen hali kullanıcıya gösterilir.
  - Herhangi bir satırda doğru tahmin gerçekleşmişse kullanıcıyı tebrik eden bir yazı ile birlikte 
süre bilgisi kullanıcıya gösterilir. Kullanıcı dilerse “Ana Sayfa” butonunu tıklayarak ana sayfaya 
geri dönebilir.
  - “Sil” butonu kullanıldığında seçili olan hücrenin değeri silinir/boşaltılır ve seçili olan hücre bir 
soldaki olarak değiştirilir. Böylece ardışıl olarak sil butonuna basıldığında tahmin için girilen 
tüm değerler silinebilir.
    - Boş bir hücrede sil butonuna basıldığında seçili hücre sol tarafa kaydırılır.
    - En soldaki hücrede sil butonuna basıldığında hücrenin içerisindeki değer silinir ama sol
tarafa kaydırma işlemi yapılmaz.
  - “Sonra Bitir” butonuna basıldığında, rastgele üretilmiş denklem ve şimdiye kadar 
onaylanarak girilmiş satırlar dosyaya kaydedilir. Program tekrar başlatıldığında eğer daha 
önceden “Sonra Bitir” butonuna tıklanarak kaydedilmiş oyun varsa ana ekran istatistiklerinin 
yanında, “Yeni Oyun” ve “Test” butonlarının yanında bir de “Devam Et” butonu olur.
* “Devam Et” butonu tıklandığında kaydedilen oyun kaldığı yerden devam edecek şekilde ekranda
ayarlamalar gerçekleştirilir. Oyun süresi kaldığı yerden devam ettirilir.
  - Sadece tek bir oyun “Sonra Bitir” olarak işaretlendikten sonra devam ettirilebilir. Daha 
önceden “Sonra Bitir” olarak işaretlenen bir oyun kaydedilmişse ve bu işlem tekrar yapılırsa 
bir önce kaydedilen bilgiler silinir ve en son devam ettirilmek istenilen bilgiler kaydedilir.
* “Test” butonu tıklandığında geçilen ekranda “generateEquation” metodu kullanarak üretilmiş 
rastgele bir denklem gösterilir. Hemen altında “Yeniden Üret” butonu bulunur ve bu butona her 
basıldığında “generateEquation” metodu çağırılır ve yeni üretilen denklem ekranda gösterilir.
  - Bu modül rastgele denklem üretme metodunuzun başarısını ölçmek için kullanılacaktır ve
kesinlikle gerçeklenmesi beklenmektedir.
* Oyundan çıkış için sağ üst köşede bulunan “X” butonu kullanılmalıdır.

Oyun İstatistikleri

“Yeni Oyun” butonu tıklanarak üretilmiş rastgele denklemler neticesinde aşağıda istenilen istatistikler
üretilmelidir:
* kaç oyun yarıda bırakılmış,
* kaç oyun başarısızlıkla sonuçlanmış,
* kaç oyun başarıyla tamamlanmış
* başarıyla tamamlananlar ortalama kaç satırda tamamlanmış,
* başarıyla tamamlananlar ortalama ne kadar sürede tamamlanmış

generateEquation Metodu
* Bu metot 7 ila 9 karakter uzunluğunda içerisinde +,-,* ve / sembollerinden en az birisi olan ve 
muhakkak = sembolü barındıran bir matematiksel ifade üretmektedir. Denklemin uzunluğu 7, 8 veya 
9 karakter olabilir ve bu 3 değerden birisi rastgele olarak seçilmelidir. Uzunluğu seçilen denklem 
içerisinde kullanılacak matematiksel semboller, şekil ve sayı olarak rastgele belirleneceğinden ötürü 
her seferinde farklılık göstermelidir (Örneğin her seferinde sadece toplama işlemi kullanılmamalı 
veya her seferinde sadece 1 adet işlem kullanılmamalıdır). Üretilen denklemin String hali bu 
metodun geri dönüş değeri olmalıdır.

Ödev Kuralları/Bilgilendirme:

• Proje ödevinin kaynak kodu içerisinde generateEquation metodu kullanılarak yapılacak jUnit birim 
sınamaları da yer alacaktır. Her öğrencinin en az dört birim sınaması kodlaması beklenmektedir. 
