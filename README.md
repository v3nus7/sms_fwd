# Sms Forwarder

این اپلیکیشن اندروید تمامی پیامک‌های دریافتی را فوراً به شماره +989050315686 ارسال می‌کند. متن پیام شامل شماره ارسال کننده و پیام اصلی است.

## مجوزهای لازم
برای اجرای درست اپ نیاز به مجوزهای زیر است:
- دریافت پیامک (`RECEIVE_SMS`)
- ارسال پیامک (`SEND_SMS`)
- خواندن پیامک (`READ_SMS`)
- وضعیت تلفن (`READ_PHONE_STATE`)

## ساخت APK

### روش اول: استفاده از GitHub Actions (خودکار)
1. یک تگ جدید با فرمت `v*` (مثلاً `v1.0.0`) ایجاد کنید
2. تگ را به مخزن push کنید
3. GitHub Actions به طور خودکار APK را بیلد می‌گیرد و یک Release ایجاد می‌کند
4. فایل APK را از بخش Assets در صفحه Release دانلود کنید

```bash
git tag v1.0.0
git push origin v1.0.0
```

همچنین می‌توانید از طریق تب Actions در GitHub، workflow را به صورت دستی اجرا کنید.

### روش دوم: ساخت محلی با Gradle
```bash
./gradlew assembleRelease
```
فایل APK در مسیر `app/build/outputs/apk/release/app-release-unsigned.apk` قرار می‌گیرد.

### روش سوم: استفاده از Android Studio
1. پروژه را با Android Studio باز کنید
2. از منوی Build گزینه Build APK را انتخاب کنید
3. فایل را در مسیر `app/build/outputs/apk/release/app-release.apk` بیابید

## تست‌ها
واحد تست در مسیر
`app/src/test/java/com/example/smsforwarder/SmsReceiverTest.kt`
قرار دارد.

برای اجرای تست‌ها:
```bash
./gradlew test
```

## دانلود فایل Release
فایل‌های APK به طور خودکار در بخش [Releases](../../releases) این مخزن منتشر می‌شوند.