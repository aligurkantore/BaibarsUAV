✅ ABOUT THE APPLICATION
A dynamic animation has been added to the splash screen using the Lottie library. This animation provides a visually striking experience to users during the application launch.
On the home page, a drone animation has been created based on incoming latitude, longitude, and altitude data. The drone moves up and down, left and right, 
depending on changes in the data, offering users a dynamic visual experience. Additionally, an area displaying the incoming data has been added. When this area is tapped, 
dynamic graphs related to the data are displayed. Users can easily access these graphs to analyze the data. These features enhance the interaction within the application 
and present the data in a more understandable and visually appealing way.




✅ USED TECHNOLOGIES AND LIBRARIES

MVVM (Model-View-ViewModel): The application was designed using this architectural pattern.

Modular Structure: It was divided into modules such as app, core, and features to make the code more readable and manageable.

Base Activity & Fragment & ViewModel: Common operations were abstracted to ensure reusability.

Jetpack ViewModel & LiveData: Used to manage UI data in a lifecycle-aware manner.

Hilt: Used for Dependency Injection (DI) operations.

Coroutines & Flow: Used for asynchronous operations and managing data flow.

Intent: Used for navigating between Activities (pages).

Navigation Component: Used for navigating between Fragments (pages).

ViewBinding: Provided secure access to layouts written in XML.

MPAndroidChart: Used for graphing and data visualization.

Lottie: Used to display JSON-based animations in the app.

Toml libs.versions.toml: A structure used for centrally managing the versions of dependencies.




✅ USED ANDROID SDK AND REQUIREMENTS

Minimum SDK: 21 (Lollipop)

Target SDK: 33 (Android 13)

Compile SDK: 33 (Android 13)

Android SDK Location: C:\Users\mizmilli\AppData\Local\Android\Sdk




✅ FAKE DATA GENERATION

Several approaches were used to generate fake data. Initially, GPS coordinates were altered using the Random.nextDouble() function, 
shifting the original coordinates by ±0.01 degrees. The altitude was randomly selected in the range of (100..150). For battery voltage, 
,it was decreased slightly every second, and updated using Random.nextFloat(). These updates occurred every 5 seconds. 
Over time, the flight duration also increased by one second each time and was displayed in the hh:mm:ss format using the formatTime function. 
Lastly, all of these values were published in real-time using Flow, so that continuously changing data was generated.







✅ UYGULAMA HAKKINDA

Splash ekranına Lottie kütüphanesi ile dinamik bir animasyon eklenmiştir. Bu animasyon, uygulamanın açılışında kullanıcılara görsel olarak dikkat çekici bir deneyim sunar. 
Ana sayfada ise, gelen enlem, boylam ve yükseklik verilerine göre bir drone animasyonu oluşturulmuştur. Drone, verilerin değişimine bağlı olarak yükselip alçalarak sağa sola hareket eder 
ve böylece kullanıcılara dinamik bir görsel deneyim sunar.Bunun yanı sıra, gelen verilerinin bulunduğu bir alan eklenmiştir. Bu alana tıklanıldığında, 
o verilere ait grafikler dinamik olarak görüntülenir. Kullanıcılar, verileri analiz etmek için bu grafiklere kolayca erişebilir. 
Bu özellikler, uygulamanın etkileşimini artırırken, verilerin daha anlaşılır ve görsel olarak sunulmasını sağlar.




✅ KULLANILAN TEKNOLOJİLER VE KÜTÜPHANELER

-MVVM (Model-View-ViewModel): Uygulama bu mimari yapıya göre tasarlandı.

-Modüler Yapı: app, core ve features gibi modüllere ayrılarak daha okunabilir ve yönetilebilir hale getirildi.

-Base Activity & Fragment & ViewModel: Ortak işlemler soyutlanarak tekrar kullanılabilirlik sağlandı.

-Jetpack ViewModel & LiveData: UI verilerini yaşam döngüsüne duyarlı yönetmek için kullanıldı.

-Hilt: Dependency Injection (bağımlılık enjeksiyonu) işlemleri için kullanıldı.

-Coroutines & Flow: Asenkron işlemler ve veri akışı yönetimi için kullanıldı.

-Intent: Activityler(sayfa) arası geçişler için kullanıldı.

-Navigation Component: Fragmentlar(sayfa) arası geçişler için kullanıldı.

-ViewBinding: XML ile yazılan layout'lara güvenli erişim sağlandı.

-MPAndroidChart: Grafik ve veri görselleştirme için kullanıldı.

-Lottie: JSON tabanlı animasyonları uygulamada göstermek için kullanıldı.

-Toml libs.versions.toml: Bağımlılıkların sürüm yönetimini merkezi bir şekilde yapabilmek için kullanılan yapı.




✅ KULLANILAN ANROID SDK VE GEREKSİNİMLER

-Minimum SDK: 21 (Lollipop)

-Target SDK: 33 (Android 13)

-Compile SDK: 33 (Android 13)

-Android SDK konumu: C:\Users\mizmilli\AppData\Local\Android\Sdk




✅ SAHTE VEVRİ ÜRETİMİ

Bu sahte verileri elde etmek için birkaç farklı yaklaşım kullanıldı. İlk olarak, GPS koordinatları için Random.nextDouble() fonksiyonunu kullanılarak, 
başlangıçtaki koordinatları değiştirildi (±0.01 derece). Yükseklik değeri de (10..25).random() gibi bir aralıkla rastgele seçildi. 
Pil voltajı içinse her saniyede küçük bir azalma yaparak, voltajı Random.nextFloat() ile güncellenildi. Bu güncellemeler her 5 saniyede bir gerçekleşti. 
Zamanın ilerlemesiyle uçuş süresi de her saniye arttı ve formatTime fonksiyonu ile hh:mm:ss formatında gösterildi. 
Son olarak, tüm bu veriler Flow ile gerçek zamanlı olarak yayımlandı, böylece sürekli değişen veriler elde edildi.

