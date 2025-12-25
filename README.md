# Jenkins Pipeline - Health Check ve Deploy

Bu Jenkins pipeline, bir HTTPS endpoint'e health check yaparak deploy işlemini yönetir.

## Özellikler

- **Health Check Stage**: https://example.com adresine GET isteği atar
- **HTTP Durum Kodları**:
  - `200`: Test başarılı, deploy aşamasına geçilir
  - `400` veya `500`: Pipeline fail olur
  - Network hatası veya diğer hatalar: Pipeline fail olur
- **JUnit Test Raporlama**: Test sonuçları JUnit formatında raporlanır
- **Conditional Deploy**: Sadece health check başarılı olursa deploy edilir

## Gereksinimler

Jenkins'te **HTTP Request Plugin** yüklü olmalıdır:
1. Jenkins Dashboard → Manage Jenkins → Manage Plugins
2. "Available" sekmesinde "HTTP Request Plugin" arayın ve yükleyin

## Kullanım

1. Jenkins'te yeni bir Pipeline job oluşturun
2. Pipeline definition olarak "Pipeline script from SCM" veya "Pipeline script" seçin
3. Bu `Jenkinsfile`'ı kullanın
4. URL'yi kendi endpoint'inize göre değiştirin (şu anda: https://example.com)

## Customization

**Endpoint değiştirmek için:**
```groovy
url: 'https://your-endpoint.com',
```

**Deploy komutlarını eklemek için:**
`Deploy` stage'indeki yorum satırlarını kendi deploy komutlarınızla değiştirin:
```groovy
stage('Deploy') {
    steps {
        bat 'your-deploy-command.bat'  // Windows için
        // sh './your-deploy-script.sh'  // Linux için
    }
}
```

## Test Sonuçları

JUnit test sonuçları Jenkins dashboard'unda görüntülenebilir:
- Her build'in test sonuçları görülebilir
- Test trend grafikleri otomatik oluşturulur
- Başarısız testler detaylı olarak gösterilir
