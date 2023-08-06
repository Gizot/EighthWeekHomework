# EighthWeekHomework
# ErpSystem Projesi

ErpSystem projesi, Allianz şirketinin ERP (Enterprise Resource Planning) sistemi için geliştirilen bir uygulamadır. ERP sistemi, bir şirketin tüm iş süreçlerini yönetmeye ve entegre etmeye yardımcı olan bir yazılım sistemidir. Bu proje, müşteri yönetimi, ürün yönetimi, sipariş yönetimi ve fatura yönetimi gibi temel işlemleri gerçekleştiren bir RESTful API sağlar.

Projede kullanılan teknolojiler ve yapılar şunlardır:

Java dilinde Spring Boot framework kullanılmıştır. Spring Boot, Java uygulamaları için hızlı ve kolay bir şekilde geliştirme yapmamıza olanak sağlayan bir çatıdır.
Veritabanı olarak PostgreSQL kullanılmıştır. PostgreSQL, açık kaynaklı ve güçlü bir veritabanı yönetim sistemidir.
Veritabanı işlemleri için Spring Data JPA kullanılmıştır. Spring Data JPA, veritabanı işlemlerini kolaylaştıran bir modül sağlar.
Proje için Swagger UI kullanılmıştır. Swagger UI, API dokümantasyonunu otomatik olarak oluşturur ve interaktif bir şekilde görüntülememize olanak sağlar.


Proje, müşteri işlemleri için CustomerController ve CustomerService, ürün işlemleri için ProductController ve ProductService, sipariş işlemleri için OrderController ve OrderService, fatura işlemleri için BillController ve BillService gibi farklı bileşenlerden oluşur. Her bir bileşen, ilgili işlemleri gerçekleştirmek için gerekli metodları içerir.

Müşteri işlemleri, müşteri oluşturma, müşteri listeleme, müşteri arama ve müşteri güncelleme gibi temel işlevleri içerir. Benzer şekilde, ürün işlemleri, ürün oluşturma, ürün listeleme, ürün arama ve ürün güncelleme gibi işlemleri içerir.

Sipariş işlemleri, sipariş oluşturma, sipariş listeleme, siparişe ürün ekleme, sipariş silme ve sipariş güncelleme gibi işlemleri sağlar. Siparişler, müşteri ve ürün bilgilerini içerir ve bu bilgilere göre farklı işlemler yapılabilir.

Fatura işlemleri, fatura oluşturma ve fatura listeleme gibi temel işlemleri içerir. Faturalar, müşteri ve sipariş bilgilerini içerir ve bu bilgilere göre farklı hesaplamalar yapılabilir.

Projeyi çalıştırmak için yerel bir PostgreSQL veritabanına ihtiyaç vardır ve veritabanı bağlantı bilgileri application.properties dosyasında belirtilmelidir. Proje başlatıldığında, Swagger UI üzerinden API dokümantasyonuna erişilebilir ve API'leri test etmek kolaylaştırılır.

Projeyi geliştirmek ve katkıda bulunmak isteyenler, projenin GitHub deposundan kodu çekebilir ve geliştirme ortamlarında açarak çalışmalara başlayabilirler. Projeye katkıda bulunurken, projenin yapılandırmasına ve kod kalitesine dikkat etmek önemlidir. Ayrıca, projeye yeni özellikler eklemek veya mevcut özellikleri geliştirmek için pull request göndermek de mümkündür.
ErpSystem, Allianz şirketinin ERP (Enterprise Resource Planning) sistemi için geliştirilen bir uygulamadır. Bu proje, müşteri, ürün, sipariş ve fatura işlemlerini yönetmek için kullanılan bir RESTful API sağlar. Ayrıca, bu projenin kullanımı ve yapılandırması aşağıdaki gibi yapılmıştır:

## Başlangıç
Proje, aşağıdaki gereksinimlere dayanarak çalıştırılabilir:

- Java 17 veya daha üst bir sürüm
- PostgreSQL veritabanı (yerelde) kurulu olmalıdır.
- **PostgreSQL veritabanı için aşağıdaki bağlantı bilgileri kullanılmalıdır:**
spring.datasource.url=jdbc:postgresql://localhost:5432/erp_db
spring.datasource.username=postgres
spring.datasource.password=1234
spring.jpa.properties.hibernate.jdbc.lob.non_contextual_creation=true
spring.jpa.show-sql=true
spring.jpa.generate-ddl=true
spring.sql.init.mode=never
- Swagger UI
- Uygulama, API dokümantasyonunu görüntülemek için Swagger UI'yi kullanır. Swagger UI'ye erişmek için aşağıdaki URL'yi ziyaret edebilirsiniz:
http://localhost:8082/swagger-ui.html
## Başlangıç ve Kullanım
Projeyi yerel bir geliştirme ortamında çalıştırmak için aşağıdaki adımları izleyin:

- Proje deposunu yerel makinenize klonlayın.
- PostgreSQL veritabanınızda "erp_db" adında bir veritabanı oluşturun.
- Projeyi IntelliJ IDEA, Eclipse veya diğer bir Java IDE'sinde açın.
- Projeyi derleyin ve çalıştırın.
- Swagger UI'ye erişerek API dokümantasyonunu inceleyin ve test edin.
- Geliştirme ve Katkıda Bulunma
- 
## NOT 
Bu projeye katkıda bulunmak veya hata bildiriminde bulunmak isterseniz, lütfen GitHub deposunda bir konu açın veya pull request gönderin. Her türlü geri bildiriminiz değerlidir ve projeyi geliştirmemize yardımcı olacaktır.
