Feature: Sepete Ekleme ve Silme Testi

  Background: Uygulama appium üzerinden ayaga kaldirilir

  Scenario: iki farkli kategorideki ürünlerin sepete
  eklenip daha sonra sepetten silinmesi

    Given uygulamaya giris yapilir
    When kisisel bakim ve ev bakimi kategorisinden ilk urunler sepete eklenir
    And sepete gidilir sepette iki urun oldugu dogrulanir
    And sepette ki urunler silinir
    Then sepetin bos oldugu dogrulanir
